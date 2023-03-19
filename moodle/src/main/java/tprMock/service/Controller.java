package tprMock.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tprMock.service.entity.SnilsDto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RestController
public class Controller {


    @PostMapping(
            value = "/snils",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> snilsStatus(@Valid @RequestBody SnilsDto snilsDto) throws Exception {
      /* Венуть код 400, в сообщении ответа указать в поле messege одну из следующих проблем):
         - не валидная контрольная сумма
         - не валидный JSON (не верное поле snils, буквы вместо чисел, не верное количество чисел и тд)  */
        if (snilsDto.checkHashSum() == "error") {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"CheckSum error\"}");
        } else {
            return ResponseEntity.ok().body(snilsDto);
        }
    }

    @ExceptionHandler
    public ResponseEntity<Object> exc(HttpServletRequest request, Exception ex) {
        System.out.println(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .header("content-type", "application/json")
                .body("{\"message\": \"" +ex.getMessage() +"\"}");
    }
}

