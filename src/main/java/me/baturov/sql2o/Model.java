package me.baturov.sql2o;

import me.baturov.cinema.Cinema;
import me.baturov.hall.Hall;
import me.baturov.seat.Seat;
import me.baturov.status.Status;

import java.util.List;

public interface Model {
    List<Cinema> getAllCinemas();

    Cinema getCinema(int cinema_id);

    List<Hall> getAllHalls();

    List<Hall> getHalls(int cinema_id);

    List<Seat> getAllSeats();

    Seat getSeat(int cinema_id, int hall_id);

    Status getStatus(int st_id);

    void createTrigger();
}
