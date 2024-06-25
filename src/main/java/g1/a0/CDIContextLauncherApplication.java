package g1.a0;

import c1.BusinessCalculationService;
import c1.DataService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Arrays;

//데이터 서비스를 사용하는 비즈니스 서버가 있다고 해보자.
//@Component
@Named
class BusinessService{
   private DAtaService dataService;


    public DAtaService getDataService() {

        return dataService;
    }

    //@Autowired
    @Inject
    public void setDataService(DAtaService dataService) {
        System.out.println("setter injection");
        this.dataService = dataService;
    }
}
//@Component
@Named
class DAtaService{

}

@Configuration
@ComponentScan
public class CDIContextLauncherApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext
                (CDIContextLauncherApplication.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(context.getBean(BusinessService.class).getDataService());
    }
}

