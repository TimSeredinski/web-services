package com.epam.travel_agency.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Country {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    @Size(max = 40, min = 3, message = "name not valid")
    @NotEmpty(message = "Please enter name")
    private String name;
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @OneToMany(mappedBy = "country")
//    private Set<Tour> tours;

    public Country(){
    }

    public Country(String name) {
        this.name = name;
    }

    public Country(Country country) {
        id = country.getId();
        name = country.getName();
    }

}
