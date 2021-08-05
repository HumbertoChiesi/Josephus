package gui;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class entradasGui {
	JFrame telaPrincipal = null;
	Container entradasPainel = new JPanel();
	Container entradasBttnPainel = new JPanel();
	JLabel lbNsoldados = null;
    JTextField lbTxtNsoldados = null;
    JLabel lbIntervalo = null;
    JTextField lbTxtIntervalo = null;
    JLabel lbTempoEspera = null;
    JTextField lbTxtTempoEspera = null;
    JLabel lbPessoa = null;
    JLabel lbPessoaValor = null;
    JButton iniciar = null;
    JButton reiniciar = null;
    JButton sair = null;
    int qntdPessoas;
    int intervalo;
    int tempoEspera;
    
    public entradasGui(int qntd, int intervalo, int tempoEspera, JFrame telaPrincipal) {
    	this.telaPrincipal = telaPrincipal;
    	this.qntdPessoas = qntd;
    	this.intervalo = intervalo;
    	this.tempoEspera = tempoEspera;
    }
    
    public void inserirLabelsEntradas() {
		lbNsoldados = new JLabel("Qntd. pessoas(1-40)");
		lbTxtNsoldados = new JTextField("" + this.qntdPessoas);
		lbTxtNsoldados.setColumns(4);
		lbTxtNsoldados.setEnabled(true);
		lbIntervalo = new JLabel("Intervalo (2-"+ (this.qntdPessoas-1) + ")");
		lbTxtIntervalo = new JTextField("" + this.intervalo);
		lbTxtIntervalo.setColumns(4);
		lbTxtIntervalo.setEnabled(true);
		lbTempoEspera = new JLabel("Tempo de espera (>1)");
		lbTxtTempoEspera = new JTextField(""+ this.tempoEspera);
		lbTxtTempoEspera.setColumns(4);
		lbTxtTempoEspera.setEnabled(true);
		
		
		
		entradasPainel.add(lbNsoldados);
		entradasPainel.add(lbTxtNsoldados);
		entradasPainel.add(lbIntervalo);
		entradasPainel.add(lbTxtIntervalo);
		entradasPainel.add(lbTempoEspera);
		entradasPainel.add(lbTxtTempoEspera);
		telaPrincipal.add("North", entradasPainel);
	}
    
    public void inserirLabelsEntradasBttn() {
		lbPessoa = new JLabel("Numero pessoa executada: ");
		lbPessoa.setVisible(false);
		lbPessoaValor = new JLabel(" ");
		lbPessoaValor.setVisible(false);
		iniciar = new JButton("Iniciar");
		iniciar.addActionListener((ActionListener)this.telaPrincipal);
		reiniciar = new JButton("Reiniciar");
		reiniciar.addActionListener((ActionListener)this.telaPrincipal);
		sair = new JButton("Sair");
		sair.addActionListener((ActionListener)this.telaPrincipal);
		
		entradasBttnPainel.add(lbPessoa);
		entradasBttnPainel.add(lbPessoaValor);
		entradasBttnPainel.add(iniciar);
		entradasBttnPainel.add(reiniciar);
		entradasBttnPainel.add(sair);
		telaPrincipal.add("South", entradasBttnPainel);
	}
}
