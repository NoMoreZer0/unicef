package swag.rest.nis_risk_app.service.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import swag.rest.nis_risk_app.dao.EmergencyRepository;
import swag.rest.nis_risk_app.dao.FileRepository;
import swag.rest.nis_risk_app.entity.Emergency;
import swag.rest.nis_risk_app.entity.File;
import swag.rest.nis_risk_app.service.FileStorageService;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {

    private final FileRepository fileRepository;


    @Override
    @Transactional
    public File store(MultipartFile file, Emergency emergency) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        File fileToSave = new File(fileName, file.getContentType(), file.getBytes());
        fileToSave.setFileEmergency(emergency);
        return fileRepository.save(fileToSave);
    }

    @Override
    @Transactional
    public List<File> getAllFilesByEmergency(Emergency emergency) {
        return fileRepository.findAllByFileEmergency(emergency);
    }

    @Override
    @Transactional
    public File getFile(String id) {
        return fileRepository.findById(id).get();
    }
}
