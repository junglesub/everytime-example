package example.everytime.repository;

import example.everytime.domain.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

    @Query("select c from College c where c.name = :collegeName")
    College findCollegeByName (String collegeName);

}
