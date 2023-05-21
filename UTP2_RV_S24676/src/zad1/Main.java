/**
 *
 *  @author Raksha Vladyslav S24676
 *
 */

package zad1;

import java.util.*;

public class Main {
  public Main() {
    List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12);
    System.out.println(test1(src1));

    List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv" );
    System.out.println(test2(src2));
  }

  public List<Integer> test1(List<Integer> src) {
    Selector sel = new Selector() {
      @Override
      public boolean sel(Object sel) {
        if((int)sel < 10){
          return true;
        } else {
          return false;
        }
      }
    };/*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */
    Mapper map = new Mapper() {
      @Override
      public Object map(Object map) {
        map = (int)map + 10;
        return map;
      }
    }; /*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */
    return   /*<-- zwrot wyniku
            uzyskanego przez wywołanie statycznej metody klasy ListCreator:
           */  ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public List<Integer> test2(List<String> src) {
    Selector sel = new Selector() {
      @Override
      public boolean sel(Object sel) {
        if(sel.toString().length() > 3){
          return true;
        }
          return false;
        }
    };
    /*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */
    Mapper map = new Mapper() {
      @Override
      public Object map(Object map) {
        map = map.toString().length() + 10;
        return map;
      }
    }; /*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */
    return   /*<-- zwrot wyniku
            uzyskanego przez wywołanie statycznej metody klasy ListCreator:
           */  ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public static void main(String[] args) {
    new Main();
  }
}
