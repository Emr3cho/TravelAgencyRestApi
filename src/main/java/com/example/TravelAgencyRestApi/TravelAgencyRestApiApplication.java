package com.example.TravelAgencyRestApi;

import com.example.TravelAgencyRestApi.service.HolidayService;
import com.example.TravelAgencyRestApi.service.Impl.HolidayServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class TravelAgencyRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyRestApiApplication.class, args);

	}

}
