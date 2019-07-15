package com.stech.social.app.facebook.service;

import com.restfb.types.Comment;
import com.restfb.types.Comments;
import com.restfb.types.Likes;
import com.restfb.types.Post;
import com.stech.social.app.facebook.model.FB_Post;

import java.util.List;

public interface PostService {
    List<Post> getPosts();

    Post getPost(String postId);

    Likes getLikes(String postId);

    Comments getComments(String postId);

    List<Comment> getAllComments(String postId);

    FB_Post savePost(FB_Post post);
}
