
package support;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class ArquivoRank {

	public static String lerArquivoRank() {
		
		/* Cria uma inst�ncia de File Reader -- Classe p/ intera��o c/ Arquivos */
		FileReader fileR;
		
		/* Buffer para leitura */
		BufferedReader buff;
		
		/* String de retorno - */
		String leituraArquivo = null;
		
		/* Vari�vel de �ndice */
		int cont = 0;
		
		/* Realiza tentativa de leitura do Arquivo */
		try {
			
			/* Obt�m o arquivo xml*/
			fileR = new FileReader("libs//Rank.xml");
			
			/* Determina o Buffer */
			buff = new BufferedReader(fileR);
			
			/* Enquanto houver conte�do a ser lido */
			while (buff.ready()) {
				
				/* Obt�m o conte�do da Linha e incrementa o Contador */
				if(cont==0){
					leituraArquivo = buff.readLine();
					cont++;
				}
				
				/* Obt�m a linha subsequente do arquivo para ler */
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
		
		/* Cria uma inst�ncia de File Reader -- Classe p/ intera��o c/ Arquivos */
		FileWriter fileRank;
		
		/* Buffer para leitura */
		BufferedWriter buff;
		
		/*Grava��o*/
		try {
			
			/* Obt�m o arquivo xml */
			fileRank = new FileWriter("libs//Rank.xml");
			
			/* Gera o Buffer p/ grava��o */
			buff = new BufferedWriter(fileRank);
			
			/* Insere o Cote�do da String no Arquivo */
			buff.write(inserirNoArquivo);
			
			/* Encerra o Buffer */
			buff.close();
			
		} catch (IOException e) {
			// Tratamento de Erros
			
			System.out.println("\n\n\t\t   ERRO! N�o foi poss�vel realizar grava��o do arquivo.");
			System.out.println("\n\t\t   Verifique se o arquivo 'Rank.xml' se encontra na pasta");
			System.out.println("\n\t\t             'libs', na ra�z desta aplica��o.        \n\n");
			
			e.printStackTrace();
		}
	}
}