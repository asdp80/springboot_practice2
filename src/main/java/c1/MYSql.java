package c1;

import org.springframework.stereotype.Component;

@Component
public class MYSql extends DataService {
    int[] retrieveData(){
        return new int[]{11,22,33,44,55};
    }

}
