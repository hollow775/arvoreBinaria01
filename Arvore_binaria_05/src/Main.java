import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //criando a arvore
        long tempoInicial = 0;
        long tempoFinal = 0;
        BTree b = new BTree(3);
        b = ComporArvore(b, 5000);

        //Verifique se os 10 primeiros números primos estão presentes.
        // Imprima e Remova-os da árvore
        tempoInicial = System.currentTimeMillis();
        b = Primo(b);
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo gasto A: "+(tempoFinal - tempoInicial));
        System.out.println("\n////////////\n");
        //Verifique se os múltiplos de 5 estão presentes.
        // Imprima e Remova-os da árvore
        tempoInicial = System.currentTimeMillis();
        b = Multiplos5(b);
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo gasto B: "+(tempoFinal - tempoInicial));
        System.out.println("\n////////////\n");

        //Insira 100 números criados aleatoriamente na árvore e imprima a árvore em-ordem.
        tempoInicial = System.currentTimeMillis();
        b = ComporArvore(b, 100);
        b.Show();
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo gasto C: "+(tempoFinal - tempoInicial));
        System.out.println("\n////////////\n");

        //Verifique se os múltiplos de 5 e os 10 primeiros números primos estão presentes.
        // Imprima e Remova-os da árvore.
        b = Multiplos5(b);
        b = Primo(b);
        tempoInicial = System.currentTimeMillis();
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo gasto D: "+(tempoFinal - tempoInicial));
        System.out.println("\n////////////\n");
    }
    static BTree ComporArvore(BTree b, int tamanho){
        Random random = new Random();
        for(int i=0; i<tamanho; i++){
            b.Insert(random.nextInt(10000));
        }
        return(b);
    }
    static BTree Primo(BTree b){
        int[] primos = {2, 3, 5, 7, 9, 11, 13, 17, 19, 23};
        for(int i=0; i<10; i++){
            if(b.Contain(primos[i]) != false){
                System.out.print(primos[i] + ", ");
                b.Remove(primos[i]);
            }
        }
        return(b);
    }
    static BTree Multiplos5(BTree b){
        for(int i = 0; i<10000; i = i + 5){
            if(b.Contain(i) != false){
                System.out.print(i + ", ");
                b.Remove(i);
            }
        }
        return(b);
    }
}

