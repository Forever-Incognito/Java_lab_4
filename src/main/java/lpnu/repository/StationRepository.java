package lpnu.repository;

import lpnu.entity.Station;
import lpnu.entity.Train;
import lpnu.entity.Platform;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StationRepository {
    private final List<Station> stations = new ArrayList<>();
    private long id = 1;

    public List<Station> getAllStations() {
        return new ArrayList<>(stations);
    }

    public void deleteStationById(final Long id) {
        for (final Station station : stations) {
            if (station.getId().equals(id)) {
                stations.remove(station);
                break;
            }
        }
    }

    public Station updateStation(final Station station) {
        final Station savedStation = getStationById(station.getId());

        savedStation.setName(station.getName());
        savedStation.setPlatforms(station.getPlatforms());

        return savedStation;
    }

    public void saveStation(final Station station) {
        station.setId(id);
        ++id;
        stations.add(station);
    }

    public Station getStationById(final Long id) {
        return stations.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "train with id '" + id + "' not found"));
    }

    public Station addPlatform(final Platform platform, final Long id) {
        final Station station = getStationById(id);

        if (station.getPlatforms().stream().anyMatch(platform::equals)) {
            throw new ServiceException(400, "there is already such platform");
        } else {
            station.getPlatforms().add(platform);
        }
        return station;
    }

    public Station addTrain(final Train train, final Long stationId, final Long platformId) {
        final Station cinema = getStationById(stationId);

        if (cinema.getPlatforms().get(platformId.intValue() - 1).getTrains().stream().anyMatch(train::equals)) {
            throw new ServiceException(400, "there is already such train");
        } else {
            cinema.getPlatforms().get(platformId.intValue() - 1).getTrains().add(train);
        }

        return cinema;
    }
}
