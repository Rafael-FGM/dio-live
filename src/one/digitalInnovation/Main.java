package one.digitalInnovation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import one.digitalInnovation.dominio.Bootcamp;
import one.digitalInnovation.dominio.Conteudo;
import one.digitalInnovation.dominio.Curso;
import one.digitalInnovation.dominio.Dev;
import one.digitalInnovation.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {
		Curso cursoJavaBasico = new Curso();
		cursoJavaBasico.setTitulo("Java Básico");
		cursoJavaBasico.setDescricao("Aprenda os conceitos básicos sobre Java");
		cursoJavaBasico.setCargaHoraria(8);

		Curso cursoDotNet = new Curso();
		cursoDotNet.setTitulo("Java .NET");
		cursoDotNet.setDescricao("Aprenda os conceitos básicos sobre C#");
		cursoDotNet.setCargaHoraria(8);

		Curso cursoJavaAvancado = new Curso();
		cursoJavaAvancado.setTitulo("Java Avançado");
		cursoJavaAvancado.setDescricao("Aprenda os conceitos avançados sobre Java");
		cursoJavaAvancado.setCargaHoraria(8);

		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Aprendendo Orientação a Objetos com Java");
		mentoria.setDescricao("Imersão sobre os pilares da Orientação a Objetos");
		mentoria.setData(LocalDateTime.now());

		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("GFT START #2 Java");
		bootcamp.setInicio(LocalDate.now());
		bootcamp.setFim(bootcamp.getInicio().plusDays(45));
		List<Conteudo> conteudosBootcamp = Arrays.asList(cursoJavaBasico, cursoJavaAvancado, mentoria);
		bootcamp.setConteudos(conteudosBootcamp);

		Dev rafa = new Dev();
		rafa.setNome("Rafael");

		Dev patrik = new Dev();
		patrik.setNome("Alexandre");
		
		rafa.inscrever(cursoDotNet);
		rafa.inscrever(bootcamp);
		rafa.progredir();
		rafa.progredir();
		
		patrik.inscrever(bootcamp);
		patrik.progredir();
		patrik.progredir();
		patrik.progredir();
		patrik.progredir();
		
		System.out.println(String.format("XP Rafael: %.2f", rafa.calcularTotalXp()));
		System.out.println(String.format("XP Alexandre: %.2f", patrik.calcularTotalXp()));

		List<Dev> ranking = Arrays.asList(rafa, patrik).stream()
								  .sorted((dev1, dev2)-> Double.compare(dev2.calcularTotalXp(), dev1.calcularTotalXp()))
								  .collect(Collectors.toList());
		
		for (Dev dev : ranking) {
			System.out.println(dev.getNome());
		}
	}

}
