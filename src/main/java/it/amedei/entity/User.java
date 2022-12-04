package it.amedei.entity;/*
@author Alessandro Amedei
2022    
*/

import it.amedei.validator.NotNullAndNotBlank;
import it.amedei.validator.NullOrNotBlank;
import it.amedei.validator.ValidationGroups;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "users_keygen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "users_keygen", sequenceName = "users_seq", initialValue = 1, allocationSize = 1)
    @Null(groups = ValidationGroups.Post.class)
    @NotNull(groups = ValidationGroups.Put.class)
    private Integer id;

    @Column(nullable = false)
    @NullOrNotBlank(groups = ValidationGroups.Put.class)
    @NotNullAndNotBlank(groups = ValidationGroups.Post.class)
    private String name;

    @Column(nullable = false)
    @NullOrNotBlank(groups = ValidationGroups.Put.class)
    @NotNullAndNotBlank(groups = ValidationGroups.Post.class)
    private String surname;

    @Column(nullable = false, unique = true)
    @NullOrNotBlank(groups = ValidationGroups.Put.class)
    @NotNullAndNotBlank(groups = ValidationGroups.Post.class)
    @Email(regexp = ".+@.+\\..+")
    private String email;

    @Column(nullable = false, unique = true)
    @NullOrNotBlank(groups = ValidationGroups.Put.class)
    @NotNullAndNotBlank(groups = ValidationGroups.Post.class)
    private String phone;

    @Column(nullable = true)
    @NullOrNotBlank
    private String city;

    @Column(nullable = false)
    @NotNull(groups = ValidationGroups.Post.class)
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void update(User user) {
        if (user.getName() != null)
            this.setName(user.getName());
        if (user.getSurname() != null)
            this.setSurname(user.getSurname());
        if (user.getEmail() != null)
            this.setEmail(user.getEmail());
        if (user.getBirthday() != null)
            this.setBirthday(user.getBirthday());
        if (user.getPhone() != null)
            this.setPhone(user.getPhone());
        if (user.getCity() != null)
            this.setCity(user.getCity());
    }
}
