import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Main {

    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("/Users/macbook/Documents/IF_BBC/EAD/Estrutura_de_dados_II/Arquivos_ordenacao/dados_3.txt");
        BufferedReader readFile = new BufferedReader(file);
        FileWriter novoArquivo = new FileWriter("/Users/macbook/Documents/IF_BBC/EAD/Estrutura_de_dados_II/Arquivos_ordenacao/Algoritmos_ord_3/dadosOrdenados_3.txt");
        PrintWriter gravarArquivo = new PrintWriter(novoArquivo);

        gravarArquivo.printf("Desenvolvedor: Clayton Rodrigues Dos Prazeres.\n ___________ \n");
        // preparando o documento

        double contador = 0.0;
        String line = "";
        long tempoInicial;
        long tempoFinal;

        String linha = readFile.readLine();
        while (linha != null) {
            linha = readFile.readLine();
            if (linha != null) {
                line = linha;
            }
        }
        file.close();
        line = line.replace("[", "");
        line = line.replace("]", "");
        line = line.replace(" ", "");
        String[] str = line.split(",");
        int[] dados = new int[str.length];
        iniciarVetor(dados, str);

        //HeapSort
        tempoInicial = System.currentTimeMillis();
        contador = HeapSort(dados, contador);
        tempoFinal = System.currentTimeMillis() - tempoInicial;
        System.out.println("Heap Sort Executado em = " + (tempoFinal) + " ms\nCom " + contador + " movimentos.\n");
        gravarArquivo.printf("\nHeapSort: \n--------------------\n");
        gravarArquivo(gravarArquivo, contador, tempoFinal, dados);



        gravarArquivo.close();
    }

    public static void gravarArquivo(PrintWriter gravarArquivo, double contador, long tempoFinal, int dados[]) {
        gravarArquivo.printf("O números de movimentos foi: " + contador + ".\n");
        gravarArquivo.printf("O tempo gasto foi: " + tempoFinal + " ms.\n");
        gravarArquivo.printf("O vetor ordenado é: \n");
        for (int i = 0; i < dados.length; i++) {
            if (i == 0) {
                gravarArquivo.printf("[" + dados[i] + ", ");
            } else if (i == dados.length - 1) {
                gravarArquivo.printf(dados[i] + "]");
            } else {
                gravarArquivo.printf(dados[i] + ", ");
            }
        }
        gravarArquivo.printf("_______________________________\n\n\n");
    }

    public static void iniciarVetor(int dados[], String str[]) {
        for (int i = 0; i < str.length; i++) {
            dados[i] = Integer.parseInt(str[i]);
        }
    }
    public static double HeapSort(int arr[], double contador)
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            contador++;
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
        return contador;
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

}