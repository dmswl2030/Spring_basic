package hello.SpringBasic;

import hello.SpringBasic.discount.DiscountPolicy;
import hello.SpringBasic.discount.RateDiscountPolicy;
import hello.SpringBasic.member.MemberRepository;
import hello.SpringBasic.member.MemberService;
import hello.SpringBasic.member.MemberServiceImpl;
import hello.SpringBasic.member.MemoryMemberRepository;
import hello.SpringBasic.order.OrderService;
import hello.SpringBasic.order.OrderServiceImpl;

//AppCongif는 애플리케이션의 실제 동작에 필요한 구현객체를 생성
public class AppConfig {
	 /**
     *  역할을 알 수 있게 한다.
     *  memberRepository() : Member를 저장하는 역할
     */
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    /**
     *  discountPolicy() : 할인에 관련된 부분
     */
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
    	return new RateDiscountPolicy();
    }

    /**
     *  MemberService가 호출되면?
     *  그러면 MemberServiceImpl이 생성이 됨
     *  그 때 MemoryMemberRepository가 주입이 됨
     */
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
