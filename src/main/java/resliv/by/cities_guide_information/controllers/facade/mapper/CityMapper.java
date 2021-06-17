package resliv.by.cities_guide_information.controllers.facade.mapper;

import org.springframework.stereotype.Component;
import resliv.by.cities_guide_information.controllers.facade.dto.CityDto;
import resliv.by.cities_guide_information.entities.City;

@Component
public class CityMapper {

    public CityDto toDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .description(city.getDescription())
                .build();
    }

    public City toEntity(CityDto cityDto, boolean isCreate) {
        City city = new City();

        if (isCreate) {
            city.setId(cityDto.getId());
        }

        city.setName(cityDto.getName());
        city.setDescription(cityDto.getDescription());

        return city;
    }

}
