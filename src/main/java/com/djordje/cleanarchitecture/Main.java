package com.djordje.cleanarchitecture;

import com.djordje.cleanarchitecture.configuration.WhatsTheTimeConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(WhatsTheTimeConfiguration.class);
    }
}
