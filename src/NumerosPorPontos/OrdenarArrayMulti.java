/**
 * @titulo Programa de ordenação de Array simples do tipo String com numeração separada por pontos (exemplo: 1, 1.1, 1.1.1, 1.1.1.1)
 * @versão 1.0
 * @autor Raul Santiago
 * @email raulsantiago@id.uff.br
 * @dataInicial 13/08/2018
 * @dataAtualização 13/08/2018
 * @responsávelAtualização Raul Santiago
 * @metodo Uilizar uma Array Simples de String converter para Array Multidimensional de Inteiros e ordenar por números crescente respeitando a
 * separação dos pontos, onde os números após os pontos através da Array Multidimensional de Inteiros são entendidas por colunas e ordenador, 
 * posteriormente a ordenação convertemos para Array Simples de String conforme a sua origem, inicialmente a Array Simples de String com 20
 * linhas, porém o correto é o tamanho existente do BD e 5 colunas podendo ser alterado pelo programador conforme requisitado pelo cliente.
 * Usuário não deve utilizar numeração com 0(zero), configurar REGEX e menssagem de alerta.
 */

package NumerosPorPontos;

import java.util.*;

class ProgramaOrdenar {
	public static void main(String[] args) {
		System.out.println("Programa de ordenação de numeros separado por ponto de Array simples do tipo String\n");
		// Definir no banco de dados not null para esta lista de códigos, evitando bug quando excluído pelo usuário.
		String codigos[] = new String[20]; //Definição do tamanho de linhas do Array simples tipo String, neste exemplo de 20 
		// mas tem que ser o tamnho idêntico ao existente no banco de dados, utilizar metodo de aferir quantidade de registro no BD
		// para definir o tamanho do array dinamicamente.
		codigos[0] = "5.4";
		codigos[1] = "5";
		codigos[2] = "5.1";
		codigos[3] = "5.1.3";
		codigos[4] = "5.1.2";
		codigos[5] = "5.1.2.2";
		codigos[6] = "5.12";
		codigos[7] = "5.50";
		codigos[8] = "5.5";
		codigos[9] = "5.1.4";
		codigos[10] = "5.1.5.1.3";		
		codigos[11] = "5.1.3.1";
		codigos[12] = "5.1.3.2";
		codigos[13] = "5.1.3.2.3";
		codigos[14] = "1.1";
		codigos[15] = "1.2";
		codigos[16] = "2";
		codigos[17] = "3.3.3";
		codigos[18] = "15.1.3";
		codigos[19] = "55.1.3";
		for(String codi: codigos)
		{
			System.out.println("Array simples de String inicialmente Desordenado: "+codi); //Somente para visualizar a inicial da lista
		}		
		// Preencher o Array Multidimensional somente com os números inteiros sem os pontos da separação extraídos do array simples tipo String
		int[][] tabela = new int[20][5]; // Definir o tamanho de acordo com o Array simples de String já requisitado/definido pelo cliente e BD
		for(int i=0; i < codigos.length; i++)
		{
			String str = new String(codigos[i]);			
			StringTokenizer valor = new StringTokenizer(str, ".");			
			int cont = 0;
			while (valor.hasMoreTokens())
			{				
				String numero = valor.nextToken();		
		        tabela[i][cont] =  Integer.valueOf(numero);
		        cont++;		        
		    }			
		}		
		// Listando somente para visualizar Array multidimensional de Inteiros inicialmente Desordenado
		System.out.println("--------------------------");
		System.out.println("Array multidimensional de Inteiros inicialmente Desordenado");
		for(int k=0; k < tabela.length; k++)
		{
			for(int j=0; j < tabela[k].length; j++) 
			{
				System.out.print(tabela[k][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
		// Aqui começa o método de ordenação por Array Multidimensional, limitado para somente ate 5 colunas, caso queira aumentar ampliar o
		// desenvoldimento dando continuidade para verificação de um maior números de colunas.
		// 1) Ordenação somente da PRIMEIRA coluna.
		for(int k=0; k < tabela.length; k++)
		{		
			for(int i=k+1; i < tabela.length; i++) 
			{	
				if(tabela[k][0] > tabela[i][0])
				{
					int aux0;
					int aux1;
					int aux2;
					int aux3;
					int aux4;
					aux0 = tabela[k][0];
					aux1 = tabela[k][1];
					aux2 = tabela[k][2];
					aux3 = tabela[k][3];
					aux4 = tabela[k][4];
					tabela[k][0] = tabela[i][0];
					tabela[k][1] = tabela[i][1];
					tabela[k][2] = tabela[i][2];
					tabela[k][3] = tabela[i][3];
					tabela[k][4] = tabela[i][4];
					tabela[i][0] = aux0;
					tabela[i][1] = aux1;
					tabela[i][2] = aux2;
					tabela[i][3] = aux3;					
					tabela[i][4] = aux4;					
				}			
			}
		}
		// 2) Ordenação somente da SEGUNDA coluna.				
		for(int k=0; k < tabela.length; k++)
		{		
			for(int i=k+1; i < tabela.length; i++) 
			{	
				if( (tabela[k][0] == tabela[i][0]) && (tabela[k][1] > tabela[i][1]) )
				{
					int aux0;
					int aux1;
					int aux2;
					int aux3;
					int aux4;
					aux0 = tabela[k][0];
					aux1 = tabela[k][1];
					aux2 = tabela[k][2];
					aux3 = tabela[k][3];
					aux4 = tabela[k][4];
					tabela[k][0] = tabela[i][0];
					tabela[k][1] = tabela[i][1];
					tabela[k][2] = tabela[i][2];
					tabela[k][3] = tabela[i][3];
					tabela[k][4] = tabela[i][4];
					tabela[i][0] = aux0;
					tabela[i][1] = aux1;
					tabela[i][2] = aux2;
					tabela[i][3] = aux3;					
					tabela[i][4] = aux4;					
				}
			}
		}
		// 3) Ordenação somente da TERCEIRA coluna.				
		for(int k=0; k < tabela.length; k++)
		{		
			for(int i=k+1; i < tabela.length; i++) 
			{	
				if( (tabela[k][0] == tabela[i][0]) && (tabela[k][1] == tabela[i][1]) && (tabela[k][2] > tabela[i][2]) )
				{
					int aux0;
					int aux1;
					int aux2;
					int aux3;
					int aux4;
					aux0 = tabela[k][0];
					aux1 = tabela[k][1];
					aux2 = tabela[k][2];
					aux3 = tabela[k][3];
					aux4 = tabela[k][4];
					tabela[k][0] = tabela[i][0];
					tabela[k][1] = tabela[i][1];
					tabela[k][2] = tabela[i][2];
					tabela[k][3] = tabela[i][3];
					tabela[k][4] = tabela[i][4];
					tabela[i][0] = aux0;
					tabela[i][1] = aux1;
					tabela[i][2] = aux2;
					tabela[i][3] = aux3;					
					tabela[i][4] = aux4;					
				}
			}
		}
		// 4) Ordenação somente da QUARTA coluna.				
		for(int k=0; k < tabela.length; k++)
		{		
			for(int i=k+1; i < tabela.length; i++) 
			{	
				if( (tabela[k][0] == tabela[i][0]) && (tabela[k][1] == tabela[i][1]) && (tabela[k][2] == tabela[i][2])
						&& (tabela[k][3] > tabela[i][3]) )
				{
					int aux0;
					int aux1;
					int aux2;
					int aux3;
					int aux4;
					aux0 = tabela[k][0];
					aux1 = tabela[k][1];
					aux2 = tabela[k][2];
					aux3 = tabela[k][3];
					aux4 = tabela[k][4];
					tabela[k][0] = tabela[i][0];
					tabela[k][1] = tabela[i][1];
					tabela[k][2] = tabela[i][2];
					tabela[k][3] = tabela[i][3];
					tabela[k][4] = tabela[i][4];
					tabela[i][0] = aux0;
					tabela[i][1] = aux1;
					tabela[i][2] = aux2;
					tabela[i][3] = aux3;					
					tabela[i][4] = aux4;					
				}
			}
		}
		// 5) Ordenação somente da QUINTA coluna.				
		for(int k=0; k < tabela.length; k++)
		{		
			for(int i=k+1; i < tabela.length; i++) 
			{	
				if( (tabela[k][0] == tabela[i][0]) && (tabela[k][1] == tabela[i][1]) && (tabela[k][2] == tabela[i][2])
						&& (tabela[k][3] == tabela[i][3]) && (tabela[k][4] > tabela[i][4]) )
				{
					int aux0;
					int aux1;
					int aux2;
					int aux3;
					int aux4;
					aux0 = tabela[k][0];
					aux1 = tabela[k][1];
					aux2 = tabela[k][2];
					aux3 = tabela[k][3];
					aux4 = tabela[k][4];
					tabela[k][0] = tabela[i][0];
					tabela[k][1] = tabela[i][1];
					tabela[k][2] = tabela[i][2];
					tabela[k][3] = tabela[i][3];
					tabela[k][4] = tabela[i][4];
					tabela[i][0] = aux0;
					tabela[i][1] = aux1;
					tabela[i][2] = aux2;
					tabela[i][3] = aux3;					
					tabela[i][4] = aux4;					
				}
			}
		}
		// Listando somente para visualizar Array multidimensional de Inteiros final Ordenado
		System.out.println("Array multidimensional de Inteiros final Ordenado");
		for(int k=0; k < tabela.length; k++)
		{
			for(int j=0; j < tabela[k].length; j++) 
			{
				System.out.print(tabela[k][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
		// Preencher o Array simples de String com os numeros em separados pelos pontos .
		String codigos2[] = new String[20]; //Definição do tamanho de linhas do Array simples tipo String, dinamico conforme registros no BD.
		for(int k=0; k < tabela.length; k++)
		{	
			String b = "";
			for(int i=0; i < 5; i++) //Definição numeros de colunas com cliente REGEX e menssagem alerta pro usuário
			{	
				if(tabela[k][i] != 0) // (0)Zero não pode ser utilizado pelo cliente para criar a lista de números com pontos.
				{
					String r = Integer.toString(tabela[k][i]);
					b += r + ".";
					int num = b.lastIndexOf(".");
					codigos2[k] = b.substring(0,num);
				}
			}
		}// Este Array simples de String codigos2[] que é a posição final ordenada para ser inserido no banco de dados.
		for(String codi: codigos2)
		{
			System.out.println("Array simples de String final Ordenado: "+codi); //Somente para visualizar a posição final da lista
		}
	}
}