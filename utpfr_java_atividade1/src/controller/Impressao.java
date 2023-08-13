package controller;

import java.util.List;
import java.util.Optional;

import model.Carga;
import model.Passeio;

public class Impressao {

    public static void imprimeCarrosPasseio(List<Passeio> carros) {
        if (carros == null) {
            erroNull();
            return;
        }
        System.out.println("\n==========================================\n");
        carros.forEach(Impressao::imprimePasseio);
        System.out.println("\n==========================================\n");
    }

    public static void imprimeCarroPasseioPorPlaca(List<Passeio> carros, String placa) {
        if (carros == null) {
            erroNull();
            return;
        }
        Optional<Passeio> passeio = carros.stream().filter(c -> c.getPlaca().equals(placa)).findAny();
        passeio.ifPresentOrElse(Impressao::imprimePasseio, () -> System.out.println("\n========[Nenhum veículo encontrado]========\n"));
    }

    public static void imprimeCarrosCarga(List<Carga> carros) {
        if (carros == null) {
            erroNull();
            return;
        }
        System.out.println("\n==========================================\n");
        carros.forEach(Impressao::imprimeCarga);
        System.out.println("\n==========================================\n");
    }

    public static void imprimeCarroCargaPorPlaca(List<Carga> carros, String placa) {
        if (carros == null) {
            erroNull();
            return;
        }
        Optional<Carga> carga = carros.stream().filter(c -> c.getPlaca().equals(placa)).findAny();
        carga.ifPresentOrElse(Impressao::imprimeCarga, () -> System.out.println("\n=========[Nenhum carro encontrado]=========\n"));
    }
    
    public static void imprimeMenu() {
        System.out.println("[Sistema de Gestão de Veículos - Menu Principal]\n");
        System.out.println("    1. Cadastrar Veículo de Passeio");
        System.out.println("    2. Cadastrar Veículo de Carga");
        System.out.println("    3. Imprimir Todos os Veículos de Passeio");
        System.out.println("    4. Imprimir Todos os Veículos de Carga");
        System.out.println("    5. Imprimir Veículo de Passeio pela Placa");
        System.out.println("    6. Imprimir Veículo de Carga pela Placa");
        System.out.println("    7. Sair do Sistema");
        System.out.println("\n==========================================\n");
    }
    
    public static void imprimeCarga(Carga vCarga) {
        if (vCarga == null) {
            erroNull();
            return;
        }
        System.out.println("--------------[Listar>Carga]--------------\n");
        System.out.println("Placa:             " + vCarga.getPlaca());
        System.out.println("Marca:             " + vCarga.getMarca());
        System.out.println("Modelo:            " + vCarga.getModelo());
        System.out.println("Cor:               " + vCarga.getCor());
        System.out.println(String.format("Vel. Máxima:       %s km/h",vCarga.getVelMaxima()));
        System.out.println(String.format("(Vel. Máxima:      %.2f cm/h)", vCarga.calculaVel(vCarga.getVelMaxima())));
        System.out.println("Qtde. Rodas:       " + vCarga.getQtdRodas());
        System.out.println("[Carga] " 
                        + "\n * Carga Máxima:   " + vCarga.getCargaMax() 
                        + "\n * Tara:           " + vCarga.getTara());
        if (vCarga.getMotor() != null) {
            System.out.println("[Motor] " 
                            + "\n * Potência:       " + vCarga.getMotor().getPotencia() 
                            + "\n * Qtd. Pistões:   " + vCarga.getMotor().getQtdPist());
        }
        System.out.println("Cálculo interface: " + vCarga.calcular());
    }
    
    public static void imprimePasseio(Passeio vPasseio) {
        if (vPasseio == null) {
            erroNull();
            return;
        }
        System.out.println("-------------[Listar>Passeio]-------------\n");
        System.out.println("Placa:             " + vPasseio.getPlaca());
        System.out.println("Marca:             " + vPasseio.getMarca());
        System.out.println("Modelo:            " + vPasseio.getModelo());
        System.out.println("Cor:               " + vPasseio.getCor());
        System.out.println(String.format("Vel. Máxima:       %s km/h",vPasseio.getVelMaxima()));
        System.out.println(String.format("(Vel. Máxima:      %s m/h)",vPasseio.calculaVel(vPasseio.getVelMaxima())));
        System.out.println("Qtde. Rodas:       " + vPasseio.getQtdRodas());
        System.out.println("Qtde. Passageiros: " + vPasseio.getQtdPassageiros());
        if (vPasseio.getMotor() != null) {
            System.out.println("[Motor] " 
                            + "\n * Potência:       " + vPasseio.getMotor().getPotencia() 
                            + "\n * Qtd. Pistões:   " + vPasseio.getMotor().getQtdPist());
        }
        System.out.println("Cálculo interface: " + vPasseio.calcular());
    }
    
    public static void erroNull() {
        System.out.println("\n[Não há cadastros, execute outra operação]\n");
    }
}
