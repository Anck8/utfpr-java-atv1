package model;

import controller.Calcular;

public final class Carga extends Veiculo implements Calcular {
    
    private int cargaMax;
    private int tara;
    
    @Override
    public final float calculaVel(float velMaxima) {
        return velMaxima*100000;
    }

    @Override
    public final int calcular() {
        return (Math.round(getVelMaxima()) + getQtdRodas() + getCargaMax() + getTara() + getMotor().getPotencia() + getMotor().getQtdPist());
    }
    
    public Carga() {
        super();
        this.cargaMax = 0;
        this.tara = 0;
    }
    public Carga(int cargaMax, int tara) {
        super();
        this.cargaMax = cargaMax;
        this.tara = tara;
    }
    public Carga(String placa, String marca, String modelo, String cor, Float velMaxima, Integer qtdRodas, Integer qtdPist,
                    Integer potencia, int cargaMax, int tara) {
        super(placa, marca, modelo, cor, velMaxima, qtdRodas, qtdPist, potencia);
        this.cargaMax = cargaMax;
        this.tara = tara;
    }
    public final int getCargaMax() {
        return cargaMax;
    }
    public final void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }
    public final int getTara() {
        return tara;
    }
    public final void setTara(int tara) {
        this.tara = tara;
    }
}
