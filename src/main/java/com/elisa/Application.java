package com.elisa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.yammer.metrics.core.Counter;
import com.yammer.metrics.core.MetricsRegistry;
import com.yammer.metrics.core.Timer;
/**
 * Created by elisa on 18/08/15.
 */

@Configuration
@ComponentScan


public class Application {
    private MetricsRegistry registry;

    public static void main(String[] args) {

    }

    @Bean
    public Counter counter;


        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-context.xml");
        /*Timer processTimer = (Timer) context.getBean("processTimer");
*/


        NamePrinter elisaNamePrint = (NamePrinter) context.getBean("elisaNamePrint");
        Counter nameCounter = (Counter) context.getBean("nameCounter");
/*
        processTimer.time();
*/
        elisaNamePrint.printName();
        nameCounter.inc();
        System.out.println(nameCounter.count());
        //te.spellCheck();
        //Writer te = (Writer) context.getBean("writer");
        Counter anotherCounter = (Counter) context.getBean("nameCounter");
        /*processTimer.stop();*/
        System.out.println(anotherCounter.count());
    }
}
