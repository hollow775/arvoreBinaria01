import java.util.Random;
public class Arvore {
    public static void main(String args[]){
        //criando a arvore
        NoArvore tree = new NoArvore();
        long tempoInicial = 0;
        long tempoFinal = 0;
        tree = ComporArvore(tree, 5000);


        //Verifique se os 10 primeiros números primos estão presentes.
        // Imprima e Remova-os da árvore
        tempoInicial = System.currentTimeMillis();
        tree = balancearDWS(tree);
//        tree = balancearVetor(tree);
        Primo(tree);
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo gasto A: "+(tempoFinal - tempoInicial));
        System.out.println("\n////////////\n");
        //Verifique se os múltiplos de 5 estão presentes.
        // Imprima e Remova-os da árvore
        tempoInicial = System.currentTimeMillis();
        tree = balancearDWS(tree);
//        tree = balancearVetor(tree);
        Multiplos5(tree);
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo gasto B: "+(tempoFinal - tempoInicial));
        System.out.println("\n////////////\n");

        //Insira 100 números criados aleatoriamente na árvore e imprima a árvore em-ordem.
        tempoInicial = System.currentTimeMillis();
        tree = balancearDWS(tree);
//        tree = balancearVetor(tree);
        tree = ComporArvore(tree, 100);
        tree.Imp_infixa(tree);
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo gasto C: "+(tempoFinal - tempoInicial));
        System.out.println("\n////////////\n");

        //Verifique se os múltiplos de 5 e os 10 primeiros números primos estão presentes.
        // Imprima e Remova-os da árvore.
        tempoInicial = System.currentTimeMillis();
        tree = balancearDWS(tree);
//        tree = balancearVetor(tree);
        Multiplos5(tree);
        Primo(tree);
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo gasto D: "+(tempoFinal - tempoInicial));
        System.out.println("\n////////////\n");

    }
    // cria uma arvore com 5 mil números de 0 - 9999.
    static NoArvore ComporArvore(NoArvore tree, int tamanho){
        Random random = new Random();
        for(int i=0; i<tamanho; i++){
            tree.Insere(tree, random.nextInt(10000));
        }
        return(tree);
    }
    // como essa parte estava se repetindo muito coloquei ela em um método
    //ela balanceia a árvore.
    static NoArvore balancearDWS(NoArvore tree){
        Algoritmo_DSW balancear = new Algoritmo_DSW();
        int contador = balancear.contadorNos(tree);
        tree = balancear.balancear(tree, contador);
        return(tree);
    }
    static NoArvore balancearVetor(NoArvore tree){
        Algoritmo_Vetor balancearVetor = new Algoritmo_Vetor();
        tree = balancearVetor.convertBTBST(tree);
        return(tree);
    }
    static NoArvore Primo(NoArvore tree){
        int[] primos = {2, 3, 5, 7, 9, 11, 13, 17, 19, 23};
        for(int i=0; i<10; i++){
            if(tree.Search(tree, primos[i]) != null){
                System.out.print(primos[i]+", ");
                tree.Retira(tree, primos[i]);
            }
        }
        return(tree);
    }
    static NoArvore Multiplos5(NoArvore tree){
        for(int i = 0; i<10000; i = i + 5){
            if(tree.Search(tree, i)!=null){
                System.out.print(i+", ");
                tree.Retira(tree, i);
            }
        }
        return(tree);
    }

}
