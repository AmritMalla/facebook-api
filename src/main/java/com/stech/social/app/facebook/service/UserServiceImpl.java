package com.stech.social.app.facebook.service;


import com.restfb.Parameter;
import com.restfb.exception.FacebookException;
import com.restfb.types.User;
import com.stech.social.app.facebook.constant.FBConstants;
import com.stech.social.app.facebook.util.FacebookClientProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    FacebookClientProvider facebookClientProvider;

    @Override
    public User getUser() {
        User user;
        try {
            user = facebookClientProvider.getFacebookClient().fetchObject("me", User.class,
                    Parameter.with("fields", FBConstants.SCOPES));
            return user;
        } catch (FacebookException ex) {
           logger.error(ex.getMessage());
        }
        return null;
    }


}
