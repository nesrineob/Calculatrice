public class Calcul 
{
	private double resultat;
	
	public Calcul()                    { this.resultat = 0.0;  }
	
	public void reset()                { this.resultat = 0.0;  }
	
	public void addition    (double x) { this.resultat += x;   }
	
	public void soustraction(double x) { this.resultat -= x;   }
	
	public void multiplication(double x) 
	{  
		if( this.resultat == 0.0) { this.addition(x); }
		
		else
			this.resultat = this.resultat * x;
			
	}
	
	public String getResultat()   { return Double.toString(resultat); }
	
}
	