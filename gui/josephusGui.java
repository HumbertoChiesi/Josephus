package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import imagens.josephusImg;
import listaDuplamenteLigadaCircular.ListaDuplamenteLigadaCircular;
import listaDuplamenteLigadaCircular.No;

public class josephusGui extends JFrame implements ActionListener{
	Container painelPrincipal = this.getContentPane();
	pessoasGui pGui = null;
	entradasGui eGui = null;
	josephusImg icone = new josephusImg();
	josephusGui.atualizadorGui att;
	int qntdPessoas;
	int intervalo;
	int tempoEspera;
	ListaDuplamenteLigadaCircular listaPessoas = null;
	
	public josephusGui(int qntdPessoas, int intervalo, int tempoEspera) {
		super("Algoritmo Josephus");	
		this.setSize(561, 861);
		this.setResizable(false);
		this.setDefaultCloseOperation(3);
		this.qntdPessoas = qntdPessoas;
		this.intervalo = intervalo;
		this.tempoEspera = tempoEspera;
		this.pGui = new pessoasGui(qntdPessoas, this);
		this.eGui = new entradasGui(qntdPessoas, intervalo, tempoEspera, this);
		this.listaPessoas = new ListaDuplamenteLigadaCircular();
		criarListaPessoas(qntdPessoas);
	}
	
	public void mostrarGui() {
		this.eGui.inserirLabelsEntradas();
		this.pGui.inserirLabelsPessoas(this.qntdPessoas, icone.getImgArmaAntes());
		this.eGui.inserirLabelsEntradasBttn();
		this.pack();
		this.setVisible(true);
	}
	
	private void criarListaPessoas(int qntd) {
		for(int i = 1; i<=qntd; i++) {
			this.listaPessoas.inserirFim(i);
			listaPessoas.getFim().setId(i);
		}
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
        if (comando.equals("Sair")) {
            System.exit(0);
        } else if (comando.equals("Iniciar")) {
        	iniciar();
        } else if (comando.equals("Reiniciar")) {
        	reiniciar();
        }
	}
	
	private void iniciar() {
		try {
			int nSoldados = Integer.parseInt(eGui.lbTxtNsoldados.getText());
			int intervalo = Integer.parseInt(eGui.lbTxtIntervalo.getText());
			int tempo = Integer.parseInt(eGui.lbTxtTempoEspera.getText());
			if(nSoldados > 1 && nSoldados < 41 && intervalo < nSoldados && intervalo > 1 && tempo > 0) {
				atualizarIniciar(nSoldados, intervalo, tempo);
				att = new atualizadorGui();
				att.start();
			} else {
				JOptionPane.showMessageDialog(null, "Numero de Soldados 1-40\nIntervalo <"+nSoldados+"\nTempo de espera > 0", "Erro", 0);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Algum dos valores digitados nao eh um numero", "Erro", 0);
		}			
	}
	
	private void atualizarIniciar(int qntd, int intervalo, int tempo) {
		this.qntdPessoas = qntd;
		this.intervalo = intervalo;
		this.tempoEspera = tempo;
		this.pGui.inserirLabelsPessoas(qntd, icone.getImgArmaDepois());
		listaPessoas.limparLista();
		criarListaPessoas(qntd);
		this.eGui.lbTxtNsoldados.setEnabled(false);
		this.eGui.lbTxtIntervalo.setEnabled(false);
		this.eGui.lbTxtTempoEspera.setEnabled(false);
		this.eGui.lbPessoa.setVisible(true);
		this.eGui.lbPessoaValor.setVisible(true);
		this.eGui.iniciar.setEnabled(false);
		this.eGui.reiniciar.setEnabled(false);
	}
	
	private void reiniciar() {
		pGui.inserirLabelsPessoas(this.qntdPessoas, icone.getImgArmaAntes());
		eGui.iniciar.setEnabled(true);
		eGui.reiniciar.setEnabled(false);
		eGui.lbPessoa.setVisible(false);
		eGui.lbPessoaValor.setVisible(false);
		eGui.lbTxtNsoldados.setEnabled(true);
		eGui.lbTxtIntervalo.setEnabled(true);
		eGui.lbTxtTempoEspera.setEnabled(true);
	}
	
	private class atualizadorGui extends Thread{
		public void run() {
			this.algoritmoJosephus(josephusGui.this.qntdPessoas, josephusGui.this.intervalo);
		}
		
		public void algoritmoJosephus(int qntdPessoas, int intervalo){
			int i = 1;
			int chave, sobrevivente;
			No aux = josephusGui.this.listaPessoas.getInicio();
			
			while(qntdPessoas>1) {
				if(i == intervalo) {
					chave = (int) aux.getConteudo();
					aux = aux.getProximo();
					josephusGui.this.listaPessoas.remover(chave);
					pGui.pessoas[chave-1].setIcon(icone.getImgMorto());
					eGui.lbPessoaValor.setText(""+chave);
					josephusGui.this.repaint();
					
					try {
                        Thread.sleep((long)josephusGui.this.tempoEspera);
                    } catch (InterruptedException var10) {
                        System.out.println("ERRO INESPERADO");
                        System.exit(0);
                    }

					
					i = 1;
					qntdPessoas--;
				} else {
					aux = aux.getProximo();
					i++;
				}
			}
			
			sobrevivente = (int)josephusGui.this.listaPessoas.getInicio().getConteudo();
			pGui.pessoas[sobrevivente-1].setIcon(icone.getImgSobreviveu());
			eGui.lbPessoa.setText("Numero pessoa que sobreviveu: ");
			eGui.lbPessoaValor.setText(""+sobrevivente);
			eGui.reiniciar.setEnabled(true);
		}
	}

}
