package com.example.TravelAgencyRestApi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Data
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer duration;
    private Integer freeslots;
    private double price;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date date;

    public Holiday() {
    }

    public Holiday(long id, Integer duration, Integer freeslots, double price, Location location, String title, Date date) {
        this.id = id;
        this.duration = duration;
        this.freeslots = freeslots;
        this.price = price;
        this.location = location;
        this.title = title;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getFreeslots() {
        return freeslots;
    }

    public void setFreeslots(int freeslots) {
        this.freeslots = freeslots;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
