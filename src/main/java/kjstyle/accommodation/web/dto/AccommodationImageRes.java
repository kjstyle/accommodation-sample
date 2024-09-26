package kjstyle.accommodation.web.dto;

import kjstyle.accommodation.domain.enums.ImageType;
import kjstyle.accommodation.domain.repository.entities.ImageEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class AccommodationImageRes {

    @Getter
    @AllArgsConstructor
    public static class Upload {
        private Long id;
        private ImageType imageType;
        private String path;

        public static Upload from(ImageEntity entity) {
            return new Upload(entity.getId(), entity.getImageType(), entity.getPath());
        }
    }
}
