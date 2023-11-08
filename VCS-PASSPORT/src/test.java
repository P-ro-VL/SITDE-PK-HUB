import org.bspfsystems.yamlconfiguration.file.YamlConfiguration;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Collections;

public class test {
    public static void main(String[] args) throws Exception {
        String data = readURL("https://raw.githubusercontent.com/P-ro-VL/SITDE-PK-BANKS/main/Data/SubjectCodes.yml");
        InputStream in = new URL(data).openStream();
        Files.copy(in, Paths.get("config.yml"), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        YamlConfiguration config = YamlConfiguration.loadConfiguration(new File("config.yml"));
        System.out.println(config.get("Available"));
    }

    public static String readURL(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);

        in.close();

        return response.toString();
    }
}
