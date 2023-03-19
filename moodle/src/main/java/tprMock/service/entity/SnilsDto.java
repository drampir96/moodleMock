package tprMock.service.entity;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.stream.Stream;

@Data
public class SnilsDto {
    private String message = "success";
    @NotBlank (message = "NULL snils value")
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{3} \\d{2}", message = "validation snils error")
    private String snils;

/*    public String checkPattern() {
        if (snils == null)
            message = "emty snill value";
        return message;
    }*/


    public String checkHashSum() {
        int[] arrSnils = Stream.of(snils.replaceAll("\\D+", "").split("")).mapToInt(Integer::parseInt).toArray();
        int checkNumber = arrSnils[9] * 10 + arrSnils[10];
        int hashSum = 0;
        for (int i = 0, j = 9; i <= 8; i++, j--) {
            System.out.println(arrSnils[i] + "/" + j + "\n");
            hashSum = hashSum + arrSnils[i] * j;
        }
        System.out.println(checkNumber);
        System.out.println(hashSum);
        if (checkNumber == hashSum) {
            message = "success";
        } else {
            message = "hashSum error";
        }
        return message;
    }


}
