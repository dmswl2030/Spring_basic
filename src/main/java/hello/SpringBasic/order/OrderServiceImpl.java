package hello.SpringBasic.order;

import hello.SpringBasic.discount.FixDiscountPolicy;
import hello.SpringBasic.member.Member;
import hello.SpringBasic.member.MemoryMemberRepository;

public class OrderServiceImpl {
	private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    private final FixDiscountPolicy discountPolicy = new FixDiscountPolicy();

    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
