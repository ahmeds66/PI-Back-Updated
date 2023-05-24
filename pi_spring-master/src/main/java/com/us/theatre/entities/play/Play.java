package com.us.theatre.entities.play;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.us.theatre.entities.actor.Actor;
import com.us.theatre.entities.actor.ActorImage;
import com.us.theatre.entities.category.Category;

import com.us.theatre.entities.reservation.Reservation;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Play {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlay;
	private String titlePlay;
	private String subjectPlay;
	private String biographyPlay;
	private Long ticketsNumPlay;
	private Date datePlay;
	private Double pricePlay;
	
	@ManyToOne
	private Category category;
	
	/*@OneToMany (mappedBy = "play")
	 private List<PlayImage> images;
	 private String imagePath;*/
	
	 @OneToOne
	 private PlayImage image;
	 private String imagePath;
	
	@ManyToMany
	@JoinTable (
			name = "plays_actors", joinColumns = @JoinColumn (name = "idPlay"),
			inverseJoinColumns = @JoinColumn (name = "idActor")
	)
	private List<Actor> actors;

	@JsonIgnore
	@OneToMany(mappedBy = "play")
	private List<Reservation> reservations;
}