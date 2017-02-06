package br.com.verity.livro.web.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	String doGet(HttpServletRequest req, HttpServletResponse resp) throws Exception;

	void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
