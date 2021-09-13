package com.example.project.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }
    //딱 한개의 객체 인스턴스만 존재하기 때문에 반드시 private으로 생성자를 생성해야 된다.
    //굉장히 중요하다.
    private SingletonService(){

    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
