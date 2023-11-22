package com.practice.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient/* implements InitializingBean, DisposableBean*/ {

    private String url;

    public NetworkClient() {
        System.out.println("construct 呼び出し, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //サービススタート呼び出し
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call = " + url + " message = " + message);
    }

    //サービス終了呼び出し
    public void disconnect() {
        System.out.println("close = " + url);
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("初期化接続メッセージ");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
