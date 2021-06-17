package resliv.by.cities_guide_information.controllers;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import resliv.by.cities_guide_information.controllers.facade.CityFacade;
import resliv.by.cities_guide_information.controllers.facade.dto.CityDto;

import javax.validation.Valid;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class CityController {

    CityFacade cityFacade;

    @GetMapping("/api/v1/cities")
    public ResponseEntity<List<CityDto>> find() {

        return ResponseEntity.ok(cityFacade.find());
    }

    @PostMapping("/api/v1/cities")
    public ResponseEntity<CityDto> create(@Valid @RequestBody CityDto cityDto) {
        CityDto response = cityFacade.create(cityDto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/api/v1/cities/{cityId}")
    public ResponseEntity<CityDto> update(@PathVariable Long cityId,
                                             @Valid @RequestBody CityDto cityDto) {

        CityDto response = cityFacade.update(cityId, cityDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/api/v1/cities/{cityId}")
    public void delete(@PathVariable Long cityId) {

        cityFacade.delete(cityId);
    }
}
