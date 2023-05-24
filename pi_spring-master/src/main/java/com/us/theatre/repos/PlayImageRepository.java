package com.us.theatre.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.us.theatre.entities.play.PlayImage;

public interface PlayImageRepository extends JpaRepository<PlayImage, Long> {

}