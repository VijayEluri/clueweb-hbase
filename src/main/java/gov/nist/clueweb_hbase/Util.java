package gov.nist.clueweb_hbase;

import java.net.URL;
import java.net.MalformedURLException;

public class Util {
    public static String reverse_hostname(String uri) {
        URL url = null;
        try {
            url = new URL(uri);
        } catch (MalformedURLException mue) {
            return null;
        }
        String host = url.getHost();
        StringBuilder newhost = new StringBuilder();
        String[] parts = host.split("\\.", 0);
        for (int i = parts.length - 1; i > 0; i--) {
            if (i > 0)
                newhost.append(parts[i]).append(".");
        }
        newhost.append(parts[0]);
        int port = url.getPort();
        if (port != -1)
            newhost.append(":").append(port);
        newhost.append(url.getFile());
        return newhost.toString();
    }
}
