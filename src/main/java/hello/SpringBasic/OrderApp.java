package hello.SpringBasic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.SpringBasic.member.Grade;
import hello.SpringBasic.member.Member;
import hello.SpringBasic.member.MemberService;
import hello.SpringBasic.order.Order;
import hello.SpringBasic.order.OrderService;

public class OrderApp {
	public static void main(String[] args) {
//		AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
		
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
//        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
