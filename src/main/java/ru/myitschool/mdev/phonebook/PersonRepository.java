package ru.myitschool.mdev.phonebook;

import org.springframework.data.repository.CrudRepository;
import ru.myitschool.mdev.phonebook.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}

