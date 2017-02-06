package br.com.verity.livro.web.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Tarefa {
	String executa(HttpServletRequest request, HttpServletResponse response);
}
