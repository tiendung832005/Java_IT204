package com.data.session16a.DAO;

import com.data.session16a.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BusDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Bus bus) {
        String sql = "INSERT INTO bus(license_plate, bus_type, row_seat, col_seat, total_seat, image) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, bus.getLicensePlate(), bus.getBusType(), bus.getRowSeat(), bus.getColSeat(), bus.getTotalSeat(), bus.getImage());
    }

    public List<Bus> findAll() {
        String sql = "SELECT * FROM bus";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Bus.class));
    }

    public Bus findById(Long id) {
        String sql = "SELECT * FROM bus WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Bus.class), id);
    }

    public void update(Bus bus) {
        String sql = "UPDATE bus SET license_plate=?, bus_type=?, row_seat=?, col_seat=?, total_seat=?, image=? WHERE id=?";
        jdbcTemplate.update(sql, bus.getLicensePlate(), bus.getBusType(), bus.getRowSeat(), bus.getColSeat(), bus.getTotalSeat(), bus.getImage(), bus.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM bus WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
