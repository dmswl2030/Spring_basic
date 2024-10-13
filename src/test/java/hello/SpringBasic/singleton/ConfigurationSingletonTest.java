package hello.SpringBasic.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.SpringBasic.AppConfig;
import hello.SpringBasic.member.MemberRepository;
import hello.SpringBasic.member.MemberServiceImpl;
import hello.SpringBasic.order.OrderServiceImpl;

public class ConfigurationSingletonTest {
	
	@Test
	void configurationTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
		
		MemberRepository memberRepository1 = memberService.getMemberRepository();
		MemberRepository memberRepository2 = orderService.getMemberRepository();
		
		System.out.println("memberService -> memberRepository1:: " + memberRepository1);
		System.out.println("orderService -> memberRepository2:: " + memberRepository2);
	}

}
