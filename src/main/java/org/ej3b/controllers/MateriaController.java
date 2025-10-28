package org.ej3b.controllers;

import org.ej3b.models.Materia;
import org.ej3b.models.Usuarios;
import org.ej3b.services.MateriaService;

import java.util.List;

import io.javalin.http.Context;

import java.sql.SQLException;

import com.password4j.Password;

public class MateriaController {
    private final  MateriaService materiaService;

    public MateriaController(MateriaService ms){
        this.materiaService = ms;
    }
    public void findAllMaterias(Context ctx){
        try {
            List<Materia> materias = materiaService.findAll();
            ctx.json(materias);
        } catch (SQLException e) {
           ctx.status(500).result("hubo un error al buscar todas materias, siga intentado!!!");
        }

    }
    public void savemateria(Context ctx){
        //todo el codiggo para verificar que los datos estan correcto
        try{
            Materia materia =ctx.bodyAsClass(Materia.class);

            materiaService.save(materia);
            ctx.status(201).result("Materia se guardo con exito!");
        }catch (Exception e){
            //e.printStackTrace();
            ctx.status(500).result("error al guardar la materia");
        }
    }
    public void deleteMateria(Context ctx){
        try{
            String clave = ctx.pathParam("clave");
            materiaService.delete(clave);
            ctx.status(201).result("Materia se elimino con exito!");
        }catch (Exception e){
            ctx.status(500).result("error al eliminar la materia");
        }
    }

    public void updatemateria(Context ctx){
        //todo el codiggo para verificar que los datos estan correcto
        try{
            Materia materia =ctx.bodyAsClass(Materia.class);

            materiaService.update(materia);
            ctx.status(201).result("Materia se guardo con exito!");
        }catch (Exception e){
            //e.printStackTrace();
            ctx.status(500).result("error al guardar la materia");
        }
    }
    /*
    //esto no se debe de hacer solo es para prueba
    public void testUser(Context ctx){
        Usuarios ur = ctx.bodyAsClass(Usuarios.class);

        String hasPass = Password.hash(ur.getPass()).withBcrypt().getResult();
        System.out.println("EL usuario :" + ur.getUser()+" tiene el hash "+hasPass);
    }

    public void loginUser(Context ctx){
        UsuarioRegistro ur = ctx.bodyAsClass(UsuarioRegistro.class);
        try{
            UsuarioRegistro userfound = UsuarioService.findUser(ur);
            if(userfound == null){
                ctx.status(500).result("el usuario y contraseña no existe");
                throw new SQLException("usuario no existe");
            }

        } catch (SQLException e) {
            ctx.status(500).result("el usuario y contraseña no existe");
        }

        boolean rs = Password.check(ur.getPass(), userfound.getPass()).withBcrypt();
        if(rs)
            ctx.status(201).result("Bienvenido "+ur.getUser());
            /// generar todo el mecanismo para obtener un token
        else
            ctx.status(500).result("contraseña incorrecta");

    }

    public void registerUser(Context ctx){
        try{
            UsuarioRegistro ur = ctx.bodyAsClass(UsuarioRegistro.class);
            String hasPass = Password.hash(ur.getPass()).withBcrypt().getResult();
            ur.setPass(hasPass);
            usuarioService.save(ur);
            ctx.status(201).result("Usuario se guardo con exito!");
        } catch (Exception e) {
            ctx.status(500).result("Error al guargar el usuario");
        }

   }*/
}
