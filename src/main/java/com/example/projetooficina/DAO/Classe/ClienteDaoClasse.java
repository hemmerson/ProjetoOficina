package com.example.projetooficina.DAO.Classe;

import com.example.projetooficina.DAO.ErroDAO;
import com.example.projetooficina.DAO.FabricaConexao;
import com.example.projetooficina.DAO.Interface.ClienteDaoInterface;
import com.example.projetooficina.Modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 02/12/2023
 */
public class ClienteDaoClasse implements ClienteDaoInterface {

    private Connection con;
    public ClienteDaoClasse() throws ErroDAO {
        con = FabricaConexao.pegaConexao();
    }

    @Override
    public void inserir(Cliente c) throws ErroDAO {
        String sql = "insert into cliente (nome, telefone, endereco, bairro, cidade, estado, complemento, numero) values (?,?,?,?,?,?,?,?)";
        try (PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, c.getNome());
            pstm.setString(2, c.getTelefone());
            pstm.setString(3, c.getEndereco());
            pstm.setString(4, c.getBairro());
            pstm.setString(5, c.getCidade());
            pstm.setString(6, c.getEstado());
            pstm.setString(7, c.getComplemento());
            pstm.setInt(8, c.getNumero());
            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                c.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void editar(Cliente c) throws ErroDAO {
        String sql = "update cliente set nome=?, telefone=?, endereco=?, bairro=?, cidade=?, estado=?, complemento=?, numero=? where idCliente = ?;";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, c.getNome());
            pstm.setString(2, c.getTelefone());
            pstm.setString(3, c.getEndereco());
            pstm.setString(4, c.getBairro());
            pstm.setString(5, c.getCidade());
            pstm.setString(6, c.getEstado());
            pstm.setString(7, c.getComplemento());
            pstm.setInt(8, c.getNumero());
            pstm.setInt(9, c.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void deletar(Cliente c) throws ErroDAO {
        deletar(c.getId());
    }

    @Override
    public void deletar(int codigo) throws ErroDAO {
        String sql = "delete from cliente where idCliente=?";
        try (PreparedStatement pstm=con.prepareStatement(sql)){
            pstm.setInt(1, codigo);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public Cliente buscar(int id) throws ErroDAO {
        Cliente c = null;
        String sql = "select * from cliente where idCliente = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                c = new Cliente();
                c.setId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setTelefone(rs.getString(3));
                c.setEndereco(rs.getString(4));
                c.setBairro(rs.getString(5));
                c.setCidade(rs.getString(6));
                c.setEstado(rs.getString(7));
                c.setComplemento(rs.getString(8));
                c.setNumero(rs.getInt(9));
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return c;
    }

    @Override
    public ArrayList<Cliente> buscar() throws ErroDAO {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "select * from cliente";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setTelefone(rs.getString(3));
                cliente.setEndereco(rs.getString(4));
                cliente.setBairro(rs.getString(5));
                cliente.setCidade(rs.getString(6));
                cliente.setEstado(rs.getString(7));
                cliente.setComplemento(rs.getString(8));
                cliente.setNumero(rs.getInt(9));
                clientes.add(cliente);
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return clientes;
    }

    @Override
    public void sair() throws ErroDAO {

    }
}
