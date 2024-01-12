package com.example.jeeproject.models.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.passay.*;

import java.util.Arrays;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public void initialize(ValidPassword constraintAnnotation){

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context){
        PasswordValidator passwordValidator = new PasswordValidator(
                Arrays.asList(
                        new LengthRule(8,255),
                        new CharacterRule(EnglishCharacterData.UpperCase, 1),
                        new CharacterRule(EnglishCharacterData.LowerCase, 1),
                        new CharacterRule(EnglishCharacterData.Digit, 1),
                        new CharacterRule(EnglishCharacterData.Special, 1),
                        new WhitespaceRule()
                )
        );
        RuleResult ruleResult = passwordValidator.validate(new PasswordData(password));
        if (ruleResult.isValid()){
            return true;
        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(
                String.join(",", passwordValidator.getMessages(ruleResult))
        ).addConstraintViolation();

        return false;
    }
}
