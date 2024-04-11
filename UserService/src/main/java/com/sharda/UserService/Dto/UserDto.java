package com.sharda.UserService.Dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserDto implements Serializable {
    private String id;
    private String name;
    private String email;
    private String about;
    private List<RatingDto> ratings;
}
