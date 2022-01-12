package com.GabrielCharland.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
    /*
     * La classe StudentController est niveau Web de l'application. C'est
     * la partie du code qui reçoit et renvoie les demandes HTTP. La
     * logique des demandes est traitée à ce niveau, puis envoyée aux
     * différents Services, selon la demande.
     */

    private final StudentService studentService;

    @Autowired // Initialise le StudentService automatiquement
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    /*
     * Mapping selon les méthodes de HTTP
     *      - GET, POST, DELETE, PUT
     */
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentID}")
    public void deleteStudent(@PathVariable("studentID") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentID}")
    public void updateStudent(@PathVariable("studentID") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}
