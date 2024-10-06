package com.icesi.demoBoot.controllers;

import com.icesi.demoBoot.beans.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    public static List<Student> students = new ArrayList<Student>();

    public StudentController() {
        students.add(new Student("John", "Doe"));
        students.add(new Student("Jane", "Doe"));
        students.add(new Student("Alice", "Smith"));
        students.add(new Student("Bob", "Smith"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{firstName}/{lastName}")
    public Student studentPathVariables(@PathVariable ("firstName") String firstName, @PathVariable ("lastName") String lastName) {
        return new Student(firstName, lastName);
    }

    @GetMapping("/student/query")
    public Student studentQuery(@RequestParam (name="firstName") String firstName, @RequestParam (name="lastName") String lastName) {
        return new Student(firstName, lastName);
    }

    @PostMapping("/student")
    public void addStudent(@RequestBody Student student) {
        students.add(student);
    }

    @PutMapping("/student/{firstName}")
    public void updateStudent(@PathVariable ("firstName") String firstName, @RequestBody Student student) {
        for (Student s : students) {
            if (s.getFirstName().equals(firstName)) {
                s.setFirstName(student.getFirstName());
                s.setLastName(student.getLastName());
            }
        }
    }

    @DeleteMapping("/student/{firstName}")
    public void deleteStudent(@PathVariable ("firstName") String firstName) {
        students.removeIf(s -> s.getFirstName().equals(firstName));
    }
}
