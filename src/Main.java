import com.Main.entity.Reserva.Reserva;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Cria uma reserva
//        Reserva res = new Reserva("diego", "luxo", 3, 250);
//
//        //imprimir os dados usando toString()
//        System.out.println(res.toString());

        Reserva[] reservas = new Reserva[10];
        int contador = 0; // controla quantas reserva ja existem

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("escolha uma Opção\n");

        // loop do menu
        do {
            System.out.println("1 - Cadastrar nova reserva");
            System.out.println("2 - Listar reservas");
            System.out.println("3 - Buscar reserva por nome do hóspede");
            System.out.println("4 - Ordenar reserva por numero de dias (decrescente)");
            System.out.println("5 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    // Passo 1 do case 1: verificar se o vetor ainda tem espaço
                    // Passo 2: pedir os dados via Scanner (nome, tipo, dias, valor)
                    // Passo 3: perguntar se deseja confirmar a reserva (1-sim, 2-não)
                    // Passo 4: se confirmou, criar objeto Reserva e adicionar ao vetor
                    // Passo 5: incrementar contador

                    if (contador < reservas.length) {

                        System.out.println("Digite o nome do hóspede\n");
                        String nomeHospede = scanner.nextLine();

                        System.out.println("Deseja um quarto basico, Luxo ou Presidencial \n");
                        String tipoQuarto = scanner.nextLine();

                        System.out.println("quantos dias de estadia\n");
                        int numeroDias = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("qual o valor da diaria\n");
                        double valorDiaria = scanner.nextDouble();

                        System.out.println("Deseja confirmar a reserva? \n1 sim \n2 não");
                        int confirmacao = scanner.nextInt();

                        if (confirmacao == 1) {

                            Reserva reserva = new Reserva(nomeHospede, tipoQuarto, numeroDias, valorDiaria);

                            System.out.println("Reserva confirmada");

                            reservas[contador] = reserva;
                            contador++;

                        } else {
                            System.out.println("Reserva não confirmada");
                        }

                    }else {
                        System.out.println("Hotel lotado");
                    }

                    break;

                case 2:
                    // Listar reservas (for até contador)

                    if (contador > 0) {

                        for (int i = 0;i < contador; i++) {
                            System.out.println(reservas[i].toString());
                        }


                    } else {
                        System.out.println("Nenhuma reserva cadastrada");
                    }

                    break;

                case 3:
                    // Buscar por nome (for até contador + if contains)

                    System.out.println("Digite o nome do hóspede a buscar: \n");
                    String nomeBusca = scanner.nextLine();

                    if (contador > 0) {

                        boolean encontrou = false;

                        for (int i = 0; i < contador;i++) {

                            reservas[i].getNomeHospede();

                            if (reservas[i].getNomeHospede().toLowerCase().contains(nomeBusca.toLowerCase())) {
                                // imprimir a reserva usando toString()
                                System.out.println(reservas[i].toString());
                                encontrou = true;
                            }

                        }

                        if (!encontrou) {
                            System.out.println("Nenhuma reserva encontrada com esse nome\n");
                        }

                    }

                    break;

                case 4:
                    // Ordenar reservas

                    if (contador > 0){

                        for (int i = 0; i < contador;i++){
                            for (int j = i + 1; j < contador;j++){
                                if (reservas[i].getNumeroDias() < reservas[j].getNumeroDias()) {

                                    Reserva aux = reservas[i];
                                    reservas[i] = reservas[j];
                                    reservas[j] = aux;
                                }
                            }
                        }

                        System.out.println("Reservas ordenadas por número de dias (decrescente)\n");

                        for (int i = 0; i < contador; i++) {
                            System.out.println(reservas[i].toString());
                        }

                    } else {
                        System.out.println("Nenhuma reserva cadastrada");
                    }

                    break;

                case 5:
                    // Sair do sistema (pode imprimir "Saindo...")
                    System.out.println("Sistema Finalizado");

                    break;

                default:
                    // Avisar opção inválida

                    System.out.println("Opção inválida! Tente novamente.\n");
            }
        }while (opcao != 5);

    }
}
