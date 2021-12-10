package lpnu.mapper;

import lpnu.dto.PlatformDTO;
import lpnu.entity.Platform;
import org.springframework.stereotype.Component;

public class PlatformToPlatformDTOMapper {
    public Platform toEntity(final PlatformDTO platformDTO){
        return new Platform(
                platformDTO.getId(),
                platformDTO.getTrains());
    }
    public PlatformDTO toDTO(final Platform platform){
        return new PlatformDTO(
                platform.getId(),
                platform.getTrains());

    }
}
