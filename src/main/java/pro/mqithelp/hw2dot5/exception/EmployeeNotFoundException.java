package pro.mqithelp.hw2dot5.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid parameters")
public class EmployeeNotFoundException extends RuntimeException {

}
