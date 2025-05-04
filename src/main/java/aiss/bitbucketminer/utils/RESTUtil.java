package aiss.bitbucketminer.utils;

import java.util.List;
import org.springframework.http.HttpHeaders;

public class RESTUtil {
    public static String getNextPageUrl(HttpHeaders headers) {
        String result = null;

        // If there is no link header, return null
        List<String> linkHeader = headers.get("Link");
        if (linkHeader == null)
            return null;

        // If the header contains no links, return null
        String links = linkHeader.get(0);
        if (links == null || links.isEmpty())
            return null;

        // Return the next page URL or null if none.
        for (String token : links.split(", ")) {
            if (token.endsWith("rel=\"next\"")) {
                // Found the next page. This should look something like
                int idx = token.indexOf('>');
                result = token.substring(1, idx);
                break;
            }
        }

        return result;
    }

}
