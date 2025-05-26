package com.data.session12.service;



import com.data.session12.model.Bus;
import com.data.session12.repository.BusRepository;

import java.sql.SQLException;
import java.util.List;

public class BusService {
    private final BusRepository busRepository = new BusRepository();

    public void save(Bus bus) throws SQLException {
        busRepository.save(bus);
    }

    public List<Bus> findAll() throws SQLException {
        return busRepository.findAll();
    }

    public void deleteById(int id) throws SQLException {
        busRepository.deleteById(id);
    }
}