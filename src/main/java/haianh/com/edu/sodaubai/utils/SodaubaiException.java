package haianh.com.edu.sodaubai.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SodaubaiException extends RuntimeException{

    public SodaubaiException() {
        super();
    }
    public SodaubaiException(String message, Throwable cause) {
        super(message, cause);
    }
    public SodaubaiException(String message) {
        super(message);
    }
    public SodaubaiException(Throwable cause) {
        super(cause);
    }
}
