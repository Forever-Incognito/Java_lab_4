package lpnu.service.impl;

import lpnu.dto.StationDTO;
import lpnu.dto.TrainDTO;
import lpnu.dto.PlatformDTO;
import lpnu.entity.Station;
import lpnu.entity.Train;
import lpnu.entity.Platform;
import lpnu.exception.ServiceException;
import lpnu.mapper.StationToStationDTOMapper;
import lpnu.mapper.TrainToTrainDTOMapper;
import lpnu.mapper.PlatformToPlatformDTOMapper;
import lpnu.repository.StationRepository;
import lpnu.service.StationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationServiceImpl implements StationService {
    private final StationToStationDTOMapper stationMapper;
    private final PlatformToPlatformDTOMapper platformMapper;
    private final TrainToTrainDTOMapper trainMapper;
    private final StationRepository stationRepository;

    public StationServiceImpl(final StationToStationDTOMapper stationMapper, final PlatformToPlatformDTOMapper hallMapper,
                             final TrainToTrainDTOMapper trainMapper, final StationRepository stationRepository) {
        this.stationMapper = stationMapper;
        this.platformMapper = hallMapper;
        this.trainMapper = trainMapper;
        this.stationRepository = stationRepository;
    }

    @Override
    public List<StationDTO> getAllStations() {
        return stationRepository.getAllStations().stream()
                .map(stationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StationDTO getStationById(final Long id) {
        return stationMapper.toDTO(stationRepository.getStationById(id));
    }

    @Override
    public void deleteStationById(final Long id) {
        stationRepository.deleteStationById(id);
    }

    @Override
    public StationDTO saveStation(final StationDTO stationDTO) {
        if(stationDTO.getId() != null){
            throw new ServiceException(400, "id not null");
        }

        Station station = stationMapper.toEntity(stationDTO);

        if (stationRepository.getAllStations().stream().anyMatch(stationMapper.toEntity(stationDTO)::equals)){
            throw new ServiceException(400, "station is already saved");
        }

        stationRepository.saveStation(station);
        return stationMapper.toDTO(station);
    }

    @Override
    public StationDTO addPlatform(final PlatformDTO hallDTO, final Long id) {
        final Station station = stationRepository.addPlatform(platformMapper.toEntity(hallDTO), id);

        stationRepository.saveStation(station);
        return stationMapper.toDTO(station);
    }

    @Override
    public StationDTO addTrain(final TrainDTO trainDTO, final Long stationId, final Long hallId) {
        final Station station = stationRepository.addTrain(trainMapper.toEntity(trainDTO), stationId, hallId);

        stationRepository.saveStation(station);
        return stationMapper.toDTO(station);
    }
}