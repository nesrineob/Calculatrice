public class Calcul 
{
	private double resultat;
	
	public Calcul()                    { this.resultat = 0.0;  }
	
	public void reset()                { this.resultat = 0.0;  }
	
	public void addition    (double x, double y)   { this.resultat = x + y;     }
	
	public void soustraction(double x, double y)   { this.resultat = x - y;     }
	
	public void multiplication(double x, double y) { this.resultat = y * x; 	}
	
	public String getResultat()   { return Double.toString(resultat); }
	
}
	