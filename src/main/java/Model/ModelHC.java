/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseg
 */
public class ModelHC implements Model {

    private List<Heroe> listaHeroes;
    private List<String> heroesDispo;

    public ModelHC() {
        this.listaHeroes = new ArrayList<>();
        crearHeroes();
        this.heroesDispo = new ArrayList<>();
        listadoHeroesParaAgregar();
    }

    @Override
    public List<Heroe> getHeroes() {
        return new ArrayList(this.listaHeroes); // Copia de la lista original
    }
    
    @Override
    public List<String> getListadoDisponible(){
        return new ArrayList(this.heroesDispo);
    }

    @Override
    public Heroe getHeroe(String id) {
        int i = 0;
        Heroe encontrado = null;
        while (i < this.listaHeroes.size() && encontrado == null) {
            Heroe a = this.listaHeroes.get(i);
            if (a.getId().equals(id)) {
                encontrado = a;
            } else {
                i++;
            }
        }
        if (encontrado == null) {
            throw new RuntimeException("No se encontró heroe con ID " + id);
        }
        return encontrado;
    }

    @Override
    public int addHeroe(Heroe heroe) {        
        this.listaHeroes.add(heroe);
        updateListadoHeroes(heroe.getId());
        return 0;
    }

    @Override
    public int updateHeroe(Heroe heroe) {
        Heroe target = getHeroe(heroe.getId());
        int idx = this.listaHeroes.indexOf(target);
        this.listaHeroes.set(idx, heroe);
        
        return 0;
    }

    @Override
    public int removeHeroe(String id) {
        Heroe target = getHeroe(id);
        this.listaHeroes.remove(target);
        this.heroesDispo.add(id); // agrego de vuelta el heroe a la lista de heroesDispo
        return 0;
    }
    
    @Override
    public void updateListadoHeroes(String id){
        
        for(int count = 0; count < this.heroesDispo.size(); count++){
            if(id.equals(this.heroesDispo.get(count))){
                this.heroesDispo.remove(count);
            } 
        }
    }

    private void crearHeroes() {

        this.listaHeroes.add(new Heroe("dc-batman", "Batman", "DC Comics", "Bruce Wayne", "Detective Comics #27", "Bruce Wayne"));
        this.listaHeroes.add(new Heroe("dc-superman", "Superman", "DC Comics", "Kal-El", "Action Comics #1", "Kal-El"));
        this.listaHeroes.add(new Heroe("dc-flash", "Flash", "DC Comics", "Alan Scott", "All-American Comics #16", "Alan Scott, Hal Jordan, Guy Gardner, John Stewart, Kyle Raynor, Jade, Sinestro, Simon Baz"));
        this.listaHeroes.add(new Heroe("marvel-spider", "Spider-Man", "Marvel Comics", "Peter Parker", "Amazing Fantasy #15", "Peter Parker"));
    }
    
    private void listadoHeroesParaAgregar(){
        this.heroesDispo.add("dc-arrow");
        this.heroesDispo.add("dc-black");
        this.heroesDispo.add("dc-blue");
        this.heroesDispo.add("dc-flash");
        this.heroesDispo.add("dc-green");
        this.heroesDispo.add("dc-martian");
        this.heroesDispo.add("dc-robin");
        this.heroesDispo.add("dc-wonder");
        this.heroesDispo.add("marvel-captain");
        this.heroesDispo.add("marvel-cyclops");
        this.heroesDispo.add("marvel-daredevil");
        this.heroesDispo.add("marvel-hawkeye");
        this.heroesDispo.add("marvel-hulk");
        this.heroesDispo.add("marvel-iron");
        this.heroesDispo.add("marvel-silver");
        this.heroesDispo.add("marvel-thor");
        this.heroesDispo.add("marvel-wolverine");
    }
    
}
