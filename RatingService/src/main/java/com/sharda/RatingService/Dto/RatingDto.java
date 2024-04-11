package com.sharda.RatingService.Dto;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RatingDto {
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    private Date createdTime;
}
