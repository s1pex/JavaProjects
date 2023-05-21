package ShotTheDuck;

import javax.swing.*;

public class NickName {
    String nick;
    public NickName(boolean print){
        if(print == true) {
            nick = JOptionPane.showInputDialog(null, "Your nickname : ", "Enter your nickname", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
