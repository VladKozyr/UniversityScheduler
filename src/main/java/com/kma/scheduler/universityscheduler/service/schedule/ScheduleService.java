package com.kma.scheduler.universityscheduler.service.schedule;

import com.kma.scheduler.universityscheduler.model.Slot;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    public Slot[] getSchedule(int userId){
        return null;
    }

    public void addSlot(int userId, Slot slot){}
    public void cleanSchedule(int userId){}
    public boolean updateSchedule(int userId, Slot slot){return true;}
}
