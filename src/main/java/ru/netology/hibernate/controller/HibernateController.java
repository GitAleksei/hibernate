package ru.netology.hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.service.HibernateService;

import java.util.List;

@RestController
public class HibernateController {
    private final HibernateService hibernateService;

    public HibernateController(HibernateService hibernateService) {
        this.hibernateService = hibernateService;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCity(@RequestParam(name = "city") String city) {
        return hibernateService.getPersonsByCity(city);
    }
}
