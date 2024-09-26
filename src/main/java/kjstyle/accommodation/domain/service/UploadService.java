package kjstyle.accommodation.domain.service;

import kjstyle.accommodation.domain.enums.ImageType;
import kjstyle.accommodation.domain.repository.ImageRepository;
import kjstyle.accommodation.domain.repository.entities.ImageEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UploadService {

    private final ImageRepository imageRepository;

    public ImageEntity uploadAccommodationImage(ImageType imageType, MultipartFile imageFile) throws IOException {
        final String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
        final String fileDir = "tmpfile/accommodation/" + imageType.toString();
        final String filePath = fileDir + "/" + fileName;

        File destDir = new File(fileDir);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        File destFile = new File(filePath);
        imageFile.transferTo(destFile);

        ImageEntity imageEntity = ImageEntity.builder()
                .imageType(imageType)
                .path(filePath)
                .build();

        return imageRepository.save(imageEntity);
    }
}
