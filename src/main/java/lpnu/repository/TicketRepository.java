package lpnu.repository;

import lpnu.dto.TicketDTO;
import lpnu.entity.Ticket;
import lpnu.entity.User;
import lpnu.exception.ServiceException;
import lpnu.mapper.TicketToTicketDTOMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketRepository {
    private final List<Ticket> tickets = new ArrayList<>();
    private long id = 1;

    private final UserRepository userRepository;
    private final PlatformRepository platformRepository;
    private final TicketToTicketDTOMapper ticketMapper;

    public TicketRepository(final UserRepository userRepository, final TicketToTicketDTOMapper ticketMapper,
                            final PlatformRepository platformRepository) {
        this.userRepository = userRepository;
        this.platformRepository = platformRepository;
        this.ticketMapper = ticketMapper;
    }

    public List<Ticket> getAllTickets() {
        return new ArrayList<>(tickets);
    }

    public void deleteTicketById(final Long id) {
        for (final Ticket ticket : tickets) {
            if (ticket.getId().equals(id)) {
                tickets.remove(ticket);
                break;
            }
        }
    }

    public Ticket updateTicket(final Ticket ticket) {
        final Ticket savedTicket = getTicketById(ticket.getId());

        savedTicket.setId(ticket.getId());
        savedTicket.setPrice(ticket.getPrice());
        savedTicket.setSeat(ticket.getSeat());
        savedTicket.setCarriage(ticket.getCarriage());
        savedTicket.setStationId(ticket.getStationId());
        savedTicket.setTrainId(ticket.getTrainId());
        savedTicket.setTrainId(ticket.getTrainId());

        return savedTicket;
    }

    public void saveTicket(final Ticket ticket) {
        ticket.setId(id);
        ++id;
        tickets.add(ticket);
    }

    public Ticket getTicketById(final Long id) {
        return tickets.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "ticket with id " + id + " not found"));
    }

    public void removeTicketFromUserByTicketId(final Long id) {
        TicketDTO ticketDTO = ticketMapper.toDTO(getTicketById(id));
        for (User user : userRepository.getAllUsers()) {
            user.getTicketDTOList().remove(ticketDTO);
        }
    }
}
