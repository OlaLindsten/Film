package Filmer;

public class Film {
    
    private int id;
    private String titel;
    private String genre;
    private String regissör;
    private String betyg;
    private String längd;
    
    public Film(int id, String titel, String genre, String regissör, String betyg, String längd){
        this.id = id;
        this.titel = titel;
        this.genre = genre;
        this.regissör = regissör;
        this.betyg = betyg;
        this.längd = längd;
    }
    
    public int getId(){
        return id;
    }
    
    public String getTitel(){
        return titel;
    }
    
    public String getGenre(){
        return genre;
    }
    
    public String getRegissör(){
        return regissör;
    }
    
    public String getBetyg(){
        return betyg;
    }
    
    public String getLängd(){
        return längd;
    }
    
}