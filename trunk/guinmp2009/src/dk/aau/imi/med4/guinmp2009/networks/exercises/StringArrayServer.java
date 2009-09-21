package dk.aau.imi.med4.guinmp2009.networks.exercises;

import java.io.*;

public class StringArrayServer {
    public static void main(String[] args) throws IOException {
        new StringArrayServerThread().start();
    }
}
