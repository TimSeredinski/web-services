package com.epam.travel_agency.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Embeddable
@Getter
@Setter
@ToString
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "tour_id"}))
public class UserTour {

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    @ManyToOne
    @JoinColumn(name = "tour_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Tour tour;

    public UserTour() {
    }

}
