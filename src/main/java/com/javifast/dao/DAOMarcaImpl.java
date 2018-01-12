package com.javifast.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javifast.beans.Camiseta;
import com.javifast.beans.Equipo;
import com.javifast.beans.Jugador;
import com.javifast.beans.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository // se marca la implementacion como repositorio para llevar un orden de las capas
public class DAOMarcaImpl implements DAOMarca{

	@Autowired //agregamos la anotacion para que se implemente la conexion definida en nuestro beans.xlm de forma automatica
	private DataSource dataSource; // los parametros de conexion son llamados por el objeto DataSource del archivo beans.xml
	
	@Override
	public boolean agregar(Marca marca) throws Exception { // en esta capa se realizara la logica de inyeccion de datos
		String sql = "INSERT INTO marca(id,nombre) values(?,?)";
		boolean estado = false;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, marca.getId());
			ps.setString(2, marca.getNombre());
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
	public List<Marca> consultar(int id) throws Exception {
		String sqlId = "SELECT * FROM marca where id = ?;";
		String sqlAll = "SELECT * FROM marca;";
		Connection con = null;
        List<Marca> lista = null;
        try {
        	con = dataSource.getConnection();
        	PreparedStatement ps = null;
        	if(id==0) {
        	ps = con.prepareStatement(sqlAll);	
        	}else {
            ps = con.prepareStatement(sqlId);
            ps.setInt(1, id);
        	}
            lista = new ArrayList<Marca>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Marca ma = new Marca();
                ma.setId(rs.getInt("id"));
                ma.setNombre(rs.getString("nombre"));
                
                lista.add(ma);
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
	
	@Override
	public boolean eliminar(Marca marca) throws Exception {
		boolean estado = false;
		String sql = "DELETE FROM marca WHERE id = ?;";
		Connection con = null;
		try {
		con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, marca.getId());
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
	public boolean modificar(Marca marca) throws Exception {
		boolean estado = false;
		String sql = "UPDATE marca set nombre = ? WHERE id = ?";
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, marca.getNombre());
			ps.setInt(2, marca.getId());
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

}
