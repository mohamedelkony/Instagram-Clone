package kony.insta.entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="users")
public class userEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    @Column(unique = true)
    private String email;
    private String gender;

    private String password;

    @Column(unique = true)
    private String username;

  private int age;

    public int compareTo(userEntity other) {
        return (int) (this.id - other.id);
    }
}

/*
Why SEQUENCE over Identity?
https://thorben-janssen.com/jpa-generate-primary-keys/
 */
