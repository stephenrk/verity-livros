package br.com.verity.livro.servlet;

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

@WebServlet("/alterar-livro")
public class AlterarLivroServlet extends HttpServlet {
	private static final long serialVersionUID = -419960058901250240L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		LivroBusiness business = new LivroBusiness();
		LivroBean livro = business.getLivroById(id);
		
		String action = "alterar-livro";
		String title = "ALTERAR LIVRO";
		
		request.setAttribute("livro", livro);
		request.setAttribute("action", action);
		request.setAttribute("title", title);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/paginas/adicionar-livro.jsp");
		
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			return;
		}
		
		livro.setId(id);
		livro.setTitulo(titulo);
		livro.setQtdPaginas(Integer.parseInt(qtdPaginas));
		livro.setDataPublicacao(dataPublicacao);	
		business.atualizar(livro);
		
		response.sendRedirect("/verity-livro");
	}
}
