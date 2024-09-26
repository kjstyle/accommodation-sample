package kjstyle.accommodation.domain.model;

import kjstyle.accommodation.domain.enums.ImageType;
import kjstyle.accommodation.domain.repository.entities.ImageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AccommodationImage {
    private Long id;
    private ImageType imageType;
    private String path;
    private Long accommodationId;

    public ImageEntity toSaveEntity(long accommodationId) {
        return ImageEntity.builder()
                .accommodationId(accommodationId)
                .imageType(this.imageType)
                .path(this.path)
                .build();
    }
}
