package com.gorila.platform.cup.competitor.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gorila.platform.cup.account.domain.Account;

import javax.persistence.*;

@Entity
public class Competitor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer weight;
    private CompetitorBelt belt;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Account account;

    public Competitor(){}

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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public CompetitorBelt getBelt() {
        return belt;
    }

    public void setBelt(CompetitorBelt belt) {
        this.belt = belt;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", weight=" + weight +
                ", belt=" + belt +
                ", account=" + account +
                '}';
    }
}
