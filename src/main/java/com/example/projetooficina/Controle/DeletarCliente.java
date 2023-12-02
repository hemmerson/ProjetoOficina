package com.example.projetooficina.Controle;

import com.example.projetooficina.DAO.Classe.ClienteDaoClasse;
import com.example.projetooficina.DAO.ErroDAO;
import com.example.projetooficina.Modelo.Usuario;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 02/12/2023
 */
@WebServlet(name = "deletarcliente", urlPatterns = {"/deletarcliente"})
public class DeletarCliente extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Integer id = Integer.parseInt(request.getParameter("id"));

        if (id != null ){
            Usuario usuarioSessao = (Usuario) request.getSession().getAttribute("usuario");
            if (usuarioSessao != null){
                try{
                    ClienteDaoClasse dao = new ClienteDaoClasse();
                    dao.deletar(id);
                    dao.sair();
                    response.sendRedirect("index.jsp?mensagem=sucessodeletarcliente");
                } catch (ErroDAO e) {
                    response.sendRedirect("index.jsp?mensagem=erroaotentardeletarcliente");
                }
            }
            else {
                response.sendRedirect("index.jsp?mensagem=erroaotentardeletarcliente");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=erroaotentardeletarcliente");
        }
    }
}