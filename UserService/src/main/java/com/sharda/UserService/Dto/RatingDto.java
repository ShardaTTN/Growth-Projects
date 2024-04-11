package com.sharda.UserService.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sharda.UserService.model.Hotel;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class RatingDto implements Serializable {
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    private Date createdTime;
    private Hotel hotel;
}
