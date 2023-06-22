package ru.smaginv.api.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {

    private int id;

    @NotBlank
    @Size(min = 2, max = 64)
    private String firstName;

    @Email
    private String email;
}
