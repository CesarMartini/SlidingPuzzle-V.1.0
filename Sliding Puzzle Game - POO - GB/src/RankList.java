

						/****************************************************************
						 * 																*
						 *				Monty Python and the Holy Grail 				*
						 *						(Text Version)							*
						 * 																*
						 *		  http://www.sacred-texts.com/neu/mphg/mphg.htm			*
						 *																*
						 *																*
						 * 		   Classe para cadastro, exibição e escolha das			*
						 * 				     palavras do puzzle.						*
						 * 																*
						 * 																*
						 * 	@author César Martini; 										*
						 *	@version 1.0 (Beta);										*
						 *	@category games, college, college homework;					*
						 *																*
						 *																*
						 ****************************************************************/



import java.util.ArrayList;
import java.util.List;



public class RankList {
	
	// Criação de uma lista para Armazenar o Rank.
	List<Jogador> lista = new ArrayList<Jogador>();;
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	/* Adiciona Jogador e/ou Vitória */
	public void addRList(Jogador jp){
		
		// Flag para verificar existência do Jogador;
		boolean Existe = false;
		
		// Enquanto houverem itens na lista
		for (Jogador rank : lista) {
			
			// Verifica se o Nome Atual é Igual ao dos Cadastrados
			if (rank.getNome().equals(jp.getNome())) {
				
				/* Determina posição no Rank */
				jp = rank;
				
				/* Valida flag de Jogador já Cadastrado */
				Existe = true;
			}
		}
		
		// Insere novo jogador, caso nunca tenha sido criado.
		if (!Existe)
			this.lista.add(jp);
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	/* Mostra o Rank */
	void imprimirRank() {
		/* Logo */
		System.out.print("\n\n\n#-----------------------------------------------------------------------------#\n");
		System.out.print("\n  __  __              __                                                   ");
		System.out.print("\n /\\ \\/\\ \\  __        /\\ \\                                                  ");
		System.out.print("\n \\ \\ \\_\\ \\/\\_\\     __\\ \\ \\___     ____    ___    ___   _ __    __    ____  ");
		System.out.print("\n  \\ \\  _  \\/\\ \\  /'_ `\\ \\  _ `\\  /',__\\  /'___\\ / __`\\/\\`'__\\/'__`\\ /',__\\ ");
		System.out.print("\n   \\ \\ \\ \\ \\ \\ \\/\\ \\L\\ \\ \\ \\ \\ \\/\\__, `\\/\\ \\__//\\ \\L\\ \\ \\ \\//\\  __//\\__, `\\");
		System.out.print("\n    \\ \\_\\ \\_\\ \\_\\ \\____ \\ \\_\\ \\_\\/\\____/\\ \\____\\ \\____/\\ \\_\\\\ \\____\\/\\____/");
		System.out.print("\n     \\/_/\\/_/\\/_/\\/___L\\ \\/_/\\/_/\\/___/  \\/____/\\/___/  \\/_/ \\/____/\\/___/ ");
		System.out.print("\n                   /\\____/                                                 ");
		System.out.print("\n                   \\_/__/                                                  ");
		System.out.print("\n\n#-----------------------------------------------------------------------------#\n\n");
		
		/* Lista */
		for (Jogador jogador : lista) {
			System.out.print("\n\n\t   NOME:   \t" + jogador.getNome() + ".");
			System.out.print("\n\t   GANHOU: \t" + jogador.getWin() + " partidas.");
		}
		
		System.out.print("\n\n#-----------------------------------------------------------------------------#");
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	/* Incrementa contador de Vitórias */
	void somarVitoria(Jogador jp) {

		for (Jogador jogador : lista) {
			if (jogador.getNome().equals(jp.getNome()))
				jogador.setWin(jogador.getWin() + 1);
		}
	}
}
