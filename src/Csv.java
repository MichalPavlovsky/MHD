import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Csv {
        public String[] suradnice(String cisloMhd) throws IOException {
            if (cisloMhd.length()== 1){
                cisloMhd=String.format(" %s", cisloMhd);
            }
        String csvUrl = "https://egov.presov.sk/geodatakatalog/dpmp.csv";
        URL url = new URL(csvUrl);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
        List<String> result = new ArrayList<String>();
        while ((inputLine = in.readLine()) != null) {
            String[] values = inputLine.split(";");
            for (String value : values) {
                if (values[0].equals(cisloMhd)) {
                    String str = values[12];
                    String str1 = values[13];
                    result.add(str);
                    result.add(str1);
                    in.close();
                    return result.toArray(new String[result.size()]);

                }
            }
        }
        in.close();
        return result.toArray(new String[result.size()]);
        }
}