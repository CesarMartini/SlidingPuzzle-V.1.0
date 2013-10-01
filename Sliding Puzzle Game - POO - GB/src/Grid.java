

						/****************************************************************
						 * 																*
						 *		 		  THE GRID - A Digital Frontier					*
						 *																*
						 *																*
						 * 		   Classe para exibi��o do tabuleiro do puzzle.			*
						 * 																*
						 * 																*
						 * 	@author C�sar Martini 										*
						 *	@version 0.7 (alpha);										*
						 *	@category games, college, college homework;					*
						 *																*
						 *																*
						 ****************************************************************/

/*
	NOTAS DO AUTOR:
	
	Conclu�do:
	
		* ?????
		* ?????
	
	Em Desenvolvimento:
	
		* ?????
*/


public class Grid {

	/*-----------------------------------------------------------------------------------------------------------*/
	
	public static void main (String args[]){
		
		//String pal1 = "TRON", pal2="DAFT", pal3="PUNK", pal4="CLU";
		char[] thegrid = {'T','R','O','N','D','A','F','T','P','U','N','K','C','L','U',0};
		int ajuda = 1;
		
		Grid grid = new Grid();
		
		grid.showGrid(thegrid);
		
		if (ajuda == 1) {
			//grid.help(pal1, pal2, pal3, pal4);
			ajuda = 0;
		}
		
		grid.showGrid(thegrid);
		
		if (ajuda == 1) {
			//grid.help(pal1, pal2, pal3, pal4);
			ajuda = 0;
		}
	}
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	public void showGrid (char[] grid) {
		
		// M�todo utilizado para montar o tabuleiro com a localiza��o atual das pe�as, recebendo a matriz com as mesmas.
		
		int i, j, k;
		
		i = 0;
		j = 0;
		k = 0;
		
		System.out.print("\n\n\t");
		
		// La�o de Repeti��o para gerenciamento das quatro linhas...
		for (i=0; i<4; i++){
			
			// La�o de Repeti��o para gerenciamento das quatro colunas...
			for (k=0; k<4; k++){
				
				// Verifica��o para impress�o das letras do array
				if (grid [j] != 0){
					
					// Impress�o das Letras...
					System.out.print("\t " + grid [j] + " \t ");
					
					// Impress�o do Separador...
					if ((j + 1)%4 != 0){
						System.out.print("\u00A6 ");
					}
					
				}else{
					
					//Impress�o do Espa�o em branco...
					System.out.print("\t    \t");
					// Impress�o do Separador...
					if ((j + 1)%4 != 0){
						System.out.print(" \u00A6 ");
					}
				}
				
				j++;
			}
			
			if (i != 3){
				System.out.print("\n\t  ---------------------------------------------------------------\n\t");
			}
		
		}
		
		System.out.println("\n\n");
		
	}
	
/*
	
	public void help (String p1, String p2, String p3, String p4){
		
		System.out.print("\n\t  ------- DICAS -------\n");
		System.out.print("\n\t  Palavra 1 - " + p1 );
		System.out.print("\n\t  Palavra 2 - " + p2 );
		System.out.print("\n\t  Palavra 3 - " + p3 );
		System.out.print("\n\t  Palavra 4 - " + p4 );
		System.out.print("\n\n\t  ---------------------\n\n");
	}
*/

}
