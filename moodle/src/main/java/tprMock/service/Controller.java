package tprMock.service;

import tprMock.service.entity.SnilsDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RestController
public class Controller {
    int delay = 200;

    @SneakyThrows
    @PostMapping(
            value = "/snils",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> snilsStatus(@Valid @RequestBody SnilsDto snilsDto) {
        Thread.sleep(delay);
        try {
            return ResponseEntity.ok().body(snilsDto);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \""+e.getMessage()+"\"}");
        }
    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<String> exc(HttpServletRequest request, MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .header("content-type", "application/json")
                .body("{\"message\": \"" + ex.getBindingResult().getFieldError().getDefaultMessage() + "\"}");
    }


    @SneakyThrows
    @GetMapping(
            value = "/delay",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> rst(@PathVariable int newdelay) {
        delay = newdelay;
        return ResponseEntity.ok().body(delay);
    }

}



