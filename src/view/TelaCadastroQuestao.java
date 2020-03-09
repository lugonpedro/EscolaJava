package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.DatabaseController;
import control.QuestaoController;

public class TelaCadastroQuestao extends JFrame {

	private JPanel contentPane;
	private JTextField txtPerg;
	private JTextField txtResp;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtD;
	private JTextField txtE;
    DatabaseController dc = new DatabaseController();
    QuestaoController qc = new QuestaoController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroQuestao frame = new TelaCadastroQuestao();
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
	public TelaCadastroQuestao() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPergunta = new JLabel("Pergunta");
		lblPergunta.setBounds(10, 11, 89, 14);
		contentPane.add(lblPergunta);
		
		txtPerg = new JTextField();
		txtPerg.setBounds(10, 25, 448, 50);
		contentPane.add(txtPerg);
		txtPerg.setColumns(10);
		
		JLabel lblRespostaCorreta = new JLabel("Resposta Correta");
		lblRespostaCorreta.setBounds(10, 84, 132, 14);
		contentPane.add(lblRespostaCorreta);
		
		txtResp = new JTextField();
		txtResp.setBounds(10, 99, 444, 50);
		contentPane.add(txtResp);
		txtResp.setColumns(10);
		
		JLabel lblB = new JLabel("B");
		lblB.setBounds(10, 160, 46, 14);
		contentPane.add(lblB);
		
		JLabel lblC = new JLabel("C");
		lblC.setBounds(10, 185, 46, 14);
		contentPane.add(lblC);
		
		JLabel lblD = new JLabel("D");
		lblD.setBounds(10, 210, 46, 14);
		contentPane.add(lblD);
		
		JLabel lblE = new JLabel("E");
		lblE.setBounds(10, 238, 46, 14);
		contentPane.add(lblE);
		
		txtB = new JTextField();
		txtB.setBounds(20, 157, 434, 20);
		contentPane.add(txtB);
		txtB.setColumns(10);
		
		txtC = new JTextField();
		txtC.setBounds(20, 185, 434, 20);
		contentPane.add(txtC);
		txtC.setColumns(10);
		
		txtD = new JTextField();
		txtD.setBounds(20, 210, 434, 20);
		contentPane.add(txtD);
		txtD.setColumns(10);
		
		txtE = new JTextField();
		txtE.setBounds(20, 235, 434, 20);
		contentPane.add(txtE);
		txtE.setColumns(10);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					salvarQuestao();
					JOptionPane.showMessageDialog(null, "Salva com sucesso");
					TelaCadastroQuestao.this.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCriar.setBounds(365, 277, 89, 23);
		contentPane.add(btnCriar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroQuestao.this.dispose();
			}
		});
		btnVoltar.setBounds(10, 277, 89, 23);
		contentPane.add(btnVoltar);
	}
	
	public boolean validaCampos() {
		return (txtPerg.getText().equals("") && txtResp.getText().equals(""));
	}
	
	public void salvarQuestao() throws Exception {
		if(validaCampos()) {
			JOptionPane.showMessageDialog(null, "Preencha pelo menos a pergunta e a resposta");
		}else {
			qc.criarQuestao(txtPerg.getText(), txtResp.getText(), txtB.getText(), txtC.getText(), txtD.getText(), txtE.getText());
		}
	}
}
