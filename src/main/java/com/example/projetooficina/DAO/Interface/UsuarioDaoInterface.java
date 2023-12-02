package com.example.projetooficina.DAO.Interface;

import com.example.projetooficina.DAO.ErroDAO;
import com.example.projetooficina.Modelo.Usuario;

import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 02/12/2023
 */
public interface UsuarioDaoInterface {
    public void inserir(Usuario u) throws ErroDAO;
    public void editar(Usuario u) throws ErroDAO;
    public void deletar(Usuario u) throws ErroDAO;
    public void deletar(int codigo) throws ErroDAO;
    public Usuario buscar(int id) throws ErroDAO;
    public ArrayList<Usuario> buscar() throws ErroDAO;
    public void sair() throws ErroDAO;
}
