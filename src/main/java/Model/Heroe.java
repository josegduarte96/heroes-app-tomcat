/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.File;

/**
 *
 * @author joseg
 */
public class Heroe {
    private int id;
    private String superhero;
    private String publisher;
    private String alter_ego;
    private String first_appearance;
    private String characters;
    private String foto;
    
    public Heroe(int id){
        this.id = id;
    }

    public Heroe() {
    }   

    public Heroe(int id, String superhero, String publisher, String alter_ego, String first_appearance, String characters, String foto) {
        this.id = id;
        this.superhero = superhero;
        this.publisher = publisher;
        this.alter_ego = alter_ego;
        this.first_appearance = first_appearance;
        this.characters = characters;
        setFoto(foto);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getSuperhero() {
        return superhero;
    }

    public void setSuperhero(String superhero) {
        this.superhero = superhero;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAlter_ego() {
        return alter_ego;
    }

    public void setAlter_ego(String alter_ego) {
        this.alter_ego = alter_ego;
    }

    public String getFirst_appearance() {
        return first_appearance;
    }

    public void setFirst_appearance(String first_appearance) {
        this.first_appearance = first_appearance;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {        
         if (foto == null || foto.trim().isEmpty()) {
            foto = "assets/nopicture.jpg";
        }
        if (!foto.contains("nopicture") || this.foto == null || this.foto.contains("nopicture")) {
            this.foto = foto.trim();
        }
    }

    @Override
    public String toString() {
        return "Heroe{" + "id=" + id + ", superhero=" + superhero + ", publisher=" + publisher + ", alter_ego=" + alter_ego + ", first_appearance=" + first_appearance + ", characters=" + characters + ", foto=" + foto + '}';
    }

    
    
    
}
