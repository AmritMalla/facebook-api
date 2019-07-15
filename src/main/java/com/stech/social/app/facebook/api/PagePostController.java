package com.stech.social.app.facebook.api;


import com.stech.social.app.facebook.constant.FBConstants;
import com.stech.social.app.facebook.model.FB_PagePost;
import com.stech.social.app.facebook.model.FB_PagePostListResponseEntity;
import com.stech.social.app.facebook.model.FB_PagePostRequestEntity;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class PagePostController {

    @GetMapping(value = "/getpage/{pageId}/feed")
    public List<FB_PagePost> getAllPage(@PathVariable("pageId") String pageId) {

        final String url = "https://graph.facebook.com/" +
                pageId
                + "/feed?access_token=" + FBConstants.PAGE_ACCESS_TOKEN;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<FB_PagePostListResponseEntity> response = restTemplate.exchange(url,
                HttpMethod.GET, request, FB_PagePostListResponseEntity.class);
        return response.getBody().getData();
    }

    @GetMapping(value = "/feed/{feedId}")
    public FB_PagePost getPageFeed(@PathVariable("feedId") String feedId) {

        String url = "https://graph.facebook.com/" +
                feedId
                + "?access_token=" + FBConstants.PAGE_ACCESS_TOKEN;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<FB_PagePost> response = restTemplate.exchange(url,
                HttpMethod.GET, request, FB_PagePost.class);
        return response.getBody();
    }

    @PostMapping(value = "/feed/{pageId}")
    public String postPageFeed(@PathVariable("pageId") String pageId,
                               @RequestParam("message") String message) {

        String url = "https://graph.facebook.com/" +
                pageId
                + "/feed?access_token=" + FBConstants.PAGE_ACCESS_TOKEN;
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        FB_PagePostRequestEntity fb_pagePostRequestEntity = new FB_PagePostRequestEntity();
        fb_pagePostRequestEntity.setMessage(message);

        HttpEntity<FB_PagePostRequestEntity> requestEntity = new HttpEntity<>(fb_pagePostRequestEntity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url,
                HttpMethod.POST, requestEntity, String.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        }
        return null;
    }

    @DeleteMapping(value = "/feed/{feedId}")
    public String deletePageFeed(@PathVariable("feedId") String feedId) {
        final String url = "https://graph.facebook.com/" +
                feedId
                + "?access_token=" + FBConstants.PAGE_ACCESS_TOKEN;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url,
                HttpMethod.DELETE, request, String.class);
        return response.getBody();
    }

    @PostMapping(value = "/feed/scheduled/{pageId}")
    public String scheduledPostPageFeed(@PathVariable("pageId") String pageId,
                                        @RequestParam("message") String message,
                                        @RequestParam("scheduled_publish_time") Long scheduledPublishTime) {

        String url = "https://graph.facebook.com/" +
                pageId
                + "/feed?access_token=" + FBConstants.PAGE_ACCESS_TOKEN;
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        FB_PagePostRequestEntity entity = new FB_PagePostRequestEntity();
        entity.setMessage(message);
        entity.setScheduled_publish_time(scheduledPublishTime);
        entity.setPublished(false);

        HttpEntity<FB_PagePostRequestEntity> requestEntity = new HttpEntity<>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url,
                HttpMethod.POST, requestEntity, String.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        }
        return null;
    }


}
