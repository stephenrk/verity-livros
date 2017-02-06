package br.com.verity.livro.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.verity.livro.bean.LivroBean;
import br.com.verity.livro.business.LivroBusiness;

@WebServlet("/lista")
public class ListaLivroServlet extends HttpServlet {
	private static final long serialVersionUID = -2868264357254972423L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LivroBusiness business = new LivroBusiness();
		
		List<LivroBean> livros = business.getListar();
		
		int totalRegistros = livros.size();
		
		request.setAttribute("livros", livros);
		request.setAttribute("totalRegistros", totalRegistros);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/paginas/lista-livros.jsp");
		
		rd.forward(request, response);
	}

}
