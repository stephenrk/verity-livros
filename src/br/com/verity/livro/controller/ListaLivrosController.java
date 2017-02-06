package br.com.verity.livro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.verity.livro.bean.LivroBean;
import br.com.verity.livro.business.LivroBusiness;
import br.com.verity.livro.web.interfaces.Logica;

public class ListaLivrosController implements Logica {

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		List<LivroBean> livros = new LivroBusiness().getListar();
		int total = livros.size();
		String logica = "ListaLivrosController";
		
		req.setAttribute("livros", livros);
		req.setAttribute("logica", logica);
		req.setAttribute("total", total);
		
		System.out.println("Listando livros...");
		
		return "/WEB-INF/paginas/lista-livros.jsp";
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
	}

}
