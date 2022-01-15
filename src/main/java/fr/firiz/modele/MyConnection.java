package fr.firiz.modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class MyConnection {

    static String user;
    static String passwd;
    static String url;

    public static void closeConnection(Connection conn, Statement stmt) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        stmt.close();
        conn.close();
    }

    public static boolean testData(String name) throws IOException, SQLException {
        if (user == null) {
            setConnectionInfos();
        }
        Connection conn = DriverManager.getConnection(url, user, passwd);
        String sql = "SELECT * FROM gnome WHERE nom = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        ResultSet result = stmt.executeQuery();
        if (result.next()) {
            return true;
        }
        return false;
    }

    public static Gnome getData(String name) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        Gnome gnome = null;
        if (user == null) {
            setConnectionInfos();
        }
        Connection conn = DriverManager.getConnection(url, user, passwd);
        String sql = "SELECT * FROM gnome WHERE nom = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(sql);
        preparedStmt.setString(1, name);
        ResultSet result = preparedStmt.executeQuery();
        while (result.next()) {
            gnome = new Gnome(name, result.getString("metier"
            ), result.getInt("niveau"), result.getString("avatar"));
            gnome.setAvatar(result.getString("avatar"));
            System.out.println(name + result.getString("metier"
            ) + result.getInt("niveau") + result.getString("avatar"));
        }
        closeConnection(conn, preparedStmt);
        return gnome;
    }

    public static void setConnectionInfos() throws IOException {
        String infos[] = new String[3];
        File file = new File("./src/main/java/datas/connexion.data");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        byte n = 0;
        while ((line = br.readLine()) != null) {
            infos[n] = line;
            n++;
        }
        user = infos[0];
        passwd = infos[1];
        url = infos[2];
        br.close();

    }
}