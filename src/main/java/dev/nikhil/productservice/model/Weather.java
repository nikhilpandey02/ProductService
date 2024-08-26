package dev.nikhil.productservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Weather {

    public String name;
    public double lat;
    public double lon;
    public String country;
}
