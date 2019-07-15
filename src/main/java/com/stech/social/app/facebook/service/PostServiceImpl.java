package com.stech.social.app.facebook.service;

import com.restfb.Connection;
import com.restfb.Parameter;
import com.restfb.types.Comment;
import com.restfb.types.Comments;
import com.restfb.types.Likes;
import com.restfb.types.Post;
import com.stech.social.app.facebook.model.FB_Post;
import com.stech.social.app.facebook.util.FacebookClientProvider;
import com.stech.social.app.repository.FBPostRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    FacebookClientProvider facebookClientProvider;

    @Autowired
    FBPostRepo fbPostRepo;


    @Override
    public List<Post> getPosts() {
        Connection<Post> myFeed = facebookClientProvider.getFacebookClient().fetchConnection("me/feed", Post.class, Parameter.with("limit", 10));
        return myFeed.getData();
    }

    @Override
    public Post getPost(String postId) {
        Post post = facebookClientProvider.getFacebookClient().fetchObject("/", Post.class, Parameter.with("id", postId));
        savePost(convert(post));
        return post;
    }

    @Override
    public Likes getLikes(String postId) {
        return facebookClientProvider.getFacebookClient().fetchObject(postId + "/likes", Likes.class, Parameter.with("summary", "true"));
    }

    @Override
    public Comments getComments(String postId) {
        return facebookClientProvider.getFacebookClient().fetchObject(postId + "/comments", Comments.class, Parameter.with("summary", "true"));
    }

    @Override
    public List<Comment> getAllComments(String postId) {

        Connection<Comment> commentConnection = facebookClientProvider.getFacebookClient().fetchConnection(
                postId + "/comments", Comment.class, Parameter.with("limit", 10));
        return commentConnection.getData();

    }

    @Override
    public FB_Post savePost(FB_Post post) {
        FB_Post save = fbPostRepo.save(post);
        return save;
    }

    private FB_Post convert(Post post) {
        FB_Post fb_post = new FB_Post();
        fb_post.setCreated_time(post.getCreatedTime());
        fb_post.setId(post.getId());
        fb_post.setMessage(post.getMessage());
        fb_post.setTotalCommentCount(getComments(post.getId()).getTotalCount());
        fb_post.setTotalLikeCount(getLikes(post.getId()).getTotalCount());
        return fb_post;
    }


}
