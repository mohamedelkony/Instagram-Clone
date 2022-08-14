package kony.insta.dto.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GenderValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface gender {
    String message() default "gender must be 'male' or 'female'";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

