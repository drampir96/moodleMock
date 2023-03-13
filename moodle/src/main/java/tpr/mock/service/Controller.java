package tpr.mock.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tpr.mock.service.entity.RsEntity;

@Slf4j
@RestController
public class Controller {


    @SneakyThrows
    @PostMapping(
            value = "/snills",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String Res(RsEntity rsEntity) {
        return rsEntity.toString();
    }


}
