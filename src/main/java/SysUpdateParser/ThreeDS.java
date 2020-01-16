package SysUpdateParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ThreeDS {
    private String newestFirmwareVersion;
    private final String url = "https://www.nintendo.co.jp/support/3ds/system_update/index.html";

    public ThreeDS() {

    }

    public void getUpdates() throws IOException {
        System.out.println("Looking for 3DS updates...");
        Document doc = Jsoup.connect(url).get();
        Elements test = doc.select("p").attr("class", "ff_b");
        String newest = test.first().nextElementSibling().text();
        newestFirmwareVersion = newest.substring(newest.indexOf('\u300c') + 1, newest.indexOf('\u300d') - 1);
        System.out.println(newestFirmwareVersion);
    }

    public String getVersion() {
        return this.newestFirmwareVersion;
    }
}
