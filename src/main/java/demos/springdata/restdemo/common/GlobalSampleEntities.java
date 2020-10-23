package demos.springdata.restdemo.common;

import demos.springdata.restdemo.model.Post;
import demos.springdata.restdemo.model.User;

import java.util.List;

public class GlobalSampleEntities {

    public static final List<Post> SAMPLE_POSTS = List.of(
            new Post("Welcome to Spring Data", "Developing data access objects with Spring data is easy... "),
            new Post("Reactive Spring Data", "Check R2DBC for reactive JDBC API... "),
            new Post("New in Spring 5", "Webflux provides reactive and non-blocking web service implementation... ")
    );

    public static final List<User> SAMPLE_USERS = List.of(
            new User("Default", "Admin", "admin", "admin"),
            new User("John", "Doe", "john", "john")
    );
}
