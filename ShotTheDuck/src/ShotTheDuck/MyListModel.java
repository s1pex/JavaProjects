package ShotTheDuck;

import javax.swing.*;
import java.util.Vector;

public class MyListModel extends AbstractListModel {
    public Vector<String> nicks;

    public MyListModel(Vector<String> nicks){
        this.nicks = nicks;
    }

    @Override
    public int getSize(){
        return nicks.size();
    }

    @Override
    public Object getElementAt(int index) {
        return nicks.get(index);
    }

    public void add(String text,int index){
        nicks.add(index, text);
        fireIntervalAdded(this, index, index);
    }
    public void add(String text){
        add(text, getSize());
    }
}
