package patika.dev.schoolmanagementsystem.api.controller;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import patika.dev.schoolmanagementsystem.entity.ErrorExceptionLogger;
import patika.dev.schoolmanagementsystem.service.ErrorExceptionLoggerService;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class ErrorExceptionLoggerController {
    private final ErrorExceptionLoggerService loggerService;

    @GetMapping("/get-error-exceptions-by-date")
    public ResponseEntity<Page<List<ErrorExceptionLogger>>> getAllErrorExceptionsWithDate(
            @ApiParam(value = "error log query for course usage", example = "05/07/2021", required = true)
            @RequestParam String transactionDate,
            @RequestParam(required = false) Integer pageNumber,
            @RequestParam(required = false) Integer pageSize,
            @PageableDefault(page = 0, size = 10) Pageable pageable){
        return new ResponseEntity<>(this.loggerService.getAllErrorLoggersWithDate(transactionDate, pageNumber, pageSize, pageable), HttpStatus.OK);
    }
}
