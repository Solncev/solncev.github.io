package ru.kpfu.itis.group11501.solncev;

import java.io.*;
import java.util.Scanner;
import static java.lang.Integer.parseInt;
import static java.lang.Boolean.parseBoolean;
import static ru.kpfu.itis.group11501.solncev.src.Mask.isMask;

import ru.kpfu.itis.group11501.solncev.src.*;


/**
 * Created by Марат on 20.05.2016.
 */

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        boolean includeSubfolders ;
        boolean autoDelete ;

        String [] line = sc.nextLine().split(" ");

        File inputDir = new File(line[0]);

        if(!inputDir.exists()){
            throw new IllegalArgumentException("Error in " + line[0] + "! This directory may not exist or symbol in input path is illegal:");
        }

        File outputDir = new File(line[1]);
        if(!outputDir.exists()){
            throw new IllegalArgumentException("Error in " + line[1] + "! This directory may not exist or symbol in input path is illegal:");
        }

        String mask = line[2];
        if(!isMask(mask)){
            throw new IllegalArgumentException("Mask: " + mask + "incorrect");
        }

        int waitInterval = parseInt(line[3]);
        if(waitInterval < 0){
            throw new IllegalArgumentException("WaitInterval: " + waitInterval +  " incorrect");
        }


        if(line[4].equals("true")|| line[4].equals("false")){
            includeSubfolders = parseBoolean(line[4]);
        }
        else{
            throw new IllegalArgumentException("value of includeSubfolders: " + line[4] + "incorrect" );
        }

        if(line[5].equals("true")|| line[5].equals("false")){
            autoDelete = parseBoolean(line[5]);
        }
        else{
            throw new IllegalArgumentException("value of autoDelete: " + line[5] + "incorrect");
        }


        MyScanner ms = new MyScanner(inputDir, outputDir, mask, waitInterval, includeSubfolders, autoDelete);
        ms.scan();

    }
}
