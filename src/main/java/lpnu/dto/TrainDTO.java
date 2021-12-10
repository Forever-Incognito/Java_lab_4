package lpnu.dto;

import lpnu.entity.Train;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class TrainDTO {
    public static final double MARK_UP = 220;
    public static final double STANDART_PRICE = 250;
    private Long id;

    @Min(1)
    @Max(26)
    private double duration;

    @Min(1)
    @Max(1365)
    private double distance;

    @NotBlank
    private String nameOfConnection; //for example: "Lviv-Kyiv"

    @Min(0)
    @Max(18)
    private int minAge;

    private double pricePassengerSeat;

    @NotBlank
    private String passengerSeat ;

    public TrainDTO(){

    }

    public TrainDTO(final Long id, final double duration, final double distance,final String nameOfConnection,
                 final int minAge, double pricePassengerSeat, final String passengerSeat){
        this.id = id;
        this.duration = duration;
        this.distance = distance;
        this.nameOfConnection = nameOfConnection;
        this.minAge = minAge;
        this.pricePassengerSeat = pricePassengerSeat;
        this.passengerSeat = passengerSeat;
    }

    public TrainDTO(final Long id, final double duration, final double distance,final String nameOfConnection,
                 final int minAge, final String passengerSeat){
        this.id = id;
        this.duration = duration;
        this.distance = distance;
        this.nameOfConnection = nameOfConnection;
        this.minAge = minAge;
        this.passengerSeat = passengerSeat;
    }

    //Getter
    public Long getId() {
        return id;
    }

    public double getDuration() {
        return duration;
    }

    public double getDistance() {
        return distance;
    }

    public String getNameOfConnection() {
        return nameOfConnection;
    }

    public int getMinAge() {
        return minAge;
    }

    public double getPricePassengerSeat() {
        return pricePassengerSeat;
    }

    public String getPassengerSeat() {
        return passengerSeat;
    }

    //Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setNameOfConnection(String nameOfConnection) {
        this.nameOfConnection = nameOfConnection;
    }

    public int setMinAge(int minAge) {
        return minAge;
    }

    public void setPricePassengerSeat(double pricePassengerSeat) {
        this.pricePassengerSeat = pricePassengerSeat;
    }

    public void setPassengerSeat(String passengerSeat) {
        this.passengerSeat = passengerSeat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainDTO trainDTO = (TrainDTO) o;
        return Double.compare(trainDTO.id, id) == 0 &&  Double.compare(trainDTO.duration, duration) == 0 && Double.compare(trainDTO.distance, distance) == 0 && minAge == trainDTO.minAge && Double.compare(trainDTO.pricePassengerSeat, pricePassengerSeat) == 0 && Objects.equals(id, trainDTO.id) && Objects.equals(nameOfConnection, trainDTO.nameOfConnection) && Objects.equals(passengerSeat, trainDTO.passengerSeat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration, distance, nameOfConnection, minAge, pricePassengerSeat, passengerSeat);
    }
}
