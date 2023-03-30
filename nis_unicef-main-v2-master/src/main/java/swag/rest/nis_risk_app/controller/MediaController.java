package swag.rest.nis_risk_app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import swag.rest.nis_risk_app.dao.CommonFilesRepository;
import swag.rest.nis_risk_app.dao.UserRepository;
import swag.rest.nis_risk_app.entity.CommonFiles;
import swag.rest.nis_risk_app.entity.Users;

@RestController
@RequiredArgsConstructor
@RequestMapping("/media")
public class MediaController {

    @Value("${picture.base.url}")
    private String pictureBaseUrl;

    @Value("${files.base.url}")
    private String fileBaseUrl;

    private final String notFoundMessage = "Username not found";

    private final UserRepository userRepository;

    private final CommonFilesRepository commonFilesRepository;

    @Operation(description = "Set current users avatar")
    @PostMapping(value = "/picture",
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    @Transactional
    public Users uploadPicture(
        @Parameter(content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE))
        @RequestParam("picture") MultipartFile file) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userRepository.findByUsername(auth.getName())
            .orElseThrow(() -> new UsernameNotFoundException(notFoundMessage));
        user.setPicture(file.getBytes());
        Users temp = userRepository.save(user);
        user.setPictureLink(String.format(pictureBaseUrl,temp.getId()));
        return userRepository.save(user);
    }


    @Transactional
    @Operation(description = "Get users avatar")
    @GetMapping(value = "/picture/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getProfilePicture(@PathVariable Long id) {
        Users user = userRepository.findById(id).orElseThrow(() ->
            new UsernameNotFoundException(notFoundMessage));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.IMAGE_JPEG);
        responseHeaders.setContentDisposition(ContentDisposition.attachment().build());
        return user.getPicture();
    }

    @Operation(description = "Set current users avatar")
    @PostMapping(value = "/file",
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void uploadFile(
        @Parameter(content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE))
        @RequestParam("file") MultipartFile file) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userRepository.findByUsername(auth.getName())
            .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        CommonFiles commonFiles = CommonFiles.builder()
            .fileName(file.getOriginalFilename())
            .file(file.getBytes())
            .build();
        CommonFiles persistedFile =
            commonFilesRepository.save(commonFiles);
        List<Users> allUsers = userRepository.findAll();
        allUsers.forEach(u -> u.getFiles().add(persistedFile));
        userRepository.saveAll(allUsers);
        List<Users> allUsersWithFile = userRepository.findAll();
        for (Users u : allUsersWithFile) {
            u.getFiles().stream()
                .filter(f -> f.getFileName().equals(persistedFile.getFileName()))
                .findFirst()
                .orElseThrow(FileNotFoundException::new)
                .setFileLink(String.format(fileBaseUrl, u.getId(), persistedFile.getId()));
        }
        userRepository.save(user);
    }

    @Transactional
    @Operation(description = "Get common file links")
    @GetMapping(value = "/file-link",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getProfileFileLinks() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userRepository.findByUsername(auth.getName())
            .orElseThrow(() -> new UsernameNotFoundException(notFoundMessage));
        return user.getFiles().stream().map(CommonFiles::getFileLink)
            .collect(Collectors.toList());
    }

    @Transactional
    @Operation(description = "Get common files")
    @GetMapping(value = "/files/{userId}/{id}",
        produces = "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    public byte[] getProfileFiles(@PathVariable Long id,
                                  @PathVariable Long userId)
        throws FileNotFoundException {
        Users user = userRepository.findById(userId)
            .orElseThrow(() -> new UsernameNotFoundException(notFoundMessage));
        return user.getFiles().stream().filter(file -> file.getId().equals(id))
            .findAny().orElseThrow(FileNotFoundException::new).getFile();
    }
}
