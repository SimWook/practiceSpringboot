package com.practice.core;

import com.practice.core.member.Grade;
import com.practice.core.member.Member;
import com.practice.core.member.MemberService;
import com.practice.core.member.MemberServiceImpl;
import com.practice.core.order.Order;
import com.practice.core.order.OrderService;
import com.practice.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
