<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
    </head>
    <body>
        <%Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioEditar");%>
        <h1>Datos del usuario</h1>
        <form action="SvEditar" method="POST">
            <p><label>Dni: </label> <input type="text" name="dni" value="<%=usuario.getDni()%>"></p>
            <p><label>Nombre: </label> <input type="text" name="nombre" value="<%=usuario.getNombre()%>"></p>
            <p><label>Apellido: </label> <input type="text" name="apellido" value="<%=usuario.getApellido()%>"></p>
            <p><label>Teléfono: </label> <input type="text" name="telefono" value="<%=usuario.getTelefono()%>"></p>
            <button type="submit" >Enviar</button>
        </form>
    </body>
</html>
