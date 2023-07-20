package gl.group.TicketManager.services;

import gl.group.TicketManager.entities.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> getAllTickets();
    Ticket addTicket(Ticket ticket);
    Ticket getTicket(Long id);

    Ticket editTicket(Ticket ticket, Long id);
    void deleteTicket(Long id);

    List<Ticket> searchTickets(String text);

}
