package lpnu.mapper;

import lpnu.dto.TicketDTO;
import lpnu.entity.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketToTicketDTOMapper {
    public Ticket toEntity(final TicketDTO ticketDTO){
        return new Ticket(
                ticketDTO.getId(),
                ticketDTO.getSeat(),
                ticketDTO.getCarriage(),
                ticketDTO.getStationId(),
                ticketDTO.getPlatformId(),
                ticketDTO.getTrainId());
    }
    public TicketDTO toDTO(final Ticket ticket){
        return new TicketDTO(
                ticket.getId(),
                ticket.getPrice(),
                ticket.getSeat(),
                ticket.getCarriage(),
                ticket.getStationId(),
                ticket.getPlatformId(),
                ticket.getTrainId());
    }
}
