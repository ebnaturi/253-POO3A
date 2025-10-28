package org.ej3b.controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class JwtMiddleware {
    private final TokenManager tokenManager;

    public JwtMiddleware(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    public void apply(Javalin app) {
        app.before("/api/protected/*", this::validateJwt);
    }

    private void validateJwt(Context ctx) {
        String authHeader = ctx.header("Authorization");
        String userId = ctx.header("User-Id");

        // Verificar que existan los headers
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            ctx.status(401).json(Map.of(
                    "error", "Authorization header faltante o malformado"
            ));
            return;
        }

        if (userId == null) {
            ctx.status(401).json(Map.of(
                    "error", "User-Id header requerido"
            ));
            return;
        }

        // Extraer el token
        String token = authHeader.substring(7);

        // Validar el token
        try {
            if (!tokenManager.validateToken(token, userId)) {
                ctx.status(403).json(Map.of(
                        "error", "Token inválido o expirado"
                ));
            }
            // Token válido - la solicitud continúa
        } catch (Exception e) {
            ctx.status(401).json(Map.of(
                    "error", "Error al validar el token"
            ));
        }
    }
}
