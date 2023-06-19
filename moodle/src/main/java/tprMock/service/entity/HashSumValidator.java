package tprMock.service.entity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.stream.Stream;

public class HashSumValidator implements
        ConstraintValidator<HashSum, String> {

    @Override
    public void initialize(HashSum contactNumber) {
    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        try {
            int[] arrSnils = Stream.of(contactField.replaceAll("\\D+", "").split("")).mapToInt(Integer::parseInt).toArray();
            int checkNumber = arrSnils[9] * 10 + arrSnils[10];
            int hashSum = 0;
            for (int i = 0, j = 9; i <= 8; i++, j--) {
                hashSum = hashSum + arrSnils[i] * j;
            }
            return checkNumber == hashSum;
        }
        catch (final Exception e) {
            return false;
        }
    }

}