package kony.insta.exceptions;

import kony.insta.dto.execptions.errorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExceptionsAdvice {
    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    errorMessageDTO notFoundHandler(NotFoundException ex) {
         var x=new errorMessageDTO(ex.getMessage());

    return x;
    }
}
