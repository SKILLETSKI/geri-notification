package geriapp.Twilio;


import com.google.gson.Gson;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;

@Service
public class AdministratorService {
    private String filePath;

    public AdministratorService() {
        this.filePath = getClass().getClassLoader().getResource("Administrator.json").getPath();
    }

    public AdministratorService(String filePath) {
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