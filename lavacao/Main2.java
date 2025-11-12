/*          ATENÇÃO! NOVA VERSÃO APÓS FEEDBACK DOS PROFESSORES EM AULA!


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

void main(String[] args) {

    int contador = 0, v1 = 0, v2 = 0, v3 = 0, s1 = 0, s2 = 0, s3 = 0;   //                  VARIÁVEIS
    double totalArrecadado = 0.0;
    String Veiculo, Servico, Nome;
    Scanner input = new Scanner(System.in);
    System.out.print("Informe a quantidade de atendimentos : ");
    contador = input.nextInt();

    while (true) {                          //                  LOOP PARA GARANTIR AS ITERAÇÕES INFORMADAS
        if (contador == 0) {               //                   RELATÓRIO FINAL
            String maiorVeiculo;
            if (v1 >= v2 && v1 >= v3) {
                maiorVeiculo = "Pequenos";
            } else if (v2 >= v1 && v2 >= v3) {
                maiorVeiculo = "Medio";
            } else {
                maiorVeiculo = "Grande";
            }
            String maiorServico;
            if (s1 >= s2 && s1 >= s3) {
                maiorServico = "Lavação Externa";
            } else if (s2 >= s1 && s2 >= s3) {
                maiorServico = "Externa+Interna";
            } else {
                maiorServico = "Externa+Interna+Cera";
            }

            IO.println("====== Relatório Final ========" +
                    "\n Percentual dos atendimentos por veículo" +
                    "\n\t Pequenos = " + ((double) v1 / (v1 + v2 + v3) * 100) + " por cento" +
                    "\n\t Médios = " + ((double) v2 / (v1 + v2 + v3) * 100) + " por cento" +
                    "\n\t Grandes = " + ((double) v3 / (v1 + v2 + v3) * 100) + " por cento");
            IO.println("\n Percentual dos atendimentos por serviços" +
                    "\n\t Lavação externa = " + ((double) s1 / (s1 + s2 + s3) * 100) + " por cento" +
                    "\n\t Externa+interna = " + ((double) s2 / (s1 + s2 + s3) * 100) + " por cento" +
                    "\n\t Externa+interna+cera = " + ((double) s3 / (s1 + s2 + s3) * 100) + " por cento");
            IO.println("Valor total arrecadado = " + totalArrecadado);
            IO.println("Veiculos mais atendidos = " + maiorVeiculo);
            IO.println("Servicos mais realizados = " + maiorServico);
            break;                          //             FIM DO RELATÓRIO FINAL
        }

        IO.print("Informe o nome do cliente : ");                   //      COLETA NOME DO
        Nome = input.next();                                        //      CLIENTE E TIPO DE VEÍCULO E SERVIÇO
        IO.println("=== Tipo de Veículo ===\n" +
                "1 - Veículo Pequeno\n" +
                "2 - Veículo Médio\n" +
                "3 - Veículo Grande\n" +
                "Sua opção : ");
        String opcao;
        do {                                //                  LOOP PRA FORÇAR DADOS CORRETOS
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
        IO.println("=== Tipo de Lavação ===\n" +
                "1 - Externa\n" +
                "2 - Externa+interna\n" +
                "3 - Externa+interna+cera\n" +
                "Sua opção : ");
        do {                                //                  LOOP PARA FORÇAR DADOS CORRETOS
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
                IO.println("Opção Inválida. Digite 1, 2 ou 3");
            }
        } while (true);

        double valor = 0;                        //              RELATÓRIO PARCIAL
        if (Veiculo.equals("Veículo Pequeno") && Servico.equals("Externa")) {
            valor = 50.0;
        }
        if (Veiculo.equals("Veículo Pequeno") && Servico.equals("Externa+interna")) {
            valor = 70.0;
        }
        if (Veiculo.equals("Veículo Pequeno") && Servico.equals("Externa + Interna + Cera")) {
            valor = 90.0;
        }
        if (Veiculo.equals("Veículo Médio") && Servico.equals("Externa")) {
            valor = 70.0;
        }
        if (Veiculo.equals("Veículo Médio") && Servico.equals("Externa+interna")) {
            valor = 90.0;
        }
        if (Veiculo.equals("Veículo Médio") && Servico.equals("Externa + Interna + Cera")) {
            valor = 110.0;
        }
        if (Veiculo.equals("Veículo Grande") && Servico.equals("Externa")) {
            valor = 90.0;
        }
        if (Veiculo.equals("Veículo Grande") && Servico.equals("Externa+interna")) {
            valor = 110.0;
        }
        if (Veiculo.equals("Veículo Grande") && Servico.equals("Externa + Interna + Cera")) {
            valor = 130.0;
        }
        IO.println("Cadastro realizado" +
                "\nVeículo = " + Veiculo +
                "\nServico = " + Servico +
                "\nValor = " + valor);
        totalArrecadado += valor;
        contador--;                             //              FIM DA COLETA DE DADOS
    }
    input.close();
    IO.println("Programa encerrado");
}


