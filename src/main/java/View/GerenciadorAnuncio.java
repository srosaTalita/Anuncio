package View;

import Controller.CalculadoraController;
import Controller.RelatorioController;
import Model.Anuncio;
import java.util.*;
/**
 *
 * @author talita
 */

public class GerenciadorAnuncio {
    
    public static ArrayList<Anuncio> cadastro() throws Exception{
        
        ArrayList<Anuncio> anuncios = new ArrayList<>();

        String novoAnuncio = "s";

        while (novoAnuncio.equalsIgnoreCase("s")) {

            System.out.println("Nome do Anúncio: ");
            Scanner sc1 = new Scanner(System.in);
            String nomeAnuncio = sc1.nextLine();

            System.out.println("Cliente: ");
            Scanner sc2 = new Scanner(System.in);
            String cliente = sc2.nextLine();

            System.out.println("Data de Início (Ex: dia/mes/ano): ");
            Scanner sc3 = new Scanner(System.in);
            String dataInicio = sc3.nextLine();

            System.out.println("Data de Término (Ex: dia/mes/ano): ");
            Scanner sc4 = new Scanner(System.in);
            String dataTermino = sc4.nextLine();

            System.out.println("Investimento por dia: ");
            Scanner sc5 = new Scanner(System.in);
            double investimento = sc5.nextDouble();

            /*Salva os dados fornecidos em um arraylist*/
            Anuncio dados = new Anuncio(nomeAnuncio, cliente, dataInicio, dataTermino, investimento);
            anuncios.add(dados);

            System.out.println("Quer adicionar outro anúncio? (s/n)");
            Scanner sc6 = new Scanner(System.in);
            novoAnuncio = sc6.nextLine();
        }
        return anuncios;
    }
    
        //função para mostrar os dados no relatório
    public static void dados(Anuncio anuncio) throws Exception {

        CalculadoraController calculadora = new CalculadoraController();
        double dinheiroInvestido = RelatorioController.investimentoTotal(anuncio);
        int visualizacoes = calculadora.visualizacaoTotal(dinheiroInvestido);
        System.out.println("--------------Anúncio--------------");
        System.out.println("Investimento Total: " + dinheiroInvestido + " reais");
        System.out.println("Visualizações Totais: " + visualizacoes + " visualizações");
        System.out.println("Clicks Totais: " + calculadora.clicksAnuncio(visualizacoes) + " clicks");
        System.out.println("Compartilhamentos Totais: " + calculadora.compartilhados(visualizacoes) + " compartilhamentos");
        System.out.println("-----------------------------------");
    }

    //função pra gerar relatórios
    public static void relatorio(ArrayList<Anuncio> lista) throws Exception {
        String pesquisa = "s";
        while (pesquisa.equalsIgnoreCase("s")) {
            int count = 0;
            System.out.println("Filtrar relatório por: ");
            System.out.println("1 - Cliente");
            System.out.println("2 - Data");
            System.out.println("Digite o número correspondente a opção:");

            Scanner relatorio = new Scanner(System.in);
            int filtro = relatorio.nextInt();

            //Se desejar filtrar pelo nome do cliente
            if (filtro == 1) {

                Scanner nome = new Scanner(System.in);
                System.out.println("Digite o nome do cliente: ");
                String nomeCliente = nome.nextLine();
                //buscar o anuncio pelo cliente                
                for (Anuncio anuncio : lista) {
                    if (anuncio.getCliente().equalsIgnoreCase(nomeCliente)) {
                        dados(anuncio);
                        count +=1;
                    }
                }
                if (count == 0) {
                    System.out.println("*Não foi encontrado nenhum anúncio com esse cliente*");
                }
            } //Se desejar filtrar por data
            else if (filtro == 2) {

                Scanner inicio = new Scanner(System.in);
                System.out.println("Digite a data de inicio do anúncio (Ex: dd/mm/yyyy): ");
                String dataInicio = inicio.nextLine();

                Scanner fim = new Scanner(System.in);
                System.out.println("Digite a data de término do anúncio (Ex: dd/mm/yyyy): ");
                String dataFim = inicio.nextLine();

                for (Anuncio anuncio : lista) {
                    if (anuncio.getDataInicio().equals(dataInicio) && anuncio.getDataTermino().equals(dataFim)) {
                        dados(anuncio);
                        count +=1;
                    } 
                }
                if (count == 0) {
                    System.out.println("*Não foi encontrado nenhum anúncio com esse intervalo de tempo*");
                }
            } 
            else {
                System.out.println("*Opção Inválida*");
            }
            Scanner pergunta = new Scanner(System.in);
            System.out.println("Deseja fazer outra pesquisa? (s/n)");
            pesquisa = pergunta.nextLine();
        }
    }
    
    public static void main(String[] args) throws Exception {
        
        relatorio(cadastro());
    }
}
