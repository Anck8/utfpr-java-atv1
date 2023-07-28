package model;

public class Motor {
    
    private int qtdPist;
    private int potencia;
    
    public Motor() {
        super();
        this.qtdPist = 0;
        this.potencia = 0;
    }
    public Motor(Integer qtdPist, Integer potencia) {
        super();
        this.qtdPist = qtdPist;
        this.potencia = potencia;
    }
    public Integer getQtdPist() {
        return qtdPist;
    }
    public final void setQtdPist(Integer qtdPist) {
        this.qtdPist = qtdPist;
    }
    public final Integer getPotencia() {
        return potencia;
    }
    public final void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }
}
