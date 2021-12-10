package lpnu.service;

import lpnu.dto.TrainDTO;

import java.util.List;

public interface TrainService {
    TrainDTO saveTrain(final TrainDTO trainDTO);
    List<TrainDTO> getAllTrains();
    TrainDTO getTrainById(final Long id);
    TrainDTO updateTrain(final TrainDTO trainDTO);
    void deleteTrainById(final Long id);
}
