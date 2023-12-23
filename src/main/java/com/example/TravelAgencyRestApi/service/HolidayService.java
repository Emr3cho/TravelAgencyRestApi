package com.example.TravelAgencyRestApi.service;

import com.example.TravelAgencyRestApi.model.DTO.request.CreateHolidayDTO;
import com.example.TravelAgencyRestApi.model.DTO.request.UpdateHolidayDTO;
import com.example.TravelAgencyRestApi.model.DTO.response.ResponseHolidayDTO;

import java.util.List;

public interface HolidayService {
    ResponseHolidayDTO createHoliday(CreateHolidayDTO createHolidayDTO);
    List<ResponseHolidayDTO> getAllHolidays();
    ResponseHolidayDTO getHolidayById(Long holidayId);
    ResponseHolidayDTO updateHoliday(UpdateHolidayDTO update);
    Boolean deleteHoliday(Long holidayId);

}
