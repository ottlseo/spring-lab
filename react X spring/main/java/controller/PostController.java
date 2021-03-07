package controller;

import domain.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import service.PostService;

public class PostController {
    @Controller
    public class PostController{
        private final PostService postService;

        @Autowired
        public PostController(PostService postService){ //생성자
            this.postService = postService;
        }
        @PostMapping(value = "/")
        public String create(PostForm postForm){
            Posts
        }
    }
}
