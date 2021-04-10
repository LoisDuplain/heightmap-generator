package fr.loisduplain.heightmapgenerator;

public class Math {
    
    public static float map(double value, double istart, double istop, double ostart, double ostop) {
        return (float) (ostart + (ostop - ostart) * ((value - istart) / (istop - istart)));
    }
    
}
