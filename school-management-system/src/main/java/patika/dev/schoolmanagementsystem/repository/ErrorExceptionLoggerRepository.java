package patika.dev.schoolmanagementsystem.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import patika.dev.schoolmanagementsystem.entity.ErrorExceptionLogger;

import java.time.LocalDate;
import java.util.List;

    @Repository
    public interface ErrorExceptionLoggerRepository extends PagingAndSortingRepository<ErrorExceptionLogger, Long> {
        @Query("SELECT e FROM ErrorExceptionLogger e WHERE e.exceptionDate= ?1")
        Page<List<ErrorExceptionLogger>> findAllErrorException(LocalDate exceptionDate, Pageable pageable);
    }

