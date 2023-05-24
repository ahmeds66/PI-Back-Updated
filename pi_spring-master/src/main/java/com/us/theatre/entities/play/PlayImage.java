package com.us.theatre.entities.play;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.us.theatre.entities.actor.Actor;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayImage {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idImage ;
 private String name ;
 private String type ;
 @Column( name = "IMAGE" , length = 4048576 ) 
 @Lob
 private byte[] image; 
 
 @OneToOne
 private Play play;
 /*@ManyToOne
 @JoinColumn (name="idPlay")
 @JsonIgnore
 private Play play;*/
}