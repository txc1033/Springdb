package com.javifast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javifast.beans.Camiseta;
import com.javifast.beans.Marca;

@Repository
public class DAOCamisetaImpl implements DAOCamiseta {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public boolean agregar(Camiseta camiseta) throws Exception {
		String sql = "INSERT INTO camiseta(id,numero,idMarca) values(?,?,?)";
		boolean estado = false;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, camiseta.getId());
			ps.setString(2, camiseta.getNumero());
			ps.setInt(3, camiseta.getMarca().getId());
			ps.executeUpdate();
			estado = true;
			ps.close();
		}catch(Exception e) {
			throw e;
		}finally {
			if (con !=null) {
				con.close();
			}
		}
		return estado;
	}

	@Override
	public boolean eliminar(Camiseta camiseta) throws Exception {
		boolean estado = false;
		String sql = "DELETE FROM equipo WHERE id = ?;";
		Connection con = null;
		try {
		con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, camiseta.getId());
		ps.executeUpdate();
		estado = true;
		ps.close();
		}catch(Exception e) {
			throw e;
		}finally {
			
		}
		
		return estado;
	}

	@Override
	public boolean modificar(Camiseta camiseta) throws Exception {
		boolean estado = false;
		String sql = "UPDATE equipo set numero = ?, idMarca = ? WHERE id = ?";
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, camiseta.getNumero());
			ps.setInt(2, camiseta.getMarca().getId());
			ps.setInt(3, camiseta.getId());
			ps.executeUpdate();
			estado = true;
			ps.close();
		}catch(Exception e) {
			throw e;
		}finally{
			if (con !=null) {
				con.close();
			}
		}
		return estado;
	}

	@Override
	public List<Camiseta> consultar(int id) throws Exception {
		String sqlId = "SELECT * FROM camiseta where id = ?;";
		String sqlAll = "SELECT * FROM camiseta;";
		Connection con = null;
        List<Camiseta> lista = null;
        try {
        	con = dataSource.getConnection();
        	PreparedStatement ps = null;
        	if(id==0) {
        	ps = con.prepareStatement(sqlAll);	
        	}else {
            ps = con.prepareStatement(sqlId);
            ps.setInt(1, id);
        	}
            lista = new ArrayList<Camiseta>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Camiseta ca = new Camiseta();
                Marca ma = new Marca();
                ca.setId(rs.getInt("id"));
                ca.setNumero(rs.getString("numero"));
                ma.setId(rs.getInt("idMarca"));
                ca.setMarca(ma);
                lista.add(ca);
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            throw e;
        } finally {
        	if (con !=null) {
				con.close();
			}
        }
        return lista;
	}

}
