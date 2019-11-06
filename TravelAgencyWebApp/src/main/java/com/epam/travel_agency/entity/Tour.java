package com.epam.travel_agency.entity;

import com.epam.travel_agency.entity.enums.TourType;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
@Entity
@ToString
@TypeDef(
        name = "tour_type",
        typeClass = PostgreSQLEnumType.class
)
@AllArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String photo;
    private Date date;
    @Min(value = 1)
    private int duration;
    private String description;
    @Min(value = 1)
    private int cost;

    @Enumerated(EnumType.STRING)
    @Type(type = "tour_type")
    @Column(
            name = "tour_type",
            columnDefinition = "tour_type"
    )
    private TourType tourType;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @OneToMany(mappedBy = "tour", fetch = FetchType.EAGER)
//    private Set<Review> reviews;
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @ManyToMany(mappedBy = "tours")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Set<User> users = new HashSet<>();

    public Tour() {
    }

    public Tour(String photo, @Min(value = 1) int duration, String description, @Min(value = 1) int cost, TourType tourType) {
        this.photo = photo;
        this.duration = duration;
        this.description = description;
        this.cost = cost;
        this.tourType = tourType;
    }
}
