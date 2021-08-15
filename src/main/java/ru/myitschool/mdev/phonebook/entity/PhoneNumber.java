package ru.myitschool.mdev.phonebook.entity;

import javax.persistence.*;

@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_phone")
    private Integer id_phone;

    private Long value;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="person_id")
    private Person owner;

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Integer getId_phone() {
        return id_phone;
    }

    public void setId_phone(Integer id_phone) {
        this.id_phone = id_phone;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id_phone=" + id_phone +
                ", value=" + value +
                ", owner=" + owner.getName() +
                '}';
    }

    public void setValue(Long value) {
        this.value = value;
    }

}
