package ru.smaginv.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person-generator"
    )
    @SequenceGenerator(
            name = "person-generator",
            sequenceName = "person_seq",
            initialValue = 20,
            allocationSize = 10
    )
    @Column(name = "person_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "email")
    private String email;
}
