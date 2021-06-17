package resliv.by.cities_guide_information.controllers.facade.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class CityDto {

    Long id;

    @NotEmpty(message = "Missing or empty required param: 'name'.")
    String name;

    String description;

}
