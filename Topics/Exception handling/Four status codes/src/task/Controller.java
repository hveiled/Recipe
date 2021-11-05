package task;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

@RestController
public class Controller {

    @GetMapping("/test/{status}")
    public String testing(@PathVariable int status) {
        if (status == 300) {
            throw new ResponseStatusException(HttpStatus.MULTIPLE_CHOICES, "300 Multiple Choices");
        } else if (status == 400) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "400 Bad Request");
        } else if (status == 500) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "500 Internal Server Error");
        } else {
            return "200 OK";
        }
    }
}
