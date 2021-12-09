package com.kma.scheduler.universityscheduler;

import com.kma.scheduler.universityscheduler.controller.LectorController;
import com.kma.scheduler.universityscheduler.entity.LectorEntity;
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
public class LectorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LectorController lectorController;

    @Test
    public void getLectors() throws Exception{
        LectorEntity lectorEntity = new LectorEntity(null,"Test name","Test login",null,"Test cathedra");
        ArrayList<LectorEntity> lectors = new ArrayList<>();
        lectors.add(lectorEntity);
        when(lectorController.getLectors()).thenReturn(lectors);

        mockMvc.perform(MockMvcRequestBuilders.get("/lector/all"))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
                .andExpect(status().isOk());
    }

    @Test
    public void checkAuthForStudent() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/me")).andExpect(MockMvcResultMatchers.status().is(401));
    }
}
