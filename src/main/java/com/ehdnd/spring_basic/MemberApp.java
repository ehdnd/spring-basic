package com.ehdnd.spring_basic;

import com.ehdnd.spring_basic.member.Grade;
import com.ehdnd.spring_basic.member.Member;
import com.ehdnd.spring_basic.member.MemberService;
import com.ehdnd.spring_basic.member.MemberServiceImpl;

public class MemberApp {

  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

    Member memberA = new Member(1L, "memberA", Grade.VIP);
    memberService.join(memberA);

    Member findMember = memberService.findMember(1L);
    System.out.println("findMember = " + findMember.getName());
    System.out.println("memberA = " + memberA.getName());
  }

}
