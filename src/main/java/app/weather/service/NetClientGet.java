package app.weather.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetClientGet {
	// http://localhost:8080/RESTfulExample/json/product/get
		public static void main(String[] args) {

		  try {

			//URL url = new URL("http://api.worldweatheronline.com/premium/v1/weather.ashx?key=e2402af8d1124766b2835951170602&q=48152&format=json&num_of_days=1&fx=yes&show_comments=no");
			URL url = new URL("http://api.worldweatheronline.com/premium/v1/weather.ashx?key=e2402af8d1124766b2835951170602&q="
		        +"48152"+"&format=json&num_of_days=2&extra=yes&fx=yes&show_comments=no&tp=12&showlocaltime=yes");
			//URL url = new URL("http://openlibrary.org/api/volumes/brief/isbn/0596156715.json");
			
//			URL url = new URL("http://api.wunderground.com/api/"+"ed044d75b91fb500"+
//                "/forecast/q/"+"48152"+".json");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }

		}

	}

