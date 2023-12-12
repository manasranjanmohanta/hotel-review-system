package com.ldtech.rating.services;

import com.ldtech.rating.entities.Rating;

import java.util.List;

public interface RatingService {

//    create rating
    Rating createRating(Rating rating);

//    get all ratings
    List<Rating> getAllRatings();

//    get single rating
    Rating getRatingById(long ratingId);

//    get rating by userId

    List<Rating> getRatingByUserId(long userId);

//    get rating by hotelId

    List<Rating> getRatingByHotelId(long hotelId);

//    update rating by rating Id
    Rating updateRatingById(Rating rating, long ratingId);

//    delete rating by ratingId
    void deleteRatingById(long ratingId);


}

