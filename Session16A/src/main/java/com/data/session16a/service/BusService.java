package com.data.session16a.service;

import com.data.session16a.DAO.BusDao;
import com.data.session16a.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {
    @Autowired
    private BusDao busDao;

    public void save(Bus bus) {
        busDao.save(bus);
    }

    public List<Bus> getAll() {
        return busDao.findAll();
    }

    public Bus getById(Long id) {
        return busDao.findById(id);
    }

    public void update(Bus bus) {
        busDao.update(bus);
    }

    public void delete(Long id) {
        busDao.delete(id);
    }
}
