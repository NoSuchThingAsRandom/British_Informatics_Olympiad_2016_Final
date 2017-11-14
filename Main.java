package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Agents Anonymous Prequel, Enter using commaK");
        int numSpies = Integer.parseInt(in.nextLine());
        String line;
        BitSet validSpies=new BitSet(numSpies);
        validSpies.flip(0,numSpies);
        ArrayList<int[]> spiesWhoKnowEachOther = new ArrayList<>();
        while (!Objects.equals(line = in.nextLine(), "-1,-1")) {

            spiesWhoKnowEachOther.add(new int[]{Integer.parseInt((line.split(","))[0]),Integer.parseInt((line.split(","))[1])});
        }
        for(int currentSpy=0;currentSpy<numSpies;currentSpy++){
            if(validSpies.get(currentSpy)) {
                ArrayList<Integer> thisSpyKnows = new ArrayList<Integer>();
                for (int[] x : spiesWhoKnowEachOther) {
                    if (x[0] == currentSpy) {
                        thisSpyKnows.add(x[1]);
                        validSpies.set(x[1], false);
                    }
                    if (x[1] == currentSpy) {
                        thisSpyKnows.add(x[0]);
                        validSpies.set(x[0], false);
                    }
                }
            }
        }
        for(int x=0;x<validSpies.size();x++){
            if (validSpies.get(x)){
                System.out.println("This spy is valid: "+(x+1));
            }
        }

    }
}
