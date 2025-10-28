package org.ej3b.routers;

import io.javalin.Javalin;
import org.ej3b.controllers.MateriaController;

public class MateriaRouter {

    private final MateriaController materiaController;

    public MateriaRouter(MateriaController materiaController) {
        this.materiaController = materiaController;
    }

    public void register(Javalin app) {
        app.get("/materias",materiaController::findAllMaterias);
        app.post("/materias",materiaController::savemateria);
        app.delete("/materias/{clave}",materiaController::deleteMateria);
        app.patch("/materias",materiaController::updatemateria);
        //app.post("/usuario",materiaController::testUser);
       // app.post("/login",materiaController::loginUser);
    }
}
