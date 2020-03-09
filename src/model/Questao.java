package model;

public class Questao {
	private int codigo;
	private String descricao;
	private String a;
	private String b;
	private String c;
	private String d;
	private String e;
	
	public Questao(String descricao, String a, String b, String c, String d, String e) {
		this.descricao = descricao;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		
	}

	public Questao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getE() {
		return e;
	}

	public void setE(String e) {
		this.e = e;
	}
	
	
}
