package hello.SpringBasic;

import hello.SpringBasic.member.Grade;
import hello.SpringBasic.member.Member;
import hello.SpringBasic.member.MemberService;

public class MemberApp {
	
	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();
        //MemberServiceImpl memberService = new MemberServiceImpl();
		
		MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }

}
