package ru.smaginv.data.web.controller;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smaginv.data.entity.Person;
import ru.smaginv.data.service.PersonService;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/data/people", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> get(@PathVariable("personId") int personId) {
        log.info("Get person by id: {}", personId);
        return ResponseEntity.ok(personService.get(personId));
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        log.info("Get all people");
        return ResponseEntity.ok(personService.getAll());
    }

    @PutMapping("/{personId}")
    public void update(@PathVariable("personId") int personId, @RequestBody @Valid Person person) {
        log.info("Update person with id: {}", personId);
        personService.update(personId, person);
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody @Valid Person person) {
        log.info("Create person: {}", person);
        return ResponseEntity.ok(personService.create(person));
    }

    @DeleteMapping("/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("personId") int personId) {
        log.info("Delete person by id: {}", personId);
        personService.delete(personId);
    }
}
