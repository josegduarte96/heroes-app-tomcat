/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author joseg
 */
public interface Model {
    /**
     * Devuelve una lista de heroes existentes
     * @return 
     */
    public List<Heroe> getHeroes();
    
    /**
     * Retorna un heroe por ID
     * @param id el id del heroe a retornar
     * @return El heroe encontrado por ID o null si no existe
     */
    public Heroe getHeroe(String id);
    
    /**
     * Agrega un heroe al modelo
     * @param heroe El heroe a agregar
     * @return La cantidad de registros modificados
     */
    public int addHeroe(Heroe heroe);
    
    /**
     * Modifica un heroe del modelo
     * @param heroe El heroe que contiene los datos para modificar
     * @return La cantidad de registros modificados
     */
    public int updateHeroe(Heroe heroe);
    
    /**
     * Borra un heroe por ID
     * @param id el id del heroe a borrar
     * @return La cantidad de registros modificados
     */
    public int removeHeroe(String id);
    
    /**
     * Obtiene la lista de heroes disponibles para agg a la web
     * @return La cantidad de heroes que no se han agregado
     */
    public List<String> getListadoDisponible();
    
    /**
     * Actualiza la lista de heroes disponible para agregar
     * @param id el id del heroe que se agrego
     */
    public void updateListadoHeroes(String id);
}
