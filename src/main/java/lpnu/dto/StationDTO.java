package lpnu.dto;

import lpnu.entity.Platform;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StationDTO {
    private Long id;

    @NotBlank
    private String name;

    private List<Platform> platforms = new ArrayList<>();

    public StationDTO() {

    }

    public StationDTO(final Long id, final String name, List<Platform> platforms) {
        this.id = id;
        this.name = name;
        this.platforms = platforms;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationDTO that = (StationDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(platforms, that.platforms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, platforms);
    }
}
