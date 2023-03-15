package org.bguerra.apiserclet.webapp.headers.controlers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bguerra.apiserclet.webapp.headers.configs.ProductoServicePrincipal;
import org.bguerra.apiserclet.webapp.headers.models.entities.Producto;
import org.bguerra.apiserclet.webapp.headers.services.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {
    @Inject
    //@Named("defecto")
    @ProductoServicePrincipal
    private ProductoService service;

    @Inject
    private LoginService auth;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Producto> productos = service.listar();

        Optional<String> usernameOptional = auth.getUsername(req);

        req.setAttribute("productos", productos);
        req.setAttribute("username", usernameOptional);
        req.setAttribute("title", req.getAttribute("title") + ": Listado de productos");
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}
