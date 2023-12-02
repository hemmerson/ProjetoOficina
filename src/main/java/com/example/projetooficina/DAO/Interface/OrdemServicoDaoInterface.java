package com.example.projetooficina.DAO.Interface;

import com.example.projetooficina.DAO.ErroDAO;
import com.example.projetooficina.Modelo.OrdemServico;

import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 02/12/2023
 */
public interface OrdemServicoDaoInterface {
    public void inserir(OrdemServico os) throws ErroDAO;
    public void editar(OrdemServico os) throws ErroDAO;
    public void deletar(OrdemServico os) throws ErroDAO;
    public void deletar(int codigo) throws ErroDAO;
    public OrdemServico buscar(int id) throws ErroDAO;
    public ArrayList<OrdemServico> buscar() throws ErroDAO;
    public void sair() throws ErroDAO;
}
