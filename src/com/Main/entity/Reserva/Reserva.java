package com.Main.entity.Reserva;

public class Reserva {

    private String nomeHospede;
    private String tipoQuarto;
    private int numeroDias;
    private double valorDiaria;


    public Reserva(String nomeHospede, String tipoQuarto,int numeroDias,double valorDiaria) {
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
        this.numeroDias = numeroDias;
        this.valorDiaria = valorDiaria;

        }

        public int getNumeroDias() {
            return numeroDias;
        }

        public void setNumeroDias(int numeroDias) {
            if (numeroDias < 1) {
                System.out.println("Número de dias invalido!");
                this.numeroDias = 1;
            } else {
                this.numeroDias = numeroDias;
            }
        }

        public double getValorDiaria() {
            return valorDiaria;
        }

        public void setValorDiaria(double valorDiaria) {
            if (valorDiaria <= 0) {
                System.out.println("valor da diaria invalido!");
                this.valorDiaria = 1;
            } else {
                this.valorDiaria = valorDiaria;
            }
        }

        public String getNomeHospede() {
            return nomeHospede;
        }

        public void setNomeHospede(String nomeHospede) {
            this.nomeHospede = nomeHospede;
        }

        public String getTipoQuarto() {
            return tipoQuarto;
        }

        public void setTipoQuarto(String tipoQuarto) {
            this.tipoQuarto = tipoQuarto;
        }

    public double calcularValorTotal() {

        double calcularValorTotal = 0;

        return calcularValorTotal = numeroDias * valorDiaria;
    }

    @Override
    public String toString() {
        return "Hóspede: " + nomeHospede +
                ", quarto: " + tipoQuarto +
                ", Dias de estadia: " + numeroDias +
                ", Valor total: R$ " + calcularValorTotal();
    }
}


