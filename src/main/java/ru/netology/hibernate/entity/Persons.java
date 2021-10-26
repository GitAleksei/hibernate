package ru.netology.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persons {
    @EmbeddedId
    private PrimaryKeyForPersons primaryKeyForPersons;

    private String phoneNumber;

    private String cityOfLiving = "unknown";
}
