package com.example.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "patrons")
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 100)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email
    @Column(unique = true)
    private String email;

    @Size(max = 20)
    private String phone;

    @Size(max = 255)
    private String address;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "membership_date")
    private Date membershipDate;

    // Getters and setters
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Date getMembershipDate() {
        return membershipDate;
    }
    
    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }
}