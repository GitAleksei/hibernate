package ru.netology.hibernate.service;

import org.springframework.stereotype.Service;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.repository.HibernateRepository;

import java.util.List;

@Service
public class HibernateService {
    private final HibernateRepository hibernateRepository;

    public HibernateService(HibernateRepository hibernateRepository) {
        this.hibernateRepository = hibernateRepository;
    }

    public List<Persons> getPersonsByCity(String city) {
        return hibernateRepository.findByCityOfLiving(city);
    }

//    public List<Persons> getPersonsByAgeLessThan(int age) {
//        return hibernateRepository.findByAgeLessThanOrderByAge(age);
//    }
}
