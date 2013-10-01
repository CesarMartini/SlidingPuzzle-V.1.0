
public class dadosJogador {

	/* Palavras do Jogador */
	private String [] palavras = new String [4];
	
	/* Array do Jogador */
	private char [] Jogo = new char [16]; 
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public String[] getPalavras() {
		return palavras;
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public void setPalavras(String[] palavras) {
		this.palavras = palavras;
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public char[] getJogo() {
		return Jogo;
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public void setJogo( ) {
		String[] palavras = this.palavras;
		
		/* Índice / Flags */
		int i=0, fq=0, ft=0;
		
		/* Array para Inserção */
		char[] jogo = new char[16];
		
		/* Loop - Insere 4 palavras */
		for (i=0; i<4; i++){
			
			/* Obtém cada uma das palavras em um array de char */
			/* Array Auxiliar */
			char[] aux = palavras[i].toCharArray();
			
			/* Verifica se possui 4 letras */
			if (aux.length==4){
				fq++;
				
				/* Insere... */
				if (fq == 1){
					jogo[0] = aux[0];
					jogo[1] = aux[1];
					jogo[2] = aux[2];
					jogo[3] = aux[3];
					
				}else if (fq == 2){
					jogo[4] = aux[0];
					jogo[5] = aux[1];
					jogo[6] = aux[2];
					jogo[7] = aux[3];
					
				}else if (fq == 3){
					jogo[8] = aux[0];
					jogo[9] = aux[1];
					jogo[10] = aux[2];
					jogo[11] = aux[3];
				}
				
			/* Verifica se possui 3 letras */
			}else if (aux.length==3){
				ft++;
				
				/* Insere... */
				if (ft == 1){
					jogo[12] = aux[0];
					jogo[13] = aux[1];
					jogo[14] = aux[2];
				}
			}
		}
		
		/* Verificação Final */
		if ((fq+ft)==(4)){
			this.Jogo = jogo;
		
		}else{ 
			System.out.print("\n\n\t   Falha ao criar tabuleiro de Jogo! ");
		}
	}
	
}
