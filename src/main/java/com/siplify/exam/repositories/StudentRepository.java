package com.siplify.exam.repositories;

import com.siplify.exam.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    public Student findByName(String name);
}
