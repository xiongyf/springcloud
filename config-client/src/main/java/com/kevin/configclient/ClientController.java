package com.kevin.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Value("${example.property}")
    String property;

    @GetMapping("/property")
    public String property() {
        return property;
    }
}
