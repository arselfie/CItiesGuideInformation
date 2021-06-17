package resliv.by.cities_guide_information.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import resliv.by.cities_guide_information.entities.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByNameContainingIgnoringCase(String name);

}
