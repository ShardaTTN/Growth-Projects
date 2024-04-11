package com.sharda.UserService.feignService;

import com.sharda.UserService.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE", url = "${hotel.service.uri}")
public interface HotelService {

    @GetMapping("/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);
}
