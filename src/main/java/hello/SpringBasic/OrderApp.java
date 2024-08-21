package hello.SpringBasic;

import hello.SpringBasic.member.Grade;
import hello.SpringBasic.member.Member;
import hello.SpringBasic.member.MemberService;
import hello.SpringBasic.member.MemberServiceImpl;
import hello.SpringBasic.order.Order;
import hello.SpringBasic.order.OrderServiceImpl;

public class OrderApp {
	public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
//        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
