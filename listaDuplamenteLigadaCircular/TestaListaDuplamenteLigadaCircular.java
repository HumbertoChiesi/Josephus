package listaDuplamenteLigadaCircular;

import javax.swing.JOptionPane;
class TestaListaDuplamenteLigadaCircular {
    public static void main(String[] args) {                             // make a new list
        IListaDuplamenteLigadaCircular l = new ListaDuplamenteLigadaCircular();

 
        l.inserirFim("Ze");
        mostrarLista(l);
        l.inserirFim(11);
        mostrarLista(l);
        l.inserirInicio(22);
        mostrarLista(l);
        l.inserirFim("Julio");
        mostrarLista(l);
        l.inserirFim(33);
        mostrarLista(l);
        System.out.println("Removeu do inicio: " + l.removerInicio());
        mostrarLista(l);
        System.out.println("Removeu do fim: " + l.removerFim());
        mostrarLista(l);
        System.out.println("Removeu do fim: " + l.removerFim());
        mostrarLista(l);
        System.out.println("Remover do inicio: " + l.removerInicio());
        mostrarLista(l);
        System.out.println("Removeu do fim: " + l.removerFim());
        mostrarLista(l);
        System.out.println("Remover do inicio: " + l.removerInicio());
        mostrarLista(l);
        System.out.println("Removeu do fim: " + l.removerFim());
        mostrarLista(l);
        l.inserirInicio(444);
        mostrarLista(l);
        l.inserirInicio(555);
        mostrarLista(l);
    }

    /**
     * Metodo mostrarLista
     *
     * @param l lista ligada
     */
    public static void mostrarLista(IListaDuplamenteLigadaCircular l){
        // Mostra lista no terminal
        System.out.println(l);
        System.out.println(l.toStringDoFim());
        
        // Mostra lista numa janela
        JOptionPane.showMessageDialog(null, l);
    }
}

