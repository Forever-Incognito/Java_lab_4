package lpnu.dto;

import lpnu.entity.Ticket;

import javax.validation.constraints.Min;
import java.util.Objects;

public class TicketDTO {
    private static final double MARK_UP = 220;
    private static final double STANDART_Price = 250;

    private Long id;

    @Min(175)
    private double price;

    @Min(1)
    private int seat;

    @Min(1)
    private int carriage;

    @Min(1)
    private Long stationId;

    @Min(1)
    private Long platformId;

    @Min(1)
    private Long trainId;

    public TicketDTO(){

    }

    public TicketDTO(final Long id, final double price, final int seat, final int carriage,
                  final Long stationId, final Long platformId, final Long trainId){
        this.id = id;
        this.price = price;
        this.seat = seat;
        this.carriage = carriage;
        this.stationId = stationId;
        this.platformId = platformId;
        this.trainId = trainId;
    }

    //Getter
    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getSeat() {
        return seat;
    }

    public int getCarriage() {
        return carriage;
    }

    public Long getStationId() {
        return stationId;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public Long getTrainId() {
        return trainId;
    }

    //Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setCarriage(int carriage) {
        this.carriage = carriage;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDTO ticketDTO = (TicketDTO) o;
        return Double.compare(ticketDTO.price, price) == 0 && seat == ticketDTO.seat && carriage == ticketDTO.carriage && Objects.equals(id, ticketDTO.id) && Objects.equals(stationId, ticketDTO.stationId) && Objects.equals(platformId, ticketDTO.platformId) && Objects.equals(trainId, ticketDTO.trainId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, seat, carriage, stationId, platformId, trainId);
    }
}
