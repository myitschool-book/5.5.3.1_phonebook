package ru.myitschool.mdev.phonebook;

import org.springframework.data.repository.CrudRepository;
import ru.myitschool.mdev.phonebook.entity.PhoneNumber;

public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Integer> {
}
