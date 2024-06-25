package DepInjectionLauncherApplication.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class YourBusinessClass{
    @Autowired
    dependency1 dependency1;
    @Autowired
    dependency2 dependency2;

    @Autowired
    public YourBusinessClass(DepInjectionLauncherApplication.game.dependency1 dependency1, DepInjectionLauncherApplication.game.dependency2 dependency2) {
    System.out.println("Constructor Injection - YourBusinessClass");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }
//    @Autowired
//    public void setDependency1(DepInjectionLauncherApplication.game.dependency1 dependency1) {
//        System.out.println("Setter Injection - setDependency1");
//        this.dependency1 = dependency1;
//    }
//@Autowired
//    public void setDependency2(DepInjectionLauncherApplication.game.dependency2 dependency2) {
//    System.out.println("Setter Injection - setDependency2");
//        this.dependency2 = dependency2;
//    }
//
//    public String toString(){
//        return "Using " + dependency1 + " and " +dependency2;
//    }
}
@Component

class dependency1{
}
@Component

class dependency2{
}
/*
생성자 주입, 수정자 주입, 필드 주입을 사용하여 dependency를 가져오는 연습
 */
@Configuration
@ComponentScan
public class GamingAppLauncherApplication {

    public static void main(String[] args) {

       try ( var context = new AnnotationConfigApplicationContext
                   (GamingAppLauncherApplication.class))
        {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(YourBusinessClass.class));
       }
    }
}

