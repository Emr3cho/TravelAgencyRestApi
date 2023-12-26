package com.example.TravelAgencyRestApi.service.Impl;

import com.example.TravelAgencyRestApi.dao.HolidayRepository;
import com.example.TravelAgencyRestApi.dao.LocationRepository;
import com.example.TravelAgencyRestApi.model.DTO.request.CreateHolidayDTO;
import com.example.TravelAgencyRestApi.model.DTO.request.UpdateHolidayDTO;
import com.example.TravelAgencyRestApi.model.DTO.response.ResponseHolidayDTO;
import com.example.TravelAgencyRestApi.model.Holiday;
import com.example.TravelAgencyRestApi.model.Location;
import com.example.TravelAgencyRestApi.service.HolidayService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HolidayServiceImpl implements HolidayService {
    private final HolidayRepository repository;
    private final LocationRepository locationRepository;

    @Autowired
    public HolidayServiceImpl(HolidayRepository repository, LocationRepository locationRepository) {
        this.repository = repository;
        this.locationRepository = locationRepository;
    }

    private ResponseHolidayDTO converterToResponce(Holiday holiday){
        ResponseHolidayDTO response = new ResponseHolidayDTO();
        BeanUtils.copyProperties(holiday,response);
        return response;
    }
    @Override
    public ResponseHolidayDTO createHoliday(CreateHolidayDTO createHolidayDTO) {
        Holiday holiday = new Holiday();

        // Създаване на Location от CreateHolidayDTO
        Location location = this.loadLocationById(createHolidayDTO.getLocation());

        // Задаване на Location на Holiday
        holiday.setLocation(location);

        // Копиране на останалите свойства от CreateHolidayDTO към Holiday
        BeanUtils.copyProperties(createHolidayDTO, holiday);

        // Записване на Holiday в репозиторито
        Holiday savedLocation = repository.save(holiday);

        // Създаване на ResponseHolidayDTO и копиране на данните от Holiday
        ResponseHolidayDTO response = new ResponseHolidayDTO();
        BeanUtils.copyProperties(savedLocation, response);
        return response;
    }


    @Override
    public List<ResponseHolidayDTO> getAllHolidays() {
        List<Holiday> responce = repository.findAll();

        return responce.stream().map(this::converterToResponce).collect(Collectors.toList());
    }

    @Override
    public ResponseHolidayDTO getHolidayById(Long holidayId) {
        Optional<Holiday> optionalHoliday = repository.findById(holidayId);
        return optionalHoliday.map(this::converterToResponce).orElse(null);
    }

    @Override
    public ResponseHolidayDTO updateHoliday(UpdateHolidayDTO update) {
        Optional<Holiday> holidayOptional = repository.findById(update.getId());
        if (holidayOptional.isPresent()) {
            Holiday holiday = holidayOptional.get();
            BeanUtils.copyProperties(update, holiday);
            Holiday updatedHoliday = repository.save(holiday);
            return converterToResponce(updatedHoliday);
        }
        return null;
    }

    @Override
    public Boolean deleteHoliday(Long holidayId) {
        if (repository.existsById(holidayId)) {
            repository.deleteById(holidayId);
            return true;
        }
        return false;
    }

    private Location loadLocationById(long id){
        return locationRepository.findById(id).get();
    }

}
