package com.stech.social.app.facebook.api;

import com.stech.social.app.facebook.constant.FBConstants;
import com.stech.social.app.facebook.model.FB_CommentsListResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PostCommentsController {
    private final String COMMENT_SCOPES = "can_comment,can_remove,can_hide,can_like,comment_count,like_count";

    @GetMapping(value = "/comments/{postId}")
    public FB_CommentsListResponse getAllComments(
            @PathVariable("postId") String postId
    ) {
        final String url = "https://graph.facebook.com/" +
                postId
                + "/comments?summary=true&fields=" + COMMENT_SCOPES +
                "&access_token=" + FBConstants.PAGE_ACCESS_TOKEN;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<FB_CommentsListResponse> response = restTemplate.exchange(url,
                HttpMethod.GET, request, FB_CommentsListResponse.class);
        return response.getBody();
    }


}
