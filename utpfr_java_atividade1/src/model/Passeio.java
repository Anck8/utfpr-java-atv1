package model;

import controller.Calcular;

public class Passeio extends Veiculo implements Calcular {

    private int qtdPassageiros;
    
    @Override
    public final float calculaVel(float velMaxima) {
        return velMaxima*1000;
    }
    
    @Override
    public final int calcular() {
        String parametrosConcat = getPlaca()+getMarca()+getModelo()+getCor();
        return  Math.toIntExact(parametrosConcat.replaceAll("\\d", "").chars().count());
    }

    public Passeio() {
        super();
        this.qtdPassageiros = 0;
    }
    public Passeio(int qtdPassageiros) {
        super();
        this.qtdPassageiros = qtdPassageiros;
    }
    public Passeio(String placa, String marca, String modelo, String cor, Float velMaxima, Integer qtdRodas, Integer qtdPist,
                    Integer potencia, int qtdPassageiros) {
        super(placa, marca, modelo, cor, velMaxima, qtdRodas, qtdPist, potencia);
        this.qtdPassageiros = qtdPassageiros;
    }
    public final int getQtdPassageiros() {
        return qtdPassageiros;
    }
    public final void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }
}
