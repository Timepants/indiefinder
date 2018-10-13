package com.example.indiefinder.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "publisher", schema = "indiefind", catalog = "")
public class PublisherEntity {
    private int publisherId;
    private String publisherName;
    private String locationCity;
    private String locationState;
    private String website;

    @Id
    @Column(name = "publisherID")
    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    @Basic
    @Column(name = "publisherName")
    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    @Basic
    @Column(name = "locationCity")
    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    @Basic
    @Column(name = "locationState")
    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    @Basic
    @Column(name = "website")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublisherEntity that = (PublisherEntity) o;
        return publisherId == that.publisherId &&
                Objects.equals(publisherName, that.publisherName) &&
                Objects.equals(locationCity, that.locationCity) &&
                Objects.equals(locationState, that.locationState) &&
                Objects.equals(website, that.website);
    }

    @Override
    public int hashCode() {

        return Objects.hash(publisherId, publisherName, locationCity, locationState, website);
    }
}
