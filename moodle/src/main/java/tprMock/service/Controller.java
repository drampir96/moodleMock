package tprMock.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    public ResponseEntity<Object> snilsStatus(@Valid @RequestBody SnilsDto snilsDto) {
        if (snilsDto.checkHashSum() == "hashSum error") {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"CheckSum error\"}");
        } else {
            return ResponseEntity.ok().body(snilsDto);
        }
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<String> exc(HttpServletRequest request, MethodArgumentNotValidException ex) {
        //System.out.println(ex.getBindingResult().getFieldError().getDefaultMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .header("content-type", "application/json")
                .body("{\"message\": \"" + ex.getBindingResult().getFieldError().getDefaultMessage() + "\"}");
    }
}


