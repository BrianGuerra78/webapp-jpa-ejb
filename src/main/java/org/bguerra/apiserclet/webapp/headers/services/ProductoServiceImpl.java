package org.bguerra.apiserclet.webapp.headers.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.bguerra.apiserclet.webapp.headers.configs.ProductoServicePrincipal;
import org.bguerra.apiserclet.webapp.headers.configs.Service;
import org.bguerra.apiserclet.webapp.headers.models.entities.Categoria;
import org.bguerra.apiserclet.webapp.headers.models.entities.Producto;
import org.bguerra.apiserclet.webapp.headers.repositories.CrudRepository;
import org.bguerra.apiserclet.webapp.headers.repositories.RepositoryJpa;

import java.util.List;
import java.util.Optional;

@Service
@ProductoServicePrincipal
@Stateless
public class ProductoServiceImpl implements ProductoService {

    @Inject
    @RepositoryJpa
    private CrudRepository<Producto> repositoryJdbc;
    @Inject
    @RepositoryJpa
    private CrudRepository<Categoria> repositoryCategoriaJdbc;

    @Override
    public List<Producto> listar() {
        try {
            return repositoryJdbc.listar();
        } catch (Exception throwables) {
            //throw new RuntimeException(e);
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.porId(id));
        } catch (Exception throwables) {
            //throw new RuntimeException(e);
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            repositoryJdbc.guardar(producto);
        } catch (Exception throwables) {
            //throw new RuntimeException(e);
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repositoryJdbc.eliminar(id);
        } catch (Exception throwables) {
            //throw new RuntimeException(e);
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public List<Categoria> listarCategoria() {
        try {
            return repositoryCategoriaJdbc.listar();
        } catch (Exception throwables) {
            //throw new RuntimeException(e);
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        try {
            return Optional.ofNullable(repositoryCategoriaJdbc.porId(id));
        } catch (Exception throwables) {
            //throw new RuntimeException(e);
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
