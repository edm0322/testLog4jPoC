package org.wins.testLog4j.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController //Output JSON Format
public class HelloController {
    private static final Logger logger = LogManager.getLogger("HelloWorld");

    @GetMapping("/") //hello GET Request
    public String index(@RequestHeader("X-Api-Version") String apiVersion) {
        ThreadContext.put("apiVersion", apiVersion);
        logger.info("Received a request for API version " + apiVersion);
        return "Hello, world!";
    }
}
