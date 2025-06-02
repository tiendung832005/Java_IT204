package com.data.session16a.service;

import com.data.session16a.DAO.BusTripDao;
import com.data.session16a.model.BusTrip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusTripService {
    @Autowired
    private BusTripDao busTripDao;

    public void save(BusTrip trip) {
        busTripDao.save(trip);
    }

    public List<BusTrip> getAll() {
        return busTripDao.findAll();
    }

    public BusTrip getById(Long id) {
        return busTripDao.findById(id);
    }

    public void update(BusTrip trip) {
        busTripDao.update(trip);
    }

    public void delete(Long id) {
        busTripDao.delete(id);
    }

    public List<BusTrip> search(String departure, String destination) {
        return busTripDao.search(departure, destination);
    }
}
