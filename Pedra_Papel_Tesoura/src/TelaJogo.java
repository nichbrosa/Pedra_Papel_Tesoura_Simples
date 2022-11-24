import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class TelaJogo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//classes para contador player e bot
	int p = 0;
	int b = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogo frame = new TelaJogo();
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
	public TelaJogo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaJogo.class.getResource("/imagens/icone1.png")));
			
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblbot = new JLabel("0");
		lblbot.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblbot.setBounds(485, 27, 30, 41);
		contentPane.add(lblbot);
		
		JLabel lblPlayer = new JLabel("0");
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPlayer.setBounds(140, 27, 30, 41);
		contentPane.add(lblPlayer);
		
		JLabel lblrobo = new JLabel("Escolhendo...");
		lblrobo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblrobo.setBounds(376, 62, 226, 220);
		contentPane.add(lblrobo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/pedra papel tesoura.png")));
		lblNewLabel.setBounds(140, 54, 226, 246);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Jogador");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(24, 27, 124, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Robo");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(408, 27, 83, 41);
		contentPane.add(lblNewLabel_1_1);
		//botao pedra
		JButton btnpedra = new JButton("Pedra");
		btnpedra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gerador de numero aleatorio para o BOT
				Random gerador = new Random();
				int bot = gerador.nextInt(3);
				//caso 0  a imagem do escolhendo vira uma pedra e aparece uma mensagem dizendo empate
				if(bot==0) {
					lblrobo.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/pedra.png")));
					JOptionPane.showMessageDialog(null, "Empate");
					//caso 1  a imagem do escolhendo vira uma papel e aparece uma mensagem dizendo derrota
				}else if(bot==1) {		
					lblrobo.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/papel.png")));
					JOptionPane.showMessageDialog(null, "Derrota");
					// adiciona +1 no contador de pontos do bot
					b++;
					lblbot.setText(Integer.toString(b));
					//caso 2  a imagem do escolhendo vira uma tesoura e aparece uma mensagem dizendo vitoria
				}else if(bot==2) {
					lblrobo.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/tesoura.png")));
					JOptionPane.showMessageDialog(null, "Vitoria");
					//adiciona +1 no contador de pontos do player
					p++;
					lblPlayer.setText(Integer.toString(p));
				}
			}
		});
		btnpedra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnpedra.setBounds(10, 78, 120, 34);
		contentPane.add(btnpedra);
		//botao papel
		JButton btnpapel = new JButton("Papel");
		btnpapel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gerador de numero aleatorio para o BOT
				Random gerador = new Random();
				int bot = gerador.nextInt(3);
				//caso 0  a imagem do escolhendo vira uma pedra e aparece uma mensagem dizendo vitoria
				if(bot==0) {
					lblrobo.setText("Tesoura");
					JOptionPane.showMessageDialog(null, "Vitoria");
					//adiciona +1 no contador de pontos do player
					p++;
					lblPlayer.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/pedra.png")));
					//caso 1  a imagem do escolhendo vira uma papel e aparece uma mensagem dizendo empate
				}else if(bot==1) {
					lblrobo.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/papel.png")));
					JOptionPane.showMessageDialog(null, "Empate");
					//caso 2  a imagem do escolhendo vira uma tesoura e aparece uma mensagem dizendo derrota
				}else if(bot==2) {
					// adiciona +1 no contador de pontos do bot
					b++;
					lblbot.setText(Integer.toString(b));
					lblrobo.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/tesoura.png")));
					JOptionPane.showMessageDialog(null, "Derrota");
				}
			}
		});
		btnpapel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnpapel.setBounds(10, 132, 120, 34);
		contentPane.add(btnpapel);
		//botao tesoura
		JButton btntesoura = new JButton("Tesoura");
		btntesoura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gerador de numero aleatorio para o BOT
				Random gerador = new Random();
				int bot = gerador.nextInt(3);
				//caso 0  a imagem do escolhendo vira uma pedra e aparece uma mensagem dizendo derrota
				if(bot==0) {			
					lblrobo.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/pedra.png")));
					JOptionPane.showMessageDialog(null, "Derrota");
					// adiciona +1 no contador de pontos do bot
					b++;
					lblbot.setText(Integer.toString(b));
					//caso 1  a imagem do escolhendo vira uma papel e aparece uma mensagem dizendo vitoria
				}else if(bot==1) {
					lblrobo.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/papel.png")));
					JOptionPane.showMessageDialog(null, "Vitoria");
					//adiciona +1 no contador de pontos do player
					p++;
					lblPlayer.setText(Integer.toString(p));
					//caso 2  a imagem do escolhendo vira uma tesoura e aparece uma mensagem dizendo empate
				}else if(bot==2) {
					lblrobo.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/tesoura.png")));
					JOptionPane.showMessageDialog(null, "Empate");
				}
			}
		});
		btntesoura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btntesoura.setBounds(10, 191, 120, 34);
		contentPane.add(btntesoura);
		
	}
}
