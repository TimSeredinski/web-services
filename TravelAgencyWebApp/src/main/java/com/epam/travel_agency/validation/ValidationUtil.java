package com.epam.travel_agency.validation;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidationUtil {

    public static boolean isObjectValid(Object object){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Object> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
            return false;
        }
        return true;
    }
}
