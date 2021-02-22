import java.sql.SQLOutput;

public class Arvore01 {
    public static void main(String[] args){
        NoArvore tree = new NoArvore();
        ComporArvore(tree);
        ImprimirArvore(tree);
        tree = RemoverPrimos(tree);
        ImprimirArvore(tree);

    }
    static boolean Primo(int num){
        for(int j = 2; j<num; j++){
            if(num % j == 0){
                return false;
            }
        }
        return true;
    }
    static void ComporArvore(NoArvore tree){
        int qtdNum = 0;
        int num = 2;
        tree.InsereRaiz(tree, num);
        qtdNum++; num++;
        while (qtdNum < 1000) {
            if(Primo(num)){
                qtdNum++;
                tree.Insere(tree, num);
            }
            num++;
        }
    }
    static void ImprimirArvore(NoArvore tree){
        tree.Imp_prefixa(tree);
        System.out.println("______________");
        tree.Imp_infixa(tree);
        System.out.println("______________");
        tree.Imp_posfixa(tree);
        System.out.println("______________");
    }
    static NoArvore RemoverPrimos(NoArvore tree){
        int intervalo = 0;
        int cont = 2;
        while(cont<=7919){
            if(Primo(cont)){
                tree = tree.Retira(tree, cont);
                intervalo += 100;
                cont = intervalo;
            }else{
                cont++;
            }
        }
        return(tree);
    }
}
