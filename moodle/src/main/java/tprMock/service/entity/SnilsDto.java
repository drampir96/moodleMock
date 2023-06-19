package tprMock.service.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.stream.Stream;

@Data
public class SnilsDto {

    @JsonProperty("message")
    private String message = "success";

    @NotBlank (message = "NULL snils value")
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{3} \\d{2}", message = " snils validation error")
    @HashSum
    @JsonProperty("snils")
    private String snils;




}
