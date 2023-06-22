package ru.smaginv.data.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.smaginv.data.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("SELECT p FROM Person p WHERE p.id = :personId")
    Optional<Person> get(@Param("personId") int personId);

    @Query("SELECT p FROM Person p ORDER BY p.id")
    List<Person> getAll();

    @Modifying
    @Query("DELETE FROM Person p WHERE p.id = :personId")
    int delete(@Param("personId") int personId);
}
