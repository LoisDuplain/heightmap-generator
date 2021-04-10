package fr.loisduplain.heightmapgenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Map {
    
    private int             width;
    private int             height;
    private float           noiseReduction;
    private long            seed;
    private SimplexNoise    simplexNoise;
    
    public Map(int width, int height, float noiseReduction) {
        this(width, height, noiseReduction, new Random().nextLong());
    }
    
    public Map(int width, int height, float noiseReduction, long seed) {
        this.width = width;
        this.height = height;
        this.noiseReduction = noiseReduction;
        this.seed = seed;
        this.simplexNoise = new SimplexNoise(seed);
    }
    
    public String[] generateMap() {
        String[] textMap = new String[height];
        
        for (int y = 0; y < height; y++) {
            StringBuilder line = new StringBuilder();
            for (int x = 0; x < width; x++) {
                int value = (int) Math.map(simplexNoise.eval(x / 30.0, y / 30.0), -1, 1, 0, 9);
                line.append(value);
            }
            textMap[y] = line.toString();
        }
        return textMap;
    }
    
    public void writeMap() throws IOException {
        String fileName = "map-" + width + "-" + height + "-" + noiseReduction + "-" + seed + ".txt";
        String[] textMap = generateMap();
        File mapFile = new File(fileName);
        if (mapFile.exists())
            mapFile.delete();
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append(String.valueOf(height)).append("\n");
        writer.append(".\n");
        for (String s : textMap) {
            writer.append(s).append("\n");
        }
        writer.close();
    }
    
    public long getSeed() {
        return seed;
    }
    
    public void setSeed(long seed) {
        this.seed = seed;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public SimplexNoise getSimplexNoise() {
        return simplexNoise;
    }
    
    public void setSimplexNoise(SimplexNoise simplexNoise) {
        this.simplexNoise = simplexNoise;
    }
}
