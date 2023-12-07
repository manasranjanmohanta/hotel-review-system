package com.ldtech.hotel.services.impl;

import com.ldtech.hotel.entities.Hotel;
import com.ldtech.hotel.exceptions.ResourceNotFoundException;
import com.ldtech.hotel.repositories.HotelRepository;
import com.ldtech.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        Hotel hotel1 = hotelRepository.save(hotel);
        return hotel1;
    }

    @Override
    public Hotel getHotelById(long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel", "hotelId", hotelId));
        return hotel;
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> all = hotelRepository.findAll();
        return all;
    }

    @Override
    public Hotel updateHotelById(Hotel hotel, long hotelId) {
        Hotel hotel1 = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel", "hotelId", hotelId));

        hotel1.setHotelName(hotel.getHotelName());
        hotel1.setHotelLocation(hotel.getHotelLocation());
        hotel1.setHotelAbout(hotel.getHotelAbout());

        return hotelRepository.save(hotel1);
    }

    @Override
    public void deleteHotelById(long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel", "hotelId", hotelId));
        hotelRepository.delete(hotel);
    }
}
