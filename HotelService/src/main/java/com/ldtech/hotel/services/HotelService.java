package com.ldtech.hotel.services;

import com.ldtech.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);

    Hotel getHotelById(long hotelId);

    List<Hotel> getAllHotels();

    Hotel updateHotelById(Hotel hotel, long hotelId);

    void deleteHotelById(long hotelId);
}
