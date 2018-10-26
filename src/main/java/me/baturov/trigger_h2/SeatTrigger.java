package me.baturov.trigger_h2;

import org.h2.api.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Sql2o;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import static me.baturov.Main.connectDB;

public class SeatTrigger implements Trigger {
    final Logger logger = LoggerFactory.getLogger(SeatTrigger.class);

    public void init(Connection connection, String s, String s1, String s2, boolean b, int i) throws SQLException {
        //ignore
    }

    public void fire(Connection connection, Object[] objects, Object[] objects1) throws SQLException {
//        Sql2o sql2o = connectDB.sql2o;
        logger.info("newRow in trigger: ", objects1);
        try (PreparedStatement stmt = connection.prepareStatement(
                "insert into seat (c_id,h_id,row,seat,st_id) " +
                        "values (?,?,?,?,?)")) {
            stmt.setObject(1, objects1[0]);
            stmt.setObject(2, objects1[1]);
            stmt.setObject(3, objects1[1]);
            stmt.setObject(4, objects1[1]);
            stmt.setObject(5, objects1[1]);
            stmt.executeUpdate();
        }
    }

    public void close() throws SQLException {
        //ignore
    }

    public void remove() throws SQLException {
        //ignore
    }
}
