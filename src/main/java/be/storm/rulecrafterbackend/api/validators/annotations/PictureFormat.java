package be.storm.rulecrafterbackend.api.validators.annotations;

import be.storm.rulecrafterbackend.api.validators.PictureFormatValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PictureFormatValidator.class})
public @interface PictureFormat {

    String message() default  "Invalid picture format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
