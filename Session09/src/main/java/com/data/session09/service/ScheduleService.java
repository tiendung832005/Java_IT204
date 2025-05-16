package com.data.session09.service;


import com.data.session09.dao.ScheduleDAO;
import com.data.session09.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleDAO scheduleDAO;

    public List<Schedule> findAllScheduleByMovie(String movieTitle) {
        return scheduleDAO.findAllScheduleByMovie(movieTitle);
    }
}
