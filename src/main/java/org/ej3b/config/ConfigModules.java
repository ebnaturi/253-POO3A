package org.ej3b.config;

import org.ej3b.controllers.MateriaController;
import org.ej3b.repositories.RepositoryMateria;
import org.ej3b.routers.MateriaRouter;
import org.ej3b.services.MateriaService;

public class ConfigModules {

    public static MateriaRouter initMateriaRouter() {
        RepositoryMateria rm = new RepositoryMateria();
        MateriaService ms = new MateriaService(rm);
        MateriaController mc = new MateriaController(ms);
        MateriaRouter mr = new MateriaRouter(mc);
        return mr;
    }
}
