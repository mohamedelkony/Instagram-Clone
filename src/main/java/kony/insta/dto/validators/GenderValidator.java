package kony.insta.dto.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<gender, String> {
    @Override
    public void initialize(gender contactNumber) {
    }

    @Override
    public boolean isValid(String gender, ConstraintValidatorContext cxt) {
        return gender != null && (gender.compareToIgnoreCase("male") == 0 || gender.compareToIgnoreCase("female") == 0);
    }
}
