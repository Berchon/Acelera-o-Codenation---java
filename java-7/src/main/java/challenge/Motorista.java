package challenge;

import java.util.Objects;

public class Motorista {

    private final String nome;
    private final int idade;
    private final int pontos;
    private final String habilitacao;

    public Motorista(String nome, int idade, int pontos, String habilitacao) {
        this.nome = nome;
        this.idade = idade;
        this.pontos = pontos;
        this.habilitacao = habilitacao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(habilitacao);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }

        // Fiz várias validacoes pois isso facilita caso se deseje aumentar a complexidade da validacao
        private static boolean validaNome(String nome) {
            return nome != null && !nome.isEmpty();
        }

        private static boolean validaIdade(int idade) {
            return idade > 0;
        }

        private static boolean validaPontos(int pontos) {
            return pontos > 0;
        }

        private static boolean validaHabilitacao(String habilitacao) {
            return habilitacao != null && !habilitacao.isEmpty();
        }

        public MotoristaBuilder withNome(String nome) {
            if (!validaNome(nome)) {
                throw new NullPointerException("Um nome deve ser informado");
            }
            this.nome = nome;
            return this;
        }

        public MotoristaBuilder withIdade(int idade) {
            if (!validaIdade(idade)) {
                throw new IllegalArgumentException("a idade deve ser maior que Zero");
            }
            this.idade = idade;
            return this;
        }

        public MotoristaBuilder withPontos(int pontos) {
            if (!validaPontos(pontos)) {
                throw new IllegalArgumentException("O número de pontos deve ser maior que Zero");
            }
            this.pontos = pontos;
            return this;
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) {
            if (!validaHabilitacao(habilitacao)) {
                throw new NullPointerException("Deve ser informado o código da habilitaćão");
            }
            this.habilitacao = habilitacao;
            return this;
        }


        public Motorista build() {
            if (!validaNome(nome)) {
                throw new NullPointerException("Um nome deve ser informado");
            }
            if (!validaHabilitacao(habilitacao)) {
                throw new NullPointerException("Deve ser informado o código da habilitaćão");
            }
            // Sei que não precisaria colocar esses 2 IFs abaixo
            if (!validaIdade(idade)) {
                throw new IllegalArgumentException("A idade deve ser maior que Zero");
            }
            if (!validaPontos(pontos)) {
                throw new IllegalArgumentException("O número de pontos deve ser maior que Zero");
            }
            return new Motorista(nome, idade, pontos, habilitacao);
        }
    }
}
