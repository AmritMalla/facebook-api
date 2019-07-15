package com.stech.social.app.facebook.util;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.stech.social.app.facebook.constant.FBConstants;
import org.springframework.stereotype.Component;

@Component
public class FacebookClientProvider {

    private FacebookClient facebookClient;

    public FacebookClientProvider() {
        this.facebookClient = new DefaultFacebookClient(FBConstants.ACCESS_TOKEN, Version.VERSION_3_3);
    }

    public FacebookClient getFacebookClient() {

          return facebookClient;
    }
}
