package be.storm.rulecrafterbackend.pl.validators;

import be.storm.rulecrafterbackend.pl.validators.annotations.ImageFormat;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class ImageFormatValidator implements ConstraintValidator<ImageFormat, MultipartFile> {

    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null || value.isEmpty()){
            return true;
        }
        String imageName = value.getOriginalFilename();
        return imageName.endsWith(".jpg") || imageName.endsWith(".jpeg") || imageName.endsWith(".png");
    }
}
