package ru.smaginv.api.service;

import ru.smaginv.api.entity.Person;

import java.util.List;

public interface ServiceApi {

    Person get(int personId);

    List<Person> getAll();

    void update(int personId, Person person);

    Person create(Person person);

    void delete(int personId);
}
