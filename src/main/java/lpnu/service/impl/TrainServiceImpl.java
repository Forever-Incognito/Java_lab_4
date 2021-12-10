package lpnu.service.impl;


import lpnu.dto.TrainDTO;
import lpnu.entity.Train;
import lpnu.exception.ServiceException;
import lpnu.mapper.TrainToTrainDTOMapper;
import lpnu.repository.TrainRepository;
import lpnu.service.TrainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainServiceImpl implements TrainService {
    private final TrainToTrainDTOMapper trainMapper;
    private final TrainRepository trainRepository;

    public TrainServiceImpl(final TrainToTrainDTOMapper trainMapper, final TrainRepository trainRepository) {
        this.trainMapper = trainMapper;
        this.trainRepository = trainRepository;
    }

    @Override
    public List<TrainDTO> getAllTrains() {
        return trainRepository.getAllTrains().stream()
                .map(trainMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TrainDTO getTrainById(final Long id) {
        return trainMapper.toDTO(trainRepository.getTrainById(id));
    }

    @Override
    public void deleteTrainById(final Long id) {
        trainRepository.deleteTrainById(id);
    }

    @Override
    public TrainDTO updateTrain(final TrainDTO trainDTO) {
        if (trainDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }

        final Train train = trainRepository.calculateAndUpdatePrice(trainMapper.toEntity(trainDTO));
        return trainMapper.toDTO(trainRepository.updateTrain(train));
    }

    @Override
    public TrainDTO saveTrain(final TrainDTO trainDTO) {
        if (trainDTO.getId() != null) {
            throw new ServiceException(400, "id not null");
        }

        final Train train = trainRepository.calculateAndUpdatePrice(trainMapper.toEntity(trainDTO));
        if (trainRepository.getAllTrains().stream().anyMatch(trainMapper.toEntity(trainDTO)::equals)) {
            throw new ServiceException(400, "train is already saved");
        }

        trainRepository.saveTrain(train);
        return trainMapper.toDTO(train);
    }
}
