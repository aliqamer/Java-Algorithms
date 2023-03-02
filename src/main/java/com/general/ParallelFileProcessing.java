package com.general;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
//import java.nio.file.Path;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 1. Periodically scans the ./src/main/resources dir and wateches for new files
 2. For each file found into this dir, a new thread should take care of its processing
 3. Processing each line of the file will be hashed using a hashing algorithm
 4. Program will create new files, marked _output sufix, and they will be placed into ./src/main/output dir
 5. Throw an exception if a line is empty
 */

public class ParallelFileProcessing {

    public static void main(String[] args) {
        System.out.println("starting...");
        new Thread(new Watcher()).start();
    }
}

class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Exception handled: "+e.getMessage());
    }
}

class Watcher implements Runnable {

    @Override
    public void run() {
        File inputDir = new File("input\\");

        while(true) {
            if(inputDir.listFiles().length != 0) {
                Arrays.stream(inputDir.listFiles())
                        .forEach(file -> {
                            Thread t = new Thread(new FileProcessor(file));
                            t.setUncaughtExceptionHandler(new ExceptionHandler());
                            t.start();
                        });
            } else {
                System.out.println("file not found");
            }
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class FileProcessor implements Runnable {

    private final File file;
    private final static String OUTPUT_PATH = "output//";

    public FileProcessor(File file) {
        this.file = file;
    }

    @Override
    public void run() {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_PATH + file.getName()));) {
            Files.lines(Path.of(file.getCanonicalPath()))
                    .map(this::hash)
                    .map(line -> line + "\n")
                    .forEach(el -> {
                        try {
                            writer.write(el);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " -> processed file: "+file.getName());
    }

    private String hash(String input) {

        if(input.equals("")){
            throw new RuntimeException("The line is empty, hashing cannot work");
        }

        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            final byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String bytesToHex(byte[] hashBytes) {
        StringBuilder hexString = new StringBuilder(2*hashBytes.length);
        for (int i = 0; i < hashBytes.length; i++) {
            String hex = Integer.toHexString(0xff & hashBytes[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}