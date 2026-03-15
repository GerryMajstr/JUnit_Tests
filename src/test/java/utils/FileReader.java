package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;

public class FileReader {


    public static List<String> getTrackingIds() {

        try {
            ObjectMapper mapper = new ObjectMapper();

            TrackingData data = mapper.readValue(
                    new File("src/test/resources/testdata/trackingIds.json"),
                    TrackingData.class);

            return data.getTrackingIds();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<User> getUsers() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            UsersData data = mapper.readValue(
                    new File("src/test/resources/testdata/users.json"),
                    UsersData.class
            );

            return data.getUsers();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}