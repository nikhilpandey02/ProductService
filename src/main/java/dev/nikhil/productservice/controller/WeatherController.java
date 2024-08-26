package dev.nikhil.productservice.controller;

import dev.nikhil.productservice.model.Weather;
import dev.nikhil.productservice.services.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired

    private CurrentWeather currentWeather;
    private List<Weather> weather;

    @GetMapping("/lat/{v1}/long/{v2}")
    public ResponseEntity<List<Weather>> getarea(@PathVariable("v1") double v1, @PathVariable("v2") double v2)
    {

        return new ResponseEntity<>(currentWeather.getValue(v1,v2), HttpStatusCode.valueOf(200));
    }

}
