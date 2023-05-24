package com.us.theatre.service.reservation;

import com.us.theatre.entities.category.Category;
import com.us.theatre.entities.play.Play;
import com.us.theatre.entities.reservation.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Reservation a);
    Reservation updateReservation(Reservation a);
    void deleteReservation(Reservation a);
    void deleteReservationById(Long id);
    Reservation getReservation(Long id);
    List<Reservation> getAllReservations();

    List<Reservation> findByIdReservation(Long id);
    List<Reservation> findByEmailClient(String email);
    List<Reservation> findByPhoneClient(String phone);
    List<Reservation> findByPlayIdPlay(Long id);
    List<Reservation> findByPlayTitlePlay(String title);
}
