package com.ldtech.user.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(name = "user_email", nullable = false, length = 320)
    private String userEmail;

    @Column(name = "user_about", nullable = false, length = 500)
    private String userAbout;

    @Transient
    private List<Rating> ratings;
}
