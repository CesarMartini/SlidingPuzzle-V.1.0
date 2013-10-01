

						/****************************************************************
						 * 																*
						 *		     													* 
						 *   		   "He say: 'I know you, you know me				*
						 *   			  One thing I can tell you is					*
						 *   				  You got to be free'"						*
						 *   															*
						 *   			  Come together - The Beatles					*
						 *																*
						 *																*
						 * 		  Classe de gerenciamento dos módulos do jogo,			*
						 *  				 palavras e jogadores.						*
						 * 																*
						 * 	@author César Martini; 										*
						 *	@version 0.7 (alpha);										*
						 *	@category games, college, college work;						*
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

import support.Keyboard;

public class Together {
	
	/* Criação de Intâncias, para Gerenciar os diferentes modos de Jogo*/
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	public void jogar (WordList wl, RankList rl) {
		
		int modo = 0, flags = 0;
		
		/* Instânciando a classe para obter os método correspondente a cada modo de jogo */
		Together t = new Together();
		
		while (flags == 0){
			System.out.print("\n\n\n#-----------------------------------------------------------------------------#\n");
				
			System.out.print("\n\n\n\t\t      ------------- M O D O ------------- ");
			System.out.print("\n\n\t\t       1 - Um Jogador; ");
			System.out.print("\n\t\t       2 - Jogador vs Jogador; ");
			System.out.print("\n\t\t       3 - Jogador vs Computador; ");
			System.out.print("\n\t\t       4 - Voltar; ");
			System.out.print("\n\n\t\t        Modo de jogo: ");
			modo = Keyboard.readInt();
			System.out.print("\n\t\t      ----------------------------------- ");
			
			System.out.print("\n#-----------------------------------------------------------------------------#\n\n");
			
			switch (modo) {
				case (1):
							t.solo(wl,rl);
					break;
				
				case (2):
							t.pvp(wl,rl);
					break;
				
				case (3):
							t.pvc(wl,rl);
					break;
				
				case (4):
							flags = 1;
					break;
				
				default:
							System.out.println("\n\t Por favor, insira uma opção válida! ");
					break;
			}
		}
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	private void pvc(WordList wl2, RankList rl2) {
		/* -----   Criando Variáveis   ----- */
		String palavrasP1 [] = new String[4]; 
		String palavrasPC [] = new String[4];
		
		String nomej1 = null;
		String nomejc = null;
		
		char [] jogoj1 = new char [16];
		char [] jogojc = new char [16];
		
		int venceu = 0, i = 0;
		
		
		
		/* ---- Instânciando Objetos ---- */
		
		// Únicos
		/* Jogador */
		Jogador j1 = new Jogador();
		Computador jc = new Computador();
		
		/* Dados */
		dadosJogador d1 = new dadosJogador(); 
		dadosJogador dc = new dadosJogador();
		
		/* Play */
		Play p1 = new Play();
		// Computador - Método play() embutido.
		
		// Gerais
		/* Grid */
		Grid g = new Grid();
		
		/* Shuffle */
		Shuffle s = new Shuffle();
		
		/* Victory */
		Victory v = new Victory(); 
		
		
		/* ---- Obtendo Dados ---- */
		
		/* Definine Variáveis */
		
		// Define Nome - Jogador 1
		j1.setNome();
		// Define Nome - Computador
		jc.setNome();
		
		
		// Obtém nome - Jogador 1
		nomej1 = j1.getNome();
		// Obtém nome - Computador
		nomejc = jc.getNome();
		
		
		// Obtem Palavras - Jogador 1
		wl2.imprimirPalavras();
		palavrasP1 = wl2.obterPalavras();
		// Obtem Palavras - Computador -- Palavras são iguais para computador e player.
		palavrasPC = palavrasP1;
		
		
		/* Verificação - Palavras Obtidas com Sucesso*/
		if ((palavrasP1[0]!="FALTA")&&(palavrasPC[0]!="FALTA")){
			
			// Enviar palavras para o Jogador - Jogador 1
			d1.setPalavras(palavrasP1);
			// Enviar palavras para o Jogador - Computador -- Posui as mesmas palavras do Jogador
			dc.setPalavras(palavrasP1);
			
			
			// Enviar palavras para Play - Jogador 1
			p1.setPalavras(j1.getPalavras());
			// Computador não necessita visualizar as palavras.
			
			
			// Criar Tabuleiro - Jogador 1
			d1.setJogo();
			// Criar Tabuleiro - Computador
			dc.setJogo();
			
			
			// Obtém Tabuleiro - Jogador 1
			jogoj1 = d1.getJogo();
			// Obtém Tabuleiro - Computador
			jogojc = dc.getJogo();
			
			// Embaralha - Jogador 1
			jogoj1 = s.Shuffling(jogoj1);
			// Embaralha - Computador
			jogojc = s.Shuffling(jogojc);
			
			
			
			/* ---- Inicia Jogo ---- */
			while (venceu!=1){
				
				/* Mostra Rodada Atual */
				System.out.print("\n\n\n\t\t      --------   R O D A D A   " + i+1 + "  -------- ");
				
				/* Vez do primeiro Jogador */
				if (venceu == 0){
					
					// Imprime Tabuleiro - Jogador 1
					g.showGrid(jogoj1);
					
					// Informa Vez - Jogador 1
					System.out.print("\n\t   É a sua vez, " + nomej1 + ".\n");
					
					// Realiza Movimento - Jogador 1
					jogoj1 = p1.verifica(jogoj1);
					
					// Verifica vitória - Jogador 1
					venceu = v.win(jogoj1, palavrasP1, nomej1);
					
					// Adiciona Vitória para o Rank - Jogador 1
					if (venceu == 1){
						rl2.addRList(j1);
					}
				/* Vez do Computador */
				}if (venceu == 0){
					
					// Imprime Tabuleiro - Computador
					g.showGrid(jogojc);
					
					// Informa Vez - Computador
					System.out.print("\n\t   É a sua vez, " + nomejc + ".\n");
					
					// Realiza Movimento - Computador
					jogojc = jc.verifica(jogojc) ;
					
					// Verifica vitória - Computador
					venceu = v.win(jogojc, palavrasPC, nomejc);
					
					// Adiciona Vitória para o Rank - Computador
					if (venceu == 1){
						rl2.addRList(jc);
					}
				}
				
				i++;
			}
			rl2.imprimirRank();
		}
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	private void pvp(WordList wl2, RankList rl2) {
		
		/* -----   Criando Variáveis   ----- */
		String palavrasP1 [] = new String[4]; 
		String palavrasP2 [] = new String[4];
		
		String nomej1 = null;
		String nomej2 = null;
		
		char [] jogoj1 = new char [16];
		char [] jogoj2 = new char [16];
		
		int venceu = 0, i = 0;
		
		
		
		/* ---- Instânciando Objetos ---- */
		
		// Únicos
		/* Jogador */
		Jogador j1 = new Jogador();
		Jogador j2 = new Jogador();
		
		/* Dados */
		dadosJogador d1 = new dadosJogador(); 
		dadosJogador d2 = new dadosJogador();
		
		/* Play */
		Play p1 = new Play();
		Play p2 = new Play();
		
		
		// Gerais
		/* Grid */
		Grid g = new Grid();
		
		/* Shuffle */
		Shuffle s = new Shuffle();
		
		/* Victory */
		Victory v = new Victory(); 
		
		
		/* ---- Obtendo Dados ---- */
		
		/* Definine Variáveis */
		
		// Define Nome - Jogador 1
		j1.setNome();
		// Define Nome - Jogador 2
		j2.setNome();
		
		
		// Obtém nome - Jogador 1
		nomej1 = j1.getNome();
		// Obtém nome - Jogador 2
		nomej2 = j2.getNome();
		
		
		// Obtem Palavras - Jogador 1
		wl2.imprimirPalavras();
		palavrasP1 = wl2.obterPalavras();
		// Obtem Palavras - Jogador 2
		wl2.imprimirPalavras();
		palavrasP2 = wl2.obterPalavras();
		
		
		/* Verificação - Palavras Obtidas com Sucesso*/
		if ((palavrasP1[0]!="FALTA")&&(palavrasP2[0]!="FALTA")){
			
			// Enviar palavras para o Jogador - Jogador 1
			d1.setPalavras(palavrasP1);
			// Enviar palavras para o Jogador - Jogador 2
			d2.setPalavras(palavrasP2);
			
			
			// Enviar palavras para Play - Jogador 1
			p1.setPalavras(palavrasP1);
			// Enviar palavras para Play - Jogador 2
			p2.setPalavras(palavrasP2);
			
			
			// Criar Tabuleiro - Jogador 1
			d1.setJogo();
			// Criar Tabuleiro - Jogador 2
			d2.setJogo();
			
			
			// Obtém Tabuleiro - Jogador 1
			jogoj1 = d1.getJogo();
			// Obtém Tabuleiro - Jogador 2
			jogoj2 = d2.getJogo();
			
			// Embaralha - Jogador 1
			jogoj1 = s.Shuffling(jogoj1);
			// Embaralha - Jogador 2
			jogoj2 = s.Shuffling(jogoj2);
			
			/* ---- Inicia Jogo ---- */
			while (venceu!=1){
				
				/* Mostra Rodada Atual */
				System.out.print("\n\n\n\t\t      --------   R O D A D A   " + i+1 + "  -------- ");
				
				/* Vez do primeiro Jogador */
				if (venceu == 0){
					
					// Imprime Tabuleiro - Jogador 1
					g.showGrid(jogoj1);
					
					// Informa Vez - Jogador 1
					System.out.print("\n\t   É a sua vez, " + nomej1 + ".\n");
					
					// Realiza Movimento - Jogador 1
					jogoj1 = p1.verifica(jogoj1);
					
					// Verifica vitória - Jogador 1
					venceu = v.win(jogoj1, palavrasP1, nomej1);
					
					// Adiciona Vitória para o Rank - Jogador 1
					if (venceu == 1){
						rl2.addRList(j1);
					}
				/* Vez do segundo Jogador */
				}if (venceu == 0){
					
					// Imprime Tabuleiro - Jogador 2
					g.showGrid(jogoj2);
					
					// Informa Vez - Jogador 2
					System.out.print("\n\t   É a sua vez, " + nomej2 + ".\n");
					
					// Realiza Movimento - Jogador 2
					jogoj2 = p2.verifica(jogoj2);
					
					// Verifica vitória - Jogador 1
					venceu = v.win(jogoj2, palavrasP2, nomej2);
					
					// Adiciona Vitória para o Rank - Jogador 1
					if (venceu == 1){
						rl2.addRList(j2);
					}
				}
				i++;
			}
			rl2.imprimirRank();
		}
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	private void solo(WordList wl2, RankList rl2) {
		
		/* -----   Criando Variáveis   ----- */
		String palavras [] = new String[4]; 
		
		String nomej1 = null;
		
		char [] jogoj1 = new char [16];
		
		int venceu = 0/*, i = 0*/;
		
		
		
		/* ---- Instânciando Objetos ---- */
		
		// Únicos
		/* Jogador */
		Jogador j1 = new Jogador();
		
		/* Dados */
		dadosJogador d1 = new dadosJogador(); 
		
		/* Play */
		Play p1 = new Play();
		
		
		// Gerais
		/* Grid */
		Grid g = new Grid();
		
		/* Shuffle */
		Shuffle s = new Shuffle();
		
		/* Victory */
		Victory v = new Victory(); 
		
		
		
		/* ---- Obtendo Dados ---- */
		
		/* Definine Variáveis */
		
		// Define Nome - Jogador 1
		j1.setNome();
		
		// Obtém nome - Jogador 1
		nomej1 = j1.getNome();
		
		//System.out.println("Passou Nome.");
		
		// Obtem Palavras - Jogador 1
		wl2.imprimirPalavras();
		palavras = wl2.obterPalavras();
		
		//System.out.println("Passou Obter Palavras.");
		
		/* Verificação - Palavras Obtidas com Sucesso*/
		if ((palavras[0]!="FALTA")){
			// Enviar palavras para o Jogador - Jogador 1
			d1.setPalavras(palavras);
			
			// Enviar palavras para Play - Jogador 1
			p1.setPalavras(palavras);
			
			// Criar Tabuleiro - Jogador 1
			d1.setJogo();
			
			// Obtém Tabuleiro - Jogador 1
			jogoj1 = d1.getJogo();
			
			// Embaralha - Jogador 1
			jogoj1 = s.Shuffling(jogoj1);
			
			
			
			/* ---- Inicia Jogo ---- */
			while (venceu!=1){
				
				//System.out.print("\n\n\n\t\t      --------   R O D A D A   " + i+1 + "  -------- ");
				// Imprime Tabuleiro - Jogador 1
				g.showGrid(jogoj1);
				
				// Informa Vez - Jogador 1
				System.out.print("\n\t\t   É a sua vez, " + nomej1 + ".\n");
				
				// Realiza Movimento - Jogador 1
				jogoj1 = p1.verifica(jogoj1);
				
				// Verifica vitória - Jogador 1
				venceu = v.win(jogoj1, palavras, nomej1);
				
				// Adiciona Vitória para o Rank - Jogador 1
				if (venceu == 1){
					rl2.addRList(j1);
				}
				
				//i++;
			}
			rl2.imprimirRank();
		}
	}
}



	/*-----------------------------------------------------------------------------------------------------------*/

/*
 *		INSTANCIAR AS CLASSES 	OK
 * 
 * 		CADA JOGADOR PODE SER UMA CLASSE, COM NOME, ARRAY E PALAVRAS.	OK
 * 			COMPUTADOR HERDA AÇÕES E ATRIBUTOS DE JOGADOR -- IRÁ POSSUIR AS MESMAS PALAVRAS P/ JOGAR!	
 * 		
 * 		QUANDO NECESSÁRIO, RETORNA ESSES ATRIBUTOS PARA SEREM ENVIADOS AOS SEUS RESPECTIVOS MÓDULOS. (GETTERS E SETTERS)	OK
 * 		
 * 			UM JOGADOR -> CHAMA UM MÉTODO COM APENAS UMA INSTÂNCIA DE JOGADOR.
 * 			DOIS JOGADORES -> CHAMA UM MÉTODO DUAS INSTÂNCIAS DE JOGADOR.
 * 			JOGADOR VS COMPUTADOR -> CHAMA UM MÉTODO COM UMA INSTÂNCIA DE JOGADOR E OUTRA DE COMPUTADOR
 * 
 * 		AO FORNECER O NOME, VERIFICAR SE NÃO É COMPUTADOR.		OK
 * 
 * 
 * 			ARRAY LISTS --> RANKING E PALAVRAS
 * 
 * 			BOA SORTE. VOCÊ TEM TEMPO. CALMA E FOCO.
 * 
 * 																							SOLO		PVP			PVC
 * 
 * 		0. Escolhe modo de Jogo.										OK?	
 * 		1. Obtém palavras para todos os jogadores do Modo.									OK
 * 		2. Atribuir palavras aos jogadores.													OK
 * 		3. Obter nome de todos os jogadores e atribui-los;									OK
 * 				AO FORNECER O NOME, VERIFICAR SE NÃO É O COMPUTADOR.	OK
 * 				ToLower e ToUpper?										NO
 * 		4. Montar tabuleiro com as palavras atribuídas, para cada um dos jogadores;			OK
 * 		5. Embaralhar Tabuleiros;															OK
 * 		LOOP																				OK
 * 			6. Imprimir Tabuleiro do Jogador; 												OK
 * 			7. Movimentar peças do tabuleiro;												OK
 * 			8. Verificar Vitória;															OK
 * 		9. Insere no Rank;																	OK
 * 		10. Volta para o menu inicial;														OK
 * 
 */
 