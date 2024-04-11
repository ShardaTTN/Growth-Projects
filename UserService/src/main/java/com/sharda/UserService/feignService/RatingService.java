package com.sharda.UserService.feignService;

import com.sharda.UserService.Dto.RatingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE", url = "${rating.service.uri}")
public interface RatingService {

    @GetMapping("/users/{userId}")
    List<RatingDto> getRating(@PathVariable("userId") String userId);
}
