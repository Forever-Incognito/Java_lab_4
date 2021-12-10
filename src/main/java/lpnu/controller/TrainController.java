package lpnu.controller;

import lpnu.dto.TrainDTO;
import lpnu.service.TrainService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class TrainController {
    private final TrainService trainService;

    public TrainController(final TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping("/trains")
    public ResponseEntity<List<TrainDTO>> getTrainHalls() {
        return ResponseEntity.ok().body(trainService.getAllTrains());
    }

    @GetMapping("/trains/{id}")
    public ResponseEntity<TrainDTO> getTrainById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(trainService.getTrainById(id));
    }

    @PostMapping("/trains")
    public ResponseEntity<TrainDTO> saveTrain(@Validated @RequestBody final TrainDTO trainDTO) {
        return ResponseEntity.ok().body(trainService.saveTrain(trainDTO));
    }

    @PutMapping("/trains")
    public ResponseEntity<TrainDTO> updateTrain(@Validated @RequestBody final TrainDTO trainDTO) {
        return ResponseEntity.ok().body(trainService.updateTrain(trainDTO));
    }

    @DeleteMapping("/trains/{id}")
    public ResponseEntity deleteTrainById(@PathVariable final Long id) {
        trainService.deleteTrainById(id);
        return ResponseEntity.ok().build();
    }
}
