package com.kma.scheduler.universityscheduler;

import com.kma.scheduler.universityscheduler.controller.LectorController;
import com.kma.scheduler.universityscheduler.entity.Course;
import com.kma.scheduler.universityscheduler.entity.LectorEntity;
import com.kma.scheduler.universityscheduler.entity.Role;
import com.kma.scheduler.universityscheduler.entity.StudentEntity;
import com.kma.scheduler.universityscheduler.entity.slot.SlotEntity;
import com.kma.scheduler.universityscheduler.repository.*;
import com.kma.scheduler.universityscheduler.service.admin.AdminService;
import com.kma.scheduler.universityscheduler.service.lector.LectorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.access.annotation.Secured;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LectorRepository lectorRepository;
    @MockBean
    private StudentRepository studentRepository;
    @MockBean
    private CourseRepository courseRepository;
    @MockBean
    private ManagerRepository managerRepository;
    @MockBean
    private SlotRepository slotRepository;
    @MockBean
    private UserRepository userRepository;

    @Test
    public void checkAuthForStudent() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/me")).andExpect(MockMvcResultMatchers.status().is(401));
    }

    @Test
    public void checkLector() throws Exception{
        List<LectorEntity> lectors = new ArrayList<>();
        lectors.add(new LectorEntity(10L, "Test","Test","Test","Test"));
        when(lectorRepository.findAll()).thenReturn(lectors);

        mockMvc.perform(MockMvcRequestBuilders.get("/lector/all"))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());
    }

}
