package example.everytime.repository;

import example.everytime.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

  @Query("select m from Member m where m.username = :username and m.password = :password")
  Optional<Member> findMemberByUsernameAndPassword(String username, String password);

  @Query("select m from Member m join fetch m.college where m.memberId = :memberId")
  Optional<Member> findMemberByIdWithCollege(Long memberId);
}
