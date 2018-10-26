package me.baturov.sql2o;

import me.baturov.cinema.Cinema;
import me.baturov.hall.Hall;
import me.baturov.seat.Seat;
import me.baturov.status.Status;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oModel implements Model {
    private Sql2o sql2o;

    public Sql2oModel(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Cinema> getAllCinemas() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from cinema")
                    .executeAndFetch(Cinema.class);
        }
    }

    @Override
    public Cinema getCinema(int cinema_id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from cinema where c_id = :c_id")
                    .addParameter("c_id", cinema_id)
                    .executeAndFetchFirst(Cinema.class);
        }
    }

    @Override
    public List<Hall> getAllHalls() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from hall")
                    .executeAndFetch(Hall.class);
        }
    }

    @Override
    public List<Hall> getHalls(int cinema_id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from hall where c_id = :c_id")
                    .addParameter("c_id", cinema_id)
                    .executeAndFetch(Hall.class);
        }
    }

    @Override
    public List<Seat> getAllSeats() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from seat")
                    .executeAndFetch(Seat.class);
        }
    }

    @Override
    public Seat getSeat(int cinema_id, int hall_id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from seat where c_id = :c_id and h_id = :h_id")
                    .addParameter("c_id", cinema_id)
                    .addParameter("h_id", hall_id)
                    .executeAndFetchFirst(Seat.class);
        }
    }

    @Override
    public Status getStatus(int status_id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select status from status where st_id = :st_id")
                    .addParameter("st_id", status_id)
                    .executeAndFetchFirst(Status.class);
        }
    }
}
