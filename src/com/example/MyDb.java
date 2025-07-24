package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import program.Program;

public class MyDb {
	
	static Program program;

    public static void main(String[] args) throws IOException {
    	
    	
        BufferedReader in;
        String input;
        String output = "";
        program = new Program();
        in = new BufferedReader(new InputStreamReader(System.in));
        program.showIntro();
        do {
        	
            System.out.print("> ");
            input = in.readLine();
            output = program.runCommand(input); 
            System.out.println(output);
        } while (!"q".equals(input));
    }

}