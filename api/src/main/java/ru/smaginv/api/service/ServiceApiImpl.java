package ru.smaginv.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.smaginv.api.entity.Person;

import java.util.List;

@Service
public class ServiceApiImpl implements ServiceApi {

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public ServiceApiImpl(WebClient webClient, ObjectMapper objectMapper) {
        this.webClient = webClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public Person get(int personId) {
        return objectMapper.convertValue(webClient
                .get()
                .uri("/" + personId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                })
                .block(), new TypeReference<>() {
        });
    }

    @Override
    public List<Person> getAll() {
        return objectMapper.convertValue(webClient
                .get()
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                })
                .block(), new TypeReference<>() {
        });
    }

    @Override
    public void update(int personId, Person person) {
        webClient
                .put()
                .uri("/" + personId)
                .bodyValue(person)
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe();
    }

    @Override
    public Person create(Person person) {
        return objectMapper.convertValue(webClient
                .post()
                .bodyValue(person)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                })
                .block(), new TypeReference<>() {
        });
    }

    @Override
    public void delete(int personId) {
        webClient
                .delete()
                .uri("/" + personId)
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe();
    }
}
