package org.kuraterut;

import org.kuraterut.controller.Controller;
import org.kuraterut.entities.Zoo;
import org.kuraterut.entities.veterinaryclinic.VeterinaryClinic;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputScanner = null;
        PrintStream printStream = null;
        try{

            InputStream inputStream = new FileInputStream("src/main/resources/mainCases/in.txt");
            inputScanner = new Scanner(inputStream);
            printStream = new PrintStream(new FileOutputStream("src/main/resources/mainCases/out.txt"));

//            inputStream = System.in;
//            printStream = System.out;
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }

        VeterinaryClinic clinic = new VeterinaryClinic("main veterinary", 5);
        Zoo zoo = new Zoo("main zoo", clinic, printStream);
        Controller controller = new Controller(zoo, inputScanner, printStream);

//        boolean hasNext = true;

        controller.execute();

    }
}