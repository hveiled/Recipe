package task;

import org.springframework.web.bind.annotation.*;

import java.util.*;

class Task {
    private final String name;
    private final String description;

    Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

@RestController
public class Controller {
    ResponceEntity<?> responceEntity = new ResponceEntity<?>()
    List<Task> tasks = List.of(
            new Task("Improve UI", "implement ..."),
            new Task("Color bug", "fix ...")
    );

    @GetMapping("/tasks/all")
    public List<Task> getTasks() {
        return tasks;
    }
// Add your code below this line and do not change the code above the line.

}
