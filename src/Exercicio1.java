import java.util.Scanner;

public class Exercicio1 {
	
	public static int arraysLengths = 10;
	public static String menuPrincipal = 	"Escolha uma opção:\n\n"
										+ 	"1. Cadastrar produto\n"
										+ 	"2. Pesquisar produto\n"
										+ 	"3. Listar produto\n"
										+ 	"4. Excluir produto\n"
										+ 	"5. Finalizar\n\n";
	
	public static String[] arrayProdutoNome = new String[arraysLengths];
	public static int[] arrayProdutoQuantidade = new int[arraysLengths];
	public static double[] arrayProdutoValor = new double[arraysLengths];
	public static int produtoIndex = 0;

	public static void main(String[] args) {
		int choice = 0;
		for(int i = 0; i < arrayProdutoNome.length; i++) {
			arrayProdutoNome[i] = "";
		}
		
		do {
			choice = leituraDosLados(menuPrincipal);
			
			switch(choice) {
			case 1: {
				if(produtoIndex < arraysLengths) {
					System.out.println("\nCadastrar Produto:\n");
					cadastrarProduto(produtoIndex);
					produtoIndex++;
				} else {
					System.out.println("O limite máximo de 10 produtos foi atingido.");
				}
				break;
			}
			case 2: {
				Scanner ler = new Scanner(System.in);
				System.out.println("\nPesquisar produto:\n");
				System.out.printf(Cadastro.nome.str);
				int idx = pesquisarProduto(utilStringConform(ler.nextLine()));
				if(idx != -1) {
					printResult(idx);
				} else {
					System.out.println("\nNão existe cadastro para o item procurado!\n");
				}
				
				break;
			}
			case 3: {
				System.out.println("\nListar Produto:\n");
				listarProdutos();
				break;
			}
			case 4: {
				System.out.println("\nExcluir Produto:\n");
				Scanner ler = new Scanner(System.in);
				System.out.printf(Cadastro.nome.str);
				int idx = pesquisarProduto(utilStringConform(ler.nextLine()));
				if(idx != -1) {
					printResult(idx);
					excluirProduto(idx);
					System.out.println("Produto excluido com sucesso!\n");
				} else {
					System.out.println("\nNão existe cadastro para o item procurado!\n");
				}
				break;
			}
			default:
				System.out.println("\nAplicação Terminda!\n");
			}
			
		} while(choice != 5);

	}
	
	public static int leituraDosLados(String str) {
		Scanner ler = new Scanner(System.in);			
		System.out.printf(str);	
		return ler.nextInt();
	}
	
	public static void cadastrarProduto(int index) {
		Scanner ler = new Scanner(System.in);
		
		System.out.printf(Cadastro.nome.str);	
		arrayProdutoNome[index] = ler.nextLine();
		
		System.out.printf(Cadastro.quantidade.str);	
		arrayProdutoQuantidade[index] = ler.nextInt();
		
		System.out.printf(Cadastro.valorUnitario.str);	
		arrayProdutoValor[index] = ler.nextDouble();
	}
	
	enum Cadastro {
		nome("Informe o nome do produto -> "),
		quantidade("Informe a quantidade de produtos -> "),
		valorUnitario("Informe o valor unitario do produto -> "),
		produtoNome("Produto -> "),
		produtoQt("Quantidade -> "),
		produtoValor("Valor Unitario -> ");
		
		private  String str = "";

		Cadastro(String str) {
			this.str = str;
		}
	}
	
	public static int pesquisarProduto(String str) {
		for(int i = 0; i < arrayProdutoNome.length; i++) {
			if(arrayProdutoNome[i].strip().equalsIgnoreCase(str)) {
				return i;
			}
		}
		return -1;
	}
	
	public static String utilStringConform(String str){
		return str.strip().toLowerCase();
	}
	
	public static void printResult(int idx) {
		System.out.printf("\n" + Cadastro.produtoNome.str);
		System.out.println(arrayProdutoNome[idx]);
		
		System.out.printf(Cadastro.produtoQt.str);
		System.out.println(arrayProdutoQuantidade[idx]);
		
		System.out.printf(Cadastro.produtoValor.str);
		System.out.printf("R$ %.2f\n\n", arrayProdutoValor[idx]);
	}
	
	public static void listarProdutos() {
		for(int i = 0; i < arrayProdutoNome.length; i++) {
			printResult(i);
		}
	}
	
	public static void excluirProduto(int idx) {
		arrayProdutoNome[idx] = "";
		arrayProdutoQuantidade[idx] = 0;
		arrayProdutoValor[idx] = 0.0;
	}

}
