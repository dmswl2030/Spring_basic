package hello.SpringBasic.singleton;

import hello.SpringBasic.AppConfig;
import hello.SpringBasic.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingleTonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        //1. 조회: 호출할 때 마다 다른 객체를 생
        MemberService memberService1 = appConfig.memberService();
        //2. 조회: 호출할 때 마다 다른 객체를 생
        MemberService memberService2 = appConfig.memberService();
        
        //참조값이 다른것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
        
        //고객 트래픽이 초당 100이 나오면 초당 100개의 객체가 생성되고 소멸된다 -> 메모리 낭비가 심함
        //객체가 1개만 생성되고 공유하는 방식 필오 -> 싱글톤 패턴
        
    }
    
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
    	SingletonService singletonService1 = SingletonService.getInstance();
    	SingletonService singletonService2 = SingletonService.getInstance();
    	
    	System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
    	
        Assertions.assertThat(singletonService1).isNotSameAs(singletonService2);
    }
    
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
    	//AppConfig appConfig = new AppConfig();

    	ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // 1. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        // 2. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 == memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }
}