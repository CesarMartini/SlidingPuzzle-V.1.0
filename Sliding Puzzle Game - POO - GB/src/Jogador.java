import support.Keyboard;




						/****************************************************************
						 * 																*
						 *		    There are 11 types of people in this world:			* 
						 *			Those who know binary, those who don't know 		*
						 *		   		and those who think that they know. 			*
						 *																*
						 *																*
						 * 		   Classe para gerenciamento dos movimentos e 			*
						 * 				       dados do Jogador.						*
						 * 																*
						 * 																*
						 * 	@author César Martini; 										*
						 *	@version 0.9(alpha);										*
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


public class Jogador {

	/* ATRIBUTOS DO JOGADOR */
	
	/* Nome do Jogador */
	protected String nome;
	
	/* Número de Vitórias */
	private int win;
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	/* GETTERS E SETTERS */
	
	public String getNome() {
		return nome;
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public void setNome() {
		int flag = 0;
		
		String username = "ERRO.";
		
		/* Mensagem */
		System.out.print("\n\n\n#-----------------------------------------------------------------------------#\n");
		System.out.print("\n                    C A D A S T R O   D E  J O G A D O R E S                         ");
		System.out.print("\n\n\n#-----------------------------------------------------------------------------#\n");
		
		/* Laço p/ obter Nome Válido */
		while (flag==0){
			// Leitura do nome
			System.out.print("\n\t   Por favor, insira seu nome: \t");
			username = Keyboard.readString();
			
			// Verificação
			if (username.equals("Computador")){
				System.out.print("\n\n\t   Nome reservado. Insira outro nome. ");
			}else {
				// Validação
				flag = 1;
			}
		}
		
		// Retorno
		this.nome = username;
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public String[] getPalavras() {
		dadosJogador d = new dadosJogador(); 
		String[]palavras = d.getPalavras();
		return palavras;
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public void setPalavras(String[] palavras) {
		dadosJogador d = new dadosJogador(); 
		d.setPalavras(palavras);
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public char[] getJogo() {
		dadosJogador d = new dadosJogador(); 
		char[] Jogo = d.getJogo();
		return Jogo;
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public void setJogo( ) {
		dadosJogador d = new dadosJogador();
		d.setJogo( );
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}
	
}
