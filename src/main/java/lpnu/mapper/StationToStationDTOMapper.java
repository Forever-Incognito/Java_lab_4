package lpnu.mapper;

import lpnu.dto.StationDTO;
import lpnu.entity.Station;
import org.springframework.stereotype.Component;

public class StationToStationDTOMapper {
    public Station toEntity(final StationDTO stationDTO){
        return new Station(
                stationDTO.getId(),
                stationDTO.getName(),
                stationDTO.getPlatforms());
    }
    public StationDTO toDTO(final Station station){
        return new StationDTO(
                station.getId(),
                station.getName(),
                station.getPlatforms());
    }
}
