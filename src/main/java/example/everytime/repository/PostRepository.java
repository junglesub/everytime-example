package example.everytime.repository;

import example.everytime.domain.Post;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  @Query("select p from Post p join fetch p.member order by p.createdDate desc")
  List<Post> findAllWithMember(Pageable pageable);
}
