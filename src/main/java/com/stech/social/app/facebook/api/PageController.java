package com.stech.social.app.facebook.api;

import com.stech.social.app.facebook.constant.FBConstants;
import com.stech.social.app.facebook.model.FB_Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PageController {

    @GetMapping(value = "/getpage/{id}")
    public FB_Page getPage(@PathVariable("id")String id) {

        String url = "https://graph.facebook.com/" +
                id
                +"?access_token=" + FBConstants.ACCESS_TOKEN;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<FB_Page> response = restTemplate.exchange(url,
                HttpMethod.GET, request, FB_Page.class);
        return response.getBody();
    }



}
