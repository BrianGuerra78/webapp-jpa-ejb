package org.bguerra.apiserclet.webapp.headers.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.bguerra.apiserclet.webapp.headers.configs.Service;
import org.bguerra.apiserclet.webapp.headers.models.entities.Usuario;
import org.bguerra.apiserclet.webapp.headers.repositories.RepositoryJpa;
import org.bguerra.apiserclet.webapp.headers.repositories.UsuarioRepository;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Stateless
public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioServiceImpl(@RepositoryJpa UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username)).filter(u -> u.getPassword().equals(password));
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
