package jp.ac.uryukyu.ie.e235722;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BoardTest {
    /**
     * イベント発生時で、戻るマスがスタート地点までである時、数字表記ではなく、"スタート地点に戻る"と表記されるかを検証する。
     * -(step) == now_mas のとき"スタート地点に戻る"と出力されることを期待
     */
    @Test
    public void Test() {
        Board board = new Board(20);
        String start_back = board.display_mas(-4, 4, 20, false);
       
        assertEquals(start_back,"スタート地点に戻る");
    }    
    
}
