package org.ej3b.config;

import org.ej3b.controllers.MateriaController;
import org.ej3b.repositories.RepositoryMateria;
import org.ej3b.repositories.RepositoryUsuario;
import org.ej3b.routers.MateriaRouter;
import org.ej3b.services.MateriaService;
import org.ej3b.services.UsuarioService;
import org.ej3b.controllers.TokenManager;
import org.ej3b.controllers.UsuarioController;
import org.ej3b.routers.UsuarioRouter;


public class ConfigModules {

    public static MateriaRouter initMateriaRouter() {
        RepositoryMateria rm = new RepositoryMateria();
        MateriaService ms = new MateriaService(rm);
        MateriaController mc = new MateriaController(ms);
        MateriaRouter mr = new MateriaRouter(mc);
        return mr;
    }
    public static UsuarioRouter initUsuarios(){
        RepositoryUsuario repositoryUsuario = new RepositoryUsuario();
        UsuarioService usuarioService = new UsuarioService(repositoryUsuario);
        TokenManager tokenManager = new TokenManager();
        UsuarioController usuarioController = new UsuarioController(usuarioService,tokenManager);
        UsuarioRouter usuarioRouter = new UsuarioRouter(usuarioController);
        return usuarioRouter;

    }
}
