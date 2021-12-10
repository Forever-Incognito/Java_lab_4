package lpnu.controller;

import lpnu.dto.StationDTO;
import lpnu.dto.TrainDTO;
import lpnu.dto.PlatformDTO;
import lpnu.service.StationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class StationController {
    private final StationService stationService;

    public StationController(final StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("/station")
    public List<StationDTO> getAllStation() {
        return stationService.getAllStations();
    }

    @GetMapping("/station/{id}")
    public StationDTO getStationById(@PathVariable final Long id) {
        return stationService.getStationById(id);
    }

    @PostMapping("/station")
    public StationDTO saveStation(@Validated @RequestBody final StationDTO stationDTO) {
        return stationService.saveStation(stationDTO);
    }

    @PutMapping("/station")
    public StationDTO updatePlatform(@Validated @RequestBody final StationDTO stationDTO) {
        return stationService.updateStation(stationDTO);
    }

    @PutMapping("/station-platform/{id}")
    public StationDTO addPlatform(@Validated @RequestBody final PlatformDTO platformDTO, @PathVariable final Long id){
        return stationService.addPlatform(platformDTO, id);
    }

    @PutMapping("/station-train/{id}/{id}")
    public StationDTO addStation(@Validated @RequestBody final TrainDTO trainDTO, @PathVariable final Long stationId, @PathVariable final Long platformId){
        return stationService.addTrain(trainDTO, stationId, platformId);
    }

    @DeleteMapping("/station/{id}")
    public ResponseEntity deleteStationById(@PathVariable final Long id) {
        stationService.deleteStationById(id);
        return ResponseEntity.ok().build();
    }
}
