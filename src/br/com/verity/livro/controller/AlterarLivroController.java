package br.com.verity.livro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.verity.livro.bean.LivroBean;
import br.com.verity.livro.business.LivroBusiness;
import br.com.verity.livro.web.interfaces.Logica;

public class AlterarLivroController implements Logica {
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		LivroBusiness business = new LivroBusiness();
		LivroBean livro = business.getLivroById(id);
		
		String action = "mvc?logica=AlterarLivroController";
		String title = "ALTERAR LIVRO";
		
		request.setAttribute("livro", livro);
		request.setAttribute("action", action);
		request.setAttribute("title", title);
				
		return "/WEB-INF/paginas/adicionar-livro.jsp";
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		LivroBean livro = new LivroBean();
		LivroBusiness business = new LivroBusiness();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String titulo = request.getParameter("titulo");
		String qtdPaginas = request.getParameter("qtdPaginas");
		String dataEmTexto = request.getParameter("dataPublicacao");
		Calendar dataPublicacao = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataPublicacao = Calendar.getInstance();
			dataPublicacao.setTime(date);
		} catch (ParseException e) {
			out.println("Erro de conversão da data");
		}
		
		livro.setId(id);
		livro.setTitulo(titulo);
		livro.setQtdPaginas(Integer.parseInt(qtdPaginas));
		livro.setDataPublicacao(dataPublicacao);	
		business.atualizar(livro);
		
	}

}
