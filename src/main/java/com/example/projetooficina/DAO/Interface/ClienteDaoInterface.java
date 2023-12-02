package com.example.projetooficina.DAO.Interface;

import com.example.projetooficina.DAO.ErroDAO;
import com.example.projetooficina.Modelo.Cliente;

import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 02/12/2023
 */
public interface ClienteDaoInterface {
    public void inserir(Cliente c) throws ErroDAO;
    public void editar(Cliente c) throws ErroDAO;
    public void deletar(Cliente c) throws ErroDAO;
    public void deletar(int codigo) throws ErroDAO;
    public Cliente buscar(int id) throws ErroDAO;
    public ArrayList<Cliente> buscar() throws ErroDAO;
    public void sair() throws ErroDAO;
}
