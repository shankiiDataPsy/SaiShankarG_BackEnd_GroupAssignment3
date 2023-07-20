package gl.group.TicketManager.entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ticketNumber;
    private String ticketDescription;
    private String ticketContent;
    private String createdDate;

}
