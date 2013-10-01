

						/****************************************************************
						 * 																*
						 *		 		    "In the end, there can be 			 		*
						 *						   ONLY ONE !"							*
						 *																*
						 *																*
						 * 		   Classe para verificar a vitória do Puzzle			*
						 * 				    											*
						 * 																*
						 * 	@author César Martini; 										*
						 *	@version 0.5 (alpha);										*
						 *	@category games, college, college homework;					*
						 *																*
						 *																*
						 ****************************************************************/

/*
	NOTAS DO AUTOR:
	
	Concluído:
	
		* ?????
		* ?????
	
	Em Desenvolvimento:
	
		* ?????
*/


public class Victory {

	/* Módulo Main para realizar testes no interior da classe
	public static void main(String[] args) {
		
		int dica = 1;
		
		String name = "César";
		
		Victory victory = new Victory();
		Play play = new Play();
		char [] array = {'T','R','O','N','D','A','F','T','P','U','N','K','C','L',0,'U'};
		char [] p1 = {'T','R','O','N'};
		char [] p2 = {'D','A','F','T'};
		char [] p3 = {'P','U','N','K'};
		char [] p4 = {'C','L','U'};
		
		Grid grid = new Grid();
		grid.showGrid(array);
		play.verifica(array);
		victory.win (array, p1, p2, p3, p4, dica, name);
	}*/
	private int novaP = 0;
	
	public int getnovaP() {
		return novaP;
	}

	public void setnovaP(int novaP) {
		this.novaP = novaP;
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public int win (char[] v, String[] p, String nome){
		
		/* Declaração de flags */
		int fu=0, fd=0, ft=0, fq=0, venceu=0;
		
		/* Palavras */
		char[] u = new char [4];
		char[] d = new char [4];
		char[] t = new char [4];
		char[] q = new char [3];
		
		/* Atribuição */
		u = p[0].toCharArray();
		d = p[1].toCharArray();
		t = p[2].toCharArray();
		q = p[3].toCharArray();
		
		
		/* Contador de Palavras Montadas */
		int cont = 0;
		
		/* Obtenção dos valores das flags*/
		fu = captureTheFlag(v,u);
		fd = captureTheFlag(v,d);
		ft = captureTheFlag(v,t);
		fq = captureTheFlag(v,q);
		
		
		if (fu==4){
			cont++;
		}
		if (fd==4){
			cont++;
		}
		if (ft==4){
			cont++;
		}
		if (fq==3){
			cont++;
		}
		
		
		if (fu+fd+ft+fq==15){
			/* Mensagem Legal Anunciando a Vitória do Jogador x */ 
			System.out.print("\n\n\n#-----------------------------------------------------------------------------#\n");
			System.out.print("\n\t\t  _____                _       __           _	  "); 
			System.out.print("\n\t\t |  __ \\              | |     /_/          | |	  ");
			System.out.print("\n\t\t | |__) |_ _ _ __ __ _| |__   ___ _ __  ___| |	  ");
			System.out.print("\n\t\t |  ___/ _` | '__/ _` | '_ \\ / _ \\ '_ \\/ __| | ");
			System.out.print("\n\t\t | |  | (_| | | | (_| | |_) |  __/ | | \\__ \\_|  ");
			System.out.print("\n\t\t |_|   \\__,_|_|  \\__,_|_.__/ \\___|_| |_|___(_) ");
			System.out.print("\n\n\n#-----------------------------------------------------------------------------#");
			System.out.print("\n\n                         Parabéns, " + nome + ", você VENCEU !!!                ");
			System.out.print("\n\n#-----------------------------------------------------------------------------#\n");
			venceu = 1;
		}else{
			// Imprime quantidade de palavras montadas com sucesso, caso haja mudanças no cont.
			if (cont>getnovaP()){
				System.out.println("\n\n\t Já foram montadas " + cont + " palavras! \n\n");
				setnovaP(cont);
			}else if (cont<getnovaP()){
				System.out.println("\n\n\t Agora apenas " + cont + " palavras foram montadas. \n\n");
				setnovaP(cont);
			}
		}
		
		return venceu;
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	private int captureTheFlag(char[] array, char[]palavra){
		
		int i=0, j=0;
		
		
		int flag=0;
		
		/*Laços para verificar palavras*/
		if((palavra.length)==4){
			
			for (i=0;i<12;i=i+4){
				
				for (j=0;j<4;j++){
					/* Se as letras forem iguais*/
					if((array[j+i])==(palavra[j])){
						
						flag++;
						if (flag==4){
							return flag;
						}
					}
				}
				
				flag = 0;
			}
			
		}else if((palavra.length)==3){
			
			for(i=0; i<3; i++){
				
				if((array[i+12])==(palavra[i])){
					
					flag++;
					if (flag==3){
						return flag;
					}
				}
			}
			flag=0;
			
		}else{
			
			System.out.println("ERRO!");
		}
		
		return flag;
	}

}


/*
 * 		Verificação - Lógica
 * 
 *   0  -  1  -  2  -  3 	Palavras de 4 letras
 *  
 *   4  -  5  -  6  -  7	Palavras de 4 letras
 *  
 *   8  -  9  -  10 -  11 	Palavras de 4 letras
 * 
 * 
 * 	 12 -  13 -  14 		Palavra de 3 letras
 */