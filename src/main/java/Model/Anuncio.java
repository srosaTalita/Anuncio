package Model;

/**
 *
 * @author talita
 */
//Classe com atributos e métodos do anúncip
public class Anuncio {
    
    private String NomeAnuncio;
    private String Cliente;
    private String DataInicio;
    private String DataTermino;
    private Double InvestimentoDiario;

    public Anuncio(String NomeAnuncio, String Cliente, String DataInicio, String DataTermino, Double InvestimentoDiario) {
        this.NomeAnuncio = NomeAnuncio;
        this.Cliente = Cliente;
        this.DataInicio = DataInicio;
        this.DataTermino = DataTermino;
        this.InvestimentoDiario = InvestimentoDiario;
    }

    public String getNomeAnuncio() {
        return NomeAnuncio;
    }

    public void setNomeAnuncio(String NomeAnuncio) {
        this.NomeAnuncio = NomeAnuncio;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getDataInicio() {
        return DataInicio;
    }

    public void setDataInicio(String DataInicio) {
        this.DataInicio = DataInicio;
    }

    public String getDataTermino() {
        return DataTermino;
    }

    public void setDataTermino(String DataTermino) {
        this.DataTermino = DataTermino;
    }

    public Double getInvestimentoDiario() {
        return InvestimentoDiario;
    }

    public void setInvestimentoDiario(Double InvestimentoDiario) {
        this.InvestimentoDiario = InvestimentoDiario;
    }       
       
}

