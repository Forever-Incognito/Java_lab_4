package lpnu.service;


import lpnu.dto.TrainDTO;
import lpnu.dto.PlatformDTO;

import java.util.List;

public interface PlatformService {
    PlatformDTO savePlatform(final PlatformDTO hallDTO);

    List<PlatformDTO> getAllPlatforms();

    PlatformDTO getPlatformById(final Long id);

    PlatformDTO updatePlatform(final PlatformDTO platformDTO);

    void deletePlatformById(final Long id);

    PlatformDTO addTrain(final TrainDTO trainDTO, final Long id);
}
