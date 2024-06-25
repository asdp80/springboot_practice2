package f1.a0;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{
    private final SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency){
        super();
        this.someDependency = someDependency;
        System.out.println("All dependencies are ready!");
    }

    @PostConstruct
    public void initialize(){
        someDependency.getReady();
    }

    //컨테이너에서 인스턴스를 삭제하는 과정 중에 있음을 알려주는 콜백 알림으로 메서드에서 사용한다.
    //predestroy를 어노테이션한 메서드는 보유하고 있던 리소스를 해제하는데 일반적으로 사용된다.
    @PreDestroy
    public void cleanup(){
        System.out.println("Cleanup");
    }

}

@Component
class SomeDependency{

    public void getReady() {
        System.out.println("Some logic using SomeDependency!");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext
                (PrePostAnnotationsContextLauncherApplication.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

    }
}

