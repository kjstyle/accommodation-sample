package kjstyle.accommodation.web.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kjstyle.accommodation.web.dto.AccommodationReq;

import java.util.List;

public class AccommodationImageValidator implements ConstraintValidator<ValidAccommodationImage, List<AccommodationReq.ImageOnCreate>> {
    @Override
    public void initialize(ValidAccommodationImage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<AccommodationReq.ImageOnCreate> imageList, ConstraintValidatorContext context) {
        if (imageList == null || imageList.isEmpty()) {
            return false;
        }
        for (AccommodationReq.ImageOnCreate image : imageList) {
            if (image.getImageType() == null || image.getPath() == null) {
                return false;
            }
        }
        return true;
    }
}