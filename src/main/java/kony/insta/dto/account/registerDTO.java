package kony.insta.dto.account;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.*;import kony.insta.dto.validators.*;
@Data
@Builder
public class registerDTO {
    @NotBlank
    @Size(min=3,max=16,message = "username length must be 3 and 16 characters")
    private String username;
    @Email
    @NotBlank
    private String email;
    @gender
    private String gender;
    @Range(min=16,max=120,message = "age must be between 16 and 120 years")
    private int age;
    @Size(min=6)
    private String password;
}
