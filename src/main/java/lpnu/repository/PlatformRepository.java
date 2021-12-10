package lpnu.repository;

import lpnu.entity.Train;
import lpnu.entity.Platform;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatformRepository {
    private final List<Platform> platforms = new ArrayList<>();
    private long id = 1;

    public List<Platform> getAllPlatforms() {
        return new ArrayList<>(platforms);
    }

    public void deletePlatformById(final Long id) {
        for (final Platform platform : platforms) {
            if (platform.getId().equals(id)) {
                platforms.remove(platform);
                break;
            }
        }
    }

    public void savePlatform(final Platform platform) {
        platform.setId(id);
        ++id;
        platform.add(platform);
    }

    public Platform getPlatformById(final Long id) {
        return platforms.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "platform with id " + id + " not found"));
    }

    public Platform addTrain(final Train train, final Long id) {
        final Platform platform = getPlatformById(id);

        if (platform.getTrains().stream().anyMatch(train::equals)) {
            throw new ServiceException(400, "there is already such train");
        } else {
            platform.getTrains().add(train);
        }
        return platform;
    }


}
