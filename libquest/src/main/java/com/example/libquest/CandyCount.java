package com.example.libquest;

public class CandyCount {

        public static void main(String args[]) {

           boolean test = true;
            int i=12;

            float laTune=12.4f, lePrix=1.2f;
            int lesBonbecs=0;

            while(laTune > 0 && lePrix > 0 && laTune >= lePrix) {
                    lesBonbecs++;
                    laTune-=lePrix;
                }

            System.out.print(lesBonbecs);
        }

}
