package com.ldtech.hotel.controller;

import com.ldtech.hotel.entities.Hotel;
import com.ldtech.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;


//    creating hotel
    @PutMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

//    get single hotel
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable long hotelId){
        Hotel hotel = hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotel);
    }


//    get all hotels
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> allHotels = hotelService.getAllHotels();
        return ResponseEntity.ok(allHotels);
    }

//    update hotel
    @PutMapping("/{hotelId}")
    public ResponseEntity<String> updateHotel(@RequestBody Hotel hotel, @PathVariable long hotelId){
        hotelService.updateHotelById(hotel, hotelId);
        return ResponseEntity.ok("Hotel details updated successfully !!");
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable long hotelId){
        hotelService.deleteHotelById(hotelId);
        return ResponseEntity.ok("Hotel details deleted successfully !!");
    }
}

