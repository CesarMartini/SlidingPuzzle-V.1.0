

						/****************************************************************
						 * 																*
						 *		     													* 
						 *   		Why JAVA programmers have to wear glasses?			*
						 *		    													*
						 *					 Because they don't C# !					*
						 *																*
						 *																*
						 * 		  Classe de inicialização dos módulos do jogo,			*
						 *  				menu e sáida do puzzle.						*
						 * 																*
						 * 	@author César Martini; 										*
						 *	@version 0.3 (alpha);										*
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

import java.util.List;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import support.ArquivoPalavras;
//import support.ArquivoPalavras;
import support.ArquivoRank;
import support.Keyboard;

public class Main {

	public static void main(String[] args) {
		
		Main m = new Main();
		
		int i=0;
		
		m.menu(i);

	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	@SuppressWarnings("unchecked")
	public void menu(int ini){
		
		int s = 0;
		int op = 0;
		int flg = 0;
		
		while (s == 0){
			
			/* INTRO TOSCA */
			if (ini == 0) {
				
				System.out.print("\n#-----------------------------------------------------------------------------#\n\n");
				System.out.print("\n  SSSSSSSS   L          IIIIIII   DDDDDDD  IIIIIII   NN    N    GGGGGG  ");
				System.out.print("\n   S          L             I      D      D    I      N N   N   G        ");
				System.out.print("\n    SSSSSSSS   L             I      D      D    I      N  N  N   G   GGGG ");
				System.out.print("\n            S   L             I      D      D    I      N   N N   G      G ");
				System.out.print("\n      SSSSSSSS   LLLLLLLL   IIIIIII   DDDDDDD  IIIIIII   N    NN    GGGGGG  \n\n");
				
				System.out.print("\n           PPPPPPP    U      U   ZZZZZZ    ZZZZZZ    L          EEEEEEEE ");
				System.out.print("\n            P      P   U      U       Z         Z     L          E        ");
				System.out.print("\n             PPPPPPP    U      U      Z         Z      L          EEEEEE   ");
				System.out.print("\n              P          U      U     Z         Z       L          E        ");
				System.out.print("\n               P           UUUUUU     ZZZZZZ    ZZZZZZ   LLLLLLLL   EEEEEEEE ");
				System.out.print("\n\n\n#-----------------------------------------------------------------------------#\n");
				System.out.print("\t\t  Desenvolvido e Codificado por C\u00E9sar Martini.");
				System.out.print("\n#-----------------------------------------------------------------------------#\n\n");
				
				/* Pausa de 3 segundos */
				try {  
				    Thread.sleep(3000);  
				} catch(Exception e) {  
					ini = 1; 
				}
				
				ini = 1;
			}
			
			
			/*try{*/
			
			/* --- CARREGA OS ARQUIVOS --- */
			
			/* Instãncia da Classe XStream de manipulação de XML*/
			XStream xstr = new XStream(new DomDriver());
			
			/* Instância da Classe de Lista de Palavras */
			WordList wl = new WordList();
			
			/* Instância da Classe de Lista do Rank de Jogadores */
			RankList rl = new RankList();
			
			
			/* Carregando Listas... */
			
			/* Palavras */
			wl.listap = (List<Words>)xstr.fromXML(ArquivoPalavras.lerArquivoPalavras());
			
			/* Rank */
			rl.lista  = (List<Jogador>)xstr.fromXML(ArquivoRank.lerArquivoRank());
			
			/*}catch(Exception e){
				
				System.out.print("\n\n\t\t     ------------------------------------- ");
			 	System.out.print("\n\t\t      Erro durante a Leitura dos Arquivos  ");
			 	System.out.print("\n\t\t     ------------------------------------- ");
			}*/
			
			
			
			/* --- FIM DO CARREGAMENTO DE ARQUIVOS --- */
			
			
			
			/* MENU */
			
			System.out.print("\n\n\n\t\t      ------------- M E N U ------------- ");
			System.out.print("\n\n\t\t       1 - Jogar; ");
			System.out.print("\n\t\t       2 - Gerenciar Palavras; ");
			System.out.print("\n\t\t       3 - Ranking; ");
			//System.out.print("\n\t\t\t    4 - Instruções; ");		// Se houver tempo... e vondade... e não existirem outras demandas... e nem outras atividades... e se estivesse no escopo... ... ... ...
			System.out.print("\n\t\t       4 - Sair; ");
			System.out.print("\n\n\t\t        Escolha uma op\u00E7\u00E3o: ");
			op = Keyboard.readInt();
			System.out.print("\n\t\t      ----------------------------------- ");
			
			
			switch (op) {
				 case 1 :
					 	 /*Chama a classe Together com os Modos de Jogo.*/
					 	 Together her = new Together();
					 	 her.jogar(wl,rl);
					 	 
					 	 /* Salva Mudanças - Rank */
					 	 String xmlRank = xstr.toXML(rl.lista);
					 	 ArquivoRank.escreverArquivoRank(xmlRank);
					 	 
				   break;
				   
				 case 2 :
				 	 	 /*Chama a classe Words com o método Palavras.*/
					 	 System.out.print("\n\n\n#-----------------------------------------------------------------------------#\n\n");
					 	 
					 	 while (flg!=4){
					 		  System.out.print("\n\n\n\t\t  ------------- P A L A V R A S ------------- ");
					 		  System.out.print("\n\n\t\t   1 - Inserir nova palavra; ");
					 		  System.out.print("\n\t\t   2 - Ler palavras existentes; ");
					 		  System.out.print("\n\t\t   3 - Deletar palavra existente; ");
					 		  System.out.print("\n\t\t   4 - Sair; ");
					 		  System.out.print("\n\n\t\t    Escolha: ");
					 		  flg = Keyboard.readInt();
					 		  System.out.print("\n\t\t  ------------------------------------------- ");
					 	 	  
					 		  if (flg == 1){
					 			   // Insere as palavras...
					 			   wl.cadastro();
					 			   flg = 4;
					 		  }
					 		  
					 		  if (flg == 2){
					 			   wl.imprimirPalavras();
					 			   flg = 4;
					 		  }
					 		  
					 		  if (flg == 3){
					 			   wl.deletarPalavras();
					 			   flg = 4;
					 		  }
					 		  
					 		  if (flg!=4){
					 			   System.out.print("\n\n\t\t      ----------------------------------- ");
					    	 	   System.out.print("\n\t\t      Por favor, insira um valor válido.");
					    	 	   System.out.print("\n\t\t      ----------------------------------- ");
					 		  }
					 	 }
					 	 
					 	 // Salva Mudanças
					 	 String xmlWord = xstr.toXML(wl.listap);
			 			 ArquivoPalavras.escreverArquivoPalavras(xmlWord);
			 			 
					 	 flg = 0;
			       break;
			       
				 case 3 :
				 	 	 /*Chama a classe Rank com o método Highscores.*/
					 	 rl.imprimirRank();
			       break;
			       
				 /*case 4 :
				 	 	 //Chama a classe Noob com o método Tutorial.
				   break;*/
				   
				 case 4 :
					 	 /* Exibe mensagem para o Usuário */
					 	 System.out.print("\n\n\n#-----------------------------------------------------------------------------#\n\n");
					 	 System.out.print("\n\n\t\t     ------------------------------------- ");
					 	 System.out.print("\n\t\t     Salvando dados... Por favor, Aguarde. ");
					 	 System.out.print("\n\t\t     ------------------------------------- ");
					 	 
					 	 /* Obtém Listas *
					 	 String xmlRank = xstr.toXML(rl.lista);
					 	 String xmlWord = xstr.toXML(wl.listap);
					 	 
					 	 /* Regrava/Armazena Listas 
					 	 ArquivoRank.escreverArquivoRank(xmlRank);
					 	 ArquivoPalavras.escreverArquivoPalavras(xmlWord);*/
					 	 
					 	 /* Informa novamente o usuário */
					 	 System.out.print("\n\n\t\t     ------------------------------------- ");
					 	 System.out.print("\n\t\t           Dados Salvos com Sucesso.      ");
					 	 System.out.print("\n\t\t     ------------------------------------- ");
					 	 
					 	 
					 	 /*Sai definitivamente do jogo.*/
					 	 s = 1;
			       break;
			       
			     default:
			    	 	 System.out.print("\n\t\t      ----------------------------------- ");
			    	 	 System.out.print("\n\n\n\t\t      Por favor, insira um valor válido.");
			    	 	 System.out.print("\n\t\t      ----------------------------------- ");
			       break;
			}
			
			if (s == 1){
				System.out.print("\n\n\n#-----------------------------------------------------------------------------#\n\n");
				System.out.println("\n\n\t       Jogo Encerrado. Tenha um bom dia e até a próxima! ");
				System.out.print("\n\n\n#-----------------------------------------------------------------------------#\n\n");
			}
		}
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
}

