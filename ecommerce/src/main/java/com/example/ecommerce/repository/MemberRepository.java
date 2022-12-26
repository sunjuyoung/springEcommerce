package com.example.ecommerce.repository;

import com.example.ecommerce.domain.member.Member;
import com.example.ecommerce.domain.member.MemberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, MemberId> {
}
