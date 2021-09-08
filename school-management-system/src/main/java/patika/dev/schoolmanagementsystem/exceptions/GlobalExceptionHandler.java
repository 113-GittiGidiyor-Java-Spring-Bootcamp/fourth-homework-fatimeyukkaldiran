package patika.dev.schoolmanagementsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<SchoolManagementAppErrorResponse> handleException(BadRequestException exc){
        SchoolManagementAppErrorResponse response = getErrorResponse(HttpStatus.BAD_REQUEST, exc.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({CourseIsAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<SchoolManagementAppErrorResponse> handleException(CourseIsAlreadyExistException exc){
        SchoolManagementAppErrorResponse response = getErrorResponse(HttpStatus.BAD_REQUEST, exc.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({StudentAgeNotValidException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<SchoolManagementAppErrorResponse> handleException(StudentAgeNotValidException exc){
        SchoolManagementAppErrorResponse response = getErrorResponse(HttpStatus.NOT_ACCEPTABLE, exc.getMessage());
        return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
    }


    @ExceptionHandler({InstructorNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<SchoolManagementAppErrorResponse> handleException(InstructorNotFoundException exc){
        SchoolManagementAppErrorResponse response = getErrorResponse(HttpStatus.NOT_FOUND, exc.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InstructorIsAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<SchoolManagementAppErrorResponse> handleException(InstructorIsAlreadyExistException exc){
        SchoolManagementAppErrorResponse response = getErrorResponse(HttpStatus.BAD_REQUEST, exc.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({StudentNumberForOneCourseExceededException.class})
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseEntity<SchoolManagementAppErrorResponse> handleException(StudentNumberForOneCourseExceededException exc){
        SchoolManagementAppErrorResponse response = getErrorResponse(HttpStatus.METHOD_NOT_ALLOWED, exc.getMessage());
        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    private SchoolManagementAppErrorResponse getErrorResponse(HttpStatus httpStatus,String message) {
        SchoolManagementAppErrorResponse response = new SchoolManagementAppErrorResponse();
        response.setStatus(httpStatus.value());
        response.setMessage((message));
        response.setTimestamp(System.currentTimeMillis());
        return response;
    }
}
