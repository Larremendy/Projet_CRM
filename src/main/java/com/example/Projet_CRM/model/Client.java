package com.example.Projet_CRM.model;

import jakarta.persistence.*;

@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="company_name")
    private String companyName;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String email;
    private String phone;
    private String address;
    @Column(name="zip_code")
    private String zipCode;
    private String city;
    private String country;
    @Column(name="state")
    private ClientState clientState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ClientState getClientState() {
        return clientState;
    }

    public void setClientState(ClientState clientState) {
        this.clientState = clientState;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", companie='" + companyName + '\'' +
                ", Prenom='" + firstName + '\'' +
                ", Nom='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", Telephone='" + phone + '\'' +
                ", adresse='" + address + '\'' +
                ", Code Postal='" + zipCode + '\'' +
                ", Ville='" + city + '\'' +
                ", Pays='" + country + '\'' +
                ", Statut du client=" + clientState +
                '}';
    }
}
