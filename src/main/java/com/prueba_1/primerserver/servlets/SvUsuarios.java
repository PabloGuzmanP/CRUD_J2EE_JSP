package com.prueba_1.primerserver.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;


@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {
Controladora control = new Controladora ();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios = control.traerUsuarios();
        
               
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaUsuarios", listaUsuarios);
        
        response.sendRedirect("mostrarUsuarios.jsp");
      
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
                      
        Usuario usu = new Usuario ();
        usu.setDni(dni);
        usu.setApellido(apellido);
        usu.setNombre(nombre);
        usu.setTelefono(telefono);
        
       control.crearUsuario(usu);
       
       response.sendRedirect("index.jsp");
    } 
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}