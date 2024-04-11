package com.sharda.RatingService.services;

import com.sharda.RatingService.Dto.RatingDto;
import com.sharda.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
    List<Rating> getAllRatings();
    List<RatingDto> getRatingsByUserId(String userId);
    List<Rating> getRatingsByHotelId(String hotelId);

}
