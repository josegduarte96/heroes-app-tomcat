/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author joseg
 */
public class Heroe {
    private String id;
    private String superhero;
    private String publisher;
    private String alter_ego;
    private String first_appearance;
    private String characters;
    private String foto;
    
    public Heroe(String id){
        this.id = id;
        setFoto(id);
    }

    public Heroe(String id, String superhero, String publisher, String alter_ego, String first_appearance, String characters) {
        this.id = id;
        this.superhero = superhero;
        this.publisher = publisher;
        this.alter_ego = alter_ego;
        this.first_appearance = first_appearance;
        this.characters = characters;
        setFoto(id); // el id es el nombre de la foto
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        this.foto = this.id + ".jpg";
    }

    @Override
    public String toString() {
        return "Heroe{" + "id=" + id + ", superhero=" + superhero + ", publisher=" + publisher + ", alter_ego=" + alter_ego + ", first_appearance=" + first_appearance + ", characters=" + characters + ", foto=" + foto + '}';
    }

    
    
    
}
