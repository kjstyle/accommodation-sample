package kjstyle.accommodation.web;

import kjstyle.accommodation.domain.repository.entities.ImageEntity;
import kjstyle.accommodation.domain.service.UploadService;
import kjstyle.accommodation.domain.enums.ImageType;
import kjstyle.accommodation.web.common.BaseApiController;
import kjstyle.accommodation.web.dto.AccommodationImageRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ImageUploadRestController extends BaseApiController {

    private final UploadService uploadService;

    @PostMapping("/upload/image/accommodation")
    public AccommodationImageRes.Upload uploadImageForAccommodation(
            @RequestParam("imageType") ImageType imageType
            ,@RequestParam("image") MultipartFile imageFile) throws IOException {

        if (imageFile.isEmpty()) {
            throw new IllegalArgumentException("파일이 비어있습니다.");
        }
        ImageEntity imageEntity = uploadService.uploadAccommodationImage(imageType, imageFile);

        return AccommodationImageRes.Upload.from(imageEntity);
    }
}