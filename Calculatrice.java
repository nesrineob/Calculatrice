import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//test

@SuppressWarnings("serial")
public class Calculatrice extends JFrame implements ActionListener
{
	
	private final  int           GAP              = 10 ; // constante pour l'écrat entre les touches
	
	private		   String        s                = "" ; // va contenir la saisie de l'utilisateur
	private        Calcul        c                     ; // va gérer les calculs
	private        String        derniereOperation     ; 
	private        double        premierTerme     = 0.0;
	private        double        secondTerme      = 0.0;
	private        Double        tempDouble            ;


	private JLabel ecran;
	
	private JButton useless1;
	private JButton useless2;
	private JButton useless3;
	private JButton effacer ; 
	
	//Chiffres
	private JButton un     ;
	private JButton deux   ;
	private JButton trois  ; 
	private JButton quatre ;
	private JButton cinq   ;
	private JButton six    ;
	private JButton sept   ;
	private JButton huit   ;
	private JButton neuf   ;
	private JButton zero   ;
	private JButton virgule;
	private JButton easter ;

	//Signes
	private JButton plus ;
	private JButton moins;
	private JButton egal ;
	private JButton fois ;

	//JPanels
	private JPanel saisie ;    //contient uniquement "l'écran"
	private JPanel touches;    //contient toutes les touches. possède un GridLayout 4*3
	private JPanel signes;     //contient les signes. possède un GridLayout 4*1
  


	public Calculatrice()
	{
		setSize(300, 400);
		
		//Instanciation
		c          = new Calcul();
		
		ecran   = new JLabel("Hello World !");
		
		ecran.setToolTipText("C'EST ICI QUE S'AFFICHE CE TU TAPES ! ");
		
		useless1 = new JButton("");
		useless2 = new JButton("");
		useless3 = new JButton("");
		
		effacer  = new JButton("C");

		un      = new JButton("1");
		deux    = new JButton("2");
		trois   = new JButton("3"); 
		quatre  = new JButton("4");
		cinq    = new JButton("5");
		six     = new JButton("6");
		sept    = new JButton("7");
		huit    = new JButton("8");
		neuf    = new JButton("9");
		zero    = new JButton("0");
		virgule = new JButton(".");
		easter  = new JButton("(:");
		easter.setToolTipText("A quoi peut bien servir ce bouton...?");

		//Signes
		plus  = new JButton("+");
		moins = new JButton("-");
		egal  = new JButton("=");
		fois  = new JButton("*");
		
		egal.setToolTipText("Pour afficher le resultat peut être ?");

		saisie  = new JPanel();
		touches = new JPanel( new GridLayout(5, 3, GAP, GAP) );
		signes  = new JPanel( new GridLayout(6, 1, GAP, GAP) );

		setLayout( new BorderLayout() );

		
		this.ajouterSignes();
		add(signes, "East");

		saisie.add(ecran);
		add(saisie,  "North");
		
		
		this.ajouterChiffres();

		add(touches, "Center");
		
		this.ajouterListener();
		
		setVisible(true);

		setTitle("Calculatrice");
	}

	private void changerTaille(ActionEvent e)
	{
		
		
		if(e.getSource() == easter)
		{
			Double d = new Double(s);
			int temp = d.intValue();
			this.setSize(temp, temp);
		}
	}
	
	
	private void ajouterChiffres()
	{
		//touches.add(useless1);
		//touches.add(useless2);
		//touches.add(useless3);
		touches.add(un);
		touches.add(deux);
		touches.add(trois);
		touches.add(quatre);
		touches.add(cinq);
		touches.add(six);
		touches.add(sept);
		touches.add(huit);
		touches.add(neuf);
		touches.add(easter);
		touches.add(zero);
		touches.add(virgule);
	}

	private void ajouterSignes()
	{
		signes.add(effacer);
		signes.add(plus);
		signes.add(moins);
		signes.add(fois);
		signes.add(egal);
	}

	private void ajouterListener()
	{
		un.addActionListener( this );
		deux.addActionListener(this);
		trois.addActionListener(this); 
		quatre.addActionListener(this);
		cinq.addActionListener(this);
		six.addActionListener(this);
		sept.addActionListener(this);
		huit.addActionListener(this);
		neuf.addActionListener(this);
		zero.addActionListener(this);
		virgule.addActionListener(this);
		easter.addActionListener(this);
		
		//Signes
		plus.addActionListener(this);
		moins.addActionListener(this);
		egal.addActionListener(this);
		fois.addActionListener(this);
		effacer.addActionListener(this);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		this.gestionChiffre(e);
		
		this.gestionSignes(e);		
		
		this.gestionEgal(e);
		
		this.changerTaille(e);
		
	}
	
	private void gestionSignes(ActionEvent e)
	{
		
		
		if(e.getSource() == plus)
		{
			derniereOperation = "plus";
			premierTerme      = Double.parseDouble( s.toString()); 
			s = "";
		}		
		
		if(e.getSource () == moins)
		{
			derniereOperation = "moins";
			premierTerme      = Double.parseDouble( s.toString()); 
			s = "";
		}		
		
		if(e.getSource() == fois)
		{
			derniereOperation = "fois"; 
			premierTerme      = Double.parseDouble( s.toString()); 

			s = "";
		}		
		
		if(e.getSource() == effacer)
		{		
			c.reset();
			s = "";			
			ecran.setText("Hello World !");
		}
	}
			
	
	private void gestionChiffre(ActionEvent e)
	{
		if(e.getSource() == un)
			s += "1";
			ecran.setText( s.toString() );
			
		if(e.getSource() == deux)
			s += "2";
			ecran.setText( s.toString() );
		
		if(e.getSource() == trois)
			s += "3";
			ecran.setText( s.toString() );
		
		if(e.getSource() == quatre)
			s += "4";
			ecran.setText( s.toString() );
		
		if(e.getSource() == cinq)
			s += "5";
			ecran.setText( s.toString() );
			
		if(e.getSource() == six)
			s  += "6";
			ecran.setText( s.toString() );
			
		if(e.getSource() == sept)
			s += "7";
			ecran.setText( s.toString() );
			
		if(e.getSource() == huit)
			s += "8";;
			ecran.setText( s.toString() );
		
		if(e.getSource() == neuf)
			s += "9";
			ecran.setText( s.toString() );
		
		if(e.getSource() == zero)
			s += "0";
			ecran.setText( s.toString() );
			
		if(e.getSource() == virgule)
			if(s.contains(".")) { System.out.println(""); }
			 
			else s += "."; 
			
			ecran.setText( s.toString() );
	}

	private void gestionEgal(ActionEvent e)
	{
		if(e.getSource() == egal)
		{			
			secondTerme = Double.parseDouble( s.toString()); 
			
			if(derniereOperation == "plus")
				c.addition( premierTerme, secondTerme );
			
			if(derniereOperation == "moins")
				c.soustraction( premierTerme, secondTerme );	
			if(derniereOperation == "fois")
				c.multiplication( premierTerme, secondTerme );
			
			
			tempDouble = new Double(c.getResultat() );
			
			ecran.setText( String.valueOf(tempDouble.intValue() ) );
		}
	}
	
	public static void main(String[] args) 
	{
		new Calculatrice();	
	}

	
}