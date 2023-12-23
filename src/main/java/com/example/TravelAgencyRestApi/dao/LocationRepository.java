package com.example.TravelAgencyRestApi.dao;

import com.example.TravelAgencyRestApi.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {

}
