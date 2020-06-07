package com.example.urlShortening.controller;

import com.example.urlShortening.Application;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Israel Guerrero
 */

@RestController
@RequestMapping("/api/v1/url-shortening")
public class ApplicationController {


    @PostMapping("/restart")
    public void restart() {
        Application.restart();
    }

    @PostMapping("/close")
    public void close() {
        Application.close();
    }

}
