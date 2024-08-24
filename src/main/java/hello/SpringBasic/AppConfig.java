package hello.SpringBasic;

import hello.SpringBasic.discount.FixDiscountPolicy;
import hello.SpringBasic.member.MemberService;
import hello.SpringBasic.member.MemberServiceImpl;
import hello.SpringBasic.member.MemoryMemberRepository;
import hello.SpringBasic.order.OrderService;
import hello.SpringBasic.order.OrderServiceImpl;

//AppCongif는 애플리케이션의 실제 동작에 필요한 구현객체를 생성
public class AppConfig {
	public MemberService memberService() {
		return new MemberServiceImpl(new MemoryMemberRepository());
		
	}
	
	public OrderService orderService() {
		return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
	}
}
