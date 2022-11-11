import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class Exercicio3 {
	
	public static int[] randomArray = new int[10];

	public static void main(String[] args) {
		fillArray();
		printArray();
		ordenarCrescente();
		printArray();
		
		Scanner ler = new Scanner(System.in);
		
		System.out.printf("\n\nDigite um valor inteiro -> ");
		int element = ler.nextInt();
		if(searchElementRecursive(randomArray, element)) {
			System.out.printf("Elemento %d encontrado com sucesso no array.", element);
		} else {
			System.out.printf("Elemento %d não existe no array.", element);
		}
	}
	
	public static void fillArray() {
		Random gerador = new Random();
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = gerador.nextInt(1,1000);
		}
	}
	
	public static void printArray() {
		System.out.printf("\nO vetor aleatório tem os elementos -> ");
		for(int i = 0; i < randomArray.length; i++) {
			System.out.print(randomArray[i] + ", ");
		}
	}
	
	public static void ordenarCrescente() {
		int elementoTemp;
		
		for (int i = 0; i < randomArray.length; i++) {
			for (int j = 0; j < randomArray.length - 1; j++) {
				if(randomArray[j] > randomArray[j + 1]) {
					elementoTemp = randomArray[j];
					randomArray[j] = randomArray[j +1];
					randomArray[j +1] = elementoTemp;
				}
			}
		}
	}
	
	public static boolean searchElementRecursive(int[] arr, int element) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == element) {
				return true;
			}
		}
		return false;
	}
}
