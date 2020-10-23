package demos.springdata.restdemo.model;

import com.google.gson.annotations.Expose;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    @Expose
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Expose
    @NonNull
    @Length(min = 2, max = 60, message = "First name should contain min 2 and max 60 symbols!")
    @Column(name = "first_name")
    private String firstName;

    @Expose
    @NonNull
    @Length(min = 2, max = 60, message = "Last name should contain min 2 and max 60 symbols!")
    @Column(name = "last_name")
    private String lastName;

    @Expose
    @NonNull
    @NotNull
    @Length(min = 3, max = 60, message = "Username should contain min 3 and max 60 symbols!")
    @Column(unique = true, nullable = false)
    private String username;

    @Expose(serialize = false)
    @NonNull
    @NotNull
    @Length(min = 4, max = 30, message = "Username should contain min 4 and max 30 symbols!")
    @Column(unique = true, nullable = false)
    private String password;

    @Expose
    @NonNull
    @NotNull
    private String role = "ROLE_USER";

    private boolean active = true;

    @Expose
    private Date created = new Date();
    @Expose
    private Date modified = new Date();

    @OneToMany(mappedBy = "author")
    @ToString.Exclude
    private Collection<Post> posts = new ArrayList<>();
}
