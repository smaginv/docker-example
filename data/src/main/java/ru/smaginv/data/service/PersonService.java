package ru.smaginv.data.service;

import ru.smaginv.data.entity.Person;

import java.util.List;

public interface PersonService {

    Person get(int personId);

    List<Person> getAll();

    void update(int personId, Person person);

    Person create(Person person);

    void delete(int personId);
}
