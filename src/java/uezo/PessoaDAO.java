/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uezo;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class PessoaDAO {
    public Connection getCon() throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Cadastro","cadastro","cadastro");
    }
    public ArrayList<Pessoa> findAll() throws ClassNotFoundException, SQLException{
        Connection cn = this.getCon();
        Statement s = cn.createStatement();
        ResultSet rs = s.executeQuery("select * from pessoa");
        ArrayList<Pessoa> lista = new ArrayList<>();
        while(rs.next()){
            lista.add(new Pessoa(rs.getInt("id"),rs.getString("nome"),rs.getString("telefone"),rs.getString("email")));            
        }
        cn.close();
        return lista;
    }
    public void create(Pessoa p) throws ClassNotFoundException, SQLException{
        Connection cn = this.getCon();
        PreparedStatement ps = cn.prepareStatement("insert into pessoa values (?,?,?,?)");
        ps.setInt(1, p.getId());
        ps.setString(2, p.getNome());
        ps.setString(3, p.getTelefone());
        ps.setString(4, p.getEmail());
        ps.executeUpdate();
        cn.close();
    }
    public void delete(int id) throws ClassNotFoundException, SQLException{
        Connection cn = this.getCon();
        PreparedStatement ps = cn.prepareStatement("delete from pessoa where id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        cn.close();
    }
    public void update(String nome,String telefone,String email,int id) throws ClassNotFoundException, SQLException{
        Connection cn = this.getCon();
        PreparedStatement ps = cn.prepareStatement("update pessoa set nome = ?,telefone = ?,email = ? where id = ?");
        ps.setString(1, nome);
        ps.setString(2, telefone);
        ps.setString(3, email);
        ps.setInt(4, id);
        ps.executeUpdate();
        cn.close();
    }
    public Pessoa findById(int id) throws ClassNotFoundException, SQLException{
        Connection cn = this.getCon();
        Statement s = cn.createStatement();
        ResultSet rs = s.executeQuery("select * from pessoa where id = "+id);
        Pessoa p = null;
        while(rs.next()){
             p= new Pessoa(rs.getInt("id"),rs.getString("nome"),rs.getString("telefone"),rs.getString("email"));
        }
        cn.close();
        return p;
    }
}
