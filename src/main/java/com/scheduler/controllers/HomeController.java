package com.scheduler.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    @RequestMapping("/status")
    public Map getStatus() {
        Map map = new HashMap<String, String>();
        map.put("app-version", appVersion);
        return map;
    }

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getHomePage() {
        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<body>\n" + "Hello world\n" + "</body>\n" + "</html>";
    }
}
