package be.storm.rulecrafterbackend.api.validators;

import be.storm.rulecrafterbackend.api.validators.annotations.PictureFormat;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class PictureFormatValidator implements ConstraintValidator<PictureFormat, MultipartFile> {

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext constraintValidatorContext) {
        if(multipartFile == null || multipartFile.isEmpty()) {
            return true;
        }
        String pictureName = multipartFile.getOriginalFilename();
        return pictureName.endsWith(".jpg") || pictureName.endsWith(".jpeg") || pictureName.endsWith(".png");
    }
}
