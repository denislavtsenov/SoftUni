package com.resellerapp.model.service;

import com.resellerapp.model.entity.OfferEntity;

import java.util.Set;

public class UserServiceModel {

    private Long id;

    private String username;

    private String password;

    private String email;

    private Set<OfferEntity> offers;

    private Set<OfferEntity> boughtOffers;

    public UserServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<OfferEntity> getOffers() {
        return offers;
    }

    public void setOffers(Set<OfferEntity> offers) {
        this.offers = offers;
    }

    public Set<OfferEntity> getBoughtOffers() {
        return boughtOffers;
    }

    public void setBoughtOffers(Set<OfferEntity> boughtOffers) {
        this.boughtOffers = boughtOffers;
    }
}
