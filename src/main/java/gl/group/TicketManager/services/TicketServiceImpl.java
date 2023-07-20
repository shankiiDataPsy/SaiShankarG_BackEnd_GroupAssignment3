package gl.group.TicketManager.services;

import gl.group.TicketManager.entities.Ticket;
import gl.group.TicketManager.repos.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    TicketRepo repo;

    @Override
    public List<Ticket> getAllTickets() {
        return repo.findAll();
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        ticket.setCreatedDate(new Date().toString());
        return repo.save(ticket);
    }

    @Override
    public Ticket getTicket(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Ticket editTicket(Ticket ticket, Long id) {
        return repo.save(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Ticket> searchTickets(String text) {
        return repo.getAllTicketsMathingSearchString(text);
    }
}
