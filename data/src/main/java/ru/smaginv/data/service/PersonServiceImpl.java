package ru.smaginv.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smaginv.data.entity.Person;
import ru.smaginv.data.repository.PersonRepository;
import ru.smaginv.data.util.exception.NotFoundException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person get(int personId) {
        return personRepository.get(personId).orElseThrow(
                () -> new NotFoundException("Not found person with id: " + personId)
        );
    }

    @Override
    public List<Person> getAll() {
        return personRepository.getAll();
    }

    @Override
    @Transactional
    public void update(int personId, Person person) {
        Person updated = get(personId);
        updated.setFirstName(person.getFirstName());
        updated.setEmail(person.getEmail());
        personRepository.save(updated);
    }

    @Override
    @Transactional
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    @Transactional
    public void delete(int personId) {
        if (personRepository.delete(personId) == 0) {
            throw new NotFoundException("Not found person with id: " + personId);
        }
    }
}
