package a0;

import c1.BusinessCalculationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class example {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext
                (example.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

    }
}

