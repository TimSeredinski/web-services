package com.epam.travel_agency.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity(name = "user_account")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    @Size(max = 20, min = 3, message = "login not valid")
    @NotEmpty(message = "Please enter login")
    private String login;

    @Column(nullable = false)
    @Size(min = 6, message = "password not valid")
    @NotEmpty(message = "Please enter password")
    private String password;

//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
//    private Set<Review> reviews;

//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @ManyToMany(fetch = FetchType.EAGER, cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE})
//    @JoinTable(name = "user_tour",
//            joinColumns = @JoinColumn(name = "tour_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Set<Tour> tours = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, Set<Tour> tours) {
        this.login = login;
        this.password = password;
        //this.tours = tours;
    }
}
