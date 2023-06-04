package ewm.server.model.place;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "places", schema = "public")
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Place {
    @Id
    @GeneratedValue
    @Column(name = "place_id")
    Long placeId;
    @Column(name = "name")
    String name;
    @Column(name = "lat")
    Double lat;
    @Column(name = "lon")
    Double lon;
    @Column(name = "radius")
    Double radius;
}
