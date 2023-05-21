/**
 *
 *  @author Raksha Vladyslav S24676
 *
 */

package zad1;

import java.util.ArrayList;

public class Letters extends Thread {
    private int substractingValue = 1;
    private boolean ifTrue = true;
    private int timeForSleep = 1000;

    ArrayList<Thread> arrayList = new ArrayList<>();

    public Letters(String letters) {
        for (int i = 0; i < letters.length(); i++) {
            String onlyOneLetter = letters.substring(i, i + substractingValue);
            arrayList.add(new Thread("Thread " + onlyOneLetter) {
                public void run() {
                    while (ifTrue == true) {
                        try {
                            System.out.print(onlyOneLetter);
                            Thread.sleep(timeForSleep);
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                }
            });
        }
    }

    public void run() {
        while (ifTrue == true) {
            try {
                System.out.print(this.getName());
                Thread.sleep(timeForSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Thread> getThreads() {
        return arrayList;
    }
}
