package com.ldtech.rating.services.impl;

import com.ldtech.rating.entities.Rating;
import com.ldtech.rating.exceptions.ResourceNotFoundException;
import com.ldtech.rating.repositories.RatingRepository;
import com.ldtech.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);

    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();

    }

    @Override
    public Rating getRatingById(long ratingId) {
        Rating rating = ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Rating", "ratingId", ratingId));
        return rating;
    }

    @Override
    public List<Rating> getRatingByUserId(long userId) {
        List<Rating> rating = ratingRepository.findByUserId(userId);
        if(rating != null){
            return rating;
        } else throw new ResourceNotFoundException("Rating", "userId", userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(long hotelId) {
        List<Rating> rating = ratingRepository.findByHotelId(hotelId);
        if(rating != null){
            return rating;
        } else throw new ResourceNotFoundException("Rating", "hotelId", hotelId);
    }

    @Override
    public Rating updateRatingById(Rating rating, long ratingId) {
        Rating existingRating = ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Rating", "ratingId", ratingId));

        existingRating.setRating(rating.getRating());
        existingRating.setFeedback(rating.getFeedback());

        return ratingRepository.save(existingRating);

    }

    @Override
    public void deleteRatingById(long ratingId) {
        Rating existingRating = ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Rating", "ratingId", ratingId));
        ratingRepository.delete(existingRating);
    }
}
