package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class RequiredMethods {

    public void checkBroken(WebDriver driver)  {
        String homePage = "gittigidiyor.com/";
        String url = "";
        HttpURLConnection urlConnection = null;
        int responseCode = 200;

        List<WebElement> links = driver.findElements(By.tagName("a"));

        Iterator<WebElement> iterator = links.iterator();

        while (iterator.hasNext()) {

            url = iterator.next().getAttribute("href");

            System.out.println(url);

            if (url == null || url.isEmpty()) {
                System.out.println("URL is  not configured or empty");
                continue;
            }

            if (url.startsWith(homePage)) {
                System.out.println("URL belongs to another domain");
                continue;
            }

            try {
                urlConnection = (HttpURLConnection) (new URL(url).openConnection());

                urlConnection.setRequestMethod("HEAD");

                urlConnection.connect();

                responseCode = urlConnection.getResponseCode();

                if (responseCode >= 400) {
                    System.out.println(url + " Link is  broken " + "Response Code : " + responseCode);
                } else {
                    System.out.println(url + " Link is  valid  " + "Response Code : " + responseCode);
                }

            } catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }


}