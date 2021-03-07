import java.util.Arrays;

public class Algoritmo_Vetor {

    int[] treeArray;
    int index = 0;


    //Converte uma arvore binária em uma arvore binária de busca.
    public NoArvore convertBTBST(NoArvore tree) {

        //treeSize recebe o tamanho da árvore.
        int treeSize = calculateSize(tree);
        treeArray = new int[treeSize];

        //Converte a árvore em vetor
        convertBTtoArray(tree);

        //Coloca o array em ordem
        Arrays.sort(treeArray);

        //Faz com que o array vire uma árvore.
        NoArvore d = createBST(0, treeArray.length -1);
        return d;
    }

    //Calcula o tamanho da arvore
    public int calculateSize(NoArvore tree)
    {
        int size = 0;
        if (tree == null)
            return 0;
        else {
            size = calculateSize (tree.getEsquerda()) + calculateSize (tree.getDireita()) + 1;
            return size;
        }
    }

    //Converte a arvore em array
    public void convertBTtoArray(NoArvore tree) {
        if(tree == null){
            System.out.println("Tree is empty");
            return;
        }
        else {
            if(tree.getEsquerda() != null)
                convertBTtoArray(tree.esquerda);
            // adiciona os nós da arvore no array
            treeArray[index] = tree.getInfo();
            index++;
            if(tree.getDireita() != null)
                convertBTtoArray(tree.direita);
        }
    }

    //faz com que o array se transforme na arvore
    public NoArvore createBST(int start, int end) {

        if (start > end) {
            return null;
        }

        //Valor do meio do array que vai ser a raiz da arvore
        int mid = (start + end) / 2;
        NoArvore tree = new NoArvore(treeArray[mid]);

        //Constroi a sub avore esquerda
        tree.setEsquerda(createBST(start, mid - 1));

        //Constroi a sub arvore direita
        tree.setDireita(createBST(mid + 1, end));

        return tree;
    }

    //inorder() will perform inorder traversal on binary search tree
//    public void inorderTraversal(NoArvore tree) {
//
//
//        if(tree == null){
//            System.out.println("Tree is empty");
//            return;
//        }
//        else {
//
//            if(tree.getEsquerda()!= null)
//                inorderTraversal(tree.esquerda);
//            System.out.print(tree.info + " ");
//            if(tree.getDireita()!= null)
//                inorderTraversal(tree.direita);
//
//        }
//    }

}
