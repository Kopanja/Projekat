package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.KonkretnaTura;

public class KonkretnaTuraGui extends JPanel {

	private BufferedImage slika;
    private JButton rezervisi;
    private JButton otkazi;
    private JLabel datumPocetka;
    private JLabel datumZavrsetka;
    private JLabel slLabel;
    private JTextArea opis;
    private KonkretnaTura konkretnaTura;
    
    
	public KonkretnaTuraGui(KonkretnaTura t){ //arg Tura t
		this.konkretnaTura = t;
		this.setLayout((new BoxLayout(this, BoxLayout.LINE_AXIS)));
	    this.setAlignmentX(Component.LEFT_ALIGNMENT);
	    this.setBackground(Color.white);
		
	    try {
			slika = ImageIO.read(new File("res/slika1.jpg"));//t.getSlika
		} catch (IOException e) {
			e.printStackTrace();
		}
	    rezervisi = new JButton("Rezervisi");
	    slLabel = new JLabel(new ImageIcon(slika)); 
	    opis = new JTextArea();
	    opis.setMaximumSize(new Dimension(700,50));
	    opis.setLineWrap(true);
	    opis.setEditable(false);
	    opis.setText("23.4.2016 - 25.4.2016 " + "\n" + "NAPOMENE: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"); 
	  //t.getDatumPoc + "-" + t.getDatumZavr + "\n" + "NAPOMENE: " + t.getOpis/Napo
	    this.add(slLabel);
	    this.add(Box.createRigidArea(new Dimension(50,0)));
	    this.add(opis);
	    this.add(Box.createRigidArea(new Dimension(50,0)));
	    
	    
	}
	public KonkretnaTura getKonkretnaTura(){
		return this.konkretnaTura;
	}
	public void setKonkretnaTura(KonkretnaTura t){
		this.konkretnaTura = t;
	}
	public void addReservationListener(ActionListener al){
		rezervisi.addActionListener(al);
		this.add(rezervisi);
	}
	public void addCancelReservetionListener(ActionListener al){
		otkazi.addActionListener(al);
		this.add(otkazi);
	}
}
