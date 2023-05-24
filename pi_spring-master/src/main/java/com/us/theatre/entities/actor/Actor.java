package com.us.theatre.entities.actor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.us.theatre.entities.play.Play;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idActor;
	private String nameActor;
	private String biographyActor;
	
	 @OneToOne
	 private ActorImage image;
	 private String imagePath;

	@ManyToMany
	@JsonIgnore
	@JoinTable (
			name = "plays_actors", joinColumns = @JoinColumn (name = "idActor"),
			inverseJoinColumns = @JoinColumn (name = "idPlay")
	)
	private List<Play> plays;
}