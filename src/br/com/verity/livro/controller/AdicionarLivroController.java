package br.com.verity.livro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.verity.livro.bean.LivroBean;
import br.com.verity.livro.business.LivroBusiness;
import br.com.verity.livro.web.interfaces.Logica;

public class AdicionarLivroController implements Logica {

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) {
		
		String title = "ADICIONAR LIVRO";
		String action = "mvc?logica=AdicionarLivroController";
		
		request.setAttribute("title", title);
		request.setAttribute("action", action);
		
		return "/WEB-INF/paginas/adicionar-livro.jsp";
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		LivroBusiness business = new LivroBusiness();
		LivroBean livro = new LivroBean();
		
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
		
		livro.setTitulo(titulo);
		livro.setQtdPaginas(Integer.parseInt(qtdPaginas));
		livro.setDataPublicacao(dataPublicacao);	
		business.adicionar(livro);
		
	}
	
}
