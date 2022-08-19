package kony.insta.dto.execptions;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Builder
@AllArgsConstructor
@Data
public class errorMessageDTO {
    public errorMessageDTO(String msg){
        this.message=msg;
    }
    public String message;
    public String gt=null;
}
