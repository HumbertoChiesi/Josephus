package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import imagens.josephusImg;

public class pessoasGui {
	JFrame telaPrincipal = null;
	Container telaPessoas = new JPanel();
	JLabel[] pessoas = null;
	josephusImg icone = new josephusImg();
	int qntdPessoas;
	
	public pessoasGui(int qntd, JFrame telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
		this.qntdPessoas = qntd;
		this.pessoas = new JLabel[qntd];
		this.telaPessoas.setLayout(null);
		this.telaPessoas.setBackground(Color.DARK_GRAY);
		this.telaPessoas.setPreferredSize(new Dimension(561,561));
	}
	
	public void inserirLabelsPessoas(int qntd, ImageIcon img) {
		inicializarLabels(qntd, img);
		this.telaPrincipal.add("Center", this.telaPessoas);
	}
	
	public void inicializarLabels(int qntd, ImageIcon img) {
		this.telaPessoas.removeAll();
		this.telaPessoas.repaint();
		
		inserirArma(img);
		
		int x=35, y=25;
		for(int i = 0; i<qntd;i++) {
			this.pessoas[i] = new JLabel();
			this.pessoas[i].setToolTipText(""+(i+1));
			this.pessoas[i].setHorizontalAlignment(0);
			this.pessoas[i].setIcon(icone.getImgVivo());
			this.pessoas[i].setBounds(x, y, 40, 40);
			if(i<10) x+= 45;
			else if(i<20) y+=45;
			else if(i<30) x-=45;
			else y-=45;
			telaPessoas.add(pessoas[i]);
		}
		
		
	}
	
	public void inserirArma(ImageIcon img) {
		JLabel arma = new JLabel();
		arma.setIcon(img);
		arma.setBounds(255, 245, 60, 60);
		this.telaPessoas.add(arma);
	}
}
