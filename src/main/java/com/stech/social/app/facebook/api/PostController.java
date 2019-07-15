package com.stech.social.app.facebook.api;

import com.restfb.types.Comment;
import com.restfb.types.Comments;
import com.restfb.types.Likes;
import com.restfb.types.Post;
import com.stech.social.app.facebook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {


    @Autowired
    PostService postService;

    @RequestMapping(value = "/getposts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Post> getPosts(){

        return postService.getPosts();
    }

    @RequestMapping(path = "/getposts/{postId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Post getPost(@PathVariable String postId){
        return postService.getPost(postId);
    }

    @RequestMapping(path = "/getposts/{postId}/likes/summary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Likes getLikes(@PathVariable String postId){
        return postService.getLikes(postId);
    }

    @RequestMapping(path = "/getposts/{postId}/comments/summary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Comments getComments(@PathVariable String postId){
        return postService.getComments(postId);
    }

    @RequestMapping(path = "/getposts/{postId}/comments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Comment> getAllComment(@PathVariable String postId){
        return postService.getAllComments(postId);
    }




}
