package com.data.session16a.DAO;

import com.data.session16a.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketDao {
    @Autowired
    private JdbcTemplateAutoConfiguration jdbcTemplate;

    public void save(Ticket ticket) {
        String sql = "INSERT INTO ticket(user_id, trip_bus_id, list_seat, total_money, departure_date) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, ticket.getUserId(), ticket.getTripBusId(), ticket.getListSeat(), ticket.getTotalMoney(), ticket.getDepartureDate());
    }

    public List<Ticket> findByUserId(Long userId) {
        String sql = "SELECT * FROM ticket WHERE user_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Ticket.class), userId);
    }
}
