package jp.ac.uryukyu.ie.e235722;

public class Player {
    String name;
    String koma;
    int now_mas;
    boolean enemy_flg;

    public Player(String _name, String _koma, boolean _enemy_flg){
        this.name = _name;
        this.koma = _koma;
        this.now_mas = 0;
        this.enemy_flg = _enemy_flg;
    }
    
}