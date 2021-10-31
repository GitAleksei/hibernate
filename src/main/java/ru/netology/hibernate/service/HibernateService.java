package ru.netology.hibernate.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.repository.HibernateRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class HibernateService {
    private final HibernateRepository hibernateRepository;

    public HibernateService(HibernateRepository hibernateRepository) {
        this.hibernateRepository = hibernateRepository;
    }

    public List<Persons> getPersonsByCity(String city) {
        return hibernateRepository.findByCityOfLiving(city);
    }

    public List<Persons> getPersonsByAgeLessThan(int age) {
        return hibernateRepository.findByPrimaryKeyForPersonsAgeLessThan(age, Sort.by(
                "primaryKeyForPersons.age"));
    }

    public Persons getPersonsByNameSurname(String name, String surname) {
        return hibernateRepository
                .findByPrimaryKeyForPersonsNameAndPrimaryKeyForPersonsSurname(name, surname)
                .orElseThrow(() ->
                        new EntityNotFoundException("Entity not found: " + name + " " + surname));
    }
}
