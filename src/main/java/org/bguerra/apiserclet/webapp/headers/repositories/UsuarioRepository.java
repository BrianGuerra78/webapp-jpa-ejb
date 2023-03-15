package org.bguerra.apiserclet.webapp.headers.repositories;

import org.bguerra.apiserclet.webapp.headers.models.entities.Usuario;

import java.sql.SQLException;

public interface UsuarioRepository extends CrudRepository<Usuario> {
    Usuario porUsername(String username) throws Exception;
}
