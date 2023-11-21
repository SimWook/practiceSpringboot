package com.practice.core.singleton;

import com.practice.core.AppConfig;
import com.practice.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("Springがない純粋なコンテナー")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 照会: 呼ぶ時にオブジェクトを生成
        MemberService memberService1 = appConfig.memberService();

        //2. 照会: 呼ぶ時にオブジェクトを生成
        MemberService memberService2 = appConfig.memberService();

        //参照値が違うかを確認
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("シングルトンパターンを適用したオブジェクト使用")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("spring container and singleton")
    void springContainer() {
       // AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //参照値が違うかを確認
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }
}
