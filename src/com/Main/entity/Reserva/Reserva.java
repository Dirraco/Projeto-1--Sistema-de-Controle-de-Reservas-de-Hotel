package com.Main.entity.Reserva;

/**
 * Classe que representa uma reserva de hotel.
 * Armazena informações do hóspede, tipo de quarto,
 * quantidade de dias e valor da diária.
 */
public class Reserva {

    /** Nome do hóspede */
    private String nomeHospede;

    /** Tipo de quarto (Básico, Luxo ou Presidencial) */
    private String tipoQuarto;

    /** Quantidade de dias da estadia */
    private int numeroDias;

    /** Valor da diária do quarto */
    private double valorDiaria;

    /**
     * Construtor principal da classe Reserva.
     *
     * @param nomeHospede nome do hóspede
     * @param tipoQuarto tipo do quarto
     * @param numeroDias quantidade de dias da estadia
     * @param valorDiaria valor da diária
     */
    public Reserva(String nomeHospede, String tipoQuarto, int numeroDias, double valorDiaria) {
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
        setNumeroDias(numeroDias);
        setValorDiaria(valorDiaria);
    }

    /**
     * Construtor sobrecarregado.
     * Cria uma reserva com valores padrão:
     * 1 dia de estadia e valor da diária igual a 1.
     *
     * @param nomeHospede nome do hóspede
     * @param tipoQuarto tipo do quarto
     */
    public Reserva(String nomeHospede, String tipoQuarto) {
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
        this.numeroDias = 1;
        this.valorDiaria = 1;
    }

    /**
     * Retorna o número de dias da reserva.
     *
     * @return número de dias
     */
    public int getNumeroDias() {
        return numeroDias;
    }

    /**
     * Define o número de dias da reserva.
     * Caso seja informado um valor inválido,
     * o número de dias será ajustado para 1.
     *
     * @param numeroDias número de dias da estadia
     */
    public void setNumeroDias(int numeroDias) {
        if (numeroDias < 1) {
            System.out.println("Número de dias inválido!");
            this.numeroDias = 1;
        } else {
            this.numeroDias = numeroDias;
        }
    }

    /**
     * Retorna o valor da diária.
     *
     * @return valor da diária
     */
    public double getValorDiaria() {
        return valorDiaria;
    }

    /**
     * Define o valor da diária.
     * Caso seja informado um valor inválido,
     * o valor será ajustado para 1.
     *
     * @param valorDiaria valor da diária
     */
    public void setValorDiaria(double valorDiaria) {
        if (valorDiaria <= 0) {
            System.out.println("Valor da diária inválido!");
            this.valorDiaria = 1;
        } else {
            this.valorDiaria = valorDiaria;
        }
    }

    /**
     * Retorna o nome do hóspede.
     *
     * @return nome do hóspede
     */
    public String getNomeHospede() {
        return nomeHospede;
    }

    /**
     * Retorna o tipo do quarto.
     *
     * @return tipo do quarto
     */
    public String getTipoQuarto() {
        return tipoQuarto;
    }

    /**
     * Calcula o valor total da estadia.
     *
     * @return valor total (dias * valor da diária)
     */
    public double calcularValorTotal() {
        return numeroDias * valorDiaria;
    }

    /**
     * Retorna uma representação textual da reserva.
     *
     * @return dados formatados da reserva
     */
    @Override
    public String toString() {
        return "Hóspede: " + nomeHospede +
                ", Quarto: " + tipoQuarto +
                ", Dias de estadia: " + numeroDias +
                ", Valor total: R$ " + calcularValorTotal();
    }
}