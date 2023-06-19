package tprMock.service.entity;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = HashSumValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface HashSum {
    String message() default "Invalid hash sum";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}