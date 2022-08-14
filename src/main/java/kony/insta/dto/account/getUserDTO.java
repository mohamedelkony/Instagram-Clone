package kony.insta.dto.account;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class getUserDTO {
   private long id;
   private String username;
   private String email;
   private String gender;
   private int age;
}
