package com.robert.ecommerce.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
public class HelloController {

    @RequestMapping(method = GET, path = "/api/user/hello", produces = APPLICATION_JSON_VALUE)
    public Map<String, String> hello() {
        return Collections.singletonMap("message", "hello user");
    }

    @RequestMapping(method = GET, path = "/api/admin/hello", produces = APPLICATION_JSON_VALUE)
    public Map<String, String> hello2() {
        return Collections.singletonMap("message", "hello admin");
    }

    @RequestMapping(method = GET, path = "/api/all/hello", produces = APPLICATION_JSON_VALUE)
    public Map<String, String> hello3() {
        return Collections.singletonMap("message", "hello All");
    }
}
