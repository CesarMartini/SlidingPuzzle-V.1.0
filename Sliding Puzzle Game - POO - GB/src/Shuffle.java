

						/****************************************************************
						 * 																*
						 *		 		   Every Day I'm Shuffling  			 		*
						 *				     http://z0r.de/3714							*
						 *																*
						 *																*
						 * 		   Classe para embaralhar as palavras do Puzzle			*
						 * 				    											*
						 * 																*
						 * 	@author César Martini; 										*
						 *	@version 1.0 (Beta);										*
						 *	@category games, college, college homework;					*
						 *																*
						 *																*
						 ****************************************************************/

/*
	NOTAS DO AUTOR:
	
	Concluído:
	
		* Leitura das palavras concluída -- Diferencia palavras de 3 e 4 letras;
		* Realiza verificação do comprimento das palavras cadastradas;
	
	Em Desenvolvimento:
	
		* Talvez deveria ser adicionada uma verificação de espaços e números nas palavras do puzzle. Ou não. (Verificar);
		* Gravação das palavras em documento externo - XML.
		* Leitura das palavras cadastradas salvas no documento.
		* 
*/

import java.util.Random;

public class Shuffle {

	
	public static void main(String[] args) {

		Shuffle shuffling = new Shuffle();
		Grid grid = new Grid();
		
		char [] array = {'T','R','O','N','D','A','F','T','P','U','N','K','C','L','U',0};
		
		array = shuffling.Shuffling(array);
		
		grid.showGrid(array);
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public char[] Shuffling (char[] a) {
		
		// Inteiros para servir de índice e flag.
		int i = 0;
		int soma = 0;
		int num = 0;
		
		// Instância para utilização da classe java.util.Random
		Random gerador = new Random();
		
		// Array Verificador para garantir que, ao menos uma vez, todas as posições foram embaralhadas.
		int [] verifica = new int[16];
		
		for (i=0; i<16; i++){
			// Zerando posições do Array...
			verifica[i] = 0;
		}
		
		do {
			
			// Obtém um número entre 0 e 15
			num = gerador.nextInt(16);
			
			// Método para embaralhar...
			
			a = embaralha (num, a);
			
			// Determina que a posição já foi embaralhada ao menos uma vez.
			if (verifica[num]==0){
				verifica[num] = 1;
			}
			
			// Verifica se todas as posições foram embaralhadas.
			soma = 0;
			
			for (i=0; i<16; i++){
				soma = verifica[i] + soma;
			}
			
		}while (soma!=16);
		
		
		/* Retorna o array embaralhado e pronto para jogar */
		return a;
		
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	private char[] embaralha(int n, char[] b){
		
		int logica = 0;
		char auxx = '0', auxy = '0';
		
		// Determina qual lógica deve ser aplicada, com base na posição.
		
		switch (n){
		
			case (15):
					  logica = 4;
				break;
				
			case (14):
				      /*logica = 9;*/
				break;
				
			case (13):
				      /*logica = 9;*/
				break;
				
			case (12):
				      logica = 3;
				break;
			
			case (11):
				      /*logica = 6;*/
				break;
			
			case (10):
				      logica = 9;
				break;
				
			case (9):
			      	  logica = 9;
				break;
				
			case (8):
			      	  /*logica = 5;*/
				break;
			
			case (7):
		      	      logica = 6;
				break;
			
			case (6):
		      	      logica = 9;
				break;
			
			case (5):
		      	  	  logica = 9;
				break;
				
			case (4):
		      	      logica = 5;
				break;
			
			case (3):
		      	      logica = 2;
				break;
			
			case (2):
		      	  	  logica = 9;
				break;
			
			case (1):
		      	  	  logica = 9;
				break;
			
			case (0):
		      	  	  logica = 1;
				break;
			
			/* Apresenta Mensagem de Erro */
			 default:
				 	  System.out.println("\n\n\n\t\t   E R R O ! ! ! \n");
				break;
		}
		
		
		if (logica != 0) {
			
			// Aplica a lógica determinada.
			switch (logica){
			
				case (9):
						  /*Guradando Valor da primeira Posição Subsequente*/
						  auxx = b[n+1];
						 
						  /*Guradando Valor da segunda Posição Subsequente*/
						  auxy = b[n+5];
						  
						  /* Passagem da primeira Posição */
						  b[n+1] = b[n];
						  
						  /* Passagem da segunda Posição */
						  b[n+5] = auxx;
						  
						  /* Guardando Valor da terceira Posição Subsequente*/
						  auxx = b[n+4];
						  
						  /* Passagem da terceira Posição */
						  b[n+4] = auxy;
						   
						  /* Guardando Valor da quarta Posição Subsequente*/
						  auxy = b[n+3];
						  
						  /* Passagem da quarta Posição */
						  b[n+3] = auxx;
						  
						  /* Guardando Valor da quinta Posição Subsequente*/
						  auxx = b[n-1];
						  
						  /* Passagem da quinta Posição */
						  b[n-1] = auxy;
						  
						  /* Passagem da sexta Posição */
						  b[n] = auxx;
						  
						  /* Logica de Embaralhamento 9 Concluída! */
					break;
					
				/*
				case 7 e 8:
						   Não é necessario implementar. Para maiores explicações, visualizar no final do arquivo.
				*/
					
				case (6):
					 	  /*Guradando Valor da primeira Posição Subsequente*/
					 	  auxx = b[n+4];
					
					 	  /*Guradando Valor da segunda Posição Subsequente*/
					 	  auxy = b[n+8];
					 
					 	  /* Passagem da primeira Posição */
					 	  b[n+4] = b[n];
					 
					 	  /* Passagem da segunda Posição */
					 	  b[n+8] = auxx;
					 
					 	  /* Guardando Valor da terceira Posição Subsequente*/
					 	  auxx = b[n+7];
					 
					 	  /* Passagem da terceira Posição */
					 	  b[n+7] = auxy;
					 
					 	  /* Guardando Valor da quarta Posição Subsequente*/
					 	  auxy = b[n+3];
					 
					 	  /* Passagem da quarta Posição */
					 	  b[n+3] = auxx;
					 
					 	  /* Guardando Valor da quinta Posição Subsequente*/
					 	  auxx = b[n-1];
					 
					 	  /* Passagem da quinta Posição */
					 	  b[n-1] = auxy;
					 
					 	  /* Passagem da sexta Posição */
					 	  b[n] = auxx;
					 
					 	  /* Logica de Embaralhamento 6 Concluída! */
					break;
					
				case (5):
						  /*Guradando Valor da primeira Posição Subsequente*/
				 	  	  auxx = b[n+1];
						  
						  /*Guradando Valor da segunda Posição Subsequente*/
				 	  	  auxy = b[n+5];
				 	  	  	
				 	  	  /* Passagem da primeira Posição */
				 	  	  b[n+1] = b[n];
				 	  	  
				 	  	  /* Passagem da segunda Posição */
				 	  	  b[n+5] = auxx;
				 	  	  
				 	  	  /* Guardando Valor da terceira Posição Subsequente*/
				 	  	  auxx = b[n+9];
				 	  	  
				 	  	  /* Passagem da terceira Posição */
				 	  	  b[n+9] = auxy;
				 	  	  
				 	  	  /* Guardando Valor da quarta Posição Subsequente*/
				 	  	  auxy = b[n+8];
				 	  	  
				 	  	  /* Passagem da quarta Posição */
				 	  	  b[n+8] = auxx;
				 	  	  
				 	  	  /* Guardando Valor da quinta Posição Subsequente*/
				 	  	  auxx = b[n+4];
				 	  	  
				 	  	  /* Passagem da quinta Posição */
				 	  	  b[n+4] = auxy;
				 	  	  
				 	  	  /* Passagem da sexta Posição */
				 	  	  b[n] = auxx;
				 	  	  
				 	  	  /* Logica de Embaralhamento 5 Concluída! */
					break;
					
				case (4):
						  /*Guradando Valor da primeira Posição Subsequente*/
			 	  	  	  auxx = b[n-1];
							  		
					  	  /*Guradando Valor da segunda Posição Subsequente*/
			 	  	  	  auxy = b[n-5];
			 	  	      
			 	  	  	  /* Passagem da primeira Posição */
			 	  	  	  b[n-1] = b[n];
			 	  	  	  
			 	  	  	  /* Passagem da segunda Posição */
			 	  	  	  b[n-5] = auxx;
			 	  	  	  
			 	  	  	  /* Guardando Valor da terceira Posição Subsequente*/
			 	  	  	  auxx = b[n-4];
			 	  	  
			 	  	  	  /* Passagem da terceira Posição */
			 	  	  	  b[n-4] = auxy;
			 	  	  	  
			 	  	  	  /* Passagem da quarta Posição */
				 	  	  b[n] = auxx;
				 	  	  
				 	  	  /* Logica de Embaralhamento 4 Concluída! */
					break;
					
				case (3):
					  	  /*Guradando Valor da primeira Posição Subsequente*/
		 	  	  	  	  auxx = b[n-4];
						  
				  	  	  /*Guradando Valor da segunda Posição Subsequente*/
		 	  	  	  	  auxy = b[n-3];
		 	  	          
		 	  	  	  	  /* Passagem da primeira Posição */
		 	  	  	  	  b[n-4] = b[n];
		 	  	  	  	  
		 	  	  	  	  /* Passagem da segunda Posição */
		 	  	  	  	  b[n-3] = auxx;
		 	  	  	  
		 	  	  	  	  /* Guardando Valor da terceira Posição Subsequente*/
		 	  	  	  	  auxx = b[n+1];
		 	  	  
		 	  	  	  	  /* Passagem da terceira Posição */
		 	  	  	  	  b[n+1] = auxy;
		 	  	  	  	  
		 	  	  	  	  /* Passagem da quarta Posição */
		 	  	  	  	  b[n] = auxx;
			 	  	  
			 	  	  	  /* Logica de Embaralhamento 3 Concluída! */
			 	  	break;
			 	  	
				case (2):
					  	  /*Guradando Valor da primeira Posição Subsequente*/
		 	  	  	  	  auxx = b[n+4];
						  
				  	  	  /*Guradando Valor da segunda Posição Subsequente*/
		 	  	  	  	  auxy = b[n+3];
		 	  	          
		 	  	  	  	  /* Passagem da primeira Posição */
		 	  	  	  	  b[n+4] = b[n];
		 	  	  	  	  
		 	  	  	  	  /* Passagem da segunda Posição */
		 	  	  	  	  b[n+3] = auxx;
		 	  	  	  	  
		 	  	  	  	  /* Guardando Valor da terceira Posição Subsequente*/
		 	  	  	  	  auxx = b[n-1];
		 	  	  	  	  
		 	  	  	  	  /* Passagem da terceira Posição */
		 	  	  	  	  b[n-1] = auxy;
		 	  	  	  	  
		 	  	  	  	  /* Passagem da quarta Posição */
		 	  	  	  	  b[n] = auxx;
		 	  	  	  	  
		 	  	  	  	  /* Logica de Embaralhamento 2 Concluída! */
		 	  	  	break;
				
				case (1):
					  	  /*Guradando Valor da primeira Posição Subsequente*/
		 	  	  	  	  auxx = b[n+1];
						  		
				  	  	  /*Guradando Valor da segunda Posição Subsequente*/
		 	  	  	  	  auxy = b[n+5];
		 	  	          
		 	  	  	  	  /* Passagem da primeira Posição */
		 	  	  	  	  b[n+1] = b[n];
		 	  	  	  	  
		 	  	  	  	  /* Passagem da segunda Posição */
		 	  	  	  	  b[n+5] = auxx;
		 	  	  	  	  
		 	  	  	  	  /* Guardando Valor da terceira Posição Subsequente*/
		 	  	  	  	  auxx = b[n+4];
		 	  	  
		 	  	  	  	  /* Passagem da terceira Posição */
		 	  	  	  	  b[n+4] = auxy;
		 	  	  	  	  
		 	  	  	  	  /* Passagem da quarta Posição */
		 	  	  	  	  b[n] = auxx;
			 	  	  
			 	  	  	  /* Logica de Embaralhamento 4 Concluída! */
			 	  	break;
			 	  	
			 	 default:
			 		 	  /* Easter Egg... pois até o BUG é legal :D */
			 		      System.out.print("NA NA NA NA NA NA NA NA NA ");
			 		      System.out.println("\t HEY JUDE!");
			 		break;
			}
		}
		
		/* Retorna o array com a posição Embaralhada */
		return b;
	}
}



// Anotações e Orientações

/*	______________________________________________________________________________
 * 										|
 * 		POSIÇÕES PARA EMBARALHAR  		| 			    E S Q U E M A
 * 	____________________________________|_________________________________________
 * 										|
 * 	 0 - Canto Superior Esquerdo;		|
 * 	 3 - Canto Superior Direito;		|
 *  12 - Canto Inferior Esquerdo;		|		
 *  15 - Canto Inferior Direito;		|		
 *   4 - Borda Lateral  Esquerda 1;		|		|	0	|	1	|	2	|	3	|
 *   8 - Borda Lateral  Esquerda 2;   	|		---------------------------------
 *   7 - Borda Lateral  Direita 1;		|		|	4	|	5	|	6	|	7   |
 *  11 - Borda Lateral  Direita 2;		|		---------------------------------
 *   1 - Borda Superior 1;				|		|	8	|	9	|	10	|	11  |
 *   2 - Borda Superior 2;				|		---------------------------------
 *  13 - Borda Inferior 1;				|		|	12	|	13	|	14	|	15  |
 *  14 - Borda Inferior 2;				|		
 *   5 - Interior 1;					|
 *   6 - Interior 2;					|
 *   9 - Interior 3;					|
 *  10 - Interior 4;					|
 *  ____________________________________|_________________________________________
 *  
 *  	LÓGICA
 *  
 *		Cantos 		- 		Única para cada Um.
 *		Bordas 		- 		4 Lógicas, uma pada cada Par.
 *		Interior 	- 		Igual a Todos.
 *
 *	_______________________________________________________________________________
 *										|
 *				Lógica					|				  Esquema
 *	____________________________________|__________________________________________
 *										|	
 *	 1 - Canto Superior Esquerdo		|		|	1	|	7	|	7	|	2	|
 *   2 - Canto Superior Direito;		|		---------------------------------
 *   3 - Canto Inferior Esquerdo;		|		|	5	|	9	|	9	|	6   |
 *   4 - Canto Inferior Direito;	   	|		---------------------------------
 *   5 - Borda Lateral  Esquerda;		|		|	5	|	9	|	9	|	6   |
 *   6 - Borda Lateral  Direita;		|		---------------------------------
 *   7 - Borda Superior;				|		|	3	|	8	|	8	|	4   |
 *   8 - Borda Inferior;				|
 *   9 - Interior;						|
 *	____________________________________|__________________________________________
 *
 *	Idéia:
 *
 *	Cantos: Rotação entre 4 posições.
 *  Bordas laterais: Rotação horizontal entre 6 posições.
 *	Demais posições: Rotação horizontal entre 6 posições.
 *
 *	1)  Cantos:
 *
 *		A   B         A > B         D   A
 *              ==>   ^   v   ==>   
 *      D   C         D < C         C   B
 *
 *		No array:
 *							|						|				    	|	
 *			 0		+1		|		-4		-3		|	  -5		-4		|		-1		 0
 *							|						|		    			|
 *			+4		+5		|		 0		+1		|	  -1		 0		|		+3		+4
 *							|						|			    		|
 *
 *	
 *	2)  Bordas Laterais:
 *	
 *		F   A         F > A			E   F
 *		              ^   v   		
 *		E   B   ==>   E   B   ==>   D   A
 *					  ^   v
 *		D   C		  D < C         C   B
 *		
 *
 *		No array:
 *	
 *			-1		0		|		 0		+1
 *							|		
 *			+3	   +4		|		+4		+5
 *							|		
 *			+7	   +8		|		+8		+9
 *
 *
 *
 *  3)  Demais posições:
 *		
 *		F   A   B         F > A > B				E   F   A
 *		            ==>   ^       v      ==>		
 *		E   D   C         E < D < C				D   C   B
 *
 *
 *		No array:
 *
 *			-1		0	   +1
 *		
 *			+3	   +4	   +5
 *
 *
 * OBS: O resultado da aplicação das lógicas das posições 7 e 8 serão iguais às da nove, portanto, pode ser substitído pela mesma.
 * 		
 * 									( Na 7, é implementada a 9, já que a lógica é a Mesma. )
 *
 */     



