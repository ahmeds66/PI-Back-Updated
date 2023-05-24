package com.us.theatre.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.us.theatre.entities.actor.ActorImage;

public interface ActorImageRepository extends JpaRepository<ActorImage, Long> {

}