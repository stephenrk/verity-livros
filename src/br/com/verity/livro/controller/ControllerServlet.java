package br.com.verity.livro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.verity.livro.web.interfaces.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametro = request.getParameter("logica");
		String nomeDaClasse= "br.com.verity.livro.controller." + parametro;
		
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.doGet(request, response);
			
			request.getRequestDispatcher(pagina).forward(request, response);
		} catch (Exception e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeDaClasse= "br.com.verity.livro.controller.ListaLivrosController";
		
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			
			Logica logica = (Logica) classe.newInstance();
			logica.doPost(request, response);
			
			request.getRequestDispatcher("WEB-INF/paginas/lista-livros.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}
}
