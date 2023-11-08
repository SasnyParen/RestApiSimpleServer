package letscode.sarafan.controller;

import letscode.sarafan.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("exercise")
public class MessageController {
    private List<Map<String, String>> ExerciseList = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{ put("id", "1"); put("ExtraInfo", "123123"); put("ExtraInfo2", "123123");}});
    }};

    @GetMapping
    public List<Map<String, String>> list() {
        return ExerciseList;
    }

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return getMessage(id);
    }

    private Map<String, String> getMessage(@PathVariable String id) {
        return ExerciseList.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
}
