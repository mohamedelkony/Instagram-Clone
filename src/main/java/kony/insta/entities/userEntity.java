package kony.insta.entities;
import lombok.Data;
import java.util.*;
import java.io.*;

@Data
public class userEntity implements Comparable<userEntity>{
    private long id;
    private String email;
    private String gender;
    private String password;
    private String username;
    private int age;
    private int rate;
    private boolean privateAccount;

    public  int compareTo(userEntity other)
    {
        return (int)(this.id-other.id);
    }


}
