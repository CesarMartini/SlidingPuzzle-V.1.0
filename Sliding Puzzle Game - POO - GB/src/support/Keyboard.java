package support;
/* As seguintes linhas permitem o uso das classes de entrada e saída e de processamento
 de tokens */
import java.io.*;
import java.util.*;
/**
 * A classe Keyboard, que permite a leitura de dados de tipos nativos e da classe
 * String a partir do teclado. Basicamente esta classe encapsula o funcionamento do
 * Stream System.in, que pode ser usado como entrada padrão de dados.
 *
 * Esta classe é baseada na classe EasyIn, de Peter van der Linden. As principais
 * modificações foram:
 * - Os métodos são estáticos para facilitar o uso da classe
 * - Criação de métodos sobrecarregados para que valores default possam ser usados
 * - Melhor tratamento das exceções
 * - Reconhecimento de vários valores como booleanos e capacidade de leitura de
 * NaNs e infinitos para valores dos tipos float e double
 * - Descrição dos detalhes de implementação com comentários
 *
 * A classe permite o uso de arquivos de respostas ("answer files"), que são arquivos
 * contendo os dados que deveriam ser entrados pelo teclado. A entrada destes dados
 * pode ser simulada através de redirecionamento de arquivos. Se, por exemplo, tivermos
 * uma aplicação (classe) DemoDataKeyboard e quisermos usar um arquivo de respostas
 * chamado "dados.dat" que já contém os dados que devem ser digitados, podemos executar
 * o comando java DemoDataKeyboard < dados.dat para ler os dados do arquivo ao invés de
 * do teclado. O comando será o mesmo para os sistemas operacionais Windows e Linux.
 *
 * O suporte a arquivos de respostas é limitado, somente funcionará se todos os dados
 * a serem digitados forem entrados no arquivo de respostas, um em cada linha.
 * Exceções ocorrerão caso estas regras não sejam seguidas.
 *
 * A mensagem original de copyright de Peter van de Linden é mostrada ao final desta
 * listagem. Vale a pena notar que a sintaxe proposta e mostrada na mensagem é
 * diferente da usada pela classe Keyboard.
 *
 * O livro "An Introduction to Computer Science Using Java", de Samuel N. Kamin,
 * M. Dennis Mickunas e Edward M. Reingold (editora McGraw-Hill, ISBN 0-07-034224-5)
 * também apresenta uma classe Keyboard, cujo funcionamento e código são diferentes
 * desta.
 *
 * @author Rafael Santos
 */
public class Keyboard
{
   /**
    * Declaração dos campos privados desta classe.
    */
// O campo is é uma instância da classe InputStreamReader que será construída a
// partir do stream System.in. Note que já que esta classe só tem métodos estáticos,
// não terá construtor, mas podemos inicializar instâncias de classes desta forma.
   private static InputStreamReader is = new InputStreamReader( System.in );
// O campo br é uma instância da classe BufferedReader que usa is como argumento
// para seu construtor.
   private static BufferedReader br = new BufferedReader( is );
// O campo st é uma instância da classe StringTokenizer que será usada em vários
// métodos na classe.
   private static StringTokenizer st;
// O campo nt é uma instância da classe String que será usada em vários métodos
// na classe.
   private static String nt;
// O campo debug estabelece se mensagens de erro de conversão e leitura devem
// ser mostradas ou não. O campo não pode ser modificado diretamente, mas
// através de métodos específicos descritos abaixo.
   private static boolean debug = false;
   /**
    * O método getToken lê uma String do BufferedReader associado com a entrada padrão
    * e retorna uma instância de StringTokenizer contendo os tokens criados a partir
    * da linha lida. O método é declarado como private pois só deverá ser chamado
    * a partir de outros métodos da classe.
    * @return uma instância de StringTokenizer contendo os tokens obtidos da linha lida
    * @exception IOException se um erro de entrada e saída ocorrer.
    * @exception NullPointerException se uma string vazia for lida e tentarmos construir
    * uma instância de StringTokenizer com ela
    */
   private static StringTokenizer getToken() throws IOException, NullPointerException
   {
      String s = br.readLine();
      return new StringTokenizer(s);
   } // fim do método getToken
   /**
    * O método readBoolean lê e retorna um valor do tipo boolean. Este método
    * simplesmente chama o método readBoolean com argumentos, descrito abaixo,
    * considerando o valor default como sendo true.
    * @return o valor do tipo boolean lido (ou, em caso de erro de leitura, true)
    */
   public static boolean readBoolean()
   {
      return readBoolean(true);
   }
   /**
    * O método readBoolean lê e retorna um valor do tipo boolean. Este método tenta
    * pegar o próximo token a ser lido da entrada padrão e o compara com algumas
    * Strings constantes para verificar a igualdade, e retorna true ou false dependendo
    * do resultado da comparação.
    * @param defaultvalue o valor default caso não seja possível ler e decodificar
    * um valor booleano
    * @return o valor do tipo boolean lido (ou, em caso de erro de leitura, igual ao
    * argumento passado para o método
    */
   public static boolean readBoolean(boolean defaultvalue)
   {
      try
      {
         st = getToken(); // pega os tokens a partir da linha lida
         nt = st.nextToken(); // e a primeira String do token.
//       Retorna true se a String for igual a...
         if (nt.equalsIgnoreCase("true") || // true
            nt.equalsIgnoreCase("t") || // t
            nt.equalsIgnoreCase("yes") || // yes
            nt.equalsIgnoreCase("y") || // y
            nt.equalsIgnoreCase("on") || // on
            nt.equalsIgnoreCase("v") || // v
            nt.equalsIgnoreCase("s") || // s
            nt.equalsIgnoreCase("sim") || // sim
            nt.equalsIgnoreCase("verdadeiro")) // verdadeiro
            return true;
//       Retorna false se a String for igual a...
         else if (nt.equalsIgnoreCase("false") || // false
            nt.equalsIgnoreCase("f") || // f
            nt.equalsIgnoreCase("no") || // no
            nt.equalsIgnoreCase("n") || // n
            nt.equalsIgnoreCase("off") || // off
            nt.equalsIgnoreCase("nao") || // nao
            nt.equalsIgnoreCase("não") || // não
            nt.equalsIgnoreCase("falso")) // falso
            return false;
//       Se não for nenhum dos valores reconhecidos, retorna o default
         else return defaultvalue;
      }
      catch (IOException ioe) // se houver algum erro de leitura
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Erro de entrada e saída lendo um boolean. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
      catch (NoSuchElementException nsee) // se não houverem tokens
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Entrada não contém um boolean. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
   } // fim do método readBoolean
   /**
    * O método readByte lê e retorna um valor do tipo byte. Este método
    * simplesmente chama o método readByte com argumentos, descrito abaixo,
    * considerando o valor default como sendo (byte)0.
    * @return o valor do tipo byte lido (ou, em caso de erro de leitura, (byte)0)
    */
   public static byte readByte()
   {
      return readByte((byte)0);
   } // fim do método readByte
   /**
    * O método readByte lê e retorna um valor do tipo byte. Este método tenta
    * pegar o próximo token a ser lido da entrada padrão e o passa como argumento para
    * o construtor da classe Byte, que tenta convertê-lo. Se a leitura e conversão
    * puderem ser feitas, um valor do tipo byte é retornado, caso contrário o valor
    * default (passado como argumento) é retornado.
    * @param defaultvalue o valor default caso não seja possível ler e decodificar
    * um valor do tipo byte
    * @return o valor do tipo byte lido (ou, em caso de erro de leitura, igual ao
    * argumento passado para o método
    */
   public static byte readByte(byte defaultvalue)
   {
      try
      {
         st = getToken(); // pega os tokens a partir da linha lida
         nt = st.nextToken(); // e a primeira String do token.
//       retorna o valor processado pela classe Byte
         return Byte.parseByte(nt);
      }
      catch (IOException ioe) // se houver algum erro de leitura
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Erro de entrada e saída lendo um byte. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
      catch (NumberFormatException nfe) // se houver algum erro de conversão
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Erro de conversão de "+nt+" para um byte. "+
               "Retorna "+defaultvalue);
         return defaultvalue;
      }
      catch (NoSuchElementException nsee) // se não houverem tokens
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Entrada não contém um byte. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
   } // fim do método readByte
   /**
    * O método readShort lê e retorna um valor do tipo short. Este método
    * simplesmente chama o método readShort com argumentos, descrito abaixo,
    * considerando o valor default como sendo (short)0.
    * @return o valor do tipo short lido (ou, em caso de erro de leitura, (short)0)
    */
   public static short readShort()
   {
      return readShort((short)0);
   } // fim do método readShort
   /**
    * O método readShort lê e retorna um valor do tipo short. Este método tenta
    * pegar o próximo token a ser lido da entrada padrão e o passa como argumento para
    * o construtor da classe Short, que tenta convertê-lo. Se a leitura e conversão
    * puderem ser feitas, um valor do tipo short é retornado, caso contrário o valor
    * default (passado como argumento) é retornado.
    * @param defaultvalue o valor default caso não seja possível ler e decodificar
    * um valor do tipo short
    * @return o valor do tipo short lido (ou, em caso de erro de leitura, igual ao
    * argumento passado para o método
    */
   public static short readShort(short defaultvalue)
   {
      try
      {
         st = getToken(); // pega os tokens a partir da linha lida
         nt = st.nextToken(); // e a primeira String do token.
//       retorna o valor processado pela classe Short
         return Short.parseShort(nt);
      }
      catch (IOException ioe) // se houver algum erro de leitura
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Erro de entrada e saída lendo um short. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
      catch (NumberFormatException nfe) // se houver algum erro de conversão
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Erro de conversão de "+nt+" para um short. "+
               "Retorna "+defaultvalue);
         return defaultvalue;
      }
      catch (NoSuchElementException nsee) // se não houverem tokens
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Entrada não contém um short. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
   } // fim do método readShort
   /**
    * O método readInt lê e retorna um valor do tipo int. Este método
    * simplesmente chama o método readInt com argumentos, descrito abaixo,
    * considerando o valor default como sendo 0.
    * @return o valor do tipo int lido (ou, em caso de erro de leitura, 0)
    */
   public static int readInt()
   {
      return readInt(0);
   } // fim do método readInt
   /**
    * O método readInt lê e retorna um valor do tipo int. Este método tenta
    * pegar o próximo token a ser lido da entrada padrão e o passa como argumento para
    * o construtor da classe Int, que tenta convertê-lo. Se a leitura e conversão
    * puderem ser feitas, um valor do tipo int é retornado, caso contrário o valor
    * default (passado como argumento) é retornado.
    * @param defaultvalue o valor default caso não seja possível ler e decodificar
    * um valor do tipo int
    * @return o valor do tipo int lido (ou, em caso de erro de leitura, igual ao
    * argumento passado para o método
    */
   public static int readInt(int defaultvalue)
   {
      try
      {
         st = getToken(); // pega os tokens a partir da linha lida
         nt = st.nextToken(); // e a primeira String do token.
//       retorna o valor processado pela classe Integer
         return Integer.parseInt(nt);
      }
      catch (IOException ioe) // se houver algum erro de leitura
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Erro de entrada e saída lendo um int. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
      catch (NumberFormatException nfe) // se houver algum erro de conversão
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Erro de conversão de "+nt+" para um int. "+
               "Retorna "+defaultvalue);
         return defaultvalue;
      }
      catch (NoSuchElementException nsee) // se não houverem tokens
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Entrada não contém um int. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
   } // fim do método readInt
   /**
    * O método readLong lê e retorna um valor do tipo long. Este método
    * simplesmente chama o método readLong com argumentos, descrito abaixo,
    * considerando o valor default como sendo 0l.
    * @return o valor do tipo long lido (ou, em caso de erro de leitura, 0l)
    */
   public static long readLong()
   {
      return readLong(0l);
   } // fim do método readLong
   /**
    * O método readLong lê e retorna um valor do tipo long. Este método tenta
    * pegar o próximo token a ser lido da entrada padrão e o passa como argumento para
    * o construtor da classe Long, que tenta convertê-lo. Se a leitura e conversão
    * puderem ser feitas, um valor do tipo long é retornado, caso contrário o valor
    * default (passado como argumento) é retornado.
    * @param defaultvalue o valor default caso não seja possível ler e decodificar
    * um valor do tipo long
    * @return o valor do tipo long lido (ou, em caso de erro de leitura, igual ao
    * argumento passado para o método
    */
   public static long readLong(long defaultvalue)
   {
      try
      {
         st = getToken(); // pega os tokens a partir da linha lida
         nt = st.nextToken(); // e a primeira String do token.
//       retorna o valor processado pela classe Long
         return Long.parseLong(nt);
      }
      catch (IOException ioe) // se houver algum erro de leitura
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Erro de entrada e saída lendo um long. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
      catch (NumberFormatException nfe) // se houver algum erro de conversão
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Erro de conversão de "+nt+" para um long. "+
               "Retorna "+defaultvalue);
         return defaultvalue;
      }
      catch (NoSuchElementException nsee) // se não houverem tokens
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Entrada não contém um long. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
   } // fim do método readLong
   /**
    * O método readFloat lê e retorna um valor do tipo float. Este método
    * simplesmente chama o método readFloat com argumentos, descrito abaixo,
    * considerando o valor default como sendo 0f.
    * @return o valor do tipo float lido (ou, em caso de erro de leitura, 0f)
    */
   public static float readFloat()
   {
      return readFloat(0f);
   } // fim do método readFloat
   /**
    * O método readFloat lê e retorna um valor do tipo float. Este método tenta
    * pegar o próximo token a ser lido da entrada padrão e o analisa, verificando se
    * aparentemente é NaN ou infinito. Se não for, passa o valor lido como argumento
    * para o método parseFloat da classe Float, que tenta convertê-lo. Se a leitura e
    * conversão puderem ser feitas, um valor do tipo float é retornado, caso contrário
    * o valor default (passado como argumento) é retornado.
    * @param defaultvalue o valor default caso não seja possível ler e decodificar
    * um valor do tipo float
    * @return o valor do tipo float lido (ou, em caso de erro de leitura, igual ao
    * argumento passado para o método
    */
   public static float readFloat(float defaultvalue)
   {
      try
      {
         st = getToken(); // pega os tokens a partir da linha lida
         nt = st.nextToken(); // e a primeira String do token.
//       Verifica se o valor é aparentemente NaN ou infinito
         if (nt.toLowerCase().startsWith("nan")) return Float.NaN;
         else if (nt.toLowerCase().startsWith("inf")) return Float.POSITIVE_INFINITY;
         else if (nt.toLowerCase().startsWith("+inf")) return Float.POSITIVE_INFINITY;
         else if (nt.toLowerCase().startsWith("-inf")) return Float.NEGATIVE_INFINITY;
//       Retorna o valor processado pela classe Float
         else return Float.parseFloat(nt);
      }
      catch (IOException ioe) // se houver algum erro de leitura
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Erro de entrada e saída lendo um float. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
      catch (NumberFormatException nfe) // se houver algum erro de conversão
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Erro de conversão de "+nt+" para um float. "+
               "Retorna "+defaultvalue);
         return defaultvalue;
      }
      catch (NoSuchElementException nsee) // se não houverem tokens
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Entrada não contém um float. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
   } // fim do método readFloat
   /**
    * O método readDouble lê e retorna um valor do tipo double. Este método
    * simplesmente chama o método readDouble com argumentos, descrito abaixo,
    * considerando o valor default como sendo 0.0.
    * @return o valor do tipo double lido (ou, em caso de erro de leitura, 0.0)
    */
   public static double readDouble()
   {
      return readDouble(0.0);
   } // fim do método readDouble
   /**
    * O método readDouble lê e retorna um valor do tipo double. Este método tenta
    * pegar o próximo token a ser lido da entrada padrão, analisando o valor para
    * ver se é NaN ou infinito, e se não for, usa o valor como argumento para o método
    * parseDouble da classe Double, que tenta convertê-lo. Se a leitura e conversão
    * puderem ser feitas, um valor do tipo double é retornado, caso contrário o valor
    * default (passado como argumento) é retornado.
    * @param defaultvalue o valor default caso não seja possível ler e decodificar
    * um valor do tipo double
    * @return o valor do tipo double lido (ou, em caso de erro de leitura, igual ao
    * argumento passado para o método
    */
   public static double readDouble(double defaultvalue)
   {
      try
      {
         st = getToken(); // pega os tokens a partir da linha lida
         nt = st.nextToken(); // e a primeira String do token.
//       Verifica se o valor é aparentemente NaN ou infinito
         if (nt.toLowerCase().startsWith("nan")) return Double.NaN;
         else if (nt.toLowerCase().startsWith("inf")) return Double.POSITIVE_INFINITY;
         else if (nt.toLowerCase().startsWith("+inf")) return Double.POSITIVE_INFINITY;
         else if (nt.toLowerCase().startsWith("-inf")) return Double.NEGATIVE_INFINITY;
//       Retorna o valor processado pela classe Double
         return Double.parseDouble(nt);
      }
      catch (IOException ioe) // se houver algum erro de leitura
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Erro de entrada e saída lendo um double. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
      catch (NumberFormatException nfe) // se houver algum erro de conversão
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Erro de conversão de "+nt+" para um double. "+
               "Retorna "+defaultvalue);
         return defaultvalue;
      }
      catch (NoSuchElementException nsee) // se não houverem tokens
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Entrada não contém um double. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
   } // fim do método readDouble
   /**
    * O método readChar lê e retorna um valor do tipo char. Este método
    * simplesmente chama o método readChar com argumentos, descrito abaixo,
    * considerando o valor default como sendo ’ ’ (espaço).
    * @return o valor do tipo char lido (ou, em caso de erro de leitura, espaço)
    */
   public static char readChar()
   {
      return readChar(' ');
   } // fim do método readChar
   /**
    * O método readChar lê e retorna um valor do tipo char. Este método tenta
    * pegar o próximo token a ser lido da entrada padrão e retorna o primeiro caracter
    * deste token, ignorando os outros. Se a leitura puder ser feita, um valor do tipo
    * char é retornado, caso contrário o valor default (passado como argumento) é
    * retornado.
    * @param defaultvalue o valor default caso não seja possível ler um valor do tipo
    * char
    * @return o valor do tipo char lido (ou, em caso de erro de leitura, igual ao
    * argumento passado para o método
    */
   public static char readChar(char defaultvalue)
   {
      try
      {
         st = getToken(); // pega os tokens a partir da linha lida
         nt = st.nextToken(); // e a primeira String do token.
//       retorna o primeiro caracter da String acima
         return nt.charAt(0);
      }
      catch (IOException ioe) // se houver algum erro de leitura
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Erro de entrada e saída lendo um char. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
      catch (NoSuchElementException nsee) // se não houverem tokens
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Entrada não contém um char. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
   } // fim do método readChar
   /**
    * O método readString lê e retorna uma instância da classe String. Este método
    * simplesmente chama o método readString com argumentos, descrito abaixo,
    * considerando o valor default como sendo "" (String vazia).
    * @return o valor do tipo String lido (ou, em caso de erro de leitura, uma String
    * vazia)
    */
   public static String readString()
   {
      return readString("");
   } // fim do método readString
   /**
    * O método readString lê e retorna um valor do tipo String. Este método retorna
    * uma linha inteira lida da entrada padrão, sem processá-la como tokens. Se a
    * leitura puder ser feita, a String lida é retornada, caso contrário o valor
    * default (passado como argumento) é retornado. O valor default também é retornado
    * no caso de uma String vazia.
    * @param defaultvalue o valor default caso não seja possível ler um valor do tipo
    * String
    * @return o valor do tipo String lido (ou, em caso de erro de leitura, igual ao
    * argumento passado para o método
    */
   public static String readString(String defaultvalue)
   {
      try
      {
         nt = br.readLine(); // uma String lida diretamente
         if (nt.trim().length() == 0) // nada foi entrado, então
            return defaultvalue; // retorna o valor default
         else return nt; // retorna o que foi lido
      }
      catch (IOException ioe) // se houver algum erro de leitura
      {
         if (debug) // se for pedida a impressão de mensagens de erro
            System.err.println("KEYBOARD:: Erro de entrada e saída lendo um String. "+
               "Retorna "+defaultvalue);
         return defaultvalue; // retorna o valor default
      }
   } // fim do método readString
   /**
    * O método debugOn modifica o campo que indica que mensagens de erro deverão ser
    * mostradas, fazendo com que sejam mostradas até que o método debugOff seja chamado.
    */
   public static void debugOn()
   {
      debug = true;
      System.err.println("KEYBOARD:: Mostrando mensagens de erro e avisos...");
   } // fim do método debugOn
   /**
    * O método debugOff modifica o campo que indica que mensagens de erro deverão ser
    * mostradas, fazendo com que não sejam mostradas até que o método debufOn seja
    * chamado.
    */
   public static void debugOff()
   {
      debug = false;
   } // fim do método debugOff
} // fim da classe Keyboard
//Segue a mensagem original da classe EasyIn de Peter van der Linden
//Simple input from the keyboard for all primitive types. ver 1.0
//Copyright (c) Peter van der Linden, May 5 1997.
//corrected error message 11/21/97
//
//The creator of this software hereby gives you permission to:
//1. copy the work without changing it
//2. modify the work providing you send me a copy which I can
//use in any way I want, including incorporating into this work.
//3. distribute copies of the work to the public by sale, lease,
//rental, or lending
//4. perform the work
//5. display the work
//6. fold the work into a funny hat and wear it on your head.
//
//This is not thread safe, not high performance, and doesn’t tell EOF.
//It’s intended for low-volume easy keyboard input.
//An example of use is:
//EasyIn easy = new EasyIn();
//int i = easy.readInt(); // reads an int from System.in
//float f = easy.readFloat(); // reads a float from System.
