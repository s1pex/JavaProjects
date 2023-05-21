/**
 *
 *  @author Raksha Vladyslav S24676
 *
 */

package zad1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {

        BlockingQueue<Product> blockingQueue = new LinkedBlockingQueue<>(10000);

        Thread threadB = new Thread(() -> {
            try {
                int numberOfProduct = 0;
                int totalWeight = 0;
                while (true) {
                    Product product = blockingQueue.take();

                    totalWeight += product.getWeight();

                    numberOfProduct++;

                    if (numberOfProduct % 100 == 0) {
                        System.out.println("policzono wage " + numberOfProduct + " towarów");
                    }

                    if (blockingQueue.isEmpty()) {
                        break;
                    }
                }

                System.out.println("Waga wszystkich towarów: " + totalWeight);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadA = new Thread(() -> {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("../Towary.txt"));

                String line;
                int numberOfProduct = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    double id = Double.parseDouble(parts[0]);
                    double weight = Double.parseDouble(parts[1]);

                    Product product = new Product(id, weight);

                    blockingQueue.put(product);

                    numberOfProduct++;

                    if (numberOfProduct % 200 == 0) {
                        System.out.println("utworzono " + numberOfProduct + " obiektów");
                    }

                }
                bufferedReader.close();
                threadB.start();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });


       threadA.start();
       
    }
}
