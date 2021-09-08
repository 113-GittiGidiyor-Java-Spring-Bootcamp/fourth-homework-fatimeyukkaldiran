package patika.dev.schoolmanagementsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import patika.dev.schoolmanagementsystem.entity.ErrorExceptionLogger;

import java.util.Date;
import java.util.List;

    @Repository
    public interface ErrorExceptionLoggerRepository extends PagingAndSortingRepository<ErrorExceptionLogger, Long> {
        @Query("SELECT e FROM ErrorExceptionLogger e WHERE e.exceptionDate= ?1")
        Page<List<ErrorExceptionLogger>> findAllErrorException(LocalDate exceptionDate, Pageable pageable);
    }

