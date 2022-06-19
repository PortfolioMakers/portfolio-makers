package com.example.portfolioserver.domain.portfolio.dto;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotBlankIfContainsValidator.class) // 제약조건 로직, ConstraintValidator 구현한 클래스
@Documented
public @interface NotBlankIfContains {

    String field();
    String fieldContains();
    String targetField();

    // 에러 메세지
    String message() default "{not.blank}";
    // 유효성 검사가 언제 실행되는지 정의할 수 있다.
    Class<?>[] groups() default {};
    // 유효성 검사에 전달한 payload 정의할 수 있다.
    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        NotBlankIfContains[] value();
    }
}
