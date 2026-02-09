package com.ehdnd.spring_basic.member;

public interface MemberRepository {


  void save(Member member);

  Member findById(Long memberId);

}
