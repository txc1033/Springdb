package com.javifast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javifast.beans.Camiseta;
import com.javifast.beans.Equipo;
import com.javifast.beans.Jugador;

@Repository
public class DAOJugadorImpl implements DAOJugador {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public boolean agregar(Jugador jugador) throws Exception {
		boolean estado = false;
		String sql = "INSERT INTO jugador(id,nombre,idEquipo,idCamiseta) values(?,?,?,?)";
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, jugador.getId());
			ps.setString(2, jugador.getNombre());
			ps.setInt(3, jugador.getEquipo().getId());
			ps.setInt(4, jugador.getCamiseta().getId());
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
	public boolean modificar(Jugador jugador) throws Exception {
		boolean estado = false;
		String sql = "UPDATE jugador set nombre = ?, idEquipo = ?, idCamiseta = ? WHERE id = ?";
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, jugador.getNombre());
			ps.setInt(2, jugador.getEquipo().getId());
			ps.setInt(3, jugador.getCamiseta().getId());
			ps.setInt(4, jugador.getId());
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
	public List<Jugador> consultar(int id) throws Exception {
		String sqlId = "SELECT * FROM jugador where id = ?;";
		String sqlAll = "SELECT * FROM jugador;";
		Connection con = null;
        List<Jugador> lista = null;
        try {
        	con = dataSource.getConnection();
        	PreparedStatement ps = null;
        	if(id==0) {
        	ps = con.prepareStatement(sqlAll);	
        	}else {
            ps = con.prepareStatement(sqlId);
            ps.setInt(1, id);
        	}
            lista = new ArrayList<Jugador>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Jugador jugador = new Jugador();
                Equipo eq = new Equipo();
                Camiseta ca = new Camiseta();
                jugador.setId(rs.getInt("id"));
                jugador.setNombre(rs.getString("nombre"));
                jugador.setEquipo(eq);
                eq.setId(rs.getInt("idEquipo"));
                ca.setId(rs.getInt("idCamiseta"));
                jugador.setCamiseta(ca);
                
                lista.add(jugador);
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
	public boolean eliminar(Jugador jugador) throws Exception {
		boolean estado = false;
		String sql = "DELETE FROM jugador WHERE id = ?;";
		Connection con = null;
		try {
		con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, jugador.getId());
		ps.executeUpdate();
		estado = true;
		ps.close();
		}catch(Exception e) {
			throw e;
		}finally {
			
		}
		
		return estado;
	}

}
