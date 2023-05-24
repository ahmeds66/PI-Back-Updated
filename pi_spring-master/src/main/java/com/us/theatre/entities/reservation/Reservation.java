package com.us.theatre.entities.reservation;

import com.us.theatre.entities.play.Play;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private String nameClient;
    private String emailClient;
    private String phoneClient;

    @ManyToOne
    private Play play;
}
