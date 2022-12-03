package br.com.dio.desafio.dominio;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String nome) {
        this.nome = nome;
    }
    public Dev() {
    }


    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (!conteudo.isPresent()) {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
            return;
        }
        this.conteudosConcluidos.add(conteudo.get());
        this.conteudosInscritos.remove(conteudo.get());
        
        /*
         * Iterator<Conteudo> iterator = this.conteudosInscritos.iterator();
         * if (iterator.hasNext()) {
         * Conteudo conteudo = iterator.next();
         * this.conteudosConcluidos.add(conteudo);
         * this.conteudosInscritos.remove(conteudo);
         * }
         * else
         * System.err.println("Você não está matriculado em nenhum conteúdo!");
         */
    }

    public void finalizarConteudo(Conteudo conteudo) {
        if (!this.conteudosInscritos.contains(conteudo)) {
            System.err.println("Você não está matriculado neste conteúdo!");
            return;
        }
        this.conteudosConcluidos.add(conteudo);
        this.conteudosInscritos.remove(conteudo);
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
        /*
         * Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
         * double soma = 0;
         * while (iterator.hasNext()) {
         * double next = iterator.next().calcularXp();
         * soma += next;
         * }
         * return soma;
         */
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos)
                && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }

}
