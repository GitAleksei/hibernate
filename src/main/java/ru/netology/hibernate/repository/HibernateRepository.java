package ru.netology.hibernate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.entity.PrimaryKeyForPersons;

import java.util.List;

@Repository
public interface HibernateRepository extends CrudRepository<Persons, PrimaryKeyForPersons> {

    List<Persons> findByCityOfLiving(String city);

//    List<Persons> findByAgeLessThanOrderByAge(int age);
}
