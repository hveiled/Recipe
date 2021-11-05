package task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleController {

    @GetMapping(value = "/welcome")
    public ResponseEntity<String> welcome() {
        return new ResponseEntity<String>("Welcome!", HttpStatus.OK);
    }
}
