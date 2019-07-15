package com.stech.social.app.controller;

import com.stech.social.app.facebook.constant.FBConstants;
import com.stech.social.app.facebook.model.FbAccessToken;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultController(Model model) throws UnsupportedEncodingException {

        final String encodedURL = URLEncoder.encode(FBConstants.CALLBACK_URL, "UTF-8");
        String url = "https://www.facebook.com/v3.3/dialog/oauth?" +
                "client_id=" + FBConstants.CLIENT_ID +
                "&redirect_uri=" + encodedURL +
                "&scopes=" + FBConstants.SCOPES;
        System.out.println(url);
        model.addAttribute("loginUrl", url);
        return "facebook/Connect";
    }

    @RequestMapping(value = "/connected", method = RequestMethod.GET)
    public String afterLoggedIn(@RequestParam(required = false) String code, Model model) throws IOException {

        final String encodedURL = URLEncoder.encode(FBConstants.CALLBACK_URL, "UTF-8");
        System.out.println(code);

        String link = "https://graph.facebook.com/oauth/access_token?client_id=" + FBConstants.CLIENT_ID + "&redirect_uri=" + encodedURL
                + "&client_secret=" + FBConstants.CLIENT_SECRET + "&code=" + code;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<FbAccessToken> response = restTemplate.exchange(link, HttpMethod.GET,  request, FbAccessToken.class);
        model.addAttribute("Token", response.getBody().getAccess_token());
        return "facebook/Connected";

    }
}
