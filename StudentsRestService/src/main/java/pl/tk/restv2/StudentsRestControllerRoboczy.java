package pl.tk.restv2;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tk.model.Grade;


//consumes = MediaType.APPLICATION_JSON_VALUE
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentsRestControllerRoboczy {


    //http://localhost:8080/eportal/orders?id=1001

    @RequestMapping("/orders")
    public String sampleMethod(@RequestParam("id") String orderId, Model model){
        //...
        return null;
    }

    @GetMapping(value = "/user/{name}")
    public void samplePathVariableMethod(@PathVariable String name) {
        //...
    }

    @GetMapping("/hello")
    public ResponseEntity<String> greeting(@RequestHeader("accept-language") String language) {
        //...
        return null;
    }

    @PostMapping("/grades")
    @ResponseBody
    public String createStudent(@RequestBody Grade grade) {
        //...
        return null;
    }

}
