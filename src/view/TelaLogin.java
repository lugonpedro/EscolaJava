package view;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.DatabaseController;
import control.UsuarioController;
import java.awt.Font;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField textSenha;
	UsuarioController uc = new UsuarioController();
	DatabaseController dc = new DatabaseController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setResizable(false);
		setTitle("Curso Java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(24, 33, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(24, 58, 46, 14);
		contentPane.add(lblSenha);
		
		textLogin = new JTextField();
		textLogin.setBounds(66, 30, 220, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		textSenha = new JPasswordField();
		textSenha.setEchoChar('*');
		textSenha.setBounds(66, 55, 220, 20);
		contentPane.add(textSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					if (dc.checkLogin(textLogin.getText(), textSenha.getText())){
						if(dc.checkNivel(textLogin.getText()) == 1) {
						    TelaPrincipalAluno tela = new TelaPrincipalAluno();
						    tela.setVisible(true);
						    TelaLogin.this.dispose();
						}
						if(dc.checkNivel(textLogin.getText()) == 2) {
						    TelaPrincipalProfessor tela = new TelaPrincipalProfessor();
						    tela.setVisible(true);
							TelaLogin.this.dispose();
						}
						if(dc.checkNivel(textLogin.getText()) == 3) {
							TelaPrincipalAdministrador tela = new TelaPrincipalAdministrador();
							tela.setVisible(true);
							TelaLogin.this.dispose();
						}
					    }else if(dc.checkNivel(textLogin.getText()) == -1){
					        JOptionPane.showMessageDialog(null, "Dados incorretos!");
					    }
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnEntrar.setBounds(195, 125, 89, 23);
		contentPane.add(btnEntrar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroUsuario tela = new TelaCadastroUsuario();
				tela.setVisible(true);
			}
		});
		btnCadastrar.setBounds(10, 127, 110, 23);
		contentPane.add(btnCadastrar);
	}
}
