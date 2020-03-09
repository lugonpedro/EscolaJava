package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.Conexao;
import model.Questao;
import model.Usuario;

public class DatabaseController {
	
	public void inserirUsuario(Usuario a) throws Exception {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
			try {
			String query = "insert into user(nivel, nome, login, senha, cpf, telefone, email, nasc) values (?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, a.getNivel());
			stmt.setString(2, a.getNome());
			stmt.setString(3, a.getLogin());
			stmt.setString(4, a.getSenha());
			stmt.setString(5, a.getCpf());
			stmt.setString(6, a.getTelefone());
			stmt.setString(7, a.getEmail());
			stmt.setString(8, a.getNasc());
			stmt.executeUpdate();
		}finally{
			con.close();
		}
	}
	
	public void inserirQuestao(Questao q) throws Exception {
		Connection con = Conexao.conectar();
        PreparedStatement stmt = null;
        try {
        	String query = "INSERT INTO questao (codigo, descricao, A, B, C, D, E) VALUE (?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, q.getCodigo());
            stmt.setString(2, q.getDescricao());
            stmt.setString(3, q.getA());
            stmt.setString(4, q.getB());
            stmt.setString(5, q.getC());
            stmt.setString(6, q.getD());
            stmt.setString(7, q.getE());
            stmt.executeUpdate();
        }finally{
            con.close();
        }
	}

	public void atualizarUsuario(String user, String cpf, String nasc, String email, String tel) throws Exception {
		Connection con = Conexao.conectar();
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE user SET cpf = ? , nasc = ? , email = ? , telefone = ? WHERE nome = '"+user+"'");
            stmt.setString(1, cpf);
            stmt.setString(2, nasc);
            stmt.setString(3, email);
            stmt.setString(4, tel);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar" + ex);
        } finally {
            con.close();
        }
	}
	
	public void atualizarQuestao(Questao q) throws Exception {
		Connection con = Conexao.conectar();
        boolean retorno = false;
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE questao SET descricao = ? , A = ? , B = ? , C = ? , D = ? , E = ? , resultado = ? WHERE codigo = ? ");

            stmt.setString(1, q.getDescricao());
            stmt.setString(2, q.getA());
            stmt.setString(3, q.getB());
            stmt.setString(4, q.getC());
            stmt.setString(5, q.getD());
            stmt.setString(6, q.getE());
            stmt.setInt(7, q.getCodigo());

            Integer resultado = stmt.executeUpdate();
            if (resultado > 0) {
                retorno = true;
                JOptionPane.showMessageDialog(null, "Salvo");
            } else {
                retorno = false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex.getMessage().toLowerCase());
        } finally {
        	con.close();
        }
	}
	
	public List<String> listarAlunos() throws Exception {
		Connection con = Conexao.conectar();
		List<String> alunos = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM user WHERE nivel = '1'");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String q = new String(""+rs.getString(5));
				alunos.add(q);
			}
			}catch (SQLException ex) {
				alunos = null;
			} finally {
				con.close();
			}
		return alunos;
	}
	
	public List<String> listarProfs() throws Exception{
		Connection con = Conexao.conectar();
		List<String> profs = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM user WHERE nivel = '2'");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String q = new String(""+rs.getString(5));
				profs.add(q);
			}
			}catch (SQLException ex) {
				profs = null;
			} finally {
				con.close();
			}
		return profs;
	}
	
	public String listarCpf(String s) throws Exception {
		Connection con = Conexao.conectar();
		String query = "SELECT * FROM user WHERE nome = '"+s+"'";
		Statement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery(query);
		String q = "";
		try {
			if(rs.first() == true) {
			q += rs.getString(1);
			return q;
			}else {
				return "error";
			}
		}finally {
			con.close();
		}
	}
	
	public String listarTel(String s) throws Exception {
		Connection con = Conexao.conectar();
		String query = "SELECT * FROM user WHERE nome = '"+s+"'";
		Statement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery(query);
		String q = "";
		try {
			if(rs.first() == true) {
			q += rs.getString(8);
			return q;
			}else {
				return "error";
			}
		}finally {
			con.close();
		}
	}
	
	public String listarNasc(String s) throws Exception {
		Connection con = Conexao.conectar();
		String query = "SELECT * FROM user WHERE nome = '"+s+"'";
		Statement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery(query);
		String q = "";
		try {
			if(rs.first() == true) {
			q += rs.getString(6);
			return q;
			}else {
				return "error";
			}
		}finally {
			con.close();
		}
	}
	
	public String listarEmail(String s) throws Exception {
		Connection con = Conexao.conectar();
		String query = "SELECT * FROM user WHERE nome = '"+s+"'";
		Statement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery(query);
		String q = "";
		try {
			if(rs.first() == true) {
			q += rs.getString(7);
			return q;
			}else {
				return "error";
			}
		}finally {
			con.close();
		}
	}
	
	public List<String> listarQuestoes() throws Exception {
		Connection con = Conexao.conectar();
		List<String> questoes = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM questao");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String q = new String(""+rs.getInt(1));
				questoes.add(q);
			}
			}catch (SQLException ex) {
				questoes = null;
			} finally {
				con.close();
			}
		return questoes;
	}
	
	public List<String> listarPerguntas() throws Exception {
		Connection con = Conexao.conectar();
		List<String> perguntas = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM questao");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String q = new String(""+rs.getString(2));
				perguntas.add(q);
			}
			}catch (SQLException ex) {
				perguntas = null;
			} finally {
				con.close();
			}
		return perguntas;
	}
	
	public String listarQuestao(int s) throws Exception {
		Connection con = Conexao.conectar();
		String query = "SELECT * FROM questao WHERE codigo = '"+s+"'";
		Statement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery(query);
		String q = "";
		try {
			if(rs.first() == true) {
			q += rs.getString(2);
			return q;
			}else {
				return "error";
			}
		}finally {
			con.close();
		}
	}

	public int pegarId(int s) throws Exception {
		Connection con = Conexao.conectar();
		String query = "select * from questao where codigo = '"+s+"'";
		Statement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery(query);
		try {
			if(rs.first() == true) {
		int nivel = rs.getInt(1);
		return nivel;
			}else {
		return 0;
			}
			}finally {
		con.close();
		}
	}
	
	public String listarA(int s) throws Exception {
		Connection con = Conexao.conectar();
		String query = "SELECT * FROM questao WHERE codigo = '"+s+"'";
		Statement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery(query);
		String q = "";
		try {
			if(rs.first() == true) {
			q += rs.getString(3);
			return q;
			}else {
				return "error";
			}
		}finally {
			con.close();
		}
	}
	
	public String listarB(int s) throws Exception {
		Connection con = Conexao.conectar();
		String query = "SELECT * FROM questao WHERE codigo = '"+s+"'";
		Statement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery(query);
		String q = "";
		try {
			if(rs.first() == true) {
			q += rs.getString(4);
			return q;
			}else {
				return "error";
			}
		}finally {
			con.close();
		}
	}
	
	public String listarC(int s) throws Exception {
		Connection con = Conexao.conectar();
		String query = "SELECT * FROM questao WHERE codigo = '"+s+"'";
		Statement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery(query);
		String q = "";
		try {
			if(rs.first() == true) {
			q += rs.getString(5);
			return q;
			}else {
				return "error";
			}
		}finally {
			con.close();
		}
	}
	
	public String listarD(int s) throws Exception {
		Connection con = Conexao.conectar();
		String query = "SELECT * FROM questao WHERE codigo = '"+s+"'";
		Statement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery(query);
		String q = "";
		try {
			if(rs.first() == true) {
			q += rs.getString(6);
			return q;
			}else {
				return "error";
			}
		}finally {
			con.close();
		}
	}
	
	public String listarE(int s) throws Exception {
		Connection con = Conexao.conectar();
		String query = "SELECT * FROM questao WHERE codigo = '"+s+"'";
		Statement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery(query);
		String q = "";
		try {
			if(rs.first() == true) {
			q += rs.getString(7);
			return q;
			}else {
				return "error";
			}
		}finally {
			con.close();
		}
	}
	
	public void excluirUsuario(String nome) throws Exception {
		 Connection con = Conexao.conectar();
	        PreparedStatement stmt = null;
	        try {
	            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM user WHERE nome = '"+nome+"'");
	            stmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Excluido ");
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Erro ao Excluir" + ex);
	        } finally {
	            con.close();
	        }
	}
	
	public void excluirQuestao(Questao q) throws Exception {
		 Connection con = Conexao.conectar();
	        PreparedStatement stmt = null;
	        try {
	            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM questao WHERE codigo = ?");

	          
	            
	            
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex.getMessage().toLowerCase());
	        } finally {
	            con.close();
	        }
	    }
	
    public boolean checkLogin(String login, String senha) throws Exception{
        Connection con = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
    try {
       stmt =  (PreparedStatement) con.prepareStatement("SELECT * FROM user WHERE login = ? and senha = ?");
       stmt.setString(1, login);
       stmt.setString(2, senha);
       rs = stmt.executeQuery();
        
        if (rs.next()){
            check = true;
        }
    }catch(SQLException ex){
    	System.out.println("Erro -> "+ex);
    }finally{
     con.close();
    }
        return check;
}
	
	public int checkNivel(String s) throws Exception {
		Connection con = Conexao.conectar();
		String query = "select * from user where login = '"+s+"'";
		Statement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery(query);
		try {
			if(rs.first() == true) {
			int nivel = rs.getInt(2);
			return nivel;
			}else {
				return -1;
			}
		}finally {
			con.close();
		}
	}
	
}