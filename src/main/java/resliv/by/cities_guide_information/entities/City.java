package resliv.by.cities_guide_information.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import static lombok.AccessLevel.PRIVATE;

@Entity(name = "city")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
public class City extends BaseEntity {

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;
}
