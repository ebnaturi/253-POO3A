package org.ej3b.routers;

import io.javalin.Javalin;
import io.javalin.http.UnauthorizedResponse;
import org.ej3b.controllers.JwtMiddleware;
import org.ej3b.controllers.UsuarioController;

public class UsuarioRouter {
    private final UsuarioController usuarioController;
    private final JwtMiddleware jwtMiddleware;
    public UsuarioRouter(UsuarioController controllerAlumno, JwtMiddleware jwtMiddleware){
        this.usuarioController = controllerAlumno;
        this.jwtMiddleware = jwtMiddleware;
    }

    public void register(Javalin app){
        app.post("/signup",usuarioController::registrarUsuario);
        app.post("/login",usuarioController::verificarUsuario);
        jwtMiddleware.apply(app);
        /* tipos de errrores de autorizacion
        UnauthorizedResponse (401)
        ForbiddenResponse (403)
        BadRequestResponse (400)
        NotFoundResponse (404)
        ConflictResponse (409)
        InternalServerErrorResponse (500)
         */
        app.exception(UnauthorizedResponse.class, jwtMiddleware::noAutorizo);
    }
}