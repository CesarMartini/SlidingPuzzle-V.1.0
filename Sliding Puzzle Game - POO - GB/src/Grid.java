

						/****************************************************************
						 * 																*
						 *		 		  THE GRID - A Digital Frontier					*
						 *																*
						 *																*
						 * 		   Classe para exibição do tabuleiro do puzzle.			*
						 * 																*
						 * 																*
						 * 	@author César Martini 										*
						 *	@version 0.7 (alpha);										*
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
		
		// Método utilizado para montar o tabuleiro com a localização atual das peças, recebendo a matriz com as mesmas.
		
		int i, j, k;
		
		i = 0;
		j = 0;
		k = 0;
		
		System.out.print("\n\n\t");
		
		// Laço de Repetição para gerenciamento das quatro linhas...
		for (i=0; i<4; i++){
			
			// Laço de Repetição para gerenciamento das quatro colunas...
			for (k=0; k<4; k++){
				
				// Verificação para impressão das letras do array
				if (grid [j] != 0){
					
					// Impressão das Letras...
					System.out.print("\t " + grid [j] + " \t ");
					
					// Impressão do Separador...
					if ((j + 1)%4 != 0){
						System.out.print("\u00A6 ");
					}
					
				}else{
					
					//Impressão do Espaço em branco...
					System.out.print("\t    \t");
					// Impressão do Separador...
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
