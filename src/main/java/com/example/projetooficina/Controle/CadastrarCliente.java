package com.example.projetooficina.Controle;

import com.example.projetooficina.DAO.Classe.ClienteDaoClasse;
import com.example.projetooficina.DAO.ErroDAO;
import com.example.projetooficina.Modelo.Cliente;
import com.example.projetooficina.Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 02/12/2023
 */
@WebServlet(name = "cadastrarcliente", urlPatterns = {"/cadastrarcliente"})
public class CadastrarCliente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String complemento = request.getParameter("complemento");
        int numero = Integer.parseInt(request.getParameter("numero"));

        if (nome != null && telefone != null && nome.length()>0 && telefone.length() > 0){
            Usuario usuarioSessao = (Usuario) request.getSession().getAttribute("usuario");
            if (usuarioSessao != null){
                try{
                    Cliente c = new Cliente(nome, telefone, endereco, bairro, cidade, estado, complemento, numero);
                    ClienteDaoClasse dao = new ClienteDaoClasse();
                    dao.inserir(c);
                    dao.sair();
                    response.sendRedirect("index.jsp?mensagem=sucessocadastrarcliente");
                } catch (ErroDAO e) {
                    response.sendRedirect("index.jsp?mensagem=erroaotentarcadastrarcliente");
                }
            }
            else {
                response.sendRedirect("index.jsp?mensagem=erroaotentarcadastrarcliente");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=erroaotentarcadastrarcliente");
        }
    }
}
