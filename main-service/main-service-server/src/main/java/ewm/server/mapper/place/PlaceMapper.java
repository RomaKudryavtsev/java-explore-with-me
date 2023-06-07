package ewm.server.mapper.place;

import ewm.server.dto.place.PlaceDto;
import ewm.server.model.place.Place;

public class PlaceMapper {
    public static Place mapDtoToModel(PlaceDto dto) {
        Place place = new Place();
        place.setName(dto.getName());
        place.setLatitude(dto.getLatitude());
        place.setLongitude(dto.getLongitude());
        place.setRadius(dto.getRadius());
        return place;
    }

    public static PlaceDto mapModelToDto(Place model) {
        return PlaceDto.builder()
                .placeId(model.getPlaceId())
                .name(model.getName())
                .latitude(model.getLatitude())
                .longitude(model.getLongitude())
                .radius(model.getRadius())
                .build();
    }
}
