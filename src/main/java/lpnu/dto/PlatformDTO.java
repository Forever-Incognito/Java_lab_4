package lpnu.dto;

import lpnu.entity.Platform;
import lpnu.entity.Train;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlatformDTO {
    private Long id;

    private List<Train> trains = new ArrayList<>();


    public PlatformDTO() {

    }

    public PlatformDTO(Long id, List<Train> trains) {
        this.id = id;
        this.trains = trains;
    }

    //Getter
    public Long getId() {
        return id;
    }

    public List<Train> getTrains() {
        return trains;
    }

    //Setter
    public void setId(final Long id) {
        this.id = id;
    }

    public void setTrains(final List<Train> trains) {
        this.trains = trains;
    }

}
