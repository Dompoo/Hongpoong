package Dompoo.Hongpoong.repository;

import Dompoo.Hongpoong.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
