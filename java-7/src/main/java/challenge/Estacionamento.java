package challenge;

import java.util.ArrayList;

public class Estacionamento {

    private final ArrayList<Carro> carrosEstacionados = new ArrayList();

    private boolean validacoes(Carro carro) {
        boolean flag = true;
        if (!validaCarroAutonomo(carro)) {
            flag = false;
            throw new EstacionamentoException("Carros autônomos não podem usar o estacionamento");
        }
        if (!validaIdade(carro)) {
            flag = false;
            throw new EstacionamentoException("O motorista deve ser maior de idade");
        }
        if (!validaPontos(carro)) {
            flag = false;
            throw new EstacionamentoException("O motorista não pode estar com a CNH suspensa (com mais de 20 pontos)");
        }
        return flag;
    }

    public void estacionar(Carro carro) {

        if (validacoes(carro)) {
            if (!validaLotacaoMaxima()) {
                for (int indice = 0; indice < carrosEstacionados(); indice += 1) {
                    if (carrosEstacionados.get(indice).getMotorista().getIdade() <= 55) {
                        carrosEstacionados.remove(indice);
                        break;
                    }
                }
            }
        if (carrosEstacionados()< 10) {
                carrosEstacionados.add(carro);
            } else {
                throw new EstacionamentoException("Estacionamento lotado com idosos. Tente estacionar mais tarde!");
            }
        }

    }

    public int carrosEstacionados() {
        return carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carrosEstacionados.contains(carro);
    }

    private boolean validaLotacaoMaxima() {
        return this.carrosEstacionados() < 10;
    }

    private static boolean validaCarroAutonomo(Carro carro) {
        return carro.getMotorista() != null && !carro.getMotorista().getNome().isEmpty();
    }

    private static boolean validaIdade(Carro carro) {
        return carro.getMotorista().getIdade() >= 18;
    }

    private static boolean validaPontos(Carro carro) {
        return carro.getMotorista().getPontos() <= 20;
    }
}
