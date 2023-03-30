package swag.rest.nis_risk_app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import swag.rest.nis_risk_app.entity.Emergency;
import swag.rest.nis_risk_app.entity.File;

import java.io.IOException;
import java.util.List;


@Service
public interface FileStorageService {

    File store(MultipartFile file, Emergency emergency) throws IOException;

    List<File> getAllFilesByEmergency(Emergency emergency);
    File getFile(String id);
}
