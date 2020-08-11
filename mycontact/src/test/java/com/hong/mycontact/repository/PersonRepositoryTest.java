package com.hong.mycontact.repository;

import com.hong.mycontact.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud() {
        Person person = new Person();
        person.setName("hong");
        person.setAge(25);
        person.setBloodType("A");

        personRepository.save(person);

        System.out.println(personRepository.findAll());

        List<Person> people = personRepository.findAll();

        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getName()).isEqualTo("hong");
        assertThat(people.get(0).getAge()).isEqualTo(25);
        assertThat(people.get(0).getBloodType()).isEqualTo("A");

    }

    @Test
    void hashCodeAndEquals() {
        Person person1 = new Person("hong", 10, "A");
        Person person2 = new Person("hong", 10, "B");

        System.out.println(person1.equals(person2));

        Map<Person, Integer> map = new HashMap<>();
        map.put(person1, person1.getAge());

        System.out.println(map);
        System.out.println(map.get(person2));
    }
}