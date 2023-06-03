package ewm.server.dto.event;

import ewm.server.dto.category.CategoryDto;
import ewm.server.dto.user.UserShortDto;
import ewm.server.model.event.EventStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventFullDto {
    Long id;
    String annotation;
    CategoryDto category;
    int confirmedRequests;
    String createdOn;
    String description;
    String eventDate;
    UserShortDto initiator;
    LocationDto location;
    Boolean paid;
    int participantLimit;
    String publishedOn;
    Boolean requestModeration;
    EventStatus state;
    String title;
    Integer views;
}
