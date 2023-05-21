/**
 *
 *  @author Raksha Vladyslav S24676
 *
 */

package zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListCreator<A> {

    public List<A> list;

    public ListCreator(List<A> list){
        this.list = list;
    }

    public static ListCreator collectFrom(List list) {
        return new ListCreator(list);
    }

    public ListCreator<A> when(Predicate<A> predicate) {

        ArrayList<A> list1 = new ArrayList();

        for(int i = 0; i < list.size(); i++){
            if(predicate.test(list.get(i))){

                list1.add(list.get(i));
            }
        }
        return new ListCreator<A>(list1);
    }

    public <B>List<B> mapEvery(Function<A, B> function) {

        ArrayList<B> list2 = new ArrayList<>();

        for(int i = 0; i < list.size(); i++ ){
            list2.add(function.apply(list.get(i)));
        }
        return list2;
    }


}