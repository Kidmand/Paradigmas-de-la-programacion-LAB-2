package feed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

// Import libraries for XML parsing:
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class FeedParser {

    static private Document createDocument(String xmlString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(new StringReader(xmlString)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static private String getTagValue(String tagName, Element item) {
        Node node = item.getElementsByTagName(tagName).item(0);
        String text = "";
        if (node != null) {
            text = node.getTextContent();
        }
        return text;
    }

    static private Article parseItem(Element item) {
        String title = getTagValue("title", item);
        String description = getTagValue("description", item);
        String pubDate = getTagValue("pubDate", item);
        String link = getTagValue("link", item);
        return new Article(title, description, pubDate, link);
    }

    public static List<Article> parseXML(String xmlData) {
        Document doc = createDocument(xmlData);

        // Obtiene la lista de elementos 'item' del nodo raíz
        NodeList itemList = doc.getDocumentElement().getElementsByTagName("item");

        // Crea una lista de objetos Article
        List<Article> articles = new java.util.ArrayList<Article>();

        // Itera sobre la lista de elementos 'item'
        for (int i = 0; i < itemList.getLength(); i++) {
            Element item = (Element) itemList.item(i);
            articles.add(parseItem(item));
        }

        return articles;
    }

    public static String fetchFeed(String feedURL) throws MalformedURLException, IOException, Exception {

        URL url = new URL(feedURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");

        connection.setRequestProperty("User-agent", "lab_paradigmas_grupo_45");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int status = connection.getResponseCode();
        if (status != 200) {
            throw new Exception("HTTP error code: " + status);
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();
            return content.toString();
        }
    }
}
