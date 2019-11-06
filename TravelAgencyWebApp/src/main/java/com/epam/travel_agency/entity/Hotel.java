package com.epam.travel_agency.entity;


import com.epam.travel_agency.entity.enums.Features;
import com.vladmihalcea.hibernate.type.array.EnumArrayType;
import lombok.*;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Entity
@ToString
@TypeDef(
        typeClass = EnumArrayType.class,
        defaultForType = Features[].class,
        parameters = {
                @Parameter(
                        name = EnumArrayType.SQL_ARRAY_TYPE,
                        value = "features"
                )
        }
)
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    @Size(max = 40, min = 3, message = "name not valid")
    @NotEmpty(message = "Please enter name")
    private String name;
    @Min(value = 1)
    private int stars;
    private String website;
    private double lalitude;
    private double longitude;
    @Column(
            name = "features",
            columnDefinition = "features[]"
    )
    private Features[] features;
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @OneToMany(mappedBy = "hotel")
//    private Set<Tour> tours;

    public Hotel() {
    }
}

