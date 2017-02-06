package br.com.verity.livro.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.verity.livro.bean.LivroBean;
import br.com.verity.livro.business.LivroBusiness;

@WebServlet("/remover-livro")
public class RemoverLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//PrintWriter out = resp.getWriter();
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		LivroBean livro = new LivroBean();
		livro.setId(id);
		
		new LivroBusiness().remover(livro);
		
		resp.sendRedirect("/verity-livro");
		
		/*out.println("<html>");
		out.println("<body>");
		out.println("Livro " + livro.getId() + " removido com sucesso!");
		out.println("</body>");
		out.println("</html>");*/
	}

}
