package org.ej3b;
import io.javalin.Javalin;
import org.ej3b.config.ConfigModules;
import org.ej3b.models.Estudiantes;
import org.ej3b.models.Materia;
import org.ej3b.repositories.RepositoryMateria;

import java.util.List;
import org.ej3b.repositories.RepositoryMateria;
import org.ej3b.models.Materia;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

      /*  TokenManager tokenManager = new TokenManager();
        AuthController authController = new AuthController(tokenManager);
        JwtMiddleware jwtMiddleware = new JwtMiddleware(tokenManager);*/
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Javalin app = Javalin.create(/*configuraciones*/)
                    .start(7000);


        ConfigModules.initMateriaRouter().register(app);
        ConfigModules.initUsuarios().register(app);
    }
}