package kjstyle.accommodation.web.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kjstyle.accommodation.domain.AccommodationImage;

import java.util.List;

public class AccommodationImageValidator implements ConstraintValidator<ValidAccommodationImage, List<AccommodationImage>> {
    @Override
    public void initialize(ValidAccommodationImage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<AccommodationImage> imageList, ConstraintValidatorContext context) {
        if (imageList == null || imageList.isEmpty()) {
            return false;
        }
        for (AccommodationImage accommodationImage : imageList) {
            if (accommodationImage.getId() == null || accommodationImage.getImageType() == null || accommodationImage.getPath() == null) {
                return false;
            }
        }
        return true;
    }
}