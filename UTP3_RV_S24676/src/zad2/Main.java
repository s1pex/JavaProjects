/**
 *
 *  @author Raksha Vladyslav S24676
 *
 */

package zad2;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    List<String> dest = Arrays.asList(
            "bleble bleble 2000",
            "WAW HAV 1200",
            "xxx yyy 789",
            "WAW DPS 2000",
            "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = (List<String>) dest.stream().map(point -> point.split(" ")).
            filter(splittedPoint -> splittedPoint[0].equals("WAW")).
            map(splittedPoint -> "to " + splittedPoint[1] + " - " + "price in PLN: " + "\t" + ((int)Integer.parseInt(splittedPoint[2]) * ratePLNvsEUR)).
            collect(Collectors.toList());


    for (String r : result) System.out.println(r);
  }
}