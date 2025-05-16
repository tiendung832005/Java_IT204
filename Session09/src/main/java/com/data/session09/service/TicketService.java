package com.data.session09.service;

import com.data.session09.dao.TicketDAO;
import com.data.session09.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TicketDAO ticketDAO;

    public void addTicket(Ticket ticket) {
        ticketDAO.addTicket(ticket);
    }
}
