package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.entity.User;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

//    private static final String apikey ="4b73533bf1msh7266d0ed1fa4caep1e57dfjsn52fe50f2fb00";
//    private static final String API ="https://weatherapi-com.p.rapidapi.com/sports.json?q=CITY";

    @Value("${weather.api.key}")
    private String apikey;
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

//    //this is the way to consume external POST API but this will not work in this case because
//    //weather api is not made to handle the post method
//    public WeatherResponse postWeather(String city){
//        String finalAPI=API.replace("CITY",city);
////        String requestBody= "{\n" + " \"userName\":\"rohit\",\n" + " \"password\":\"rohit\"\n" + "}";
////        HttpEntity<String> httpEntity=new HttpEntity<>(requestBody);
//
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("key","value");
//        User user= User.builder().userName("rohit").password("rohit").build();
//        HttpEntity<User> httpEntity=new HttpEntity<>(user, httpHeaders);
//
//        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.POST, httpEntity, WeatherResponse.class);
//
//        WeatherResponse body = response.getBody();
//        return body;
//    }

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



//    ElevenLabs API for text to speech refer document from the API Refernce of elevenlabs.io

}
