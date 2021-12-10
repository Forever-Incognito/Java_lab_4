package lpnu.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Platform {
    private Long id;
    private List<Train> trains = new ArrayList<>();

    public Platform(){

    }

    public Platform(final Long id, List<Train> trains){
        this.id = id;
        this.trains = trains;
    }

    public Long getId() {
        return id;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public void add(Platform platforms) {
    }

}
