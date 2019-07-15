package com.stech.social.app.facebook.api;

import com.stech.social.app.facebook.constant.FBConstants;
import com.stech.social.app.facebook.model.FB_LikesListResponse;
import com.stech.social.app.facebook.model.FB_PagePostRequestEntity;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class PostLikesController {

    @GetMapping("/likes/{postId}")
    public FB_LikesListResponse getAllLikes(
            @PathVariable("postId") String postId
    ) {
        final String url = "https://graph.facebook.com/" +
                postId
                + "/likes?summary=true&access_token=" + FBConstants.PAGE_ACCESS_TOKEN;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<FB_LikesListResponse> response = restTemplate.exchange(url,
                HttpMethod.GET, request, FB_LikesListResponse.class);
        return response.getBody();
    }

    @PostMapping(value = "/likes/{postId}")
    public String postPageFeed(@PathVariable("postId") String pageId
                               ) {

        String url = "https://graph.facebook.com/" +
                pageId
                + "/likes?access_token=" + FBConstants.PAGE_ACCESS_TOKEN;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<FB_PagePostRequestEntity> requestEntity = new HttpEntity<>(requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url,
                HttpMethod.POST, requestEntity, String.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        }
        return null;
    }



}
