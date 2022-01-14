package fr.firiz.modele.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyConnection {

    static String user = "firiz";
    static String passwd = "8_!fz@3NNw1xlhaD";
    static String url = "jdbc:mysql://localhost/gnome";

    public Connection openMySqlConnection () throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Connection connexion = null;
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        connexion = DriverManager.getConnection(url, user, passwd);
        return connexion;
    }

    public ArrayList<String> getData(String name) {}
}
