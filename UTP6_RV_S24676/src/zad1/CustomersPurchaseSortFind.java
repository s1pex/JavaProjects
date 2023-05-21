/**
 *
 *  @author Raksha Vladyslav S24676
 *
 */

package zad1;


import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;


public class CustomersPurchaseSortFind {

    List<Purchase> listOfPurchase = new ArrayList<>();

    public void readFile(String file) {

        int idNum = 0;
        int imieNum = 1;
        int cenaNum = 3;
        int iloscNum = 4;

        listOfPurchase = new ArrayList<>();

        try {
            Files.readAllLines(Paths.get(file)).forEach((dataLine) -> {

                Purchase p = new Purchase(dataLine);

                String received[] = dataLine.split(";");
                String imieNazwisko[] = received[imieNum].split(" ");


                p.setName(imieNazwisko[imieNum]);
                p.setSurname(imieNazwisko[0]);
                p.setId(received[idNum]);


                p.setPrice(Float.parseFloat(received[iloscNum]));
                p.setQuantity(Float.parseFloat(received[cenaNum]));
                p.setProdukt(received[2]);

                listOfPurchase.add(p);
            });
        } catch (IOException ioException) {
            System.out.println("Error occurred");
        }
    }

    public void showSortedBy(String processOfSort) {
        System.out.println(processOfSort);

        if (!processOfSort.equalsIgnoreCase("Nazwiska")) {

            listOfPurchase.stream()
                    .sorted((a, b) -> {
                        double priceCompare = Float.compare(
                                (a.getQuantity() * a.getPrice() * -1)
                                , (b.getQuantity() * b.getPrice() * -1)
                        );

                        if (priceCompare != 0) {
                            return (int)priceCompare;
                        } else {
                            return a.getId().compareToIgnoreCase(b.getId());
                        }
                    })
                    .forEach((p) -> {
                        float price = (p.getPrice() * p.getQuantity());
                        System.out.println(p.getLine() + " (koszt: " + price + ")");
                    });
        } else if (!processOfSort.equalsIgnoreCase("Koszty")) {
            listOfPurchase.stream().sorted((a, b) -> {
                        double surDifference = a.getSurname().compareToIgnoreCase(b.getSurname());

                        if (surDifference != 0) {
                            return (int)surDifference;
                        } else {
                            return a.getId().compareToIgnoreCase(b.getId());
                        }
                    })
                    .forEach((p) -> System.out.println(p.getLine()));


        } else {

            listOfPurchase.forEach((p) -> System.out.println(p.getLine()));
        }

        System.out.println();
    }

    public void showPurchaseFor(String id) {
        System.out.println("Klient " + id);
        listOfPurchase.stream().filter((p) -> p.getId().equalsIgnoreCase(id))
                .forEach((p) -> System.out.println(p.getLine()));

        System.out.println();
    }
}