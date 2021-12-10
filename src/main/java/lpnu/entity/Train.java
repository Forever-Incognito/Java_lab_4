package lpnu.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class Train {
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

    public Train(){

    }

    public Train(final Long id, final double duration, final double distance,final String nameOfConnection,
                 final int minAge, double pricePassengerSeat, final String passengerSeat){
        this.id = id;
        this.duration = duration;
        this.distance = distance;
        this.nameOfConnection = nameOfConnection;
        this.minAge = minAge;
        this.pricePassengerSeat = pricePassengerSeat;
        this.passengerSeat = passengerSeat;
    }

    public Train(final Long id, final double duration, final double distance,final String nameOfConnection,
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
        Train train = (Train) o;
        return Double.compare(train.id, id) == 0 &&  Double.compare(train.duration, duration) == 0 && Double.compare(train.distance, distance) == 0 && minAge == train.minAge && Double.compare(train.pricePassengerSeat, pricePassengerSeat) == 0 && Objects.equals(id, train.id) && Objects.equals(nameOfConnection, train.nameOfConnection) && Objects.equals(passengerSeat, train.passengerSeat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration, distance, nameOfConnection, minAge, pricePassengerSeat, passengerSeat);
    }
}
