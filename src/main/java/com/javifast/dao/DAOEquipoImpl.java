package com.javifast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javifast.beans.Equipo;
@Repository
public class DAOEquipoImpl implements DAOEquipo{

	@Autowired
	private DataSource dataSource;
	
	@Override
	public boolean agregar(Equipo equipo) throws Exception {
		String sql = "INSERT INTO equipo(id,nombre) values(?,?)";
		boolean estado = false;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, equipo.getId());
			ps.setString(2, equipo.getNombre());
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
	public boolean eliminar(Equipo equipo) throws Exception {
		boolean estado = false;
		String sql = "DELETE FROM equipo WHERE id = ?;";
		Connection con = null;
		try {
		con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, equipo.getId());
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
	public boolean modificar(Equipo equipo) throws Exception {
		boolean estado = false;
		String sql = "UPDATE equipo set nombre = ? WHERE id = ?";
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, equipo.getNombre());
			ps.setInt(2, equipo.getId());
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
	public List<Equipo> consultar(int id) throws Exception {
		String sqlId = "SELECT * FROM equipo where id = ?;";
		String sqlAll = "SELECT * FROM equipo;";
		Connection con = null;
        List<Equipo> lista = null;
        try {
        	con = dataSource.getConnection();
        	PreparedStatement ps = null;
        	if(id==0) {
        	ps = con.prepareStatement(sqlAll);	
        	}else {
            ps = con.prepareStatement(sqlId);
            ps.setInt(1, id);
        	}
            lista = new ArrayList<Equipo>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Equipo eq = new Equipo();
                eq.setId(rs.getInt("id"));
                eq.setNombre(rs.getString("nombre"));
                
                lista.add(eq);
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
