package br.com.gymapi.repository;

import br.com.gymapi.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
/*Member
→ entidade que o repository vai manipular

Long
→ tipo do ID da entidade*/
public interface MemberRepository extends JpaRepository<Member, Long> {
}