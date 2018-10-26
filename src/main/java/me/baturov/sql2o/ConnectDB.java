package me.baturov.sql2o;

import org.sql2o.Sql2o;

public class ConnectDB {
    public Sql2o sql2o = new Sql2o("jdbc:h2:~/testgis","admin","admin");
    public Model model = new Sql2oModel(sql2o);
}
