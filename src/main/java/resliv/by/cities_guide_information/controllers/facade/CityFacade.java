package resliv.by.cities_guide_information.controllers.facade;

import resliv.by.cities_guide_information.controllers.facade.dto.CityDto;

import java.util.List;

public interface CityFacade {
    List<CityDto> find();

    CityDto find(Long id);

    CityDto create(CityDto cityDto);

    CityDto update(Long id, CityDto cityDto);

    void delete(Long id);
}
