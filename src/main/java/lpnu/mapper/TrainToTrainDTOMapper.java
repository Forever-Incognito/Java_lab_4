package lpnu.mapper;

import lpnu.dto.TrainDTO;
import lpnu.entity.Train;
import org.springframework.stereotype.Component;

@Component
public class TrainToTrainDTOMapper {
    public Train toEntity(final TrainDTO trainDTO){
        return new Train(
                trainDTO.getId(),
                trainDTO.getDuration(),
                trainDTO.getDistance(),
                trainDTO.getNameOfConnection(),
                trainDTO.getMinAge(),
                trainDTO.getPassengerSeat());
    }

    public Train toFullEntity(final TrainDTO trainDTO){
        return new Train(
                trainDTO.getId(),
                trainDTO.getDuration(),
                trainDTO.getDistance(),
                trainDTO.getNameOfConnection(),
                trainDTO.getMinAge(),
                trainDTO.getPricePassengerSeat(),
                trainDTO.getPassengerSeat());
    }

    public TrainDTO toDTO(final Train train){
        return new TrainDTO(
                train.getId(),
                train.getDuration(),
                train.getDistance(),
                train.getNameOfConnection(),
                train.getMinAge(),
                train.getPricePassengerSeat(),
                train.getPassengerSeat());
    }
}
