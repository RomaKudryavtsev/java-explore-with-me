package ewm.server.service.place;

import ewm.server.dto.event.EventShortDto;
import ewm.server.dto.event.LocationDto;
import ewm.server.dto.place.PlaceDto;
import ewm.server.exception.place.PlaceNotFoundException;
import ewm.server.exception.user.UserNotFoundException;
import ewm.server.mapper.place.PlaceMapper;
import ewm.server.model.place.Place;
import ewm.server.repo.event.EventRepo;
import ewm.server.repo.place.PlaceRepo;
import ewm.server.repo.user.UserRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PlaceServiceImpl implements PlaceService {
    UserRepo userRepo;
    EventRepo eventRepo;
    PlaceRepo placeRepo;

    @Override
    public PlaceDto addPlace(PlaceDto placeDto) {
        Place toBeAdded = PlaceMapper.mapDtoToModel(placeDto);
        return PlaceMapper.mapModelToDto(placeRepo.save(toBeAdded));
    }

    @Override
    public List<PlaceDto> getAllPlaces() {
        return placeRepo.findAll().stream().map(PlaceMapper::mapModelToDto).collect(Collectors.toList());
    }

    @Override
    public List<EventShortDto> getEventsNearbyPlace(Long placeId) {
        Place placeToBeSearched = placeRepo.findById(placeId).orElseThrow(() -> {
            throw new PlaceNotFoundException(String.format("Place %d has not been added by admin", placeId));
        });
        return null;
    }

    @Override
    public List<EventShortDto> getEventsNearbyUsersLocation(Long userId, LocationDto usersLocation) {
        checkIfUserExists(userId);
        return null;
    }

    private void checkIfUserExists(Long userId) {
        if (!userRepo.existsById(userId)) {
            throw new UserNotFoundException(String.format("User %d does not exist", userId));
        }
    }
}
