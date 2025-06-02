package com.data.session16a.service;

import com.data.session16a.DAO.TicketDao;
import com.data.session16a.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketDao ticketDao;

    public void save(Ticket ticket) {
        ticketDao.save(ticket);
    }

    public List<Ticket> getByUserId(Long userId) {
        return ticketDao.findByUserId(userId);
    }
}
