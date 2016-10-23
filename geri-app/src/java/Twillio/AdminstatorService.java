package Twillio;


import com.google.gson.Gson;
import com.twilio.notifications.domain.Administrator;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;

@Service
public class AdminstatorService {
    private String filePath;

    public AdminstatorService() {
        this.filePath = getClass().getClassLoader().getResource("administrators.json").getPath();
    }

    public AdminstatorService(String filePath) {
        this.filePath = filePath;
    }

    public Administrator[] getAdministrators() {
        try {
            return new Gson().fromJson(new FileReader(filePath), Administrator[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            return new Administrator[0];
        }
    }
}   