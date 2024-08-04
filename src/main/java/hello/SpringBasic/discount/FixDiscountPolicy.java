package hello.SpringBasic.discount;

import hello.SpringBasic.member.Member;
import hello.SpringBasic.member.Grade;

public class FixDiscountPolicy implements DiscountPolicy{

    private final int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}