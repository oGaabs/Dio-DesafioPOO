import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
    public static void main(String[] args) throws Exception {

        // Cursos
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        // Mentorias
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

		// Exemplo de Polimorfismo		
		// Conteudo conteudo = new Curso();
		// Conteudo conteudo1 = new Mentoria();

        /* System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        // Bootcamps
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        // Devs and Bootcamp progress
        Dev devGabriel = new Dev();
        devGabriel.setNome("Gabriel");
        devGabriel.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos "+ devGabriel.getNome() + " " +devGabriel.getConteudosInscritos());

        devGabriel.progredir();
        devGabriel.progredir();
        
        System.out.println("-");
        System.out.println("Conteudos Inscritos "+ devGabriel.getNome() + " " +devGabriel.getConteudosInscritos());
        System.out.println("Conteudos Concluidos "+ devGabriel.getNome() + " " +devGabriel.getConteudosConcluidos());
        System.out.println("XP: " + devGabriel.calcularTotalXp());

        System.out.println("--------");

        Dev devAmigo = new Dev();
        devAmigo.setNome("Amigo");
        devAmigo.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos " + devAmigo.getNome()+ " " +devAmigo.getConteudosInscritos());

        devAmigo.progredir();
        devAmigo.progredir();
        devAmigo.progredir();

        System.out.println("-");
        System.out.println("Conteudos Inscritos " + devAmigo.getNome()+ " " +devAmigo.getConteudosInscritos());
        System.out.println("Conteudos Concluidos " + devAmigo.getNome()+ " " +devAmigo.getConteudosConcluidos());
        System.out.println("XP: " + devAmigo.calcularTotalXp());
        
    }
}
