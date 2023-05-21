/**
 *
 *  @author Raksha Vladyslav S24676
 *
 */

package zad1;


import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.ArrayList;


public class Main {
  public static void main(String[] args) {

    Function<String, List<String>> flines = file -> {
      List<String> list1 = new ArrayList<>();

        try{
          String eachLine;

          FileReader fileReader = new FileReader(file);
          BufferedReader bufferedReader = new BufferedReader(fileReader);

          while((eachLine = bufferedReader.readLine()) != null){
            list1.add(eachLine);
          }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException){
            ioException.printStackTrace();
        }
      return list1;
    };


    Function<List<String>, String> join = list1 -> {
      String output = "";
      for(String s : list1){
        output = output + s;
      }
      return output;
    };


    Function<String, List<Integer>> collectInts = textLine -> {
      List<Integer> nums = new ArrayList<>();

      String num = "";
      textLine = textLine + " ";

      boolean ifNumWas = false;

      if(num.length() > 0){
        nums.add(Integer.parseInt(num));
      }

      for(char ch : textLine.toCharArray()){
        try{
          Integer.parseInt(String.valueOf(ch));
          if(!ifNumWas){
            num = "" + ch;
          } else {
            num = num + ch;
          }
          ifNumWas = true;
        } catch (NumberFormatException nfe) {
          if(ifNumWas) {
            nums.add(Integer.parseInt(num));
            num = "";
          }
          ifNumWas = false;
        }
      }
      return nums;
    };


    Function<List<Integer>, Integer> sum = nums -> (nums.stream().mapToInt(i -> i).sum());


    String fname = System.getProperty("user.home") + "/LamComFile.txt"; 
    InputConverter<String> fileConv = new InputConverter<>(fname);
    List<String> lines = fileConv.convertBy(flines);
    String text = fileConv.convertBy(flines, join);
    List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
    Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

    System.out.println(lines);
    System.out.println(text);
    System.out.println(ints);
    System.out.println(sumints);

    List<String> arglist = Arrays.asList(args);
    InputConverter<List<String>> slistConv = new InputConverter<>(arglist);  
    sumints = slistConv.convertBy(join, collectInts, sum);
    System.out.println(sumints);

  }
}


