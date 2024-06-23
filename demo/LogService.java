package com.example.demo;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LogService {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public void logUserAgent(String userAgent) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String userAgentType = classifyUserAgent(userAgent);
        @SuppressWarnings("unused")
		String logEntry = timestamp + " - Type: " + userAgentType + " - User Agent: " + userAgent;
        System.out.println("User agent logged - Type: " + userAgentType);
        // You can write the logEntry to a file or database here if needed
    }

    private String classifyUserAgent(String userAgent) {
        // Example classification based on common patterns
        if (userAgent.toLowerCase().contains("mobile")) {
            return "Mobile";
        } else if (userAgent.toLowerCase().contains("tablet")) {
            return "Tablet";
        } else {
            return "Desktop";
        }
    }
}

