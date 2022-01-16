package fr.firiz.modele;

import java.io.*;

public class Version {
    static String version;

    public static String getVersion() {
        return version;
    }

    public static void setVersion() throws IOException {
        File file = new File("./src/main/java/datas/version.data");
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);
        String line;
        while ((line = bf.readLine()) != null) {
            version = line;
        }
    }
}
