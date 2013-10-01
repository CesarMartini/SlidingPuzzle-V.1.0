

						/****************************************************************
						 * 																*
						 *		 "Sticks and stones may break your bones, but 			*
						 *				  words may never hurt you."					*
						 *																*
						 *																*
						 * 		 Classe para cadastro, exibi��o e escolha das			*
						 * 				    palavras do puzzle.							*
						 * 																*
						 * 	@author C�sar Martini; 										*
						 *	@version 0.2 (alpha);										*
						 *	@category games, college, college homework;					*
						 *																*
						 *																*
						 ****************************************************************/

/*
	NOTAS DO AUTOR:
	
	Conclu�do:
	
		* Leitura das palavras conclu�da -- Diferencia palavras de 3 e 4 letras;
		* Realiza verifica��o do comprimento das palavras cadastradas;
	
	Em Desenvolvimento:
	
		* Talvez deveria ser adicionada uma verifica��o de espa�os e n�meros nas palavras do puzzle. Ou n�o. (Verificar);
		* Grava��o das palavras em documento externo - XML.
		* Leitura das palavras cadastradas salvas no documento.
		* 
*/



//import support.Keyboard;


public class Words{
	
	/* ATRIBUTOS */
	/* Atributo Palavra*/
	private String Palavra;
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	/* GETTERS E SETTERS PARA PALAVRA */
	
	public String getPalavra() {
		return Palavra;
	}


	public void setPalavra(String palavra) {
		Palavra = palavra;
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*
	
	
	// M�todo para cadastro das Palavras...
	public void cadastro () {
		
		// Nova inst�ncia - classe WordList
		WordList wl = new WordList();
		
		// String para leitura da Palavra e Vari�veis para Controle de Fluxo.
		String p; 
		int v=0, o=1;
		
		// Instru��es para o usu�rio e leitura da String.
		System.out.print("\n\n\n\n\t\t\t # C A D A S T R O   D E  P A L A V R A S # \n\n");
		
		
		while (o==1){
			System.out.print("\n\t Por favor, insira a palavra a ser cadastrada. \n\t\t");
			p = Keyboard.readString();
			p = p.toUpperCase();
			
			// String p/ Array (char)
			char[] t = p.toCharArray();
			
			// Verifica��o - Comprimento do Array
			v = t.length;
			
			// Verifica��o: Se o Array possui 3 ou 4 Letras
			if ((v==3)||(v==4)){
				
				// Cria Palavra 
				w.setPalavra();
				
				// Cadastra Palavra
				wl.addWList(this.Palavra);
				
			// Identifica��o de Erro, Retorno ao Usu�rio e Looping da Opera��o.
			}else {
				
				System.out.print("\n\n\t ERRO! Entrada Incorreta. Tente Novamente.\n\n");
				o=1;
				
			}
		}
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/

}
 