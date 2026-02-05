import com.Main.entity.Reserva.Reserva;
import java.util.Scanner;

/**
 * Classe principal do sistema de reservas de hotel.
 * Responsável por exibir o menu e controlar o fluxo do programa.
 */
public class Main {

    /**
     * Método principal (ponto de entrada da aplicação).
     */
    public static void main(String[] args) {

        // Vetor que armazena até 10 reservas
        Reserva[] reservas = new Reserva[10];

        // Controla a quantidade de reservas cadastradas
        int contador = 0;

        // Scanner para entrada de dados do usuário
        Scanner scanner = new Scanner(System.in);

        int opcao;

        System.out.println("Escolha uma opção\n");

        // Loop principal do menu
        do {

            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch (opcao) {

                case 1:
                    // Cadastra uma nova reserva
                    contador = cadastrarReserva(reservas, contador, scanner);
                    break;

                case 2:
                    // Lista todas as reservas cadastradas
                    if (contador > 0) {
                        for (int i = 0; i < contador; i++) {
                            System.out.println(reservas[i]);
                        }
                    } else {
                        System.out.println("Nenhuma reserva cadastrada");
                    }
                    break;

                case 3:
                    // Busca reserva pelo nome do hóspede
                    buscarReservaPorNome(reservas, contador, scanner);
                    break;

                case 4:
                    // Ordena as reservas por número de dias (decrescente)
                    ordenarPorNumeroDias(reservas, contador);
                    break;

                case 5:
                    // Encerra o sistema
                    System.out.println("Sistema Finalizado");
                    break;

                default:
                    // Opção inválida
                    System.out.println("Opção inválida! Tente novamente.\n");
            }

        } while (opcao != 5);

        scanner.close();
    }

    /**
     * Exibe o menu de opções do sistema.
     */
    private static void mostrarMenu() {
        System.out.println("1 - Cadastrar nova reserva");
        System.out.println("2 - Listar reservas");
        System.out.println("3 - Buscar reserva por nome do hóspede");
        System.out.println("4 - Ordenar reserva por número de dias (decrescente)");
        System.out.println("5 - Sair");
    }

    /**
     * Realiza o cadastro de uma nova reserva.
     *
     * @param reservas vetor de reservas
     * @param contador quantidade atual de reservas
     * @param scanner  objeto Scanner para entrada de dados
     * @return novo valor do contador
     */
    private static int cadastrarReserva(Reserva[] reservas, int contador, Scanner scanner) {

        // Verifica se o hotel está lotado
        if (contador >= reservas.length) {
            System.out.println("Hotel lotado");
            return contador;
        }

        System.out.println("Digite o nome do hóspede:");
        String nomeHospede = scanner.nextLine();

        System.out.println("Deseja um quarto Básico, Luxo ou Presidencial:");
        String tipoQuarto = scanner.nextLine();

        System.out.println("Quantos dias de estadia:");
        int numeroDias = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual o valor da diária:");
        double valorDiaria = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Deseja confirmar a reserva? (1 - Sim / 2 - Não)");
        int confirmacao = scanner.nextInt();
        scanner.nextLine();

        if (confirmacao == 1) {
            reservas[contador] =
                    new Reserva(nomeHospede, tipoQuarto, numeroDias, valorDiaria);
            contador++;
            System.out.println("Reserva confirmada!");
        } else {
            System.out.println("Reserva cancelada.");
        }

        return contador;
    }

    /**
     * Busca e exibe reservas pelo nome do hóspede.
     *
     * @param reservas vetor de reservas
     * @param contador quantidade atual de reservas
     * @param scanner  objeto Scanner para entrada de dados
     */
    private static void buscarReservaPorNome(Reserva[] reservas, int contador, Scanner scanner) {

        if (contador == 0) {
            System.out.println("Nenhuma reserva cadastrada\n");
            return;
        }

        System.out.println("Digite o nome do hóspede a buscar:");
        String nomeBusca = scanner.nextLine();

        boolean encontrou = false;

        for (int i = 0; i < contador; i++) {
            if (reservas[i].getNomeHospede().toLowerCase()
                    .contains(nomeBusca.toLowerCase())) {

                System.out.println(reservas[i]);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma reserva encontrada com esse nome\n");
        }
    }

    /**
     * Ordena as reservas pelo número de dias em ordem decrescente.
     *
     * @param reservas vetor de reservas
     * @param contador quantidade atual de reservas
     */
    private static void ordenarPorNumeroDias(Reserva[] reservas, int contador) {

        if (contador == 0) {
            System.out.println("Nenhuma reserva cadastrada");
            return;
        }

        // Algoritmo de ordenação simples (Bubble Sort)
        for (int i = 0; i < contador; i++) {
            for (int j = i + 1; j < contador; j++) {
                if (reservas[i].getNumeroDias() < reservas[j].getNumeroDias()) {

                    Reserva aux = reservas[i];
                    reservas[i] = reservas[j];
                    reservas[j] = aux;
                }
            }
        }

        System.out.println("Reservas ordenadas por número de dias\n");

        for (int i = 0; i < contador; i++) {
            System.out.println(reservas[i]);
        }
    }
}