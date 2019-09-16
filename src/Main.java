import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int tam=99;
        int qtd=0;
        int op;
        Elemento[] lista= new Elemento[tam];
        Scanner tc = new Scanner(System.in);

        do{
            System.out.println("1 para add no fim"+
                    "\n2 para rem no fim"+
                    "\n3 para listar "+
                    "\n4 para add no inicio"+
                    "\n5 para rem no inicio"+
                    "\n6 incluir apos um nome"+
                    "\n7 consultar por nome"+
                    "\n8 excluir por código"+
                    "\n9 litar nomes com medias finais"+
                    "\n11 para sair ");


            op=tc.nextInt();
            switch (op){
                case 1:{
                    Elemento e= new Elemento();
                    e.ler();
                    lista[qtd]=e;
                    qtd++;
                    break;
                }
                case 2:{
                    lista[qtd-1]=null;
                    qtd--;
                }
                case 3:{
                    for (int i=0;i<qtd;i++){
                        System.out.println(lista[i]);
                    }
                    break;
                }
                case 4:{
                    Elemento e = new Elemento();
                    e.ler();
                    if (qtd == 0) {
                        lista[qtd] = e;
                        qtd++;
                    } else {
                        for (int i = qtd; i >= 0; i--) {
                            lista[i + 1] = lista[i];
                        }
                        lista[0] = e;
                        qtd++;
                    }
                    break;
                }
                case 5:{
                    for(int i=0;i<qtd;i++){
                        lista[i]=lista[i+1];
                    }
                    lista[qtd]=null;
                    qtd--;
                    break;
                }
                case 6:{
                    String nome;
                    Elemento e = new Elemento();
                    System.out.println("Digite o nome que voce deseja incluir após:");
                    nome = tc.next();
                    int posicao = 0;

                    for (int i=0;i<qtd;i++){
                        if (lista[i].nome.equals(nome)){
                            posicao = i;
                            posicao++;
                            e.ler();
                        }
                    }
                    for (int i = qtd; i >= posicao; i--) {
                        lista[i + 1] = lista[i];
                    }
                    lista[posicao] = e;
                    qtd++;
                    break;
                }
                case 7:{
                    System.out.println("Digite o nome a ser consultado:");
                    String nome;
                    nome = tc.next();
                    for (int i=0;i<qtd;i++){
                        if (lista[i].nome.equals(nome)){
                            System.out.println(lista[i]);
                        }
                    }
                    break;
                }
                case 8:{
                    System.out.println("Digite o código a ser excluido");
                    int cod;
                    cod= tc.nextInt();
                    for (int i=0;i<qtd;i++){
                        if (lista[i].cod == cod){
                            lista[i]=null;
                            qtd--;
                        }
                    }
                }
                case 9:{
                    for (int i=0;i<qtd;i++){
                        System.out.println(lista[i].nome+" nota " +lista[i].media);
                        break;
                    }
                }
            }

            if (qtd == tam ){
                op = 11;
            }
        }while (op!=11);//sair do programa

        System.out.println("quantidade na lista ="+qtd);
        System.out.println("conteudo da lista:");
        for (int i=0;i<qtd;i++){
            System.out.println(lista[i]);
        }
    }
}