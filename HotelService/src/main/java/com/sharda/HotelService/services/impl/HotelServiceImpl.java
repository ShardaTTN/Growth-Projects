package com.sharda.HotelService.services.impl;

import com.sharda.HotelService.entities.Hotel;
import com.sharda.HotelService.exception.ResourceNotFoundException;
import com.sharda.HotelService.repositories.HotelRepository;
import com.sharda.HotelService.services.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        String randomId = UUID.randomUUID().toString().split("-")[0];
        hotel.setId(randomId);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getSingleHotel(String hotelId) {
        System.out.println("hotelID" + hotelId);
        return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("hotel with given id is not found !!"));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
