package hello.SpringBasic.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import hello.SpringBasic.member.MemberService;

import static org.assertj.core.api.Assertions.*;

public class XmlAppContext {

	@Test
	void xmlAppContext() {
		ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
		MemberService memberService = ac.getBean("memberService",MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
	
}
