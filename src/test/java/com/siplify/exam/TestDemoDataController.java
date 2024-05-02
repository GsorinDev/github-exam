package com.siplify.exam;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import com.siplify.exam.entities.Student;
import com.siplify.exam.repositories.StudentRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestDemoDataController {

    @Autowired
    private StudentRepository repo;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateStudent() {
        Student savedStudent = repo.save(new Student("georgio", 21));
        assertThat(savedStudent.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void testFindStudentByName() {
        Student student = repo.findByName("georgio");    // findByName
        assertThat(student.getName()).isEqualTo("georgio");
    }

    @Test
    @Order(3)
    public void testStudentStudents() {
        repo.save(new Student("constantin", 25)); //save
        List<Student> students = (List<Student>) repo.findAll();
        assertThat(students).size().isGreaterThan(1);
    }

    @Test
    @Order(4)
    public void testUpdateStudentAge() {
        repo.save(new Student("constantin", 25)); //save

        Student student = repo.findByName("constantin");

        if (student != null) {
            student.setAge(24);
            repo.save(student);
        }

        assertThat(student).isNotNull();
        assertThat(student.getAge()).isEqualTo(24);
    }

    @Test
    @Order(5)
    public void testDeleteStudent() {
        Student student = repo.findByName("georgio");
        repo.deleteById(student.getId());
        assertThat(repo.findByName("georgio")).isNull();
    }
}
