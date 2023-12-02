package com.example.projetooficina.Controle;

import com.example.projetooficina.DAO.Classe.ClienteDaoClasse;
import com.example.projetooficina.DAO.ErroDAO;
import com.example.projetooficina.DAO.Interface.ClienteDaoInterface;
import com.example.projetooficina.Modelo.Cliente;
import com.example.projetooficina.Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 02/12/2023
 */
@WebServlet(name = "listarclientes", urlPatterns = {"/listarclientes"})
public class ListarClientes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try {
            Usuario usuarioSessao = (Usuario) request.getSession().getAttribute("usuario");
            if (usuarioSessao != null) {
                ClienteDaoInterface dao = new ClienteDaoClasse();
                List<Cliente> clientes = dao.buscar();
                request.setAttribute("clientes", clientes);
                dao.sair();
                request.getRequestDispatcher("WEB-INF/listaClientes.jsp").forward(request, response);
            } else {
                response.sendRedirect("index.jsp?mensagem=acessonegado");
            }
        } catch (ErroDAO e) {
            request.getRequestDispatcher("WEB-INF/listaPacientes.jsp?mensagem=erroaomostrar").forward(request, response);
        } catch (Exception e){
            response.sendRedirect("index.jsp?mensagem=acessonegado");
        }
    }
}
