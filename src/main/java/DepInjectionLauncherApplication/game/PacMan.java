package DepInjectionLauncherApplication.game;

import org.springframework.stereotype.Component;

@Component
public class PacMan implements GamingConsole {
    public void up(){
        System.out.println("jump");
    }
    public void down(){
        System.out.println("go down");
    }
    public void left(){
        System.out.println("Move left");
    }
    public void right(){
        System.out.println("Move right");
    }
}
