import java.util.Random;

public class Arvore {
    public static void main (String args[]) {
        //criando a arvore
        Avl_tree tree = new Avl_tree();
        long tempoInicial = 0;
        long tempoFinal = 0;
        tree = ComporArvore(tree, 5000);


        //Verifique se os 10 primeiros números primos estão presentes.
        // Imprima e Remova-os da árvore
        tempoInicial = System.currentTimeMillis();
        tree = Primo(tree);
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo gasto A: "+(tempoFinal - tempoInicial));
        System.out.println("\n////////////\n");
        //Verifique se os múltiplos de 5 estão presentes.
        // Imprima e Remova-os da árvore
        tempoInicial = System.currentTimeMillis();
        tree = Multiplos5(tree);
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo gasto B: "+(tempoFinal - tempoInicial));
        System.out.println("\n////////////\n");

        //Insira 100 números criados aleatoriamente na árvore e imprima a árvore em-ordem.
        tempoInicial = System.currentTimeMillis();
        tree = ComporArvore(tree, 100);
        tree.imp_Infixa(tree.root);
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo gasto C: "+(tempoFinal - tempoInicial));
        System.out.println("\n////////////\n");

        //Verifique se os múltiplos de 5 e os 10 primeiros números primos estão presentes.
        // Imprima e Remova-os da árvore.
        tempoInicial = System.currentTimeMillis();
        tree = Multiplos5(tree);
        tree = Primo(tree);
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo gasto D: "+(tempoFinal - tempoInicial));
        System.out.println("\n////////////\n");
    }
    static Avl_tree ComporArvore(Avl_tree tree, int tamanho){
        Random random = new Random();
        for(int i=0; i<tamanho; i++){
             tree.root = tree.insert(tree.root, random.nextInt(10000));
        }
        return(tree);
    }
    static Avl_tree Primo(Avl_tree tree){
        int[] primos = {2, 3, 5, 7, 9, 11, 13, 17, 19, 23};
        for(int i=0; i<10; i++){
            if(tree.find(primos[i]) != null){
                System.out.print(primos[i] + ", ");
                tree.root = tree.delete(tree.root, primos[i]);
            }
        }
        return(tree);
    }
    static Avl_tree Multiplos5(Avl_tree tree){
        for(int i = 0; i<10000; i = i + 5){
            if(tree.find(i) != null){
                System.out.print(i + ", ");
                tree.root = tree.delete(tree.root,i);
            }
        }
        return(tree);
    }
}
