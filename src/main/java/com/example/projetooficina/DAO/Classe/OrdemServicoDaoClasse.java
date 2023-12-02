package com.example.projetooficina.DAO.Classe;

import com.example.projetooficina.DAO.ErroDAO;
import com.example.projetooficina.DAO.FabricaConexao;
import com.example.projetooficina.DAO.Interface.OrdemServicoDaoInterface;
import com.example.projetooficina.Modelo.Aparelho;
import com.example.projetooficina.Modelo.Cliente;
import com.example.projetooficina.Modelo.OrdemServico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 02/12/2023
 */
public class OrdemServicoDaoClasse implements OrdemServicoDaoInterface {

    private Connection con;

    public OrdemServicoDaoClasse() throws ErroDAO {
        con = FabricaConexao.pegaConexao();
    }

    @Override
    public void inserir(OrdemServico os) throws ErroDAO {
        String sql = "insert into order_servico (data_entrada, data_saida, valor_total, observacao, cliente_idCliente, aparelho_idaparelho) values (?,?,?,?,?,?)";
        try (PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, os.getDataEntrada().toString());
            pstm.setString(2, os.getDataSaida().toString());
            pstm.setDouble(3, os.getValorTotal());
            pstm.setString(4, os.getObservacao());
            pstm.setInt(5, os.getcLiente().getId());
            pstm.setInt(6, os.getAparelho().getId());
            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                os.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void editar(OrdemServico os) throws ErroDAO {
        String sql = "update order_servico set data_entrada=?, data_saida=?, valor_total=?, observacao=?, cliente_idCliente=?, aparelho_idaparelho=? where idorder_servico = ?;";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, os.getDataEntrada().toString());
            pstm.setString(2, os.getDataSaida().toString());
            pstm.setDouble(3, os.getValorTotal());
            pstm.setString(4, os.getObservacao());
            pstm.setInt(5, os.getcLiente().getId());
            pstm.setInt(6, os.getAparelho().getId());
            pstm.setInt(7, os.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void deletar(OrdemServico os) throws ErroDAO {
        deletar(os.getId());
    }

    @Override
    public void deletar(int codigo) throws ErroDAO {
        String sql = "delete from order_servico where idorder_servico=?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, codigo);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public OrdemServico buscar(int id) throws ErroDAO {
        OrdemServico os = null;
        Cliente c = null;
        Aparelho a;
        String sql = "select * from order_servico where idorder_servico = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                os = new OrdemServico();
                c = new Cliente();
                a = new Aparelho();
                ClienteDaoClasse daoCliente = new ClienteDaoClasse();
                AparelhoDaoClasse daoAparelho = new AparelhoDaoClasse();
                os.setId(rs.getInt(1));
                os.setDataEntrada(LocalDate.parse(rs.getString(2), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                os.setDataSaida(LocalDate.parse(rs.getString(3), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                os.setValorTotal(rs.getDouble(4));
                c = daoCliente.buscar(rs.getInt(5));
                a = daoAparelho.buscar(rs.getInt(6));
                os.setcLiente(c);
                os.setAparelho(a);
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return os;
    }

    @Override
    public ArrayList<OrdemServico> buscar() throws ErroDAO {
        ArrayList<OrdemServico> ordemServicos = new ArrayList<>();
        String sql = "select * from cliente";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                OrdemServico os = new OrdemServico();
                Cliente c;
                Aparelho a;
                ClienteDaoClasse daoCliente = new ClienteDaoClasse();
                AparelhoDaoClasse daoAparelho = new AparelhoDaoClasse();
                os.setId(rs.getInt(1));
                os.setDataEntrada(LocalDate.parse(rs.getString(2), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                os.setDataSaida(LocalDate.parse(rs.getString(3), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                os.setValorTotal(rs.getDouble(4));
                c = daoCliente.buscar(rs.getInt(5));
                a = daoAparelho.buscar(rs.getInt(6));
                os.setcLiente(c);
                os.setAparelho(a);
                ordemServicos.add(os);
            }
            rs.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
        return ordemServicos;
    }

    @Override
    public void sair() throws ErroDAO {

    }
}
