package com.stech.social.app.facebook.api;

import com.stech.social.app.facebook.constant.FBConstants;
import com.stech.social.app.facebook.model.FB_Page;
import com.stech.social.app.facebook.model.FB_PageListResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserAccountsController {

    @GetMapping(value = "/getpages")
    public List<FB_Page> getAllPage() {

        String url = "https://graph.facebook.com/me/accounts" +
                "?access_token=" + FBConstants.ACCESS_TOKEN;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<FB_PageListResponse> response = restTemplate.exchange(url,
                HttpMethod.GET, request, FB_PageListResponse.class);
        return response.getBody().getData();
    }

}
