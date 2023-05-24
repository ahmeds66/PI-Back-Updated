package com.us.theatre.service.reservation;

import com.us.theatre.entities.reservation.Reservation;
import com.us.theatre.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;



    @Override
    public Reservation saveReservation(Reservation a) {
        return reservationRepository.save(a);
    }

    @Override
    public Reservation updateReservation(Reservation a) {
        Reservation reservationUpdated = reservationRepository.save(a);
        return reservationUpdated;
    }

    @Override
    public void deleteReservation(Reservation a) {
        reservationRepository.delete(a);
    }

    @Override
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation getReservation(Long id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> findByIdReservation(Long id) {
        return reservationRepository.findByIdReservation(id);
    }

    @Override
    public List<Reservation> findByEmailClient(String email) {
        return reservationRepository.findByEmailClient(email);
    }

    @Override
    public List<Reservation> findByPhoneClient(String phone) {
        return reservationRepository.findByPhoneClient(phone);
    }

    @Override
    public List<Reservation> findByPlayIdPlay(Long id) {
        return reservationRepository.findByPlayIdPlay(id);
    }

    @Override
    public List<Reservation> findByPlayTitlePlay(String title) {
        return reservationRepository.findByPlayTitlePlay(title);
    }
}
