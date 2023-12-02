package com.example.projetooficina.DAO.Interface;

import com.example.projetooficina.DAO.ErroDAO;
import com.example.projetooficina.Modelo.Servico;

import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 02/12/2023
 */
public interface ServicoDaoInterface {
    public void inserir(Servico s) throws ErroDAO;
    public void editar(Servico s) throws ErroDAO;
    public void deletar(Servico s) throws ErroDAO;
    public void deletar(int codigo) throws ErroDAO;
    public Servico buscar(int id) throws ErroDAO;
    public ArrayList<Servico> buscar() throws ErroDAO;
    public void sair() throws ErroDAO;
}
