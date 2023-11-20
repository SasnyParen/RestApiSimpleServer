package letscode.sarafan.controller;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("exercise")
public class MessageController {
    @GetMapping("{id}")
    public String getOne(@PathVariable String id) throws IOException {
        return ExerciseController.GetExercise(id);
    }
}
