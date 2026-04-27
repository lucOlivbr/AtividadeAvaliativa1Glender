//Aluno: Lucas Alves Oliveira
//RA: 321629404

import java.util.Scanner;

public class Atividade {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int fileiras = 6;
        int assentos = 8;

        int[][] fileirasEAssentos = new int[fileiras][assentos];

        boolean encerrar = false;
        int opcoes, fileira, assento;
        int assentosLivres, assentosOcupados;
        double percentualOcupacao;

        while (!encerrar) {
            System.out.println("-----------------------");
            System.out.println(    "Menu de opcoes:    ");
            System.out.println("-----------------------");
            System.out.println("1. Reservar assento");
            System.out.println("2. Cancelar reserva");
            System.out.println("3. Exibir mapa da sala");
            System.out.println("4. Exibir quantidade de assentos livres e ocupados");
            System.out.println("5. Encerrar");

            System.out.println("Digite a sua opcao: ");
            opcoes = entrada.nextInt();

            switch (opcoes) {
                case 1:
                    System.out.println("Digite a fileira :");
                    fileira = entrada.nextInt();
                    System.out.println("Digite o assento :");
                    assento = entrada.nextInt();

                    if (fileirasEAssentos[fileira - 1][assento - 1] == 1) {
                  //debug      System.out.println(fileirasEAssentos[fileira][assento]);
                  //debug      System.out.println(fileirasEAssentos[fileira - 1][assento -])
                        System.out.println("Assento ja esta ocupado.");
                    } else {
                        fileirasEAssentos[fileira - 1][assento - 1] = 1;
                        System.out.println("Assento reservado com sucesso.");
                    }
                    break;

                case 2:
                    System.out.println("Informe a fileira :");
                    fileira = entrada.nextInt();
                    System.out.println("Informe o numero do assento :");
                    assento = entrada.nextInt();

                    if (fileirasEAssentos[fileira - 1][assento - 1] == 1) {
                        fileirasEAssentos[fileira - 1][assento - 1] = 0;
                        System.out.println("Reserva cancelada com sucesso.");
                    } else {
                        System.out.println("O assento ja esta livre.");
                    }
                    break;

                case 3:
                    System.out.print("           ");
                    for (int j = 0; j < assentos; j++) {
                        System.out.print((j + 1) + " ");
                    }
                    System.out.println();
                    for (int i = 0; i < fileiras; i++) {
                        System.out.print("Fileira " + (i + 1) + ": ");
                        for (int j = 0; j < assentos; j++) {
                            System.out.print(fileirasEAssentos[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    assentosLivres = 0;
                    assentosOcupados = 0;
                    for (int i = 0; i < fileiras; i++) {
                        for (int j = 0; j < assentos; j++) {
                            if (fileirasEAssentos[i][j] == 1) {
                                assentosOcupados++;
                            } else {
                                assentosLivres++;
                            }
                        }
                    }
                    int total = fileiras * assentos;
                    percentualOcupacao = (assentosOcupados * 100.0) / total;

                    System.out.println("Assentos livres: " + assentosLivres);
                    System.out.println("Assentos ocupados: " + assentosOcupados);
                    System.out.println("Percentual de ocupacao: " + percentualOcupacao + "%");
                    break;

                case 5:
                    encerrar = true;
                    System.out.println("Sistema encerrando");
                    break;
            }
        }

        entrada.close();
    }
}
