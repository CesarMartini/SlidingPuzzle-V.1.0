import java.util.ArrayList;
import java.util.List;

import support.Keyboard;


public class WordList {
	
	// Criação de uma lista para Armazenar palavras.
	List<Words> listap = new ArrayList<Words>();;
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	/* Adiciona Palavra */
	public void addWList(Words np) {
		
		// Flag para verificar existência de Palavra;
		boolean Existe = false;
		
		// Enquanto houverem itens na lista
		for (Words words : listap) {
			
			// Verifica se a palavra existe
			if (words.getPalavra().equals(np.getPalavra())) {
				Existe = true;
				System.out.println("\n\n\t   Impossível Cadastrar: A palavra já existe!");
			}		
		}
		if (!Existe){
			this.listap.add(np);
			System.out.println("\n\n\t   Nova Palavra Cadastrada com Sucesso!");
		}
		
		System.out.print("\n\n\n#-----------------------------------------------------------------------------#\n");
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public void imprimirPalavras(){
		
		int i = 0;
		
		System.out.print("\n\n\n#-----------------------------------------------------------------------------#\n");
		System.out.print("\n                      L E I T U R A   D A S   P A L A V R A S                     ");
		System.out.print("\n\n#-----------------------------------------------------------------------------#\n");
		
		for (Words wordsler : listap) {
			System.out.print("\n\n\t   PALAVRA " + (i+1) + " :  \t" + wordsler.getPalavra() + ".");
			i++;
		}
		
		System.out.print("\n\n\n#-----------------------------------------------------------------------------#");
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public void deletarPalavras(){
		
		int num = 0, fl = 0, del=0;
		String ver = "FALTA", t=null;
		
		while (del == 0){
			System.out.print("\n\n\n#-----------------------------------------------------------------------------#\n");
			System.out.print("\n                        R E M O V E R   P A L A V R A S                              ");
			System.out.print("\n\n#-----------------------------------------------------------------------------#\n");
			
			/* Informa user */
			System.out.print("\n\n\n\t   Para consultar a lista de palavras, insira '0'.");
			System.out.print("\n\n\t   Por favor, insira o número correspondente: ");
			num = Keyboard.readInt();
			
			if (num == 0){
				imprimirPalavras();
			}else {
				/* Remove da Lista */
				for (Words wordsRemove : listap) {
					
					if ((fl+1)==(num)){
						
						//ver = words.getPalavra();
						this.listap.remove(wordsRemove);
						del = 1;
						break;
					}
					fl++;
					
				}
				
				/* Verifica Remoção */
				for (Words wordsverifica : listap) {
					if ((num)==(fl+1)){
						
						t = wordsverifica.getPalavra();
								
						if ((ver)==(t)){
							System.out.println("\n\n\t     Falha na Remoção da Palavra! Tente Novamente.");
							System.out.print("\n\n#-----------------------------------------------------------------------------#\n");
						}
					}
					
					fl++;
				}
			}
		}
		
		System.out.println("\n\t     Palavra Removida com Sucesso!");
		System.out.print("\n\n#-----------------------------------------------------------------------------#\n");
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public String [] obterPalavras(){
		
		/* Array do tipo String para Obter as Palavras */
		String[] palavras = {"teste", "teste", "teste", "teste"};
		
		/* Flag de Verificação */
		int flagq = 0, flagt = 0;
		
		/* String para verificações */
		//String palavra = "teste";
		
		/* Índices e Leitura de Posição*/
		int /*i=0, j=0,*/ esc=0, c=0, num=0/*, k=0*/; 
		
		
		
		System.out.print("\n\n\n#-----------------------------------------------------------------------------#\n");
		System.out.print("\n                     E S C O L H A   D E   P A L A V R A S                           ");
		System.out.print("\n\n#-----------------------------------------------------------------------------#\n");
		
		/* Verificação da Quantidade de Palavras Existentes na Lista *
		for (Words wordsescolha : listap) {
			
			palavra = wordsescolha.getPalavra();
			teste = palavra.toCharArray();
			
			System.out.println("Chegou. palavra: "+palavra);
			
			if ((teste.length) == (3)){
				j++;
				System.out.println("entrou 3");
			}else if ((teste.length)==(4)){
				i++;
				System.out.println("entrou 4");
			}
		}
		
		if (i>4){
			if (j>1){
				k=1;
			}
		}
		// Verificação: existem palavras suficientes para criar o jogo 
		if (k==1){*/
			
			while ((flagt+flagq)!=(4)){
				
				/* Laço para obter 4 palavras*/
				for (num=0; num<4; num++){
					
					esc = 0;
					
					while (esc==0){
						
						System.out.print("\n\n\t   Por favor, insira o número correspondente a palavra desejada:");
						esc = Keyboard.readInt();
						
					}
					
					c = 0;
					
					for (Words wor : listap) {
						
						// Obtém a palavra da lista
						if ((c+1)==(esc)){
							palavras[num] = wor.getPalavra();
						}
						
						// Índice para comparar lista
						c++;
					}
					
					/* Array char para testes */
					char [] teste = (palavras[num].toCharArray());
					
					/* Verificação do Conjunto de palavras */
					if ((teste.length)==(4)){
						
						flagq++;
						
					}else if ((teste.length)==(3)){
						
						flagt++;
					}
					
				}
				
				/* Verificador de Conjunto */
				if ((flagt+flagq!=4)&&(num==3)){
				
					System.out.print("\n\n\t   Por favor, selecione uma palavra de três caracteres");
					System.out.print("\n\t   e três palavras de quatro caracteres para criar o jogo.");
					
				}else if((flagt+flagq==4)&&(num==3)){
					System.out.println("\n\n\t   Palavras Selecionadas!");
				}
			}
		/*}else if (k == 0){
			
			/* Mostra ao usuário mensagem informando necessidade de inserir mais palavras *
			System.out.print("\n\n\t   Não existem palavras suficientes para criar o jogo!");
			System.out.print("\n\n\t   Por favor, cadastre mais palavras de ");
			
			if ((i<4)&&(j<1)){
				System.out.println("três e quatro letras!");
			}else if (i<4){
				System.out.println("quatro letras!");
			}else if (i<3){
				System.out.println("três letras!");
			}
			
			palav[0] = "FALTA";
		}*/
		
		return palavras;
	}
	
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	// Método para cadastro das Palavras...
	public void cadastro () {
		
		// Nova instância - classe WordList
		//WordList wl = new WordList();
		// Nova instância - classe Word
		Words w = new Words();
		
		// String para leitura da Palavra e Variáveis para Controle de Fluxo.
		String p; 
		int v=0, o=1, i=0;
		
		// Instruções para o usuário e leitura da String.
		System.out.print("\n\n\n#-----------------------------------------------------------------------------#\n");
		System.out.print("\n                     C A D A S T R O   D E  P A L A V R A S                          ");
		System.out.print("\n\n#-----------------------------------------------------------------------------#\n");
		
		while (o==1){
			
			System.out.print("\n\t   Por favor, insira a palavra a ser cadastrada: \t");
			
			p = Keyboard.readString();
			p = p.toUpperCase();
			
			// String p/ Array (char)
			char[] t = p.toCharArray();
			
			// Verificação - Comprimento do Array
			v = t.length;
			
			// Verificação - Contém Zeros
			for (i=0;i<v;i++){
				if ((t[i]) == (0)){
					// Impede Cadastro
					v = 10;
				}
			}
			
			// Verificação: Se o Array possui 3 ou 4 Letras
			if ((v==3)||(v==4)){
				
				// Cria Palavra 
				w.setPalavra(p);
				
				// Cadastra Palavra
				addWList(w);
				
				o=0;
				
			// Identificação de Erro, Retorno ao Usuário e Looping da Operação.
			}else {
				
				System.out.print("\n\n\t Apenas palavras de três e quatro caracteres são aceitas. Tente Novamente.\n\n");
				o=1;
				
			}
		}
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/

}
