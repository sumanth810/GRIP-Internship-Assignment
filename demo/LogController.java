package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/log")
    public ResponseEntity<Void> logUserAgent(@RequestHeader("User-Agent") String userAgent) {
        logService.logUserAgent(userAgent);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

