package lpnu.controller;

import lpnu.dto.TrainDTO;
import lpnu.dto.PlatformDTO;
import lpnu.mapper.TrainToTrainDTOMapper;
import lpnu.mapper.PlatformToPlatformDTOMapper;
import lpnu.service.TrainService;
import lpnu.service.PlatformService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class PlatformController {
    private final PlatformService platformService;
    private final TrainService trainService;
    private final PlatformToPlatformDTOMapper platformMapper;
    private final TrainToTrainDTOMapper trainMapper;

    public PlatformController(final PlatformService platformService, final TrainService trainService,
                          final PlatformToPlatformDTOMapper platformMapper, final TrainToTrainDTOMapper trainMapper) {
        this.platformService = platformService;
        this.trainService = trainService;
        this.platformMapper = platformMapper;
        this.trainMapper = trainMapper;
    }

    @GetMapping("/platforms")
    public ResponseEntity<List<PlatformDTO>> getAllPlatforms() {
        return ResponseEntity.ok().body(platformService.getAllPlatforms());
    }

    @GetMapping("/platforms/{id}")
    public ResponseEntity<PlatformDTO> getPlatformById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(platformService.getPlatformById(id));
    }

    @PostMapping("/platforms")
    public ResponseEntity<PlatformDTO> savePlatform(@Validated @RequestBody final PlatformDTO platformDTO) {
        return ResponseEntity.ok().body(platformService.savePlatform(platformDTO));
    }

    @PutMapping("/platforms")
    public ResponseEntity<PlatformDTO> updatePlatform(@Validated @RequestBody final PlatformDTO platformDTO) {
        return ResponseEntity.ok().body(platformService.updatePlatform(platformDTO));
    }

    @PutMapping("/platforms-train/{id}")
    public ResponseEntity<PlatformDTO> addTrain(@Validated @RequestBody final TrainDTO trainDTO, @PathVariable final Long id){
        return ResponseEntity.ok().body(platformService.addTrain(trainDTO, id));
    }

    @DeleteMapping("/platforms/{id}")
    public ResponseEntity deletePlatformById(@PathVariable final Long id) {
        platformService.deletePlatformById(id);
        return ResponseEntity.ok().build();
    }
}
