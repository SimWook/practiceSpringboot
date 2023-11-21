package com.practice.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: Aユーザが1000円を注文
        int userA = statefulService1.order("userA", 1000);
        // ThreadA: Bユーザが2000円を注文
        int userB = statefulService2.order("userB", 2000);

        //ThreadA: ユーザAが注文金額を照会
        //int price = statefulService1.getPrice();
        System.out.println("price = " + userA);

        //assertThat(statefulService1.getPrice()).isEqualTo(2000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}