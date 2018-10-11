package com.design.pattern.proxy;

interface IGamePlayer {

    void login(String user, String password);

}

class GamePlayer implements IGamePlayer{

    @Override
    public void login(String user, String password) {
        System.out.println("user:"+user+", pwd:"+password);
    }
}

class GamePlayerProxy implements IGamePlayer{
    private IGamePlayer gamePlayer;

    public GamePlayerProxy(IGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void login(String user, String password) {
        this.gamePlayer.login(user,password);
    }
}

public class MainTest {
    public static void main(String[] args) {
        IGamePlayer gamePlayer = new GamePlayer();
        IGamePlayer gamePlayerProxy = new GamePlayerProxy(gamePlayer);
        gamePlayerProxy.login("wanbf","123456");
    }
}
