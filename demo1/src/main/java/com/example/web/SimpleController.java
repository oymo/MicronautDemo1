package com.example.web;

import com.example.data.DevRepo;
import com.example.data.Developer;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class SimpleController {

    private DevRepo devRepo;

    @Inject
    public SimpleController(DevRepo devRepo) {
        this.devRepo = devRepo;
    }

    @Get("/hello")
    public String sayHello() {
        return "Hi";
    }

    @Get("/randomdev")
    public Developer getRandom() {
//        return new Developer(1, "Testdev");
//
        List<Developer> developerList;
        developerList = StreamSupport.stream(devRepo.findAll().spliterator(), false).collect(Collectors.toList());
        Collections.shuffle(developerList);
        return (developerList.isEmpty() ? null : developerList.get(0));
    }
}
