package pl.tk.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.tk.model.Student;
import pl.tk.services.StudentService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

//consumes = MediaType.APPLICATION_JSON_VALUE
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentsRestController {

    @Autowired
    StudentService studentService;

    //@ResponseStatus(value = HttpStatus.OK)    ----> obadać
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable String id) {
        Optional<Student> studentOp = studentService.getStudentById(id);
        if(studentOp.isPresent()) {
            return new ResponseEntity<>(studentOp.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       // return studentOp.map(student -> new ResponseEntity<>(student, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/students")
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
       // responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<>(savedStudent, responseHeaders, HttpStatus.CREATED);
        //return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        boolean isRemoved = studentService.removeStudent(id);
        if (isRemoved) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable String id) {
        studentService.updateStudent(id, student);
        return ResponseEntity.ok().build();

    }


//        @PutMapping("/employees/{id}")
//            public ResponseEntity<Employee> updateEmployee() {
//             Employee employee = employeeRepository.findById(employeeId)
//             .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//             employee.setEmailId(employeeDetails.getEmailId());
//             employee.setLastName(employeeDetails.getLastName());
//             employee.setFirstName(employeeDetails.getFirstName());
//             final Employee updatedEmployee = employeeRepository.save(employee);
//             return ResponseEntity.ok(updatedEmployee);
//            }



}
