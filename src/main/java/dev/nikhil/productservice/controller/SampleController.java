package dev.nikhil.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/hello")
    public String helloWorld()
    {
        System.out.println("Hello World");
        return "hello it me working";
    }

    @GetMapping("/hello/{name}")
    public String helloWithme(@PathVariable("name") String name)
    {
        return "hello "+name;
    }

    @GetMapping("/myname/{name}/seat/{no}")
    public String multiple(@PathVariable("name") String name,@PathVariable("no") long no)
    {
        return "hello "+name+" seat "+ no;
    }
}
