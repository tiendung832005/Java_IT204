package com.data.session16a.DAO;

import com.data.session16a.model.BusTrip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BusTripDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(BusTrip trip) {
        String sql = "INSERT INTO bus_trip(departure_point, destination, departure_time, arrival_time, bus_id, seats_available, image) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, trip.getDeparturePoint(), trip.getDestination(), trip.getDepartureTime(), trip.getArrivalTime(), trip.getBusId(), trip.getSeatsAvailable(), trip.getImage());
    }

    public List<BusTrip> findAll() {
        String sql = "SELECT * FROM bus_trip";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BusTrip.class));
    }

    public BusTrip findById(Long id) {
        String sql = "SELECT * FROM bus_trip WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BusTrip.class), id);
    }

    public void update(BusTrip trip) {
        String sql = "UPDATE bus_trip SET departure_point=?, destination=?, departure_time=?, arrival_time=?, bus_id=?, seats_available=?, image=? WHERE id=?";
        jdbcTemplate.update(sql, trip.getDeparturePoint(), trip.getDestination(), trip.getDepartureTime(), trip.getArrivalTime(), trip.getBusId(), trip.getSeatsAvailable(), trip.getImage(), trip.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM bus_trip WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public List<BusTrip> search(String departure, String destination) {
        String sql = "SELECT * FROM bus_trip WHERE departure_point LIKE ? AND destination LIKE ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BusTrip.class), "%" + departure + "%", "%" + destination + "%");
    }
}
