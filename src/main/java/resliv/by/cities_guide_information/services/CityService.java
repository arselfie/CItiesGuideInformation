package resliv.by.cities_guide_information.services;

import resliv.by.cities_guide_information.entities.City;

import java.util.List;

public interface CityService {
    List<City> find();

    City find(Long id);

    City create(City city);

    City update(Long id, City city);

    void delete(Long id);

    List<City> findByNameContains(String name);
}
