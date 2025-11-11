/*
 * Programa que pede:
 *
 * nome do cliente,
 * tipo de veículo (menu = Pequeno, Médio, Grande)
 * tipo de lavação (menu = Externa, Externa+interna, Externa+interna+cera)
 *
 * Saídas:
 * tipo de veículo, tipo lavação e
 * valor pago (50, 70, 90 para pequeno
 *             70, 90, 110 para médio
 *             90, 110, 130 para grande)
 * Relatório com:
 *    percentual de atendimento por tipo de veículo
 *    e tipo de lavação.
 *    valor total arrecadado.
 *    os tipos de veículos mais atendidos
 *    os serviços que foram mais atendidos
 *
 * */

import java.util.Scanner;

public class Main {
    private Scanner input;
    private String Veiculo, Servico, Nome;
    private double totalArrecadado = 0.0;
    private int contador, v1, v2, v3, s1, s2, s3;

    public Main() {
        input = new Scanner(System.in);
        System.out.print("Informe a quantidade de atendimentos : ");
        contador = input.nextInt();
        while (true) {
            if (contador == 0) {
                relatorio();
                break;
            }
            entradas();
            menu();
            parcial();
            contador--;
        }
        input.close();
        System.out.println("Programa encerrado");
    }

    private void relatorio() {
        System.out.println("====== Relatório Final ========" +
                "\n Percentual dos atendimentos por veículo" +
                "\n\t Pequenos = " + ((double)v1 / (v1+v2+v3) * 100)+" por cento" +
                "\n\t Médios = " + ((double)v2 / (v1+v2+v3) * 100)+" por cento" +
                "\n\t Grandes = " + ((double)v3 / (v1+v2+v3) * 100)+" por cento" );
        System.out.println("\n Percentual dos atendimentos por serviços" +
                "\n\t Lavação externa = " + ((double)s1 / (s1+s2+s3) * 100)+" por cento" +
                "\n\t Externa+interna = " + ((double)s2 / (s1+s2+s3) * 100)+" por cento" +
                "\n\t Externa+interna+cera = " + ((double)s3 / (s1+s2+s3) * 100)+" por cento" );
        System.out.println("Valor total arrecadado = " + totalArrecadado);
        System.out.println("Veiculos mais atendidos = " + maiorVeiculo(v1, v2, v3));
        System.out.println("Servicos mais realizados = " + maiorServico(s1, s2, s3));
    }

    private String maiorVeiculo(int v1, int v2, int v3) {
        if (v1 >= v2 && v1 >= v3) {
            return "Pequenos";
        } else if (v2 >= v1 && v2 >= v3) {
            return "Médios";
        }
        return "Grandes";
    }

    private String maiorServico(int s1, int s2, int s3) {
        if (s1 >= s2 && s1 >= s3) {
            return "Lavação Externa";
        } else if (s2 >= s1 && s2 >= s3) {
            return "Externa+Interna";
        }
        return "Externa+Interna+Cera";
    }

    private void parcial() {
        System.out.println("Cadastro realizado" +
                "\nVeículo = " + Veiculo +
                "\nServico = " + Servico +
                "\nValor = " + valor(Veiculo, Servico));
        totalArrecadado += valor(Veiculo, Servico);
    }

    private double valor(String veiculo, String servico) {
        if (veiculo.equals("Veículo Pequeno") && servico.equals("Externa")) return 50.0;
        if (veiculo.equals("Veículo Pequeno") && servico.equals("Externa+interna")) return 70.0;
        if (veiculo.equals("Veículo Pequeno") && servico.equals("Externa + Interna + Cera")) return 90.0;

        if (veiculo.equals("Veículo Médio") && servico.equals("Externa")) return 70.0;
        if (veiculo.equals("Veículo Médio") && servico.equals("Externa+interna")) return 90.0;
        if (veiculo.equals("Veículo Médio") && servico.equals("Externa + Interna + Cera")) return 110.0;

        if (veiculo.equals("Veículo Grande") && servico.equals("Externa")) return 90.0;
        if (veiculo.equals("Veículo Grande") && servico.equals("Externa+interna")) return 110.0;
        if (veiculo.equals("Veículo Grande") && servico.equals("Externa + Interna + Cera")) return 130.0;

        return 0.0;
    }

    public void entradas() {
        System.out.print("Informe o nome do cliente : ");
        Nome = input.next();
    }

    public void menu() {
        System.out.println("=== Tipo de Veículo ===\n" +
                "1 - Veículo Pequeno\n" +
                "2 - Veículo Médio\n" +
                "3 - Veículo Grande\n" +
                "Sua opção : ");
        String opcao;
        do {
            opcao = input.next();
            if (opcao.equals("1")) {
                Veiculo = "Veículo Pequeno";
                v1 = v1 + 1;
                break;
            } else if (opcao.equals("2")) {
                Veiculo = "Veículo Médio";
                v2 = v2 + 1;
                break;
            } else if (opcao.equals("3")) {
                Veiculo = "Veículo Grande";
                v3 = v3 + 1;
                break;
            } else {
                System.out.println("Opção Inválida. Digite 1, 2 ou 3");
            }
        } while (true);
        System.out.println("=== Tipo de Lavação ===\n" +
                "1 - Externa\n" +
                "2 - Externa+interna\n" +
                "3 - Externa+interna+cera\n" +
                "Sua opção : ");
        do {
            opcao = input.next();
            if (opcao.equals("1")) {
                Servico = "Externa";
                s1 = s1 + 1;
                break;
            } else if (opcao.equals("2")) {
                Servico = "Externa+interna";
                s2 = s2 + 1;
                break;
            } else if (opcao.equals("3")) {
                Servico = "Externa + Interna + Cera";
                s3 = s3 + 1;
                break;
            } else {
                System.out.println("Opção Inválida. Digite 1, 2 ou 3");
            }
        } while (true);
    }

    public static void main(String[] args) {
        new Main();
    }
}

