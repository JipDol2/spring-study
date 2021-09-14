package com.example.project.singleton;

import com.example.project.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //Thread A : A사용자 10000원 주문
        statefulService1.order("userA",10000);
        //Thread B : B사용자 20000원 주문
        statefulService2.order("userB",20000);

        int price = statefulService1.getPrice();
        System.out.println("price : " + price);//10000원을 기대했지만, 20000원이 나온다. 그 이유는 statefulService1 과 statefulService2는 같은 객체이기 때문
        //Singleton 은 항상 공유필드를 주의해야한다. 무상태로 설계해야한다.
        Assertions.assertThat(statefulService1.getPrice());
    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}