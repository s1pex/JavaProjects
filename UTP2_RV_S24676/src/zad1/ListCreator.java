/**
 * @author Raksha Vladyslav S24676
 */

package zad1;



import java.util.ArrayList;
import java.util.List;

public class ListCreator<A> {

    public List<A> list;

    public ListCreator(List<A> list){
        this.list = list;
    }

    public static ListCreator collectFrom(List list) {
        return new ListCreator(list);
    }

    public ListCreator<A> when(Selector<A> selector) {

        ArrayList<A> list1 = new ArrayList();

        for(int i = 0; i < list.size(); i++){
            if(selector.sel(list.get(i))){
                list1.add(list.get(i));
            }
        }
        return new ListCreator<A>(list1);
    }

    public List<A> mapEvery(Mapper<A> mapper) {

        ArrayList<A> list2 = new ArrayList<>();

        for(int i = 0; i < list.size(); i++ ){
            list2.add(mapper.map(list.get(i)));
        }
        return list2;
    }


    // Uwaga: klasa musi być sparametrtyzowana
}  
