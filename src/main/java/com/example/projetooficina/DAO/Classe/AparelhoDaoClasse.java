package com.example.projetooficina.DAO.Classe;

import com.example.projetooficina.DAO.ErroDAO;
import com.example.projetooficina.DAO.FabricaConexao;
import com.example.projetooficina.DAO.Interface.AparelhoDaoInterface;
import com.example.projetooficina.Modelo.Aparelho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 02/12/2023
 */
public class AparelhoDaoClasse implements AparelhoDaoInterface {

    private Connection con;
    public AparelhoDaoClasse() throws ErroDAO {
        con = FabricaConexao.pegaConexao();
    }

    @Override
    public void inserir(Aparelho a) throws ErroDAO {
        String sql = "insert into aparelho (nome, modelo, marca, numero_serie) values (?,?,?,?)";
        try (PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, a.getNome());
            pstm.setString(2, a.getModelo());
            pstm.setString(3, a.getMarca());
            pstm.setString(4, a.getNumeroSerie());
            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                a.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void editar(Aparelho a) throws ErroDAO {
        String sql = "update aparelho set nome=?, modelo=?, marca=?, numero_serie=? where idaparelho = ?;";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, a.getNome());
            pstm.setString(2, a.getModelo());
            pstm.setString(3, a.getMarca());
            pstm.setString(4, a.getNumeroSerie());
            pstm.setInt(5, a.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void deletar(Aparelho a) throws ErroDAO {
        deletar(a.getId());
    }

    @Override
    public void deletar(int codigo) throws ErroDAO {
        String sql = "delete from aparelho where idaparelho=?";
        try (PreparedStatement pstm=con.prepareStatement(sql)){
            pstm.setInt(1, codigo);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public Aparelho buscar(int id) throws ErroDAO {
        Aparelho a = null;
        String sql = "select * from aparelho where idaparelho = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                a = new Aparelho();
                a.setId(rs.getInt(1));
                a.setNome(rs.getString(2));
                a.setModelo(rs.getString(3));
                a.setMarca(rs.getString(4));
                a.setNumeroSerie(rs.getString(5));
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return a;
    }

    @Override
    public ArrayList<Aparelho> buscar() throws ErroDAO {
        ArrayList<Aparelho> aparelhos = new ArrayList<>();
        String sql = "select * from aparelho";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                Aparelho aparelho = new Aparelho();
                aparelho.setId(rs.getInt(1));
                aparelho.setNome(rs.getString(2));
                aparelho.setModelo(rs.getString(3));
                aparelho.setMarca(rs.getString(4));
                aparelho.setNumeroSerie(rs.getString(5));
                aparelhos.add(aparelho);
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return aparelhos;
    }

    @Override
    public void sair() throws ErroDAO {

    }
}
