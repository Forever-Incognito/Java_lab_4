package lpnu.repository;

import lpnu.entity.Train;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainRepository {
    private final List<Train> trains = new ArrayList<>();
    private long id = 1;

    public List<Train> getAllTrains() {
        return new ArrayList<>(trains);
    }

    public void deleteTrainById(final Long id) {
        for (final Train train : trains) {
            if (train.getId().equals(id)) {
                trains.remove(train);
                break;
            }
        }
    }

    public Train updateTrain(final Train train) {
        final Train savedTrain = getTrainById(train.getId());

        savedTrain.setNameOfConnection(train.getNameOfConnection());
        savedTrain.setDuration(train.getDuration());
        savedTrain.setMinAge(train.getMinAge());
        savedTrain.setPricePassengerSeat(train.getPricePassengerSeat());
        savedTrain.setPassengerSeat(train.getPassengerSeat());

        return savedTrain;
    }

    public void saveTrain(final Train train) {
        train.setId(id);
        ++id;
        trains.add(train);
    }

    public Train getTrainById(final Long id) {
        return trains.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "train with id " + id + " not found"));
    }

}