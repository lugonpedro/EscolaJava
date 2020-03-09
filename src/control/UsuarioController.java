package control;

import model.Usuario;

public class UsuarioController {
	
	DatabaseController dc = new DatabaseController();
	
	public void criarUsuario(int nivel, String nome, String login, String senha, String cpf, String telefone, String email, String nasc) throws Exception {
		Usuario a = new Usuario(nivel, nome, login, senha, cpf, telefone, email, nasc);
		dc.inserirUsuario(a);
	}
	
	public void excluirUsuario(String user) throws Exception {
		dc.excluirUsuario(user);
		
	}
	
	public void editarUsuario(String user, String cpf, String nasc, String email, String tel) throws Exception {
		dc.atualizarUsuario(user, cpf, nasc, email, tel);
	}

	
}