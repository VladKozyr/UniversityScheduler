package com.kma.scheduler.universityscheduler;

import com.kma.scheduler.universityscheduler.entity.Course;
import com.kma.scheduler.universityscheduler.entity.StudentEntity;
import com.kma.scheduler.universityscheduler.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        StudentEntity student = StudentEntity.builder()
                .name("Test student")
                .login("Test login")
                .course(Course.builder().year(1).faculty("FI").build())
                .build();
        studentRepository.save(student);
        Assertions.assertTrue(student.getId() != 0);
    }

    @Test
    public void updateStudent(){
        StudentEntity student = StudentEntity.builder()
                .name("Test student")
                .login("Test login")
                .course(Course.builder().year(1).faculty("FI").build())
                .build();
        studentRepository.save(student);

        student.setCourse(Course.builder().year(2).faculty("FI").build());
        StudentEntity updatedStudent = studentRepository.save(student);
        Assertions.assertEquals(2, updatedStudent.getCourse().getYear());
    }
}
