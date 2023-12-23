package com.example.TravelAgencyRestApi.dao;

import com.example.TravelAgencyRestApi.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<Holiday,Long> {
}
