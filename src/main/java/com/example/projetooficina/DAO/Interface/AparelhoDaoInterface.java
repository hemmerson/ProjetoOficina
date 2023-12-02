package com.example.projetooficina.DAO.Interface;

import com.example.projetooficina.DAO.ErroDAO;
import com.example.projetooficina.Modelo.Aparelho;

import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 02/12/2023
 */
public interface AparelhoDaoInterface {
    public void inserir(Aparelho a) throws ErroDAO;
    public void editar(Aparelho a) throws ErroDAO;
    public void deletar(Aparelho a) throws ErroDAO;
    public void deletar(int codigo) throws ErroDAO;
    public Aparelho buscar(int id) throws ErroDAO;
    public ArrayList<Aparelho> buscar() throws ErroDAO;
    public void sair() throws ErroDAO;
}
