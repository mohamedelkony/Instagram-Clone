package kony.insta.dto.execptions;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;

public class errorMessageDTO {
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public  errorMessageDTO(String msg){
        this.message=msg;
    }
    public  String message;
}
