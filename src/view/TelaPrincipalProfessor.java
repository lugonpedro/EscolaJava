package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import control.DatabaseController;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class TelaPrincipalProfessor extends JFrame {

	private JPanel contentPane;
	DatabaseController dc = new DatabaseController();
	private JTextField textResposta;
	private JTextField textB;
	private JTextField textC;
	private JTextField textD;
	private JTextField textE;
	JComboBox comboBox_1 = new JComboBox();
	JComboBox comboBox = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalProfessor frame = new TelaPrincipalProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public TelaPrincipalProfessor() throws Exception {
		setResizable(false);
		setTitle("Curso Java");
		List<String> questoes = null;
		try {
			questoes = dc.listarQuestoes();
		}catch (Exception e) {
			System.out.println("Error: "+e);
		}
		
		comboBox.removeAllItems();
		
		for(String q : questoes) {
			comboBox.addItem(q);
		}
				
		List<String> perguntas = null ;
		try {
			perguntas = dc.listarPerguntas();
		}catch (Exception p) {
			System.out.println("Error: "+p);
		}
		
		comboBox_1.removeAllItems();
		
		for(String a : perguntas) {
			comboBox_1.addItem(a);
		}
		
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
				TelaPrincipalProfessor.this.dispose();
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
		tabbedPane.addTab("Quest\u00F5es", null, panel, null);
		panel.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroQuestao tela = new TelaCadastroQuestao();
				tela.setVisible(true);
			}
		});
		btnCadastrar.setBounds(330, 218, 105, 23);
		panel.add(btnCadastrar);
		
		JButton btnEditar = new JButton("Atualizar");
		btnEditar.setBounds(445, 218, 89, 23);
		panel.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(544, 218, 89, 23);
		panel.add(btnExcluir);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = comboBox.getSelectedIndex()+1;
				try {
					comboBox_1.setSelectedIndex(dc.pegarId(comboBox.getSelectedIndex()));
					textResposta.setText(dc.listarA(id));
					textB.setText(dc.listarB(id));
					textC.setText(dc.listarC(id));
					textD.setText(dc.listarD(id));
					textE.setText(dc.listarE(id));
				} catch (Exception e) {
					System.out.println("Error: "+e);
				}
			}
		});
		
		comboBox.setBounds(10, 11, 50, 20);
		panel.add(comboBox);
		comboBox_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int id = comboBox.getSelectedIndex()+1;
				try {
					comboBox.setSelectedIndex(dc.pegarId(comboBox_1.getSelectedIndex()));
					textResposta.setText(dc.listarA(id));
					textB.setText(dc.listarB(id));
					textC.setText(dc.listarC(id));
					textD.setText(dc.listarD(id));
					textE.setText(dc.listarE(id));
				} catch (Exception q) {
					System.out.println("Error: "+q);
				}
			}
					
		});
		
		comboBox_1.setBounds(70, 11, 400, 20);
		panel.add(comboBox_1);
		
		textResposta = new JTextField();
		textResposta.setEnabled(false);
		textResposta.setBounds(10, 55, 460, 20);
		panel.add(textResposta);
		textResposta.setColumns(10);
		
		JLabel lblRespostaCorreta = new JLabel("Resposta Correta");
		lblRespostaCorreta.setBounds(10, 40, 120, 14);
		panel.add(lblRespostaCorreta);
		
		textB = new JTextField();
		textB.setEnabled(false);
		textB.setBounds(10, 97, 460, 20);
		panel.add(textB);
		textB.setColumns(10);
		
		JLabel lblOutras = new JLabel("Outras");
		lblOutras.setBounds(10, 81, 46, 14);
		panel.add(lblOutras);
		
		textC = new JTextField();
		textC.setEnabled(false);
		textC.setBounds(10, 124, 460, 20);
		panel.add(textC);
		textC.setColumns(10);
		
		textD = new JTextField();
		textD.setEnabled(false);
		textD.setBounds(10, 155, 460, 20);
		panel.add(textD);
		textD.setColumns(10);
		
		textE = new JTextField();
		textE.setEnabled(false);
		textE.setBounds(10, 186, 460, 20);
		panel.add(textE);
		textE.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(10, 218, 89, 23);
		panel.add(btnSalvar);
	}
}
