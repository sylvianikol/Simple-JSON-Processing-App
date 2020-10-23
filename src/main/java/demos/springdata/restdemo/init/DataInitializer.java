package demos.springdata.restdemo.init;

import demos.springdata.restdemo.model.User;
import demos.springdata.restdemo.service.PostService;
import demos.springdata.restdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

import static demos.springdata.restdemo.common.GlobalSampleEntities.SAMPLE_POSTS;
import static demos.springdata.restdemo.common.GlobalSampleEntities.SAMPLE_USERS;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {

        SAMPLE_USERS.forEach(user -> this.userService.addUser(user));
        log.info("Created Users: {}", this.userService.getUsers());

        SAMPLE_POSTS.forEach(post -> {
            post.setAuthor(this.userService.getUserById(1L));
            this.postService.addPost(post);
        });
        log.info("Created Posts: {}", this.postService.getPosts());
    }
}
