package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import Model.Anuncio;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author talita
 */
public class RelatorioController {
        //Converte o formato da data recebida
    public static String converteData(String dataAnuncio) throws ParseException{

        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataAnuncio);
        String dataFormatada = new SimpleDateFormat("yyyy-MM-dd").format(data);
        return dataFormatada;
      
    }
    
    //Calcula a quantidade de dias entre a data de início e término do anúncio
    public static long quantidadeDias(String dataInicial, String dataFinal) throws Exception{

        LocalDate dataInicio = LocalDate.parse(dataInicial, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate dataFim = LocalDate.parse(dataFinal, DateTimeFormatter.ISO_LOCAL_DATE);
        Duration diferenca = Duration.between(dataInicio.atStartOfDay(), dataFim.atStartOfDay());
        long diferencaDias = diferenca.toDays();
        return diferencaDias;
        
    }
    
    /*Função para calcular o investimento total do anúncio*/
    public static double investimentoTotal(Anuncio anuncio) throws ParseException, Exception{;   
        //Pega a quantidade de dias entre a data de inicio e termino
        long dias = quantidadeDias(
            converteData(anuncio.getDataInicio()), 
            converteData(anuncio.getDataTermino())
        );
        //Multiplica a quantidade de dias do anúncio e o investimento diário
        double gastoTotal = dias * anuncio.getInvestimentoDiario();
        return gastoTotal;
    }
}


