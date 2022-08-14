package kony.insta.dto.account;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

public class registerDTOres {
   public int id;
   @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
   public registerDTOres(int id){
      this.id=id;
   }
}
