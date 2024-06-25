package game.example.a0;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    //마리오게임의 인스턴스를 만들어준다.
    GamingConsole game;
    //생성자
    public GameRunner(@Qualifier("SupercontraGameQualifier") GamingConsole game) {
        this.game = game;
    }
    //게임을 실행하긴 하지만, 좋은 예는 아니다. 보통 로깅 프레임워크를 사용하는 것이 좋다.
    public void run() {
        System.out.println("Running game : " + game);
        game.up();
        game.down();
        game.left();
        game.right();

    }
}
