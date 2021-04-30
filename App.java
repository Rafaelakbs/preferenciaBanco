import java.util.*;

public class App {
    public static void main(String[] args) {

        boolean sair = false;
        boolean error = false;
        int respPreferencia = 0;
        int tamanho = 0;

        int cont2 = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n---------------------------------------------------------------"    );
        System.out.println(    "|                   Bom Dia / Boa tarde!                      |"    );                     
        System.out.println(    "|              Bem-vindo ao Banco da Sabrina!                 |"    );
        System.out.println(    "---------------------------------------------------------------\n\n");

        System.out.println("Quantos clientes cabem na fila do seu banco?(Limite da fila)");
        tamanho = sc.nextInt();
        FilaCliente fila = new FilaCliente(tamanho);

        System.out.println("\n-----Você adicionou um limite de: " + tamanho + " clientes a sua fila.-----\n\n");

        
        System.out.println("  _______________________________________ ");
        System.out.println(" |             Você deseja:              |");
        System.out.println(" |_______________________________________|");
        System.out.println(" | [ 1 ]- Adicionar novo cliente na fila |");
        System.out.println(" | [ 2 ]- Chamar o próximo cliente       |");
        System.out.println(" | [ 3 ]- Mostrar todos os clientes      |");
        System.out.println(" | [ 4 ]- Sair                           |");
        System.out.println(" |_______________________________________|");

        do {

            do {
                error = false;
                if (cont2 > 0) {
                    System.out.println("  _______________________________________ ");
                    System.out.println(" |             Você deseja:              |");
                    System.out.println(" |_______________________________________|");
                    System.out.println(" | [ 1 ]- Adicionar novo cliente na fila |");
                    System.out.println(" | [ 2 ]- Chamar o próximo cliente       |");
                    System.out.println(" | [ 3 ]- Mostrar todos os clientes      |");
                    System.out.println(" | [ 4 ]- Sair                           |");
                    System.out.println(" |_______________________________________|");

                }

                int resp = sc.nextInt();

                if (resp == 1) {
                    System.out.println("\n_________Opção: ADICIONAR CLIENTE_________\n");

                    if (fila.isFull() == false) {
                        do {
                            System.out.println("      .............................  ");
                            System.out.println("      : O cliente é preferencial? :  ");
                            System.out.println("      :        0 - SIM            :  ");
                            System.out.println("      :        1 - NÃO            :  ");
                            System.out.println("      :...........................:  ");

                            respPreferencia = sc.nextInt();

                            if (respPreferencia == 0) {
                                fila.enqueue(true);
                                

                            } else if (respPreferencia == 1) {
                                fila.enqueue(false);
                                
                            } else {
                                System.out.println("?~~~~~~COMANDO INVÁLIDO~~~~~~?");
                            }
                           
                        } while (respPreferencia != 0 && respPreferencia != 1);
                       
                    } else {

                        System.out.println("\n***A fila está cheia, chame o próximo cliente para abrir mais espaço***\n");
                    }

                    cont2++;

                } else if (resp == 2) {
                    System.out.println("\n_________Opção: PRÓXIMO CLIENTE_________");
                    if (fila.isEmpty() == false) {
                        fila.proximoCliente();
                    } else {
                        System.out.println("\n***A fila está vazia, espere um novo cliente***\n\n");
                    }
                    cont2++;

                } else if (resp == 3) {
                    System.out.println("\n_____Opção: MOSTRAR CLIENTES_____");
                    fila.imprimeFila();
                    cont2++;

                } else if (resp == 4) {
                    System.out.println("\n________Opção: SAIR________\n");
                    sair = true;
                    cont2++;
                } else {
                    System.out.println("?~~~~Opção: INVÁLIDA, INSIRA NOVAMENTE~~~~?\n");
                    error = true;
                    cont2++;

                }

            } while (error == true);

        } while (sair == false);

        sc.close();

    }
}
