package SysUpdateParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.IOException;

public class Vita {
    private String newestFirmwareVersion;
    private final String url = "http://fjp01.psp2.update.playstation.net/update/psp2/list/jp/psp2-updatelist.xml";

    public Vita() {

    }

    public void getUpdates() throws IOException {
        System.out.println("Looking for PS Vita updates...");
        Document doc = Jsoup.connect(url).get().parser(Parser.xmlParser());
        String test = doc.select("version").attr("label");
        newestFirmwareVersion = test;
        System.out.println(test);
    }

    public String getVersion() {
        return this.newestFirmwareVersion;
    }
}
