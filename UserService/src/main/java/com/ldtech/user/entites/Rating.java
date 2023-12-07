package com.ldtech.user.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private long ratingId;
    private long userId;
    private long hotelId;
    private int rating;
    private String feedback;
}
