package SysUpdateParser;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Checking for new update data...");
        String server = args[0];
        String pass = args[1];
        checkForUpdate(server, pass);
    }

    static void checkForUpdate(String server, String pass) throws IOException {
        WiiU wiiU = new WiiU();
        ThreeDS threeDS = new ThreeDS();
        Switch nSwitch = new Switch();
        threeDS.getUpdates();
        wiiU.getUpdates();
        nSwitch.getUpdates();

        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        Date date = new Date();
        String dateToSend = format.format(date);
        Map<String, String> data = new HashMap<>();
        data.put("pass", pass);
        data.put("date", dateToSend);
        data.put("threeds", threeDS.getVersion());
        data.put("wiiu", wiiU.getVersion());
        data.put("switch", nSwitch.getVersion());
        //int response = HttpRequest.post(server).form(data).code();
        System.out.println(dateToSend);
    }
}
