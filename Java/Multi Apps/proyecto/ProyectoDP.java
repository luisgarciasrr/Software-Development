public class ProyectoDP
{
	//Variables declaration
	private int a,b,c;
    private float x, x1, x2, radical;
	
	public String exp(int x, int y)
	{
		String resultado="";
		int lim,c;
		lim = y;
		c = x*x;
		
		for(int i=1;i!=lim-1;i++){
			c = c*x;
		}
		
		resultado = "El resultado de elevar " + x + " a la " + y + " potencia es " + c + "\n";
		return resultado;
	}
	
	public String fac(int x)
	{
		String resultado="";
		int limite=1,cop,total=1;
		cop=x;
		
		do
		{
			total = total * cop;
			cop--;
		}while(cop != limite);
		
		resultado = "El resultado de " + x + "! es " + total + "\n";
		return resultado;
	}
	
	public String calcularRaices(int a,int b,int c)
    {
        String resultadoCalculo="";
        
        if(a == 0)
        {
            if(b == 0)
            {
                resultadoCalculo = "No existe la ecuacion ...";
            }
            
            else
            {
                x = -(float)c/b;
                resultadoCalculo = "Ecuacion Lineal X = "+x;
            }
        }
        else
        {
            radical = b*b - (4*a*c);
            
            if(radical < 0)
            {
                resultadoCalculo = "Raices Imaginarias...";
            }
            
            else
            {
                x1 = (-b + (float)Math.sqrt(radical)) / (2*a);
                x2 = (-b - (float)Math.sqrt(radical)) / (2*a);
                resultadoCalculo = "Raices Reales\n X1 = "+x1+"\n X2 = "+x2;
            }
        }
        return resultadoCalculo;
    }
    
  public String dcf(float x)
  {
  	String resultado="";
  	float total;
  	
  	total = (x*9/5)+32;
  	resultado = x + " °C equivalen a " + total + "°F\n";
  	return resultado;
  }  
  	
  	public String dfc(float x)
  {
  	String resultado;
  	float total;
  	
  	total = (x-32)* 5/9;
  	resultado = x + " °F equivalen a " + total + "°C\n";
  	return resultado;
  }  
  	
  	public String tab(int x)
  {
  		int total;
		String resultado="";
		
		for(int i = 1 ; i <= 10 ; i++){
			total = x * i;
			resultado = resultado + i + "*" + x + "=" + total +"\r\n"  ;
			resultado = resultado;
		}
  	return resultado;
  }
}