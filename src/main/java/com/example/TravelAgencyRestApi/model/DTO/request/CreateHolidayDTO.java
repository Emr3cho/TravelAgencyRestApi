package com.example.TravelAgencyRestApi.model.DTO.request;

import com.example.TravelAgencyRestApi.model.Location;
import lombok.Data;

import java.util.Date;

@Data
public class CreateHolidayDTO {
    private Location location;
    private String title;
    private Date startDate;
    private int duration;
    private String price;
    private int freeSlots;



    public CreateHolidayDTO(Location location, String title, Date startDate, int duration, String price, int freeSlots) {
        this.location = location;
        this.title = title;
        this.startDate = startDate;
        this.duration = duration;
        this.price = price;
        this.freeSlots = freeSlots;
    }

    public CreateHolidayDTO() {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getFreeSlots() {
        return freeSlots;
    }

    public void setFreeSlots(int freeSlots) {
        this.freeSlots = freeSlots;
    }
}
