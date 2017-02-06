package br.com.verity.livro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.verity.livro.bean.LivroBean;
import br.com.verity.livro.business.LivroBusiness;
import br.com.verity.livro.web.interfaces.Logica;

public class RemoverLivroController implements Logica {

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		int id= Integer.parseInt(req.getParameter("id"));
		
		LivroBean livro = new LivroBean();
		livro.setId(id);
		
		LivroBusiness business = new LivroBusiness();
		business.remover(livro);
		
		System.out.println("Excluindo livro...");
		
	}

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return null;
	}

}
