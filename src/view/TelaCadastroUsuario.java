package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.UsuarioController;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JLabel lblSenha;
	private JTextField txtSenha;
	private JLabel lblNome;
	private JTextField txtNome;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblDataDeNascimento;
	private JTextField txtNasc;
	private JLabel lblCpf;
	private JTextField txtCpf;
	private JLabel lblTelefone;
	private JTextField txtTel;
	private JLabel lblTipoDeUsurio;
	JComboBox comboBox = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario frame = new TelaCadastroUsuario();
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
	public TelaCadastroUsuario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 11, 46, 14);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(10, 25, 160, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 56, 46, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(10, 70, 160, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 101, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 114, 160, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 145, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(10, 159, 160, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(10, 190, 120, 14);
		contentPane.add(lblDataDeNascimento);
		
		txtNasc = new JTextField();
		txtNasc.setBounds(10, 203, 160, 20);
		contentPane.add(txtNasc);
		txtNasc.setColumns(10);
		
		lblCpf = new JLabel("Cpf");
		lblCpf.setBounds(10, 234, 46, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(10, 247, 160, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 278, 60, 14);
		contentPane.add(lblTelefone);
		
		txtTel = new JTextField();
		txtTel.setBounds(10, 294, 160, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					salvarUsuario();
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnCadastrar.setBounds(314, 337, 100, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroUsuario.this.dispose();
				
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVoltar.setBounds(230, 337, 74, 23);
		contentPane.add(btnVoltar);
		
		lblTipoDeUsurio = new JLabel("Tipo de Usu\u00E1rio");
		lblTipoDeUsurio.setBounds(210, 11, 105, 14);
		contentPane.add(lblTipoDeUsurio);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aluno", "Professor"}));
		comboBox.setBounds(210, 25, 105, 20);
		contentPane.add(comboBox);
	}
	
	public boolean validaCampos() {
		return (txtNome.getText().equals("") && txtLogin.getText().equals("") && txtSenha.getText().equals("") && txtCpf.getText().equals("") && txtTel.getText().equals("") && txtEmail.getText().equals("") && txtNasc.getText().equals(""));
	}
	
	public void salvarUsuario() throws Exception {
		if(validaCampos()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos");
		}else{
			UsuarioController uc = new UsuarioController();
			if(comboBox.getSelectedItem().toString().equals("Aluno")) {
				uc.criarUsuario(1, txtNome.getText(), txtLogin.getText(), txtSenha.getText(), txtCpf.getText(), txtTel.getText(), txtEmail.getText(), txtNasc.getText());
				limparCampos();
			}if(comboBox.getSelectedItem().toString().equals("Professor")){
				uc.criarUsuario(2, txtNome.getText(), txtLogin.getText(), txtSenha.getText(), txtCpf.getText(), txtTel.getText(), txtEmail.getText(), txtNasc.getText());
				limparCampos();
			}else {
				JOptionPane.showMessageDialog(null,"Tipo de usuário não informado!");
			}
			
		}
	}
	
	public void limparCampos() {
		txtNome.setText("");
		txtLogin.setText("");
		txtSenha.setText("");
		txtCpf.setText("");
		txtTel.setText("");
		txtEmail.setText("");
		txtNasc.setText("");
	}
}
