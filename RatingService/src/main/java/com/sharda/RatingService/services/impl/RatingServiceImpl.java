package com.sharda.RatingService.services.impl;

import com.sharda.RatingService.Dto.RatingDto;
import com.sharda.RatingService.entities.Rating;
import com.sharda.RatingService.repository.RatingRepository;
import com.sharda.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        String randomId = UUID.randomUUID().toString().split("-")[0];
        rating.setRatingId(randomId);
        rating.setCreatedTime(Date.from(Instant.now()));
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<RatingDto> getRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId).stream()
                .map(rating -> RatingDto.builder()
                .ratingId(rating.getRatingId())
                .rating(rating.getRating())
                .userId(rating.getUserId())
                .hotelId(rating.getHotelId())
                .feedback(rating.getFeedback())
                .createdTime(Objects.nonNull(rating.getUpdatedTime())? rating.getUpdatedTime() : rating.getCreatedTime())
                .build()).collect(Collectors.toList());
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
