//Humberto Chiesi Neto RA00277882

package imagens;

import javax.swing.ImageIcon;

public class josephusImg {
	static ImageIcon imgVivo = new ImageIcon("img/vivo2.png");
	static ImageIcon imgMorto = new ImageIcon("img/morto2.png");
	static ImageIcon imgSobreviveu = new ImageIcon("img/sobreviveu.png");
	static ImageIcon imgArmaAntes = new ImageIcon("img/armaAntes.png");
	static ImageIcon imgArmaDepois = new ImageIcon("img/armaDepois.png");
	
	public josephusImg() {}
	
	public ImageIcon getImgVivo() {return josephusImg.imgVivo;}
	
	public ImageIcon getImgMorto(){ return josephusImg.imgMorto; }
	
	public ImageIcon getImgSobreviveu() {return josephusImg.imgSobreviveu;}
	
	public ImageIcon getImgArmaAntes() {return josephusImg.imgArmaAntes;}
	
	public ImageIcon getImgArmaDepois() {return josephusImg.imgArmaDepois;}
}