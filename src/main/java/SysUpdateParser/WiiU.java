package SysUpdateParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WiiU {
    private String newestFirmwareVersion;
    private final String url = "https://www.nintendo.co.jp/support/wiiu/system_update/index.html";

    public WiiU() {

    }

    public void getUpdates() throws IOException {
        System.out.println("Looking for Wii U updates...");
        Document doc = Jsoup.connect(url).get();
        Elements test = doc.select("p").attr("class", "hlp-mb60");
        String newest = test.get(2).nextElementSibling().text();
        newestFirmwareVersion = newest.substring(newest.indexOf('\u300c') + 1, newest.indexOf('\u300d') - 1);
        System.out.println(newestFirmwareVersion);
    }

    public String getVersion() {
        return this.newestFirmwareVersion;
    }
}
