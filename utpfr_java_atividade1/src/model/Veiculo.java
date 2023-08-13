package model;

import controller.VelocException;

public abstract class Veiculo {
    
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private Float velMaxima;
    private int qtdRodas;
    private Motor motor;
    
    abstract float calculaVel(float velMaxima) throws VelocException;
    
    protected Veiculo() {
        super();
        this.placa = " ";
        this.marca = " ";
        this.modelo = " ";
        this.cor = " ";
        this.velMaxima = 0F;
        this.qtdRodas = 0;
        this.motor = new Motor();
    }
    protected Veiculo(String placa, String marca, String modelo, String cor, Float velMaxima, Integer qtdRodas, Motor motor) {
        super();
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.velMaxima = velMaxima;
        this.qtdRodas = qtdRodas;
        this.motor = motor;
    }
    protected Veiculo(String placa, String marca, String modelo, String cor, Float velMaxima, Integer qtdRodas, Integer qtdPist, Integer potencia) {
        super();
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.velMaxima = velMaxima;
        this.qtdRodas = qtdRodas;
        this.motor = new Motor(qtdPist, potencia);
    }
    public final String getPlaca() {
        return placa;
    }
    public final void setPlaca(String placa) {
        this.placa = placa;
    }
    public final String getMarca() {
        return marca;
    }
    public final void setMarca(String marca) {
        this.marca = marca;
    }
    public final String getModelo() {
        return modelo;
    }
    public final void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public final String getCor() {
        return cor;
    }
    public final void setCor(String cor) {
        this.cor = cor;
    }
    public final Float getVelMaxima() {
        return velMaxima;
    }
    public final void setVelMaxima(Float velMaxima) {
        this.velMaxima = velMaxima;
    }
    public final int getQtdRodas() {
        return qtdRodas;
    }
    public final void setQtdRodas(int qtdRodas) {
        this.qtdRodas = qtdRodas;
    }
    public final Motor getMotor() {
        return motor;
    }
    public final void setMotor(Motor motor) {
        this.motor = motor;
    }
}
