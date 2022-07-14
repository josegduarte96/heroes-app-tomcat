/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseg
 */
public class ModelMySQL implements Model {

    private final String GET_HEROES = "SELECT * FROM heroes";
    private final String GET_HEROE = "SELECT * FROM HEROES WHERE ID = ?";
    private final String INSERT_HEROE = "INSERT INTO heroes (`superhero`, `publisher`, `alter_ego`, `first_appearance`, `characters`, `foto`) VALUES (?,?,?,?,?,?)";
    private final String UPDATE_HEROE = "UPDATE heroes SET `superhero` = ?, `publisher` = ?, `alter_ego` = ?, `first_appearance` = ?, `characters` = ?, `foto` = ? where id = ?";
    private final String DELETE_HEROE = "DELETE FROM `HEROES` WHERE (`id` = ?);";
    private final String GET_BY_PUBLISHER = "SELECT * FROM HEROES WHERE PUBLISHER = ?";
    

    @Override
    public List<Heroe> getHeroes() {
        ArrayList<Heroe> heroes = new ArrayList<>();
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(GET_HEROES);  ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                heroes.add(rsToHeroe(rs));
            }
        } catch (Exception e) {
            throw new RuntimeException("No se pudieron obtener los heroes" + e);
        }
        return heroes;
    }
    
    public List<Heroe> getHeroesByPublisher(String publisher){
        ArrayList<Heroe> heroes = new ArrayList<>();
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(GET_BY_PUBLISHER);) {
            ps.setString(1, publisher);
            try(ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                heroes.add(rsToHeroe(rs));
            }
            } catch (Exception e) {
                throw new RuntimeException("Error al cargar heroes" + e);
            }
        } catch (Exception e) {
            throw new RuntimeException("No se pudieron obtener los heroes" + e);
        }
        return heroes;
    }
    @Override
    public Heroe getHeroe(int id) {
        Heroe h = null;
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(GET_HEROE);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                h = rsToHeroe(rs);
            }
            rs.close();
        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener el heroe: " + id + " " + e);
        }
        return h;
    }

    @Override
    public int addHeroe(Heroe heroe) {
        int id = 0;
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(INSERT_HEROE, Statement.RETURN_GENERATED_KEYS);) {
            heroeToStatement(ps, heroe);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
        } catch (Exception e) {
            throw new RuntimeException("No se pudo agregar el heroe" + e);
        }
        return id;
    }

    @Override
    public int updateHeroe(Heroe heroe) {
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(UPDATE_HEROE);) {
            heroeToStatement(ps, heroe);
            ps.setInt(7, heroe.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("No pudimos actualizar el heroe:" + heroe.getId() + " " + e);
        }
        return heroe.getId();
    }

    @Override
    public void removeHeroe(int id) {
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(DELETE_HEROE);) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("No pudimos eliminar el heroe con el id:" + id + " " + e);
        }
    }
    
    private Heroe rsToHeroe(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String superhero = rs.getString("superhero");
        String publisher = rs.getString("publisher");
        String alter_ego = rs.getString("alter_ego");
        String firstAppearance = rs.getString("first_appearance");
        String characters = rs.getString("characters");
        String urlFoto = rs.getString("foto");
        Heroe heroe = new Heroe(id, superhero, publisher, alter_ego, firstAppearance, characters, urlFoto);
        return heroe;
    }

    private void heroeToStatement(PreparedStatement ps, Heroe h) throws SQLException {
        ps.setString(1, h.getSuperhero());
        ps.setString(2, h.getPublisher());
        ps.setString(3, h.getAlter_ego());
        ps.setString(4, h.getFirst_appearance());
        ps.setString(5, h.getCharacters());
        ps.setString(6, h.getFoto());
    }

}
