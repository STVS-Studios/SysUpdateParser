package SysUpdateParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Switch {
    private String newestFirmwareVersion;
    private final String url = "https://www.nintendo.co.jp/support/switch/system_update/index.html";

    public Switch() {

    }

    public void getUpdates() throws IOException {
        System.out.println("switch");
        Document doc = Jsoup.connect(url).get();
        Elements test = doc.select("div").attr("class", "c-area-border-bold--s u-max-w--small");
        String newest = test.get(11).children().text();
        newestFirmwareVersion = newest.substring(newest.indexOf('\uff1a') + 1, newest.indexOf('\uff08'));
        System.out.println(newestFirmwareVersion);
    }

    public String getVersion() {
        return this.newestFirmwareVersion;
    }
}
