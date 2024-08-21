package hello.SpringBasic.order;

import hello.SpringBasic.discount.DiscountPolicy;
import hello.SpringBasic.member.Member;
import hello.SpringBasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy; //구체에 의존하지 않고 추상화인 인터페이스에만 의존한다
    
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
