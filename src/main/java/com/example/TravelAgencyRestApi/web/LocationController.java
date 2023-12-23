package com.example.TravelAgencyRestApi.web;

import com.example.TravelAgencyRestApi.model.DTO.request.CreateLocationDTO;
import com.example.TravelAgencyRestApi.model.DTO.request.UpdateLocationDTO;
import com.example.TravelAgencyRestApi.model.DTO.response.ResponseLocationDTO;
import com.example.TravelAgencyRestApi.service.LocationService;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/locations")
@RestController
public class LocationController {

    private final LocationService locationService;


    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    //consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE
    @PostMapping()
    public ResponseEntity<Object> createLocation(@RequestBody CreateLocationDTO createLocationDTO) {
        ResponseLocationDTO responseLocationDTO = locationService.createLocation(createLocationDTO);
        return new ResponseEntity<>("saved successfully!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseLocationDTO>> getAllLocations() {
        List<ResponseLocationDTO> allLocations = locationService.getAllLocations();
        return ResponseEntity.ok(allLocations);

    }
    @DeleteMapping("/{locationId}")
    public ResponseEntity<Boolean> deleteLocation(@PathVariable Long locationId) {
        Boolean deleted = locationService.deleteLocation(locationId);
        return ResponseEntity.ok(deleted);
    }
    @GetMapping("/{locationId}")
    public ResponseEntity<ResponseLocationDTO> getLocationById(@PathVariable Long locationId) {
        ResponseLocationDTO location = locationService.getLocationById(locationId);
        return ResponseEntity.ok(location);
    }
    @PutMapping
    public ResponseEntity<ResponseLocationDTO> updateLocation(@RequestBody UpdateLocationDTO updateLocationDTO) {
        ResponseLocationDTO updatedLocation = locationService.updateLocation(updateLocationDTO);
        return ResponseEntity.ok(updatedLocation);
    }



}

