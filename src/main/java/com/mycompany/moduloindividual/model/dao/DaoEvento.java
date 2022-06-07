package com.mycompany.moduloindividual.model.dao;

import com.mycompany.moduloindividual.model.been.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ConexaoDb;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class DaoEvento {

    private final Connection c;

    public DaoEvento() throws ClassNotFoundException, SQLException{
        this.c = new ConexaoDb().getConnection();
    }
    
    public Evento inserir(Evento eve) throws SQLException, ClassNotFoundException {
        String sql = "insert into eve_evento" + " (data, local, numero_pessoas, organizador, horario)" + " values (?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,eve.getData());
        stmt.setString(2,eve.getLocal());
        stmt.setInt(3,eve.getNumero_pessoas());
        stmt.setString(4,eve.getOrganizador());
        stmt.setString(5,eve.getHorario());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            eve.setId(id);
        }
        stmt.close();
        return eve;
    }
    
    public Evento alterar(Evento eve) throws SQLException{
        String sql = "UPDATE eve_evento SET data = ?, local = ?, numero_pessoas = ?, organizador = ?, horario = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,eve.getData());
        stmt.setString(2,eve.getLocal());
        stmt.setInt(3,eve.getNumero_pessoas());
        stmt.setString(4,eve.getOrganizador());
        stmt.setString(5,eve.getHorario());
        stmt.setInt(6, eve.getId());

        // executa
        stmt.execute();
        stmt.close();
        return eve;
    }
    
    public Evento buscar(Evento eve) throws SQLException{
        String sql = "select * from eve_evento WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setLong(1,eve.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Evento retorno = null;
            while (rs.next()) {      
            // criando o objeto Evento
                retorno = new Evento(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6)
                );
            // adiciona o eve à lista de eves
            }
            stmt.close();
        return retorno;
   }
   
   public List<Evento> listar(Evento eveEnt) throws SQLException{
         // eves: array armazena a lista de registros

        List<Evento> eves = new ArrayList<Evento>();
        
        String sql = "select * from eve_evento where local like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + eveEnt.getLocal()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Evento
            Evento eve = new Evento(
              rs.getInt(1),
              rs.getString(2),
              rs.getString(3),
              rs.getInt(4),
              rs.getString(5),
              rs.getString(6)
            );
            // adiciona o eve à lista de eves
            eves.add(eve);
        }
        
        rs.close();
        stmt.close();
        return eves;
        
    }
   
    public Evento excluir(Evento eve) throws SQLException{
        String sql = "delete from eve_evento WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setLong(1,eve.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return eve;
    }
    
}
