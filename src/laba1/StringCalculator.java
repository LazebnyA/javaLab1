package laba1;

import jdk.jfr.Frequency;

import java.util.*;



public class StringCalculator {

    public int add(String numbers) {
        int sum = 0;
        if (numbers == "") { return 0; }

        String[] numsArray = getNumbersList(numbers, delimiter(numbers));

        ArrayList<Integer> negativeNumbersArray = new ArrayList<>();
        for (String value : numsArray) {
            if (Integer.parseInt(value) < 0) {
                negativeNumbersArray.add(Integer.parseInt(value));
            }
        }

        if (negativeNumbersArray.size() != 0) {
            System.out.println("Negative numbers:");
            for (Integer integer : negativeNumbersArray) {
                System.out.println(integer);
            }
        }
        else {
            for (String s : numsArray) {
                if (Integer.parseInt(s) > 1000) {
                    continue;
                }
                sum += Integer.parseInt(s);
            }
        }


        return sum;
    }


    private ArrayList<String> delimiter(String delString) {
        String[] charsSplit = delString.split("");
        ArrayList<String> delsList = new ArrayList<>();
        delsList.add(",");
        delsList.add("\n");
        String temp = "";
        if (charsSplit[0].equals("/") && charsSplit[1].equals("/")) {
            int i = 2;
            while (true) {
                if (charsSplit[i].equals("[")) {
                    while (true) {
                        if (charsSplit[i+1].equals("]")) {
                            i += 2;
                            break;
                        }
                        else {
                            temp += charsSplit[i+1];
                            i++;
                        }
                    }
                    delsList.add(temp);
                    temp = "";
                }
                else {
                    break;
                }
            }
        }
        Collections.sort(delsList);
        Collections.reverse(delsList);
        return delsList;

    }
    //              //
    private String[] getNumbersList(String numbers, ArrayList<String> delsList) {
        int lineBreakIndex = numbers.indexOf("\n");
        numbers = numbers.substring(lineBreakIndex+1);

        for (int i = 0; i < delsList.size(); i++) {
            numbers = numbers.replace(delsList.get(i), " ");
        }

        String[] numbersList = numbers.split(" ");

        return numbersList;
    }


}

