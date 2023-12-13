package com.ldtech.rating.controllers;

import com.ldtech.rating.entities.Rating;
import com.ldtech.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    private ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating rating1 = ratingService.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    @GetMapping
    private ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> allRatings = ratingService.getAllRatings();
        return ResponseEntity.ok(allRatings);
    }

    @GetMapping("/{ratingId}")
    private ResponseEntity<Rating> getRatingById(@PathVariable long ratingId){
        Rating ratingById = ratingService.getRatingById(ratingId);
        return ResponseEntity.ok(ratingById);
    }

    @GetMapping("/users/{userId}")
    private ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable long userId){
        List<Rating> ratingByUserId = ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok(ratingByUserId);
    }

    @GetMapping("/hotels/{hotelId}")
    private ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable long hotelId){
        List<Rating> ratingByHotelId = ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.ok(ratingByHotelId);
    }

    @PutMapping("/{ratingId}")
    private ResponseEntity<Rating> updateRatingById(@RequestBody Rating rating,@PathVariable long ratingId){
        Rating rating1 = ratingService.updateRatingById(rating, ratingId);
        return ResponseEntity.ok(rating1);
    }

    @DeleteMapping("/{ratingId}")
    private ResponseEntity<String> deleteRatingById(@PathVariable long ratingId){
        ratingService.deleteRatingById(ratingId);
        return ResponseEntity.ok("Rating details updated successfully !!");
    }
}
