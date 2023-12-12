package com.ldtech.rating.repositories;

import com.ldtech.rating.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByUserId(long userId);

    List<Rating> findByHotelId(long hotelId);
}
