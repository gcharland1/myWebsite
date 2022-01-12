package com.GabrielCharland.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// Informe Spring que cette classe est un service qu'il doit l'initialiser depuis le Controller avec @Autowired
@Service
public class StudentService {
    /*
     * La classe StudentService fait le pont entre la classe Student et
     * le Controller. C'est dans cette classe qu'on met la logique de
     * gestion / manipulation / modification de données. Le Controller
     * va ensuite appeler la bonne méthode du service selon la requête
     * envoyée par l'utilisateur.
     */
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll(); // Retourne la liste de tous les entrées dans la DB depuis le Repo
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean studentExists = studentRepository.existsById(studentId);
        if (!studentExists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new IllegalStateException("Student with id " + studentId + " does not exist")
        );
        // Set new name
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        // Set new email
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email already taken");
            }
            student.setEmail(email);
        }

    }
}
