package com.studentDB.demo.Controller;

import com.studentDB.demo.Entity.Student;
import com.studentDB.demo.Exception.StudentNotFound;
import com.studentDB.demo.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {
    @Autowired
    StudentRepo studentRepo;
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) throws StudentNotFound {
        return studentRepo.findById(id).orElseThrow(()->new StudentNotFound("No Student"));
    }
    @PostMapping

    public Student createStudent(@RequestBody  Student student){
        return studentRepo.save(student);
    }
    @PutMapping ("/{id}")

    public Student updateStudent(@PathVariable int id,@RequestBody Student std) throws StudentNotFound {
        Student old_std=studentRepo.findById(id).orElseThrow(()->new StudentNotFound("No student with this id"));
        std.setId(old_std.getId());
        return studentRepo.save(std);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) throws StudentNotFound {
        Student del=studentRepo.findById(id).orElseThrow(()->new StudentNotFound("No student with this id"));
        studentRepo.delete(del);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("deleteAll")
    public ResponseEntity<?> deletAll() throws StudentNotFound {
        if(studentRepo.findAll().isEmpty()) throw new StudentNotFound(("List is Empty"));
        studentRepo.deleteAll();

        return ResponseEntity.ok().build();
    }
    @GetMapping("students")
    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }
}
