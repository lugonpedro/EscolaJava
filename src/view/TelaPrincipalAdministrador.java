package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.DatabaseController;
import control.UsuarioController;

public class TelaPrincipalAdministrador extends JFrame {

	private JPanel contentPane;
	private JTextField textCpf;
	private JTextField textNasc;
	private JTextField textEmail;
	private JTextField textTel;
	private JTextField textCpf2;
	private JTextField textTel2;
	private JTextField textNasc2;
	private JTextField textEmail2;
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();
	DatabaseController dc = new DatabaseController();
	UsuarioController uc = new UsuarioController();
	JButton btnSalvar = new JButton("Salvar");
	JButton btnVoltar = new JButton("Voltar");
	JButton btnSalvar_1 = new JButton("Salvar");
	JButton btnVoltar_1 = new JButton("Voltar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalAdministrador frame = new TelaPrincipalAdministrador();
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
	public TelaPrincipalAdministrador() {
		setTitle("Curso Java");
		
		List<String> alunos = null;
		try {
			alunos = dc.listarAlunos();
		}catch (Exception e) {
			System.out.println("Error: "+e);
		}
		
		comboBox.removeAllItems();
		
		for(String a : alunos) {
			comboBox.addItem(a);
		}
		
		List<String> profs = null;
		try {
			profs = dc.listarProfs();
		}catch (Exception e) {
			System.out.println("Error: "+e);
		}
		
		comboBox_1.removeAllItems();
		
		for(String p : profs) {
			comboBox_1.addItem(p);
		}
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 350);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("                                                                                                                                                                                                        ");
		menuBar.add(mnNewMenu);
		mnNewMenu.setEnabled(false);
		
		JMenu mnConta = new JMenu("Conta");
		menuBar.add(mnConta);
		
		JRadioButtonMenuItem rdbtnmntmSair = new JRadioButtonMenuItem("Sair");
		rdbtnmntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPrincipalAdministrador.this.dispose();
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
			}
		});
		mnConta.add(rdbtnmntmSair);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Alunos", null, panel, null);
		panel.setLayout(null);
		
		JButton btnEditarAluno = new JButton("Editar");
		btnEditarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textCpf.setEnabled(true);
				textEmail.setEnabled(true);
				textNasc.setEnabled(true);
				textTel.setEnabled(true);
				btnSalvar.setEnabled(true);
				btnVoltar.setEnabled(true);
					
			}
		});
		btnEditarAluno.setBounds(10, 181, 130, 23);
		panel.add(btnEditarAluno);
		
		JButton btnExcluirAluno = new JButton("Excluir");
		btnExcluirAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza?");
				if(confirm == 0) {
				
				String nome = (String) comboBox.getSelectedItem();
				try {
					uc.excluirUsuario(nome);
					
					List<String> alunos = null;
					try {
						alunos = dc.listarAlunos();
					}catch (Exception h) {
						System.out.println("Error: "+h);
					}
					
					comboBox.removeAllItems();
					
					for(String a : alunos) {
						comboBox.addItem(a);
					}
					
				} catch (Exception h) {
					System.out.print("Error: "+h);
					}
				
				}				
				
				else {	}
			}
		});
		btnExcluirAluno.setBounds(10, 215, 130, 23);
		panel.add(btnExcluirAluno);
		
		JButton btnNovoAluno = new JButton("Novo");
		btnNovoAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			TelaCadastroUsuario tela = new TelaCadastroUsuario();
			tela.setVisible(true);
				
			}
		});
		btnNovoAluno.setBounds(150, 215, 130, 23);
		panel.add(btnNovoAluno);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String a = (String) comboBox.getSelectedItem();
					textCpf.setText(dc.listarCpf(a));
					textTel.setText(dc.listarTel(a));
					textNasc.setText(dc.listarNasc(a));
					textEmail.setText(dc.listarEmail(a));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		comboBox.setBounds(10, 11, 620, 20);
		panel.add(comboBox);
		
		textCpf = new JTextField();
		textCpf.setEnabled(false);
		textCpf.setBounds(36, 39, 170, 20);
		panel.add(textCpf);
		textCpf.setColumns(10);
		
		textNasc = new JTextField();
		textNasc.setEnabled(false);
		textNasc.setBounds(460, 39, 170, 20);
		panel.add(textNasc);
		textNasc.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setEnabled(false);
		textEmail.setBounds(460, 67, 170, 20);
		panel.add(textEmail);
		textEmail.setColumns(10);
		
		textTel = new JTextField();
		textTel.setEnabled(false);
		textTel.setBounds(36, 67, 170, 20);
		panel.add(textTel);
		textTel.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 42, 46, 14);
		panel.add(lblCpf);
		
		JLabel lblNascimento = new JLabel("Nascimento");
		lblNascimento.setBounds(392, 42, 86, 14);
		panel.add(lblNascimento);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(414, 70, 46, 14);
		panel.add(lblEmail);
		
		JLabel lblTel = new JLabel("Tel");
		lblTel.setBounds(10, 70, 46, 14);
		panel.add(lblTel);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String user = (String) comboBox.getSelectedItem();
				try {
					uc.editarUsuario(user, textCpf.getText(), textNasc.getText(), textEmail.getText(), textTel.getText());
				} catch (Exception q) {
					System.out.print("Error: "+q);
				}
				
				comboBox.removeAllItems();
				
				textCpf.setEnabled(false);
				textEmail.setEnabled(false);
				textTel.setEnabled(false);
				textNasc.setEnabled(false);
				btnSalvar.setEnabled(false);
				btnVoltar.setEnabled(false);
				
				List<String> alunos = null;
				
				try {
					alunos = dc.listarAlunos();
				} catch (Exception e) {
					System.out.print("Error: "+e);
				}
				for(String a : alunos) {
					comboBox.addItem(a);
				}
				
			}
		});
		
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(541, 98, 89, 23);
		panel.add(btnSalvar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textCpf.setEnabled(false);
				textEmail.setEnabled(false);
				textTel.setEnabled(false);
				textNasc.setEnabled(false);
				btnSalvar.setEnabled(false);
				btnVoltar.setEnabled(false);
			}
		});
		btnVoltar.setEnabled(false);
		btnVoltar.setBounds(442, 98, 89, 23);
		panel.add(btnVoltar);
		
		ImageIcon imgPesquisa = new ImageIcon("C:/Users/pedro/eclipse-workspace/CursoJava/bin/view/pesq.png");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Professores", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnEditarProfessor = new JButton("Editar");
		btnEditarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textCpf2.setEnabled(true);
				textEmail2.setEnabled(true);
				textNasc2.setEnabled(true);
				textTel2.setEnabled(true);
				btnSalvar_1.setEnabled(true);
				btnVoltar_1.setEnabled(true);
				
			}
		});
		btnEditarProfessor.setBounds(10, 187, 130, 23);
		panel_1.add(btnEditarProfessor);
		
		JButton btnExcluirProfessor = new JButton("Excluir");
		btnExcluirProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza?");
				if(confirm == 0) {
				
				String nome = (String) comboBox_1.getSelectedItem();
				try {
					uc.excluirUsuario(nome);
					
					List<String> profs = null;
					try {
						profs = dc.listarProfs();
					}catch (Exception h) {
						System.out.println("Error: "+h);
					}
					
					comboBox_1.removeAllItems();
					
					for(String a : profs) {
						comboBox_1.addItem(a);
					}
					
				} catch (Exception h) {
					System.out.print("Error: "+h);
					}
				
				}				
				
				else {	}
			}
		
		});
		btnExcluirProfessor.setBounds(10, 221, 130, 23);
		panel_1.add(btnExcluirProfessor);
		
		JButton btnNovoProfessor = new JButton("Novo");
		btnNovoProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaCadastroUsuario tela = new TelaCadastroUsuario();
				tela.setVisible(true);
				
			}
		});
		btnNovoProfessor.setBounds(150, 221, 130, 23);
		panel_1.add(btnNovoProfessor);
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String a = (String) comboBox_1.getSelectedItem();
					textCpf2.setText(dc.listarCpf(a));
					textTel2.setText(dc.listarTel(a));
					textNasc2.setText(dc.listarNasc(a));
					textEmail2.setText(dc.listarEmail(a));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
			}
		});
		comboBox_1.setBounds(10, 11, 620, 20);
		panel_1.add(comboBox_1);
		
		JLabel lblCpf_1 = new JLabel("CPF");
		lblCpf_1.setBounds(10, 42, 46, 14);
		panel_1.add(lblCpf_1);
		
		textCpf2 = new JTextField();
		textCpf2.setEnabled(false);
		textCpf2.setBounds(37, 39, 170, 20);
		panel_1.add(textCpf2);
		textCpf2.setColumns(10);
		
		JLabel lblTel_1 = new JLabel("Tel");
		lblTel_1.setBounds(10, 67, 46, 14);
		panel_1.add(lblTel_1);
		
		textTel2 = new JTextField();
		textTel2.setEnabled(false);
		textTel2.setBounds(37, 64, 170, 20);
		panel_1.add(textTel2);
		textTel2.setColumns(10);
		
		JLabel lblNascimento_1 = new JLabel("Nascimento");
		lblNascimento_1.setBounds(398, 42, 84, 14);
		panel_1.add(lblNascimento_1);
		
		textNasc2 = new JTextField();
		textNasc2.setEnabled(false);
		textNasc2.setBounds(460, 39, 170, 20);
		panel_1.add(textNasc2);
		textNasc2.setColumns(10);
		
		textEmail2 = new JTextField();
		textEmail2.setEnabled(false);
		textEmail2.setBounds(460, 64, 170, 20);
		panel_1.add(textEmail2);
		textEmail2.setColumns(10);
		
		JLabel lblEmail_1 = new JLabel("E-mail");
		lblEmail_1.setBounds(419, 67, 46, 14);
		panel_1.add(lblEmail_1);
		btnSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = (String) comboBox_1.getSelectedItem();
				try {
					uc.editarUsuario(user, textCpf.getText(), textNasc.getText(), textEmail.getText(), textTel.getText());
				} catch (Exception q) {
					System.out.print("Error: "+q);
				}
				
				
				textCpf2.setEnabled(false);
				textEmail2.setEnabled(false);
				textTel2.setEnabled(false);
				textNasc2.setEnabled(false);
				btnSalvar_1.setEnabled(false);
				btnVoltar_1.setEnabled(false);
				
				comboBox_1.removeAllItems();
				
				List<String> profs = null;
				
				try {
					profs = dc.listarProfs();
				} catch (Exception a) {
					System.out.print("Error: "+a);
				}
				
				for(String a : profs) {
					comboBox_1.addItem(a);
				}
				
			}
		});
		
		btnSalvar_1.setEnabled(false);
		btnSalvar_1.setBounds(541, 90, 89, 23);
		panel_1.add(btnSalvar_1);
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCpf2.setEnabled(false);
				textEmail2.setEnabled(false);
				textTel2.setEnabled(false);
				textNasc2.setEnabled(false);
				btnSalvar_1.setEnabled(false);
				btnVoltar_1.setEnabled(false);
			}
		});
	
		btnVoltar_1.setEnabled(false);
		btnVoltar_1.setBounds(442, 90, 89, 23);
		panel_1.add(btnVoltar_1);
	}
}
