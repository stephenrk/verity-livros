package br.com.verity.livro.business;

import java.util.List;

import br.com.verity.livro.bean.LivroBean;
import br.com.verity.livro.dao.LivroDao;

public class LivroBusiness {
	public List<LivroBean> getListar() {
		return new LivroDao().getListar();
	}
	
	public LivroBean getLivroById(int id) {
		return new LivroDao().getLivroById(id);
	}
	
	public void adicionar(LivroBean livro) {
		new LivroDao().adicionar(livro);
	}
	
	public void remover(LivroBean livro) {
		new LivroDao().remover(livro);
	}
	
	public void atualizar(LivroBean livro) {
		new LivroDao().alterar(livro);;
	}
}
