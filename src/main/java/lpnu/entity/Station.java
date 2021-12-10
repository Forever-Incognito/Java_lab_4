package lpnu.entity;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Station {
    private Long id;

    @NotBlank
    private String name;

    private List<Platform> platforms = new ArrayList<>();

    public Station(){

    }

    public Station(final Long id, final String name, final List<Platform> platforms){
        this.id = id;
        this.name = name;
        this.platforms = platforms;
    }

    //Getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    //Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public void addPlatform(final Platform platforms) {
        platforms.add(platforms);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(id, station.id) && Objects.equals(name, station.name) && Objects.equals(platforms, station.platforms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, platforms);
    }
}
