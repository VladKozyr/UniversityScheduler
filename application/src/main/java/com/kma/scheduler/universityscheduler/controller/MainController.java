package com.kma.scheduler.universityscheduler.controller;

import com.kma.scheduler.universityscheduler.aspect.executiontime.TrackExecutionTime;
import com.kma.scheduler.universityscheduler.aspect.params.MethodParams;
import com.kma.scheduler.universityscheduler.controller.mapping.SlotEditMapping;
import com.kma.scheduler.universityscheduler.entity.Course;
import com.kma.scheduler.universityscheduler.entity.Role;
import com.kma.scheduler.universityscheduler.entity.slot.SlotEntity;
import com.kma.scheduler.universityscheduler.repository.CourseRepository;
import com.kma.scheduler.universityscheduler.security.SecurityConfiguration;
import com.kma.scheduler.universityscheduler.service.admin.AdminList;
import com.kma.scheduler.universityscheduler.service.admin.AdminService;
import com.kma.scheduler.universityscheduler.service.lector.LectorService;
import com.kma.scheduler.universityscheduler.service.schedule.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private final AdminService adminService;
    private final ScheduleService scheduleService;
    private final LectorService lectorService;
    private final CourseRepository courseRepository;
    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    MainController(String demo, AdminList adminList, AdminService adminService, ScheduleService scheduleService, LectorService lectorService, CourseRepository courseRepository) {
        this.adminService = adminService;
        this.scheduleService = scheduleService;
        this.lectorService = lectorService;
        this.courseRepository = courseRepository;
        System.out.println(demo);
        System.out.println(adminList.getAdmin());
    }


    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    @TrackExecutionTime
    public String login() {
        return "login";
    }

    @RequestMapping("/main")
    @MethodParams
    public String main(HttpServletRequest request, Model model) {

        if (request.isUserInRole(Role.MANAGER) || request.isUserInRole(Role.LECTOR)) {
            model.addAttribute("slots", scheduleService.getAllSlots());
            return "main";
        }

        return "redirect:/index";
    }

    @RequestMapping("/slot/edit/{id}")
    public String editSlot(@PathVariable("id") Long id, HttpServletRequest request, Model model) {
        if (request.isUserInRole(Role.MANAGER)) {
            List<Course> courseList = new ArrayList<>();
            courseRepository.findAll().iterator().forEachRemaining(courseList::add);
            model.addAttribute("lectors", lectorService.getAllLectors());
            model.addAttribute("courses", courseList);


            SlotEntity slot = scheduleService.getById(id);
            model.addAttribute("slot", slot);
            SlotEditMapping slotEditMapping = new SlotEditMapping();
            model.addAttribute("slot_res", slotEditMapping);

            return "edit_slot";
        }

        return "redirect:/index";
    }

    @PostMapping("/editSlot/{id}")
    public String editSlot(@PathVariable("id") Long id, @ModelAttribute SlotEditMapping slotEditMapping) {
        logger.debug(slotEditMapping.toString());
        try {
            scheduleService.updateSlot(id, slotEditMapping.getLectorId(), slotEditMapping.getCourseId());
            return "redirect:/main";
        } catch (Exception e) {
            return "redirect:/index";
        }
    }
}
