package patika.dev.schoolmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import patika.dev.schoolmanagementsystem.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {
}
