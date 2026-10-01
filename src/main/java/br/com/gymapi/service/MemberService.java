package br.com.gymapi.service;

import br.com.gymapi.model.Member;
import br.com.gymapi.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }


    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public Member findMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
    }

    public Member updateMember(Long id, Member updatedMember) {
        Member existingMember = findMemberById(id);
        existingMember.setName(updatedMember.getName());
        existingMember.setCpf(updatedMember.getCpf());
        existingMember.setPhone(updatedMember.getPhone());
        existingMember.setEmail(updatedMember.getEmail());
        existingMember.setActive(updatedMember.getActive());
        return memberRepository.save(existingMember);
    }

    public void deleteMember(Long id) {
        Member member = findMemberById(id);
        memberRepository.delete(member);
    }

}