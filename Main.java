package com.company;

import java.util.*;

public class Main {

    private static void agentAnonymousPrequel(){
        //Sets up
        Scanner in = new Scanner(System.in);
        System.out.println("Agents Anonymous Prequel, Enter using commaK");
        int numSpies = Integer.parseInt(in.nextLine());
        String line;
        BitSet validSpies=new BitSet(numSpies);
        validSpies.flip(0,numSpies);
        ArrayList<int[]> spiesWhoKnowEachOther = new ArrayList<>();

        //Gets inputs
        while (!Objects.equals(line = in.nextLine(), "-1,-1")) {
            spiesWhoKnowEachOther.add(new int[]{Integer.parseInt((line.split(","))[0]),Integer.parseInt((line.split(","))[1])});
        }
        //Removes all spies who know each other
        for(int currentSpy=0;currentSpy<numSpies;currentSpy++){
            if(validSpies.get(currentSpy)) {
                for (int[] x : spiesWhoKnowEachOther) {
                    if (x[0] == currentSpy) {
                        validSpies.set(x[1], false);
                    }
                    if (x[1] == currentSpy) {
                        validSpies.set(x[0], false);
                    }
                }
            }
        }
        //Output -Calculates valid spies
        int count=0;
        ArrayList<Integer> valid=new ArrayList<>();
        for(int x=0;x<validSpies.size();x++){
            if (validSpies.get(x)){
                count++;
                valid.add((x+1));
            }
        }
        //Prints results
        System.out.println(count);
        for (int out:valid){
            System.out.println(out);
        }
    }



    public static void main(String[] args) {
        agentAnonymousPrequel();

    }
}
