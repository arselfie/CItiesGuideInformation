package resliv.by.cities_guide_information.controllers.facade.impl;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import resliv.by.cities_guide_information.controllers.facade.CityFacade;
import resliv.by.cities_guide_information.controllers.facade.dto.CityDto;
import resliv.by.cities_guide_information.controllers.facade.mapper.CityMapper;
import resliv.by.cities_guide_information.entities.City;
import resliv.by.cities_guide_information.services.CityService;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class CityFacadeImpl implements CityFacade {

    CityService cityService;
    CityMapper cityMapper;

    @Override
    public List<CityDto> find() {
        return cityService
                .find().stream()
                .map(cityMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CityDto find(Long id) {
        return cityMapper.toDto(cityService.find(id));
    }

    @Override
    public CityDto create(CityDto cityDto) {
        City city = cityService.create(cityMapper.toEntity(cityDto, true));
        return cityMapper.toDto(city);
    }

    @Override
    public CityDto update(Long id, CityDto cityDto) {
        City city = cityService.update(id, cityMapper.toEntity(cityDto, false));
        return cityMapper.toDto(city);
    }

    @Override
    public void delete(Long id) {
        cityService.delete(id);
    }
}
