

						/****************************************************************
						 * 																*
						 *		    " In the game of life we live and die				* 
						 *   another breath begins, another chance to win the fight		*
						 *		   from the moment that you hit the ground "			*
						 *							Scorpions							*
						 *																*
						 *																*
						 * 		   Classe para gerenciamento dos movimentos e 			*
						 * 				      jogadas do puzzle.						*
						 * 																*
						 * 	@author C�sar Martini; 										*
						 *	@version 0.6 (alpha);										*
						 *	@category games, college, college homework;					*
						 *																*
						 *																*
						 ****************************************************************/

/*
	NOTAS DO AUTOR:
	
	Conclu�do:
	
		* 
		* 
	
	Em Desenvolvimento:
	
		* ADICIONAR INTEGRA��O - M�TODO HELP
		* 
*/


import support.Keyboard;


public class Play /*extends Jogador*/{
	
	/*     A T R I B U T O S     */
	
	private String p1;
	private String p2;
	private String p3;
	private String p4;
	char [] array;
	
	public void setPalavras(String[] palav){
		this.p1 = palav[0];
		this.p2 = palav[1];
		this.p3 = palav[2];
		this.p4 = palav[3];
	}
	
	/*-----------------------------------------------------------------------------------------------------------
	  -----------------------------------------------------------------------------------------------------------
	  -----------------------------------------------------------------------------------------------------------*/
	
	/*     M � D U L O S     */
	
	/* M�dulo Main para realizar testes no interior da classe
	public static void main(String[] args) {
		
		char [] array = {'T','R','O','N','D','A','F','T','P','U','N','K','C','L','U',0};
		int i=0;
		
		Play play = new Play();
		
		Shuffle shuffling = new Shuffle();
		array = shuffling.Shuffling(array);
		
		Grid grid = new Grid();
		
		while (i<20){
			grid.showGrid(array);
			play.verifica(array);
		}
		
	}*/
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	// M�dulo para verifica��o das jogadas 
	public char[] verifica(char [] letras) {
		
		/* Vari�vel para obter posi��o vazia / l�gica / numero de movimentos / �ndice */
		int np = 0;
		int logica = 0;
		int t = 0;
		int i= 0;
		
		/* Vari�vel para determinar posi��o e movimentos*/
		String [] m = new String [2];
		
		/* Descobrindo posi��o vazia...*/
		for (i=0; i<16; i++){
			
			if (letras[i]==(0)){
				np = i;
			}
		}
		
		
		/*Determina a L�gica a ser aplicada, a partir da posi��o...*/
		switch (np){
			case (15):
					  logica = 4;
				break;
				
			case (14):
				      logica = 8;
				break;
				
			case (13):
				      logica = 8;
				break;
				
			case (12):
				      logica = 3;
				break;
			
			case (11):
				      logica = 6;
				break;
			
			case (10):
				      logica = 9;
				break;
				
			case (9):
			      	  logica = 9;
				break;
				
			case (8):
			      	  logica = 5;
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
		      	  	  logica = 7;
				break;
			
			case (1):
		      	  	  logica = 7;
				break;
			
			case (0):
		      	  	  logica = 1;
				break;
			
			/* Apresenta Mensagem de Erro */
			 default:
				 	  System.out.println("\n\n\n\t\t   E R R O ! ! ! \n");
				 	  System.out.println("\n\n\n\t   O desenvolvedor provavelmente andou programando de madrugada... Z z z...\n");
				 	  System.out.println("\n\n\n\t   E n�o, voc� n�o ganha nada encontrando este bug. Voc� acha que eu tenho cara de Google? \n");
				 	  System.out.println(logica);
				 	  System.out.println(t);
				break;
		}
		
		
		
		/* L�gica das Jogadas*/
		switch (logica) {
			case (1) :
					  /* Determina o n�mero de movimentos poss�veis */
					  t = 2;
					  /* Determina o tipo de movimento a ser feito */
					  m[0] = "ds";
					  /* Determina qual mensagem deve ser exibida */
					  m[1] = "Direita ou Baixo?";
					  
					  /* Envia para outro m�dulo obter a dire��o */
					  letras = direciona(letras, t, m, np);
				break;
				
			case (2) :
					  t = 2;
					  m[0] = "as";
					  m[1] = "Esquerda ou Baixo?";
					  
					  letras = direciona(letras, t, m, np);
				break;
				
			case (3) :
					  t = 2;
			  		  m[0] = "dw";
			  		  m[1] = "Direita ou Cima?";
			  
			  		  letras = direciona(letras, t, m, np);
				break;
				
			case (4) :
					  t = 2;
	  		  		  m[0] = "aw";
	  		  		  m[1] = "Esquerda ou Cima?";
	  
	  		  		  letras = direciona(letras, t, m, np);
				break;
			case (5) :
				  	  t = 3;
	  		  		  m[0] = "dws";
	  		  		  m[1] = "Direita, Cima ou Baixo?";
	  		  		  
	  		  		  letras = direciona(letras, t, m, np);
				break;
			case (6) :
			  	  	  t = 3;
	  		  		  m[0] = "aws";
	  		  		  m[1] = "Esquerda, Cima ou Baixo?";
	  		  		  
	  		  		  letras = direciona(letras, t, m, np);
	  		    break;
			case (7) :
		  	  	  	  t = 3;
		  		  	  m[0] = "ads";
		  		  	  m[1] = "Esquerda, Direita, ou Baixo?";
		  		  	  
		  		  	  letras = direciona(letras, t, m, np);
		  		break;
			    
			case (8) :
			  	  	  t = 3;
	  		  		  m[0] = "adw";
	  		  		  m[1] = "Esquerda, Direita ou Cima?";
	  		  
	  		  		  letras = direciona(letras, t, m, np);
		      	break;
			case (9) :
			  	  	  t = 4;
	  		  		  m[0] = "adws";
	  		  		  m[1] = "Esquerda, Direita, Cima ou Baixo?";
	  		  		  
	  		  		  letras = direciona(letras, t, m, np);
		      	break;
		      	
		      default:
		    	      System.out.println("\n\n\n\t\t O   E R R O ! ! ! \n");
			 	      System.out.println("\n\n\n\t   O desenvolvedor provavelmente andou programando de madrugada... Z z z...\n");
			 	      System.out.println("\n\n\n\t   E n�o, voc� n�o ganha nada encontrando este bug. Voc� acha que eu tenho cara de Google? \n");
			 	break;
		    	  
		}
		
		return letras;
		
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	private char[] direciona (char[] b, int d, String [] p, int loc){
		
		char[] movimentos = p[0].toCharArray();
		char mov = 'b';
		int i = 0;
		
		/* Obt�m a leitura correta do movimento */
		switch (d){
			case (2):
					while (((mov)!=(movimentos[0]))&((mov)!=(movimentos[1]))) {
						
						System.out.print("\n\t " + p[1] + "   ");
						mov = Keyboard.readChar();
						
						if (mov=='q'){
							/*Chama help para ver rela��o das palavras */
							help();
						}
						
						i++;
						
						/* Imprime rela��o das teclas de movimento, a cada 5 entradas incorretas */
						if ((i % 5 == 0)&((mov!=movimentos[0])&(mov!=movimentos[1]))){
							System.out.print("\n\t  ------- MOVIMENTO -------\n");
							System.out.print("\n\t  DIRE��O        LETRA");
							System.out.print("\n\t  -------------------------");
							System.out.print("\n\t  CIMA           W");
							System.out.print("\n\t  ESQUERDA       A");
							System.out.print("\n\t  BAIXO          S");
							System.out.print("\n\t  DIREITA        D");
							System.out.print("\n\n\t  ----------------------\n\n");
						}
					}
					/* Envia para o m�dulo Aplicar*/
					b = aplica (b, mov, loc);
			  break;
			  
			case (3):
					while (((mov)!=(movimentos[0]))&((mov)!=(movimentos[1]))&((mov)!=(movimentos[2]))){
						System.out.print("\n\t " + p[1] + "   ");
						mov = Keyboard.readChar();
						
						if (mov=='q'){
							/*Chama help para ver rela��o das palavras */
							help();
						}
						
						i++;
						
						/* Imprime rela��o das teclas de movimento, a cada 5 entradas incorretas */
						if ((i % 5 == 0)&((mov!=movimentos[0])&(mov!=movimentos[1])&(mov!=movimentos[2]))){
							System.out.print("\n\t  ------- MOVIMENTO -------\n");
							System.out.print("\n\t  DIRE��O        LETRA");
							System.out.print("\n\t  -------------------------");
							System.out.print("\n\t  CIMA           W");
							System.out.print("\n\t  ESQUERDA       A");
							System.out.print("\n\t  BAIXO          S");
							System.out.print("\n\t  DIREITA        D");
							System.out.print("\n\n\t  ----------------------\n\n");
						}
					}
					/* Envia para o m�dulo Aplicar*/
					b = aplica (b, mov, loc);
			  break;
			  
			case (4):
				while (((mov)!=(movimentos[0]))&((mov)!=(movimentos[1]))&((mov)!=(movimentos[2]))&((mov)!=(movimentos[3]))){
					System.out.print("\n\t " + p[1] + "   ");
					mov = Keyboard.readChar();
					
					if (mov=='q'){
						/*Chama help para ver rela��o das palavras */
						help();
					}
					
					i++;
					
					/* Imprime rela��o das teclas de movimento, a cada 5 entradas incorretas */
					if ((i % 5 == 0)&((mov!=movimentos[0])&(mov!=movimentos[1])&(mov!=movimentos[2])&(mov!=movimentos[3]))){
						System.out.print("\n\t  ------- MOVIMENTO -------\n");
						System.out.print("\n\t  DIRE��O        LETRA");
						System.out.print("\n\t  -------------------------");
						System.out.print("\n\t  CIMA           W");
						System.out.print("\n\t  ESQUERDA       A");
						System.out.print("\n\t  BAIXO          S");
						System.out.print("\n\t  DIREITA        D");
						System.out.print("\n\n\t  ----------------------\n\n");
					}
				}
				/* Envia para o m�dulo Aplicar*/
				b = aplica (b, mov, loc);
		  break;
		  
		  default:
			  System.out.println("\n\n\n\t\t   E R R O ! ! ! \n");
	 	      System.out.println("\n\n\n\t   O desenvolvedor provavelmente andou programando de madrugada... Z z z...\n");
		  break;
			  
		}
		
		return b;
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	private char[] aplica (char[] a, char m, int pos){
		
		char aux = 0;
		
		switch (m) {
			case ('w'):
						/* Obt�m o conte�do da vari�vel da Posi��o -- (Ser� 0, exceto em casos de BUG. Se for este o caso, n�o ir� "quebrar" o jogo...) */
						aux = a[pos];
						
						/* Passa o Conte�do da Vari�vel da posi��o acima para a posi��o atual */
						a[pos] = a[pos-4];
						
						/* E, por fim, insere a posi��o vazia no lugar da posi��o acima. */
						a [pos-4] = aux;
				break;
				
			case ('a'):
						/* Obt�m o conte�do da vari�vel da Posi��o -- (Ser� 0, exceto em casos de BUG. Se for este o caso, n�o ir� "quebrar" o jogo...) */
						aux = a[pos];
						
						/* Passa o Conte�do da Vari�vel da posi��o � esqueda para a posi��o atual */
						a[pos] = a[pos-1];
						
						/* E, por fim, insere a posi��o vazia no lugar da posi��o � esquerda. */
						a [pos-1] = aux;
				break;
				
			case ('s'):
						/* Obt�m o conte�do da vari�vel da Posi��o -- (Ser� 0, exceto em casos de BUG. Se for este o caso, n�o ir� "quebrar" o jogo...) */
						aux = a[pos];
						
						/* Passa o Conte�do da Vari�vel da posi��o abaixo para a posi��o atual */
						a[pos] = a[pos+4];
						
						/* E, por fim, insere a posi��o vazia no lugar da posi��o abaixo. */
						a [pos+4] = aux;
				break;
				
			case ('d'):
						/* Obt�m o conte�do da vari�vel da Posi��o -- (Ser� 0, exceto em casos de BUG. Se for este o caso, n�o ir� "quebrar" o jogo...) */
						aux = a[pos];
						
						/* Passa o Conte�do da Vari�vel da posi��o � direita para a posi��o atual */
						a[pos] = a[pos+1];
						
						/* E, por fim, insere a posi��o vazia no lugar da posi��o � direita. */
						a [pos+1] = aux;
				break;
				
			  default:
					  	System.out.println("\n\n\n\t\t   E R R O ! ! ! \n");
					  	System.out.println("\n\n\n\t Como � que, justamente neste m�dulo, ocorreu um BUG?\n");
					  	System.out.println("\n\n\n\t Lei de Clark: \"Murphy era Otimista...\"\n");
					  	System.out.println(aux);
				break;
		}
		
		return a;
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public void help ( ){
		
		System.out.print("\n\t  ------- DICAS -------\n");
		System.out.print("\n\t  Palavra 1 - " + this.p1 );
		System.out.print("\n\t  Palavra 2 - " + this.p2 );
		System.out.print("\n\t  Palavra 3 - " + this.p3 );
		System.out.print("\n\t  Palavra 4 - " + this.p4 );
		System.out.print("\n\n\t  ---------------------\n\n");
	}
	
}

/*	=================================================================================================================
 * 
 * 										ANOTA��ES, COMENT�RIOS E OUTROS
 * 
 * ==================================================================================================================
 * 
 * 
 * ---------------------------------------------------------------------
 * 
 * 		O QUE DEVE SER FEITO:
 * 
 * 	--------------------------------------------------------------------
 * 
 *	 1- Descobrir a posi��o vazia do Array (Em que se encontra o 0);
 *
 *	 2- Passa pela verifica��o para definir a l�gica a ser aplicada;  
 *
 *	 3- Entra no "Case" compat�vel;
 *
 *	 4- Executa verifica��es de Movimento;
 *
 *	 5- Realiza a Mudan�a no Array, utilizando um char auxiliar;
 * 
 *  --------------------------------------------------------------------
 * 
 * 
 *	________________________________________________________________________________________________________________
 * 
 *  					GERENCIAMENTO DAS POSI��ES E JOGADAS:
 *  ________________________________________________________________________________________________________________
 *  												|
 *  1 - Canto Superior Esquerdo;					|		0																OK
 *  ________________________________________________|_______________________________________________________________
 *  												|				
 *  2 - Canto Superior Direito;						|		3																OK
 *  ________________________________________________|_______________________________________________________________
 *  												|
 *  3 - Canto Inferior Esquerdo;					|		12																OK
 *  ________________________________________________|_______________________________________________________________
 *  												|
 *  4 - Canto Inferior Direito;						|		15																OK
 *  ________________________________________________|_______________________________________________________________
 *  												|
 *  5 - Borda Lateral Direita (L�gica Atende 2);	|		4		|		8												OK
 *  ________________________________________________|_______________________________________________________________
 *  												|
 *  6 - Borda Lateral Esquerda (L�gica Atende 2);	|		7		|		11												OK
 *  ________________________________________________|_______________________________________________________________
 *  												|
 *  7 - Borda Superior (L�gica Atende 2);			|		1		|		2												OK
 *  ________________________________________________|_______________________________________________________________
 *  												|
 *  8 - Borda Inferior (L�gica Atende 2);			|		13		|		14												OK
 *  ________________________________________________|_______________________________________________________________
 *  												|
 *  9 - Interior (L�gica Atende 4);					|		5		|		6		|		9		|		10				OK
 *  ________________________________________________|_______________________________________________________________
 *  
 *  
 *  TOTAL: 9 Possiblilidades;
 *  
 *  
 *    	Cantos        +     Bordas    + Interior
 *  	1 + 1 + 1 + 1 + 2 + 2 + 2 + 2 + 4 = 16 posi��es.
 *  
 *  ________________________________________________________________________________________________________________
 *  
 *  
 *  ****************************************************************************************************************
 *  
 *   _____________________________________________________________________
 *  				|
 *  				|
 *     L � G I C A  |				J O G A D A S   V � L I D A S
 *  				|
 *   _______________|______________________________________________________
 *  				|
 *  		1 		|			D			B
 *   _______________|______________________________________________________
 *  				|
 *  		2 		|			E 			B
 *   _______________|______________________________________________________
 *  				|
 *  		3 		|			D			C
 *   _______________|______________________________________________________
 *  				|
 *  		4 		|			E			C
 *   _______________|______________________________________________________
 *  				|
 *  		5		|			E			C			B
 *   _______________|______________________________________________________
 *  				|
 *  		6		|			D			C			B
 *   _______________|______________________________________________________
 *  				|
 *  		7		|			E			D			B
 *   _______________|______________________________________________________
 *		  			|
 *  		8		|			E			D			C
 *   _______________|______________________________________________________
 *					| 
 *  		9		|			E			D			C			B
 *   _______________|______________________________________________________
 *  				
 *  							L E G E N D A
 *  
 *          E = Esquerda      D = Direita      C = Cima      B = Baixo     
 *  				
 *   ______________________________________________________________________
 *  
 *  
 *  	ARRAY:
 *  
 *  	 0		 1		 2		 3
 *  
 *  	 4		 5		 6		 7
 *  
 *  	 8		 9		10		11
 *  
 *  	12		13		14		15
 *  
*/