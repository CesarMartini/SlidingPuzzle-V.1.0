
package support;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class ArquivoRank {

	public static String lerArquivoRank() {
		
		/* Cria uma instância de File Reader -- Classe p/ interação c/ Arquivos */
		FileReader fileR;
		
		/* Buffer para leitura */
		BufferedReader buff;
		
		/* String de retorno - */
		String leituraArquivo = null;
		
		/* Variável de Índice */
		int cont = 0;
		
		/* Realiza tentativa de leitura do Arquivo */
		try {
			
			/* Obtém o arquivo xml*/
			fileR = new FileReader("libs//Rank.xml");
			
			/* Determina o Buffer */
			buff = new BufferedReader(fileR);
			
			/* Enquanto houver conteúdo a ser lido */
			while (buff.ready()) {
				
				/* Obtém o conteúdo da Linha e incrementa o Contador */
				if(cont==0){
					leituraArquivo = buff.readLine();
					cont++;
				}
				
				/* Obtém a linha subsequente do arquivo para ler */
				if(cont>0)
					leituraArquivo += buff.readLine();
				}
			
			/* Encerra o Buffer */
			buff.close();
		
		} catch (FileNotFoundException e) {
			/* Caso ocorra falha ao ler o arquivo */
			} catch (IOException e) {
				/* Imprime mensagem de Erro */
				e.printStackTrace();
			}
		return leituraArquivo;

	}
	
	
	/*-----------------------------------------------------------------------------------------------------------*/
	
	
	public static void escreverArquivoRank(String inserirNoArquivo) {
		
		/* Cria uma instância de File Reader -- Classe p/ interação c/ Arquivos */
		FileWriter fileRank;
		
		/* Buffer para leitura */
		BufferedWriter buff;
		
		/*Gravação*/
		try {
			
			/* Obtém o arquivo xml */
			fileRank = new FileWriter("libs//Rank.xml");
			
			/* Gera o Buffer p/ gravação */
			buff = new BufferedWriter(fileRank);
			
			/* Insere o Coteúdo da String no Arquivo */
			buff.write(inserirNoArquivo);
			
			/* Encerra o Buffer */
			buff.close();
			
		} catch (IOException e) {
			// Tratamento de Erros
			
			System.out.println("\n\n\t\t   ERRO! Não foi possível realizar gravação do arquivo.");
			System.out.println("\n\t\t   Verifique se o arquivo 'Rank.xml' se encontra na pasta");
			System.out.println("\n\t\t             'libs', na raíz desta aplicação.        \n\n");
			
			e.printStackTrace();
		}
	}
}