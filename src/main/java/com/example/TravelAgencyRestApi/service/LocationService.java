package com.example.TravelAgencyRestApi.service;

import com.example.TravelAgencyRestApi.model.DTO.request.CreateLocationDTO;
import com.example.TravelAgencyRestApi.model.DTO.response.ResponseLocationDTO;
import com.example.TravelAgencyRestApi.model.DTO.request.UpdateLocationDTO;

import java.util.List;

public interface LocationService {
    ResponseLocationDTO createLocation(CreateLocationDTO createLocationDTO);
    List<ResponseLocationDTO> getAllLocations();
    ResponseLocationDTO getLocationById(Long locationId);

    ResponseLocationDTO updateLocation(UpdateLocationDTO updateLocationDTO);
    Boolean deleteLocation(Long locationId);
}
