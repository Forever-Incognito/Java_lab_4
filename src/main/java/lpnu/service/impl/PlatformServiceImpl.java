package lpnu.service.impl;

import lpnu.dto.TrainDTO;
import lpnu.dto.PlatformDTO;
import lpnu.entity.Train;
import lpnu.entity.Platform;
import lpnu.exception.ServiceException;
import lpnu.mapper.TrainToTrainDTOMapper;
import lpnu.mapper.PlatformToPlatformDTOMapper;
import lpnu.repository.PlatformRepository;
import lpnu.service.PlatformService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatformServiceImpl implements PlatformService {
    private final PlatformToPlatformDTOMapper platformMapper;
    private final TrainToTrainDTOMapper trainMapper;
    private final PlatformRepository platformRepository;
    private final TrainServiceImpl trainService;

    public PlatformServiceImpl(final PlatformToPlatformDTOMapper platformMapper, final TrainToTrainDTOMapper trainMapper,
                           final PlatformRepository platformRepository, final TrainServiceImpl trainService) {
        this.platformMapper = platformMapper;
        this.trainMapper = trainMapper;
        this.platformRepository = platformRepository;
        this.trainService = trainService;
    }

    @Override
    public List<PlatformDTO> getAllPlatforms() {
        return platformRepository.getAllPlatforms().stream()
                .map(platformMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlatformDTO getPlatformById(final Long id) {
        return platformMapper.toDTO(platformRepository.getPlatformById(id));
    }

    @Override
    public void deletePlatformById(final Long id) {
        platformRepository.deletePlatformById(id);
    }

    @Override
    public PlatformDTO updatePlatform(final PlatformDTO platformDTO) {
        if (platformDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }

        final Platform platform = platformRepository.updateAllTrainsInPlatform(platformMapper.toEntity(platformDTO));
        return platformMapper.toDTO(platformRepository.updatePlatform(platform));
    }

    @Override
    public PlatformDTO savePlatform(final PlatformDTO platformDTO) {
        if(platformDTO.getId() != null){
            throw new ServiceException(400, "id not null");
        }

        Platform platform = platformMapper.toEntity(platformDTO);
        platform = platformRepository.updateAllTrainsInPlatform(platform);

        if (platformRepository.getAllPlatforms().stream().anyMatch(platformMapper.toEntity(platformDTO)::equals)) {
            throw new ServiceException(400, "platform is already saved");
        }

        platformRepository.savePlatform(platform);
        return platformMapper.toDTO(platform);
    }

    @Override
    public PlatformDTO addTrain(final TrainDTO trainDTO, final Long id) {
        final Train newTrain = trainMapper.toEntity(trainService.saveTrain(trainDTO));
        final Train train = platformRepository.addTrain(newTrain, id);

        platformRepository.savePlatform(platform);
        return platformMapper.toDTO(platform);
    }
}
