public class Algoritmo_DSW{

    private NoArvore leftRotate(NoArvore tree){
        if(tree.getDireita()!=null){
            NoArvore noDireito = tree.getDireita();
            tree.setDireita(noDireito.getDireita());
            noDireito.setDireita(noDireito.getEsquerda());
            noDireito.setEsquerda(tree.getEsquerda());
            tree.setEsquerda(noDireito);
            int inf = tree.getInfo();
            tree.setInfo(noDireito.getInfo());
            noDireito.setInfo(inf);

        }
        return tree;
    }
    private NoArvore rightRotate(NoArvore tree){
        if(tree.getDireita()!=null){
            NoArvore noEsquerdo = tree.getEsquerda();
            tree.setEsquerda(noEsquerdo.getEsquerda());
            noEsquerdo.setEsquerda(noEsquerdo.getDireita());
            noEsquerdo.setDireita(tree.getDireita());
            tree.setDireita(noEsquerdo);
            int inf = tree.getInfo();
            tree.setInfo(noEsquerdo.getInfo());
            noEsquerdo.setInfo(inf);

        }
        return tree;
    }
    // Cria a lista encadeada.

    private NoArvore listaEncadeada(NoArvore tree) {

		while(tree.getEsquerda() != null) {
			tree = rightRotate(tree);
		}

		if(tree.getDireita() != null)
			tree.setDireita(listaEncadeada(tree.getDireita()));

		return tree;
	}

	// conta a quantidade de nos que temos na arvore
    public int contadorNos(NoArvore tree) {

        if(tree == null)
            return 0;

        int i = 1;

        while(tree.getDireita() != null) {

            tree = tree.getDireita();
            i++;
        }

        return i;
    }
    // função com o objetivo de balancear a árvore
    public NoArvore balancear(NoArvore tree, int cont) {

        int times = (int)Math.log(cont);
        NoArvore newTree = tree;

        for(int i = 0; i < times; i++) {

            newTree = leftRotate(newTree);
            tree = newTree.getDireita();

            for(int j = 0; j < cont / 2 - 1; j++) {

                tree = leftRotate(tree);
                tree = tree.getDireita();
            }

            cont >>= 1;
        }

        return newTree;
    }
}
