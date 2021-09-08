package patika.dev.schoolmanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import patika.dev.schoolmanagementsystem.entity.ErrorExceptionLogger;
import patika.dev.schoolmanagementsystem.repository.ErrorExceptionLoggerRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ErrorExceptionLoggerService {

    @Autowired
    private ErrorExceptionLoggerRepository loggerRepository;


    public Page<List<ErrorExceptionLogger>> getAllErrorLoggersWithDate(String exceptionDate, Integer page, Integer size, Pageable pageable) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate exceptionDateResult = LocalDate.parse(exceptionDate, formatter);
        if(page != null && size != null){
            pageable = PageRequest.of(page, size);
        }
        return this.loggerRepository.findAllErrorException(exceptionDateResult, pageable);
    }
}
