


						/****************************************************************
						 * 																*
						 *		    There are 11 types of people in this world:			* 
						 *			Those who know binary, those who don't know 		*
						 *		   		and those who think that they know. 			*
						 *																*
						 *																*
						 * 		   Classe para gerenciamento dos movimentos e 			*
						 * 				      dados do Computador.						*
						 * 																*
						 * 																*
						 * 	@author César Martini; 										*
						 *	@version 0.7 (alpha);										*
						 *	@category games, college, college homework;					*
						 *																*
						 *																*
						 ****************************************************************/

/*
	NOTAS DO AUTOR:
	
	Concluído:
	
		* 
		* 
	
	Em Desenvolvimento:
	
		* 
		* 
*/



import java.util.Random;


public class Computador extends Jogador {
	
	// GETTERS E SETTERS
	
	public void setNome( ) {
		this.nome = "Computador";
	}
	
	/*-----------------------------------------------------------------------------------------------------------*/
	//   MÓDULOS
	
	//Módulo para verificação das jogadas 
	
	public char[] verifica(char [] letras) {
		
		/* Variável para obter posição vazia / lógica / numero de movimentos / índice */
		int np = 0;
		int logica = 0;
		int t = 0;
		int i= 0;
		
		/* Variável para determinar posição e movimentos*/
		String [] m = new String [2];
		
		/* Descobrindo posição vazia...*/
		for (i=0; i<16; i++){
			
			if (letras[i]==(0)){
				np = i;
			}
		}
		
		
		/*Determina a Lógica a ser aplicada, a partir da posição...*/
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
				 	  System.out.println("\n\n\n\t\t   C O M P U T A D O R  -  E R R O ! ! ! \n");
				 	  System.out.println(logica);
				 	  System.out.println(t);
				break;
		}
		
		
		
		/* Lógica das Jogadas*/
		switch (logica) {
			case (1) :
					  /* Determina o número de movimentos possíveis */
					  t = 2;
					  /* Determina o tipo de movimento a ser feito */
					  m[0] = "ds";
					  /* Determina qual mensagem deve ser exibida */
					  m[1] = "Direita ou Baixo?";
					  
					  /* Envia para outro módulo obter a direção */
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
			 	      System.out.println("\n\n\n\t   E não, você não ganha nada encontrando este bug. Você acha que eu tenho cara de Google? \n");
			 	break;
		    	  
		}
		
		return letras;
		
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	private char[] direciona (char[] b, int d, String [] p, int loc){
		
		char[] movimentos = p[0].toCharArray();
		char mov = 'b';
		
		Random gerador = new Random();
		
		/* Obtém a leitura correta do movimento */
		switch (d){
			case (2):
					while (((mov)!=(movimentos[0]))&((mov)!=(movimentos[1]))) {
						
						// Obtém um número entre 0 e 3
				        int numero = gerador.nextInt(4);
				        switch (numero){
			        		case (0):
			        				mov = 'a';
			        		  break;
			        		  
			        		case (1):
		        					mov = 'w';
			        		  break;
			        		  
			        		case (2):
		        					mov = 'd';
			        		  break;
			        		  
			        		case (3):
		        					mov = 's';
			        		  break;
			        		  
			        		 default:
			        			 System.out.println(" Erro - Computador - Movimento.");
			        		  break;
				        }
					}
					
					/* Envia para o módulo Aplicar*/
					b = aplica (b, mov, loc);
			  break;
			  
			case (3):
					while (((mov)!=(movimentos[0]))&((mov)!=(movimentos[1]))&((mov)!=(movimentos[2]))){
						// Obtém um número entre 0 e 3
				        int numero = gerador.nextInt(4);
				        switch (numero){
			        		case (0):
			        				mov = 'a';
			        		  break;
			        		  
			        		case (1):
		        					mov = 'w';
			        		  break;
			        		  
			        		case (2):
		        					mov = 'd';
			        		  break;
			        		  
			        		case (3):
		        					mov = 's';
			        		  break;
			        		  
			        		 default:
			        			 System.out.println(" Erro - Computador - Movimento.");
			        		  break;
				        }
					}
					
					/* Envia para o módulo Aplicar*/
					b = aplica (b, mov, loc);
			  break;
			  
			case (4):
				while (((mov)!=(movimentos[0]))&((mov)!=(movimentos[1]))&((mov)!=(movimentos[2]))&((mov)!=(movimentos[3]))){
					// Obtém um número entre 0 e 3
			        int numero = gerador.nextInt(4);
			        switch (numero){
		        		case (0):
		        				mov = 'a';
		        		  break;
		        		  
		        		case (1):
	        					mov = 'w';
		        		  break;
		        		  
		        		case (2):
	        					mov = 'd';
		        		  break;
		        		  
		        		case (3):
	        					mov = 's';
		        		  break;
		        		  
		        		 default:
		        			 System.out.println(" Erro - Computador - Movimento.");
		        		  break;
			        }
				}
				
				/* Envia para o módulo Aplicar*/
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
						/* Obtém o conteúdo da variável da Posição -- (Será 0, exceto em casos de BUG. Se for este o caso, não irá "quebrar" o jogo...) */
						aux = a[pos];
						
						/* Passa o Conteúdo da Variável da posição acima para a posição atual */
						a[pos] = a[pos-4];
						
						/* E, por fim, insere a posição vazia no lugar da posição acima. */
						a [pos-4] = aux;
				break;
				
			case ('a'):
						/* Obtém o conteúdo da variável da Posição -- (Será 0, exceto em casos de BUG. Se for este o caso, não irá "quebrar" o jogo...) */
						aux = a[pos];
						
						/* Passa o Conteúdo da Variável da posição à esqueda para a posição atual */
						a[pos] = a[pos-1];
						
						/* E, por fim, insere a posição vazia no lugar da posição à esquerda. */
						a [pos-1] = aux;
				break;
				
			case ('s'):
						/* Obtém o conteúdo da variável da Posição -- (Será 0, exceto em casos de BUG. Se for este o caso, não irá "quebrar" o jogo...) */
						aux = a[pos];
						
						/* Passa o Conteúdo da Variável da posição abaixo para a posição atual */
						a[pos] = a[pos+4];
						
						/* E, por fim, insere a posição vazia no lugar da posição abaixo. */
						a [pos+4] = aux;
				break;
				
			case ('d'):
						/* Obtém o conteúdo da variável da Posição -- (Será 0, exceto em casos de BUG. Se for este o caso, não irá "quebrar" o jogo...) */
						aux = a[pos];
						
						/* Passa o Conteúdo da Variável da posição à direita para a posição atual */
						a[pos] = a[pos+1];
						
						/* E, por fim, insere a posição vazia no lugar da posição à direita. */
						a [pos+1] = aux;
				break;
				
			  default:
					  	System.out.println("\n\n\n\t\t   E R R O ! ! ! \n");
					  	System.out.println("\n\n\n\t Como é que, justamente neste módulo, ocorreu um BUG?\n");
					  	System.out.println("\n\n\n\t Lei de Clark: \"Murphy era Otimista...\"\n");
					  	System.out.println(aux);
				break;
		}
		
		return a;
	}
}