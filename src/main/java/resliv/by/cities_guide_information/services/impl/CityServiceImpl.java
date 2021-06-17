package resliv.by.cities_guide_information.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import resliv.by.cities_guide_information.entities.City;
import resliv.by.cities_guide_information.repositories.CityRepository;
import resliv.by.cities_guide_information.services.CityService;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class CityServiceImpl implements CityService {

    CityRepository cityRepository;

    @Override
    public List<City> find() {
        return cityRepository.findAll();
    }

    @Override
    public City find(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public City create(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City update(Long id, City city) {
        City existedCity = find(id);

        if (existedCity != null) {
            existedCity.setName(city.getName());
            existedCity.setDescription(city.getDescription());
            cityRepository.save(existedCity);
        }

        return existedCity;
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
