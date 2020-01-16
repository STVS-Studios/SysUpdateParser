import SysUpdateParser.*;
import com.github.kevinsawicki.http.HttpRequest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting SysUpdate Parser...");
        String server = args[0];
        String pass = args[1];
        System.out.println(server + " | " + pass);
        checkForUpdate(server, pass);
    }

    static void checkForUpdate(String server, String pass) throws IOException {
        WiiU wiiU = new WiiU();
        ThreeDS threeDS = new ThreeDS();
        Switch nSwitch = new Switch();
        PsFour psf = new PsFour();
        Vita vita = new Vita();
        threeDS.getUpdates();
        wiiU.getUpdates();
        nSwitch.getUpdates();
        psf.getUpdates();
        vita.getUpdates();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dateToSend = format.format(date);

        Map<String, String> data = new HashMap<>();
        data.put("pass", pass);
        data.put("date", dateToSend);
        data.put("threeds", threeDS.getVersion());
        data.put("wiiu", wiiU.getVersion());
        data.put("switch", nSwitch.getVersion());
        data.put("ps4", psf.getVersion());
        data.put("psvita", vita.getVersion());
        String response = HttpRequest.post(server).form(data).body();
        System.out.println(response);
        System.out.println(dateToSend);
    }
}
