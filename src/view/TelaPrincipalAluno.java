package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import control.DatabaseController;
import model.Questao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipalAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textQuestao;
	DatabaseController dc = new DatabaseController();
	JComboBox comboBox_1 = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalAluno frame = new TelaPrincipalAluno();
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
	public TelaPrincipalAluno() throws Exception {
		setResizable(false);
		setTitle("Curso Java");
		List<String> questoes = null;
		try {
			questoes = dc.listarQuestoes();
		}catch (Exception e) {
			System.out.println("Error: "+e);
		}comboBox_1.addActionListener(new ActionListener() 
{
	public void actionPerformed(ActionEvent arg0) {
		int id = comboBox_1.getSelectedIndex()+1;
		try {
			dc.listarQuestao(id);
			textQuestao.setText(dc.listarQuestao(id));
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		
	}
});

		comboBox_1.removeAllItems();
		for(String q : questoes) {
			comboBox_1.addItem(q);
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
				TelaPrincipalAluno.this.dispose();
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
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Quest\u00F5es", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblQuesto_1 = new JLabel("Quest\u00E3o");
		lblQuesto_1.setBounds(20, 11, 73, 14);
		panel_3.add(lblQuesto_1);
		
		comboBox_1.setBounds(20, 32, 270, 20);
		panel_3.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Pergunta");
		lblNewLabel.setBounds(20, 63, 73, 14);
		panel_3.add(lblNewLabel);
		
		textQuestao = new JTextField();
		textQuestao.setEnabled(false);
		textQuestao.setBounds(20, 88, 270, 138);
		panel_3.add(textQuestao);
		textQuestao.setColumns(10);
		
	}
	
}
