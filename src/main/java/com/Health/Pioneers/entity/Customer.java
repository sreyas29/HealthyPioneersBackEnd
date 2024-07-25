package com.Health.Pioneers.entity;

import com.Health.Pioneers.converter.ListToStringConverter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;



    @ElementCollection
    private Map<String,String> listOfRecords;

    @Column(name = "filename")
    private String filename;

//    @ElementCollection
//    @CollectionTable(name = "my_entity_map", joinColumns = @JoinColumn(name = "entity_id"))
//    @MapKeyColumn(name = "map_key")
//    @Column(name = "map_value")
//    @Convert(converter = ListToStringConverter.class)
//    private Map<String,List<String>> listOfFruitsAndVegtables=new HashMap<>();

    private String listOfVeg;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getListOfRecords() {
        return listOfRecords;
    }

//    public Map<String, List<String>> getListOfFruitsAndVegtables() {
//        return listOfFruitsAndVegtables;
//    }
//
//    public void setListOfFruitsAndVegtables(Map<String, List<String>> listOfFruitsAndVegtables) {
//        this.listOfFruitsAndVegtables = listOfFruitsAndVegtables;
//    }

    public void setListOfRecords(Map<String, String> listOfRecords) {
        this.listOfRecords = listOfRecords;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getListOfVeg() {
        return listOfVeg;
    }

    public void setListOfVeg(String listOfVeg) {
        this.listOfVeg = listOfVeg;
    }
}
