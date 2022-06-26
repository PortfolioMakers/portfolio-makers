package com.example.portfolioserver.global;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

public class NotBlankIfContainsValidator implements ConstraintValidator<NotBlankIfContains, Object> {

    private String field;
    private String fieldContains;
    private String targetField;

    @Override
    public void initialize(NotBlankIfContains constraintAnnotation) {
        field = constraintAnnotation.field();
        fieldContains = constraintAnnotation.fieldContains();
        targetField = constraintAnnotation.targetField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value == null) {
            return true;
        }
        try {
            String fieldValue = BeanUtils.getProperty(value, field);
            if(fieldValue == null || !fieldValue.contains(fieldContains)) {
                return true;
            }
            String targetFieldValue = BeanUtils.getProperty(value, targetField);
            if(targetFieldValue != null && !targetFieldValue.isBlank()) {
                return true;
            }
            // 기본 메세지 비활성화
            context.disableDefaultConstraintViolation();
            // 새로운 메세지 추가
            context.buildConstraintViolationWithTemplate("{" + value.getClass().getSimpleName() + "." + targetField + ".not.blank}")
                    .addPropertyNode(targetField)
                    .addConstraintViolation();
            return false;
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
}
