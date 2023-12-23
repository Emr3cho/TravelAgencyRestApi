package com.example.TravelAgencyRestApi.dao;

import com.example.TravelAgencyRestApi.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
