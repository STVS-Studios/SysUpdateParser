package SysUpdateParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.IOException;

public class PsFour {
    private String newestFirmwareVersion;
    private final String url = "http://fjp01.ps4.update.playstation.net/update/ps4/list/jp/ps4-updatelist.xml";

    public PsFour() {

    }

    public void getUpdates() throws IOException {
        System.out.println("Looking for PS4 updates...");
        Document doc = Jsoup.connect(url).get().parser(Parser.xmlParser());
        String test = doc.select("system_pup").attr("label");
        newestFirmwareVersion = test;
        System.out.println(test);
        //System.out.println(newestFirmwareVersion);
    }

    public String getVersion() {
        return this.newestFirmwareVersion;
    }
}
