package org.ej3b.services;

import org.ej3b.models.Materia;
import org.ej3b.repositories.RepositoryMateria;

import java.sql.SQLException;
import java.util.List;

public class MateriaService {
    private final RepositoryMateria repositoryMateria;

    public MateriaService(RepositoryMateria rm){
        this.repositoryMateria = rm;
    }
    public List<Materia> findAll()throws SQLException {
        return repositoryMateria.findAll();
    }
    public void save(Materia materia)throws SQLException
    {
        //todo el codigo para verificar reglas de negocio
        repositoryMateria.save(materia);
    }

    public void delete(String clave)throws SQLException
    {
        //todo el codigo para verificar reglas de negocio
        repositoryMateria.delete(clave);
    }
    public void update(Materia materia)throws SQLException
    {
        //todo el codigo para verificar reglas de negocio
        repositoryMateria.update(materia);
    }
}
