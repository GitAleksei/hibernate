package ru.netology.hibernate.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.entity.PrimaryKeyForPersons;

import java.util.List;
import java.util.Optional;

@Repository
public interface HibernateRepository extends CrudRepository<Persons, PrimaryKeyForPersons> {

    List<Persons> findByCityOfLiving(String city);

    List<Persons> findByPrimaryKeyForPersonsAgeLessThan(int age, Sort sort);

    Optional<Persons> findByPrimaryKeyForPersonsNameAndPrimaryKeyForPersonsSurname(
            String name, String surname);
}
