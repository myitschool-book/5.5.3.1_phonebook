package ru.myitschool.mdev.phonebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.myitschool.mdev.phonebook.entity.Person;
import ru.myitschool.mdev.phonebook.entity.PhoneNumber;

@Controller
public class MainController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @RequestMapping(path="/")
    public String index() {
        return "index";
    }

    @GetMapping(path="/addperson")
    public @ResponseBody
    String addNewPerson (@RequestParam String name) {
        Person person = new Person();
        person.setName(name);
        personRepository.save(person);
        return "Person saved!";
    }

    @GetMapping(path="/addphone")
    public @ResponseBody
    String addNewPhone (@RequestParam String value, @RequestParam String person_id) {
        PhoneNumber phone = new PhoneNumber();
        phone.setValue(Long.parseLong(value));
        Person p = new Person();
        p.setId_person(Integer.parseInt(person_id));
        phone.setOwner(p);
        phoneNumberRepository.save(phone);
        return "Phone saved!";
    }

    @GetMapping(path="/allpersons")
    public @ResponseBody
    Iterable<Person> getAllUsers() {
        return personRepository.findAll();
    }
    @GetMapping(path="/allphones")
    public @ResponseBody
    Iterable<PhoneNumber> getAllPhones() {
        return phoneNumberRepository.findAll();
    }
}
