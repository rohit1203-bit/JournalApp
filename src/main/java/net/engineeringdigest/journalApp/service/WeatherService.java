package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

//    private static final String apikey ="4b73533bf1msh7266d0ed1fa4caep1e57dfjsn52fe50f2fb00";
//    private static final String API ="https://weatherapi-com.p.rapidapi.com/sports.json?q=CITY";

    private static final String apikey ="b4e805d9fb9f0d7fb14d0ae4cccc2850";
    //check for api key on weatherstack website

    private static final String API ="http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city){
        String finalAPI=API.replace("CITY",city);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }

//    OkHttpClient client = new OkHttpClient();
//
//    Request request = new Request.Builder()
//            .url("https://weatherapi-com.p.rapidapi.com/sports.json?q=London")
//            .get()
//            .addHeader("x-rapidapi-key", "4b73533bf1msh7266d0ed1fa4caep1e57dfjsn52fe50f2fb00")
//            .addHeader("x-rapidapi-host", "weatherapi-com.p.rapidapi.com")
//            .build();
//
//    Response response = client.newCall(request).execute();
}
