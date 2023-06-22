package ru.smaginv.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @Size(min = 2, max = 64)
    @Column(name = "first_name")
    private String firstName;

    @Email
    @Column(name = "email")
    private String email;
}
