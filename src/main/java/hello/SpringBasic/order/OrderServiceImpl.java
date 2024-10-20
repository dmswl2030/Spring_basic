package hello.SpringBasic.order;

import org.springframework.beans.factory.annotation.Autowired;

import hello.SpringBasic.discount.DiscountPolicy;
import hello.SpringBasic.member.Member;
import hello.SpringBasic.member.MemberRepository;
import hello.SpringBasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; //구체에 의존하지 않고 추상화인 인터페이스에만 의존한다
    
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    	this.memberRepository = memberRepository;
    	this.discountPolicy = discountPolicy;
    }
    
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    
    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
