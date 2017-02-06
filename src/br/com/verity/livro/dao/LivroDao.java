package br.com.verity.livro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.verity.livro.bean.LivroBean;
import br.com.verity.livro.connection.ConnectionFactory;

public class LivroDao {

	private Connection connection;

	public LivroDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public LivroBean getLivroById(int id) {
		try {
			String sql = "select * from livros where id = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			LivroBean livro = new LivroBean();
			
			while(rs.next()) {
				livro.setId(rs.getInt("id"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setQtdPaginas(rs.getInt("qtdPaginas"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataPublicacao"));
				livro.setDataPublicacao(data);
			}
			
			rs.close();
			stmt.close();
			
			return livro;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<LivroBean> getListar() {
		try {
			List<LivroBean> livros = new ArrayList<LivroBean>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from livros");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				LivroBean livro = new LivroBean();
				livro.setId(rs.getInt("id"));
				livro.setTitulo(rs.getString("titulo"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataPublicacao"));
				livro.setDataPublicacao(data);
				livro.setQtdPaginas(rs.getInt("qtdPaginas"));
				
				livros.add(livro);
			}
			
			rs.close();
			stmt.close();
			return livros;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(LivroBean livro) {
		String sql = "update livros set titulo=?, dataPublicacao=?, qtdPaginas=?" +
				" where id=?";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, livro.getTitulo());
			stmt.setDate(2, new Date(livro.getDataPublicacao().getTimeInMillis()));
			stmt.setInt(3, livro.getQtdPaginas());
			stmt.setInt(4, livro.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adicionar(LivroBean livro) {
		String sql = "insert into livros" + 
				"(titulo,dataPublicacao,qtdPaginas)" + 
				" values(?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, livro.getTitulo());
			stmt.setDate(2, new Date(livro.getDataPublicacao().getTimeInMillis()));
			stmt.setInt(3, livro.getQtdPaginas());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void remover(LivroBean livro) {
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("delete from livros where id=?");
			stmt.setLong(1, livro.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
