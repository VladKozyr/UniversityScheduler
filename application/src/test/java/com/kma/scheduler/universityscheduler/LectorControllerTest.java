package com.kma.scheduler.universityscheduler;

import com.kma.scheduler.universityscheduler.controller.LectorController;
import com.kma.scheduler.universityscheduler.entity.LectorEntity;
import com.kma.scheduler.universityscheduler.service.admin.AdminService;
import com.kma.scheduler.universityscheduler.service.lector.LectorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LectorController.class)
public class LectorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LectorController lectorController;

    @Test
    public void getLectorById() throws Exception{
        LectorEntity lectorEntity = new LectorEntity(null,"Test name","Test login",null,"Test cathedra");
        ArrayList<LectorEntity> lectors = new ArrayList<>();
        lectors.add(lectorEntity);
        when(lectorController.getLectors()).thenReturn(lectors);

        mockMvc.perform(MockMvcRequestBuilders.get("/lector/all"))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
                .andExpect(status().isOk());
    }
}
