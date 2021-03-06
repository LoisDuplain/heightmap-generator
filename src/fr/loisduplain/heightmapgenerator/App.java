package fr.loisduplain.heightmapgenerator;

import java.io.IOException;

public class App {
    
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("How to use:");
            System.out.println(" ");
            System.out.println("java -jar HeightMap-Generator.jar <width> <height> <noise_reduction> <seed|random>");
            System.out.println(" ");
            System.out.println("Examples:");
            System.out.println(" ");
            System.out.println("java -jar HeightMap-Generator.jar 500 888 10 random");
            System.out.println("java -jar HeightMap-Generator.jar 250 980 1.3 random");
            System.out.println("java -jar HeightMap-Generator.jar 20 65 10.5 5684354351");
            System.out.println("java -jar HeightMap-Generator.jar 17 65 5 5684354351");
            System.out.println(" ");
            System.out.println("It will generate file named: map-width-height-noise_reduction-seed.txt");
            return;
        }
        Map map = null;
        if (args[3].equalsIgnoreCase("random")) {
            map = new Map(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Float.parseFloat(args[2]));
        } else {
            map = new Map(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Float.parseFloat(args[2]), Long.parseLong(args[2]));
        }
    
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Map generated by Loïs Duplain (lduplain) HeightMap Generator");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        try {
            map.writeMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
