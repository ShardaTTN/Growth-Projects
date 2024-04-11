package com.sharda.UserService.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hotel implements Serializable {
    private String name;
    private String location;
    private String about;
}
