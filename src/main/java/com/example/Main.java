package com.example;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@PWA(name = "Sleep Recommender", shortName = "Sleep Rec")
public class Main implements AppShellConfigurator {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
