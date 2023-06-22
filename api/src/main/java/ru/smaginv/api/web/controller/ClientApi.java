package ru.smaginv.api.web.controller;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smaginv.api.entity.Person;
import ru.smaginv.api.service.ServiceApi;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/people", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientApi {

    private final ServiceApi serviceApi;

    @Autowired
    public ClientApi(ServiceApi serviceApi) {
        this.serviceApi = serviceApi;
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> get(@PathVariable("personId") int personId) {
        log.info("Get person by id: {}", personId);
        return ResponseEntity.ok(serviceApi.get(personId));
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        log.info("Get all people");
        return ResponseEntity.ok(serviceApi.getAll());
    }

    @PutMapping("/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("personId") int personId, @RequestBody @Valid Person person) {
        log.info("Update person with id: {}", personId);
        serviceApi.update(personId, person);
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        log.info("Create person: {}", person);
        return ResponseEntity.ok(serviceApi.create(person));
    }

    @DeleteMapping("/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("personId") int personId) {
        log.info("Delete person by id: {}", personId);
        serviceApi.delete(personId);
    }
}
