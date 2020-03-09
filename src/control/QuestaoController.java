package control;

import model.Questao;

public class QuestaoController {

	public void criarQuestao(String descricao, String a, String b, String c, String d, String e) throws Exception {
		Questao q = new Questao(descricao, a, b, c, d, e);
		DatabaseController dc = new DatabaseController();
		dc.inserirQuestao(q);
	}
	
	public void desativarQuestao(Questao q) throws Exception {
		DatabaseController dc = new DatabaseController();
		dc.excluirQuestao(q);
		
	}
	
	public void editarQuestao(Questao q) throws Exception {
		DatabaseController dc = new DatabaseController();
		dc.atualizarQuestao(q);
		
	}
	
}