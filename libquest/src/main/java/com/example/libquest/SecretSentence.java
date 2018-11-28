package com.example.libquest;

public class SecretSentence {

    private static String writeSecretSentence(String faible, String fort) {


        return (faible + " s'incline face à " +fort);
    }

    public static void main(String args[]) {
        System.out.println(writeSecretSentence(args[0],args[1]));
    }

}
