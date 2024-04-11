package com.sharda.HotelService.services;

import com.sharda.HotelService.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    Hotel saveHotel(Hotel hotel);
    Hotel getSingleHotel(String hotelId);
    List<Hotel> getAllHotels();
}
