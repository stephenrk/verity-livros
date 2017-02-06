package br.com.verity.livro.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.verity.livro.bean.UsuarioBean;

public class UsuarioDao {

	private final static Map<String, UsuarioBean> USUARIOS = new HashMap<>();
	static {
		USUARIOS.put("stephenrknupfer@hotmail.com", new UsuarioBean("stephenrknupfer@hotmail.com","stiff123"));
		USUARIOS.put("rodrigo.turini@alura.com.br", new UsuarioBean("rodrigo.turini@alura.com.br","turini"));
	}

	public UsuarioBean buscaPorEmailESenha(String email, String senha) {
		if (!USUARIOS.containsKey(email))
			return null;

		UsuarioBean usuario = USUARIOS.get(email);
		if (usuario.getSenha().equals(senha))
			return usuario;
		
		return null;
	}

}
