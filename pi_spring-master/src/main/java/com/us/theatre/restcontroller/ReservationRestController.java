package com.us.theatre.restcontroller;

import com.us.theatre.entities.play.Play;
import com.us.theatre.entities.reservation.Reservation;
import com.us.theatre.service.play.PlayService;
import com.us.theatre.service.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Resservation")
@CrossOrigin
public class ReservationRestController {

    @Autowired
    ReservationService reservationService;

        @GetMapping("all")
        public List<Reservation> getAllReservations() {
            return reservationService.getAllReservations();
        }

        @GetMapping("/getbyid/{id}")
        public Reservation getReservationById(@PathVariable("id") Long id) {
            return reservationService.getReservation(id);
        }

        @PostMapping("/addrerservation")
        public Reservation createReservation(@RequestBody Reservation reservation) {
            System.out.println(reservation);
            return reservationService.saveReservation(reservation);
        }

        @PutMapping("/updatereservation")
        public Reservation updateReservation(@RequestBody Reservation reservation) {
            return reservationService.updateReservation(reservation);
        }

        @DeleteMapping("/deletereservation/{id}")
        public void deleteReservation(@PathVariable("id") Long id) {
            reservationService.deleteReservationById(id);
        }

        @GetMapping("/idreservation/{id}")
        public List<Reservation> getReservationByIdReservation(@PathVariable("id") Long id) {
            return reservationService.findByIdReservation(id);
        }

        @GetMapping("/emailclient/{email}")
        public List<Reservation> getReservationByEmailClient(@PathVariable("email") String email) {
            return reservationService.findByEmailClient(email);
        }

        @GetMapping("/phoneclient/{phone}")
        public List<Reservation> getReservationByPhoneClient(@PathVariable("phone") String phone) {
            return reservationService.findByPhoneClient(phone);
        }

        @GetMapping("/idplay/{id}")
        public List<Reservation> getReservationByPlayIdPlay(@PathVariable("id") Long id) {
            return reservationService.findByPlayIdPlay(id);
        }

        @GetMapping("/titleplay/{title}")
        public List<Reservation> getReservationByPlayTitlePlay(@PathVariable("title") String title) {
            return reservationService.findByPlayTitlePlay(title);
        }

    }
