package org.ej3b.repositories;

import  org.ej3b.models.Materia;
import org.ej3b.config.ConfigDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class RepositoryMateria {
    public List<Materia> findAll() throws SQLException {
        List<Materia> materias = new ArrayList<>();
        String sql="SELECT * FROM materia";

        try(
                Connection conn = ConfigDB.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ){
                while(rs.next()){
                    String clave = rs.getString("clave");
                    String nombre = rs.getString("nombre");
                    int creditos = rs.getInt("creditos");
                   Materia mat = new Materia(clave,nombre,creditos);
                    materias.add(mat);

                }
        }
        return materias;
    }
    public void save(Materia materia) throws SQLException {
        String sql = "INSERT INTO materia(clave,nombre,creditos) " +
                "VALUES(?,?,?)";
        try (
                Connection conn = ConfigDB.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, materia.getClave());
            stmt.setString(2, materia.getNombre());
            stmt.setInt(3, materia.getCreditos());

            stmt.executeUpdate();
        }
    }

    public void delete(String clave) throws SQLException {
            String sql ="DELETE FROM materia WHERE clave =? ";
            try(
                    Connection conn = ConfigDB.getDataSource().getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sql);
            ){
                stmt.setString(1, clave);
                stmt.executeUpdate();
            }

    }


    public void update(Materia materia) throws SQLException {
        String sql = "UPDATE materia SET " +
                "nombre =?, creditos=? WHERE clave=? ";
        try (
                Connection conn = ConfigDB.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {

            stmt.setString(1, materia.getNombre());
            stmt.setInt(2, materia.getCreditos());
            stmt.setString(3, materia.getClave());
            stmt.executeUpdate();
        }
    }
}


