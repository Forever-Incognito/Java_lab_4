package lpnu.service;

import lpnu.dto.StationDTO;
import lpnu.dto.TrainDTO;
import lpnu.dto.PlatformDTO;

import java.util.List;

public interface StationService {
    StationDTO saveStation(final StationDTO stationDTO);

    List<StationDTO> getAllStations();

    StationDTO getStationById(final Long id);

    StationDTO updateStation(final StationDTO stationDTO);

    void deleteStationById(final Long id);

    StationDTO addPlatform(final PlatformDTO platformDTO, final Long id);

    StationDTO addTrain(final TrainDTO trainDTO, final Long stationId, final Long platformId);
}
