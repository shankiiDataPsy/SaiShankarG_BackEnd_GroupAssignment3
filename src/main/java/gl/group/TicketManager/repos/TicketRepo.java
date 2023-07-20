package gl.group.TicketManager.repos;

import gl.group.TicketManager.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE LOWER(t.ticketNumber) LIKE %:text%")
    List<Ticket> getAllTicketsMathingSearchString(@Param("text") String text);

}
