package d1.a0;

import c1.BusinessCalculationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA{

}
@Component
@Lazy
class ClassB{
    private ClassA classA;

    public ClassB(ClassA classA){
        System.out.println("Some initialization Logic");
        this.classA = new ClassA();
    }

    public void doSomething(){
        System.out.println("do Something");
    }
}



@Configuration
@ComponentScan
public class LazyinitializationLauncherApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext
                (LazyinitializationLauncherApplication.class);

        System.out.println("initailization of context is completed");

        context.getBean(ClassB.class).doSomething();
    }
}

