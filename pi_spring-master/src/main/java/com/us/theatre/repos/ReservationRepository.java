package com.us.theatre.repos;

import com.us.theatre.entities.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByIdReservation(Long id);

    List<Reservation> findByEmailClient(String email);

    List<Reservation> findByPhoneClient(String phone);

    List<Reservation> findByPlayIdPlay(Long id);

    List<Reservation> findByPlayTitlePlay(String title);
}
