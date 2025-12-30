package com.derek.nasa_social_media_app.component;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NasaApiService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String getApod() {
        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
        return restTemplate.getForObject(url, String.class);
    }
}