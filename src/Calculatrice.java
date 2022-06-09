import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Calculatrice extends JFrame implements ActionListener {
	
	// Boutons entier
	private JButton bt0 = new JButton ("0");
	private JButton bt1 = new JButton ("1");
	private JButton bt2 = new JButton ("2");
	private JButton bt3 = new JButton ("3");
	private JButton bt4 = new JButton ("4");
	private JButton bt5 = new JButton ("5");
	private JButton bt6 = new JButton ("6");
	private JButton bt7 = new JButton ("7");
	private JButton bt8 = new JButton ("8");
	private JButton bt9 = new JButton ("9");
	
	// Pour afficher les boutons
	private JPanel pan = new JPanel();
	
	// Fonts
	Font fButton = new Font("Arial", Font.BOLD, 18); // Taille du texte des boutons
	Font fResultat = new Font("Arial", Font.BOLD, 40); // Taille du résultat
	Font fErreur = new Font("Arial", Font.BOLD, 20); // Taille du texte de l'erreur
	
	// Labels
	private JLabel lab1 = new JLabel(""); // Affichage des entiers
	private JLabel lab2 = new JLabel(""); // Affichage des opérateurs
	private JLabel lab3 = new JLabel(""); // Affichage des entiers après l'opérateur
	private JLabel lab4 = new JLabel(""); // Affichage du resultat
	private JLabel lab5 = new JLabel(""); // Erreur 1 : (Erreur de syntaxe)
	private JLabel lab6 = new JLabel(""); // Erreur 2 : (désignation de l'erreur)
	
	// Opérateurs
	private JButton bt10 = new JButton ("+");
	private JButton bt11 = new JButton ("=");
	private JButton bt12 = new JButton ("-");
	private JButton bt13 = new JButton ("X");
	private JButton bt14 = new JButton ("AC");
	private JButton bt15 = new JButton ("÷");
	private JButton bt16 = new JButton("²");
	
	// Supprimer
	private JButton bt17 = new JButton("S");
	
	// Résultat
	private double resultat;

	public Calculatrice() {

		/* Titre de la fenêtre */
		this.setTitle("Calculatrice");
		
		/* Dimensions de la fenêtre */
		this.setBounds(500, 300, 256, 500);
		// this.setBouds(x, y, width, height);
		// x : position de la fenêtre allant de la gauche vers la droite
		// y : position de la fenêtre allant du haut vers le bas
		// width : largeur de la fenêtre
		// height : hauteur de la fenêtre
		
		/* Ne pas redimenssionnez la fenêtre (avec la souris) */
		this.setResizable(false);
		
		/* Fermer la fenêtre */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Couleur de fond d'écran de la fenêtre */
		pan.setBackground(Color.darkGray);
		
		/* Ne Location relative à null */
		this.setLocationRelativeTo(null);
	
		/* Pas de disposition */
		this.pan.setLayout(null);
		
		/* Label 1 (Affichage des entiers) */
		this.lab1.setBounds(5, 5, 260, 40);
		this.lab1.setForeground(Color.WHITE);
		this.lab1.setFont(fResultat);
		this.pan.add(lab1);
		
		/* Label 2 (Affichage des opérateurs)  */
		this.lab2.setBounds(5, 50, 100, 40);
		this.lab2.setForeground(Color.WHITE);
		this.lab2.setFont(fResultat);
		this.pan.add(lab2);
		
		/* Label 3 (Affichage des entiers après l'opérateur) */
		this.lab3.setBounds(5, 95, 260, 40);
		this.lab3.setForeground(Color.WHITE);
		this.lab3.setFont(fResultat);
		this.pan.add(lab3);
		
		/* Label 4 (Affichage du resultat) */
		this.lab4.setBounds(5, 5, 600, 40);
		this.lab4.setForeground(Color.WHITE);
		this.lab4.setFont(fResultat);
		this.pan.add(lab4);
		
		/* Label 5 (Erreur 1 : "Erreur de syntaxe : ") */
		this.lab5.setBounds(5, 5, 600, 40);
		this.lab5.setForeground(Color.YELLOW);
		this.lab5.setFont(fErreur);
		this.pan.add(lab5);
		
		/* Label 6 (Erreur 2 : (désignation de l'erreur)) */
		this.lab6.setBounds(5, 60, 600, 40);
		this.lab6.setForeground(Color.YELLOW);
		this.lab6.setFont(fErreur);
		this.pan.add(lab6);
		
		/* 1ère ligne : AC ² ÷ ◀ */
		
		// Bouton AC
		this.bt14.setBounds(0, 160, 60, 60);
		this.bt14.setBackground(Color.GRAY); // Fond du bouton
		this.bt14.setForeground(Color.WHITE); // Couleur du texte
		this.bt14.setFont(fButton); // Taille du texte
		this.bt14.addActionListener(this);
		this.pan.add(bt14);
		
		// Bouton ²
		this.bt16.setBounds(60, 160, 60, 60);
		this.bt16.setBackground(Color.GRAY);
		this.bt16.setForeground(Color.WHITE);
		this.bt16.setFont(fButton);
		this.bt16.addActionListener(this);
		this.pan.add(bt16);
		
		// Bouton ÷
		this.bt15.setBounds(120, 160, 60, 60);
		this.bt15.setBackground(Color.GRAY);
		this.bt15.setForeground(Color.WHITE);
		this.bt15.setFont(fButton);
		this.bt15.addActionListener(this);
		this.pan.add(bt15);
		
		// Bouton ◀
		this.bt17.setBounds(180, 160, 60, 60);
		this.bt17.setBackground(new Color(255, 140, 0)); // Fond orange
		this.bt17.setForeground(Color.WHITE);
		this.bt17.setFont(fButton);
		this.bt17.addActionListener(this);
		this.pan.add(bt17);
		
		/* 2ème ligne : 7 8 9 X */
		
		// Bouton 7
		this.bt7.setBounds(0, 220, 60, 60);
		this.bt7.setBackground(Color.GRAY);
		this.bt7.setForeground(Color.WHITE);
		this.bt7.setFont(fButton);
		this.bt7.addActionListener(this);
		this.pan.add(bt7);
		
		// Bouton 8
		this.bt8.setBounds(60, 220, 60, 60);
		this.bt8.addActionListener(this);
		this.bt8.setBackground(Color.GRAY);
		this.bt8.setForeground(Color.WHITE);
		this.bt8.setFont(fButton);
		this.pan.add(bt8);
		
		// Bouton 9
		this.bt9.setBounds(120, 220, 60, 60);
		this.bt9.setBackground(Color.GRAY);
		this.bt9.setForeground(Color.WHITE);
		this.bt9.setFont(fButton);
		this.bt9.addActionListener(this);
		this.pan.add(bt9);
		
		// Bouton X
		this.bt13.setBounds(180, 220, 60, 60);
		this.bt13.setBackground(new Color(255, 140, 0));
		this.bt13.setForeground(Color.WHITE);
		this.bt13.setFont(fButton);
		this.bt13.addActionListener(this);
		this.pan.add(bt13);
		
		/* 3ème ligne : 4 5 6 - */
		
		// Bouton 4
		this.bt4.setBounds(0, 280, 60, 60);
		this.bt4.setBackground(Color.GRAY);
		this.bt4.setForeground(Color.WHITE);
		this.bt4.setFont(fButton);
		this.bt4.addActionListener(this);
		this.pan.add(bt4);
		
		/* Bouton 5 */
		this.bt5.setBounds(60, 280, 60, 60);
		this.bt5.setBackground(Color.GRAY);
		this.bt5.setForeground(Color.WHITE);
		this.bt5.setFont(fButton);
		this.bt5.addActionListener(this);
		this.pan.add(bt5);
		
		/* Bouton 6 */
		this.bt6.setBounds(120, 280, 60, 60);
		this.bt6.setBackground(Color.GRAY);
		this.bt6.setForeground(Color.WHITE);
		this.bt6.setFont(fButton);
		this.bt6.addActionListener(this);
		this.pan.add(bt6);
		
		// Bouton -
		this.bt12.setBounds(180, 280, 60, 60);
		this.bt12.setBackground(new Color(255, 140, 0));
		this.bt12.setForeground(Color.WHITE);
		this.bt12.setFont(fButton);
		this.bt12.addActionListener(this);
		this.pan.add(bt12);
		
		/* 4ème ligne : 1 2 3 + */
		
		// Bouton 1 
		this.bt1.setBounds(0, 340, 60, 60);
		this.bt1.setBackground(Color.GRAY);
		this.bt1.setForeground(Color.WHITE);
		this.bt1.setFont(fButton);
		this.bt1.addActionListener(this);
		this.pan.add(bt1);
		
		// Bouton 2
		this.bt2.setBounds(60, 340, 60, 60);
		this.bt2.setBackground(Color.GRAY);
		this.bt2.setForeground(Color.WHITE);
		this.bt2.setFont(fButton);
		this.bt2.addActionListener(this);
		this.pan.add(bt2);
		
		// Bouton 3
		this.bt3.setBounds(120, 340, 60, 60);
		this.bt3.setBackground(Color.GRAY);
		this.bt3.setForeground(Color.WHITE);
		this.bt3.setFont(fButton);
		this.bt3.addActionListener(this);
		this.pan.add(bt3);
		
		// Bouton +
		this.bt10.setBounds(180, 340, 60, 60);
		this.bt10.setBackground(new Color(255, 140, 0));
		this.bt10.setForeground(Color.WHITE);
		this.bt10.setFont(fButton);
		this.bt10.addActionListener(this);
		this.pan.add(bt10);
		
		/* 5ème ligne : 0 = */
		
		// Bouton 0
		this.bt0.setBounds(0, 400, 120, 60);
		this.bt0.setBackground(Color.GRAY);
		this.bt0.setForeground(Color.WHITE);
		this.bt0.setFont(fButton);
		this.bt0.addActionListener(this);
		this.pan.add(bt0);

		// Bouton =
		this.bt11.setBounds(120, 400, 120, 60);
		this.bt11.setBackground(new Color(255, 140, 0));
		this.bt11.setForeground(Color.WHITE);
		this.bt11.setFont(fButton);
		this.bt11.addActionListener(this);
		this.pan.add(bt11);
		
		/* Affichage du contenus de la fenêtre */
		this.setContentPane(pan);
		
		/* Affichage de la fenêtre */
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Calculatrice maCalculette = new Calculatrice();
	}

	public void actionPerformed(ActionEvent e) {
		
		// Bouton 0
		if (e.getSource() == this.bt0) {
			this.lab5.setText("");
			this.lab6.setText("");
			if (this.lab1.getText().contains("=")) {
				this.lab1.setText(this.lab1.getText().substring(2));
			}
			this.lab4.setText("");
			if (this.lab2.getText().isEmpty() == true) {
				this.lab1.setText(this.lab1.getText() + "0");
			}
			if (this.lab2.getText().isEmpty() == false) {
				this.lab3.setText(this.lab3.getText() + "0");
			}
		}
		
		// Bouton 1
		if (e.getSource() == this.bt1) {
			this.lab5.setText("");
			this.lab6.setText("");
			if (this.lab1.getText().contains("=")) {
				this.lab1.setText(this.lab1.getText().substring(2));
			}
			this.lab4.setText("");
			if (this.lab2.getText().isEmpty() == true) {
				this.lab1.setText(this.lab1.getText() + "1");
			}
			if (this.lab2.getText().isEmpty() == false) {
				this.lab3.setText(this.lab3.getText() + "1");
			}
		}
		
		// Bouton 2
		if (e.getSource() == this.bt2) {
			this.lab5.setText("");
			this.lab6.setText("");
			if (this.lab1.getText().contains("=")) {
				this.lab1.setText(this.lab1.getText().substring(2));
			}
			this.lab4.setText("");
			if (this.lab2.getText().isEmpty() == true) {
				this.lab1.setText(this.lab1.getText() + "2");
			}
			if (this.lab2.getText().isEmpty() == false) {
				this.lab3.setText(this.lab3.getText() + "2");
			}
		}
		
		// Bouton 3
		if (e.getSource() == this.bt3) {
			this.lab5.setText("");
			this.lab6.setText("");
			if (this.lab1.getText().contains("=")) {
				this.lab1.setText(this.lab1.getText().substring(2));
			}
			this.lab4.setText("");
			if (this.lab2.getText().isEmpty() == true) {
				this.lab1.setText(this.lab1.getText() + "3");
			}
			if (this.lab2.getText().isEmpty() == false) {
				this.lab3.setText(this.lab3.getText() + "3");
			}
		}
		
		// Bouton 4
		if (e.getSource() == this.bt4) {
			this.lab5.setText("");
			this.lab6.setText("");
			if (this.lab1.getText().contains("=")) {
				this.lab1.setText(this.lab1.getText().substring(2));
			}
			this.lab4.setText("");
			if (this.lab2.getText().isEmpty() == true) {
				this.lab1.setText(this.lab1.getText() + "4");
			}
			if (this.lab2.getText().isEmpty() == false) {
				this.lab3.setText(lab3.getText() + "4");
			}
		}
		
		// Bouton 5
		if (e.getSource() == this.bt5) {
			this.lab5.setText("");
			this.lab6.setText("");
			if (this.lab1.getText().contains("=")) {
				this.lab1.setText(this.lab1.getText().substring(2));
			}
			this.lab4.setText("");
			if (this.lab2.getText().isEmpty() == true) {
				this.lab1.setText(this.lab1.getText() + "5");
			}
			if (this.lab2.getText().isEmpty() == false) {
				this.lab3.setText(this.lab3.getText() + "5");
			}
		}
		
		// Bouton 6
		if (e.getSource() == this.bt6) {
			this.lab5.setText("");
			this.lab6.setText("");
			if (this.lab1.getText().contains("=")) {
				this.lab1.setText(this.lab1.getText().substring(2));
			}
			this.lab4.setText("");
			if (this.lab2.getText().isEmpty() == true) {
				this.lab1.setText(this.lab1.getText() + "6");
			}
			if (this.lab2.getText().isEmpty() == false) {
				this.lab3.setText(this.lab3.getText() + "6");
			}
		}
		
		// Bouton 7
		if (e.getSource() == this.bt7) {
			this.lab5.setText("");
			this.lab6.setText("");
			if (this.lab1.getText().contains("=")) {
				this.lab1.setText(this.lab1.getText().substring(2));
			}
			this.lab4.setText("");
			if (this.lab2.getText().isEmpty() == true) {
				this.lab1.setText(this.lab1.getText() + "7");
			}
			if (this.lab2.getText().isEmpty() == false) {
				this.lab3.setText(this.lab3.getText() + "7");
			}
		}
		
		// Bouton 8
		if (e.getSource() == this.bt8) {
			this.lab5.setText("");
			this.lab6.setText("");
			if (this.lab1.getText().contains("=")) {
				this.lab1.setText(this.lab1.getText().substring(2));
			}
			this.lab4.setText("");
			if (this.lab2.getText().isEmpty() == true) {
				this.lab1.setText(this.lab1.getText() + "8");
			}
			if (this.lab2.getText().isEmpty() == false) {
				this.lab3.setText(this.lab3.getText() + "8");
			}
		}
		
		// Bouton 9
		if (e.getSource() == this.bt9) {
			this.lab5.setText("");
			this.lab6.setText("");
			if (this.lab1.getText().contains("=")) {
				this.lab1.setText(this.lab1.getText().substring(2));
			}
			this.lab4.setText("");
			if (this.lab2.getText().isEmpty() == true) {
				this.lab1.setText(this.lab1.getText() + "9");
			}
			if (this.lab2.getText().isEmpty() == false) {
				this.lab3.setText(this.lab3.getText() + "9");
			}
		}
		
		// Bouton +
		if (e.getSource() == this.bt10) {
			this.lab5.setText("");
			this.lab6.setText("");
			if (this.lab1.getText().contains("=")) {
				this.lab1.setText(this.lab1.getText().substring(2));
			}
			if (this.lab1.getText().isEmpty() == false) {
				this.lab2.setText("+");
			}
			if (this.lab4.getText().isEmpty() == false) {
				this.lab1.setText(this.lab4.getText());
				this.lab2.setText("+");
				this.lab4.setText("");
			}
		}

		// Bouton =
		if (e.getSource() == this.bt11) {
			if (this.lab2.getText() == "+") {
				try {
					this.resultat = (double)Integer.parseInt(this.lab1.getText()) + (double)Integer.parseInt(this.lab3.getText());
					this.lab4.setText("" + this.resultat);
				} catch (Exception e1) {
					this.lab5.setText("Erreur de syntaxe : ");
					this.lab6.setText("+ ?");
				}
			}
			if (this.lab2.getText() == "-") {
				try {
					this.resultat = Integer.parseInt(this.lab1.getText()) - Integer.parseInt(this.lab3.getText());
					this.lab4.setText("" + this.resultat);
				} catch (Exception e2) {
					this.lab5.setText("Erreur de syntaxe : ");
					this.lab6.setText("- ?");
				}
			}
			if (this.lab2.getText() == "X") {
				try {
					this.resultat = Integer.parseInt(this.lab1.getText()) * Integer.parseInt(this.lab3.getText());
					this.lab4.setText("" + this.resultat);
				} catch (Exception e3) {
					this.lab5.setText("Erreur de syntaxe : ");
					this.lab6.setText("X ?");
				}
			}
			if (this.lab2.getText() == "÷") {
				try {
					this.resultat = (double)Integer.parseInt(this.lab1.getText()) / (double)Integer.parseInt(this.lab3.getText());
					this.lab4.setText("" + this.resultat);
				} catch (Exception e4) {
					this.lab5.setText("Erreur de syntaxe : ");
					this.lab6.setText("÷ ?");
				}
			}
			if (this.lab1.getText().endsWith("²")) {
				try {
					this.lab1.setText(this.lab1.getText().replace("²", ""));
					this.resultat = (int)Math.pow(Integer.parseInt(this.lab1.getText()), 2);
					this.lab4.setText(this.resultat + "");
				} catch (Exception e5) {
					this.lab5.setText("Erreur de syntaxe : ");
					this.lab6.setText("² ?");
				}
			}
			this.lab1.setText("");
			this.lab2.setText("");
			this.lab3.setText("");
		}
		
		// Bouton -
		if (e.getSource() == this.bt12) {
			this.lab5.setText("");
			this.lab6.setText("");
			if (this.lab1.getText().contains("=")) {
				this.lab1.setText(this.lab1.getText().substring(2));
			}
			if (this.lab1.getText().isEmpty() == false) {
				this.lab2.setText("-");
			}
			if (this.lab4.getText().isEmpty() == false) {
				this.lab1.setText(this.lab4.getText());
				this.lab2.setText("-");
				this.lab4.setText("");
			}
		}

		// Bouton X
		if (e.getSource() == this.bt13) {
			this.lab5.setText("");
			this.lab6.setText("");
			if (this.lab1.getText().contains("=")) {
				this.lab1.setText(this.lab1.getText().substring(2));
			}
			if (this.lab1.getText().isEmpty() == false) { 
				this.lab2.setText("X");
			}
			if (this.lab4.getText().isEmpty() == false) {
				this.lab1.setText(this.lab4.getText());
				this.lab2.setText("X");
				this.lab4.setText("");
			}
		}

		// Bouton AC
		if (e.getSource() == this.bt14) {
			this.lab1.setText("");
			this.lab2.setText("");
			this.lab3.setText("");
			this.lab4.setText("");
			this.lab5.setText("");
			this.lab6.setText("");
		}

		// Bouton ÷
		if (e.getSource() == this.bt15) {
			this.lab5.setText("");
			this.lab6.setText("");
			if (this.lab1.getText().contains("=")) {
				this.lab1.setText(this.lab1.getText().substring(2));
			}
			if (this.lab1.getText().isEmpty() == false) {
				this.lab2.setText("÷");
			}
			if (this.lab4.getText().isEmpty() == false) {
				this.lab1.setText(this.lab4.getText());
				this.lab2.setText("÷");
				this.lab4.setText("");
			}
		}

		// Bouton ²
		if (e.getSource() == this.bt16) {
			this.lab1.setText(this.lab1.getText() + "²");
		}

		// Boutou S (Supprimer)
		if (e.getSource() == this.bt17) {
			if (this.lab1.getText().isEmpty() == false && this.lab2.getText().isEmpty() == true) {
				this.lab1.setText(this.lab1.getText().substring(0, this.lab1.getText().length() - 1));
			}
			if (this.lab2.getText().isEmpty() == false && this.lab3.getText().isEmpty() == true) {
				this.lab2.setText(this.lab2.getText().substring(0, this.lab2.getText().length() - 1));
			}
			if (this.lab2.getText().isEmpty() == false && this.lab3.getText().isEmpty() == false) {
				this.lab3.setText(this.lab3.getText().substring(0, this.lab3.getText().length() - 1));
			}
			if (this.lab1.getText().isEmpty() == true) {}
		}
		
	}

}