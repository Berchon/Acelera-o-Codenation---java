package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class DesafioMeuTimeApplication implements MeuTimeInterface {
	List<Clube> clubes = new ArrayList<>();
	List<Jogador> jogadores = new ArrayList<>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if (!buscarTimes().contains(id)) {
			Clube clube = new Clube(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
			clubes.add(clube);
			return;
		}
		throw new IdentificadorUtilizadoException();
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		buscarNomeTime(idTime); // essa funćão é só pra lanćar Excećão, caso o time não exista.
		try {
			buscarNomeJogador(id); // se encontrar o id lanća a excećão, caso contrário add novo jogador
			throw new IdentificadorUtilizadoException();
		} catch (JogadorNaoEncontradoException err) {
			Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
			jogadores.add(jogador);
		}
	}

	public void definirCapitao(Long idJogador) {
		Long idTime = buscarTimeDoJogador(idJogador); // se o jogador não estivar cadastrado nao será encontrado
													// o time e será lanćada uma excećão de jogador não encontrado
		for(Jogador jogador : jogadores){
			if (jogador.getIdTime() == idTime) {
				jogador.setCapitao(false);
			}
			if ((jogador.getIdTime() == idTime) & (jogador.getId() == idJogador)) {
				jogador.setCapitao(true);
			}
		}
	}

	public Long buscarTimeDoJogador(Long idJogador) {
		for (Jogador jogador : jogadores) {
			if (jogador.getId() == idJogador) {
				return jogador.getIdTime();
			}
		}
		throw new JogadorNaoEncontradoException();
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		buscarNomeTime(idTime); // essa funćão é só pra lanćar Excećão, caso o time não exista.
		for(Jogador jogador : jogadores){
			if(jogador.getIdTime() == idTime & jogador.getCapitao()) {
				return jogador.getId();
			}
		}
		throw new CapitaoNaoInformadoException();
	}

	public String buscarNomeJogador(Long idJogador) {
		for(Jogador jogador : jogadores){
			if(jogador.getId() == idJogador) {
				return jogador.getNome();
			}
		}
		throw new JogadorNaoEncontradoException();
	}

	public String buscarNomeTime(Long idTime) {
		for(Clube clube : clubes){
			if(clube.getId() == idTime) {
				return clube.getNome();
			}
		}
		throw new TimeNaoEncontradoException();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		List<Long> jogadoresDoClube = jogadores
				.stream()
				.filter(element -> element.getIdTime() == idTime)
				.map(e-> e.getId())
				.collect(Collectors.toList());
		if (jogadoresDoClube.size() != 0) {
			Collections.sort(jogadoresDoClube);

			return jogadoresDoClube;
		}
		throw new TimeNaoEncontradoException();
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Optional<Jogador> melhorJogador = jogadores
				.stream()
				.filter(jogador -> jogador.getIdTime() == idTime)
				.max(Comparator.comparing(Jogador::getNivelHabilidade));
		if (melhorJogador.isPresent()) {
			return melhorJogador.get().getId();
		}
		throw new TimeNaoEncontradoException();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		Optional<Jogador> jogadormaisVelho = jogadores.stream()
				.filter(jogador -> jogador.getIdTime() == idTime)
				.min(Comparator.comparing(Jogador::getDataNascimento));
		if (jogadormaisVelho.isPresent()) {
			return jogadormaisVelho.get().getId();
		}
		throw new TimeNaoEncontradoException();
	}

	public List<Long> buscarTimes() {
		List<Long> idsClubes = new ArrayList<>();
		for (Clube clube: clubes) {
			idsClubes.add(clube.id);
		}
		return idsClubes;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		Optional<Jogador> maiorSalario = jogadores.stream()
				.filter(jogador -> jogador.getIdTime() == idTime)
				.max(Comparator.comparing(Jogador::getSalario));
		if (maiorSalario.isPresent()) {
			return maiorSalario.get().getId();
		}
		throw new TimeNaoEncontradoException();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		List<Jogador> salarioJogador = jogadores.stream()
				.filter(jogador -> jogador.getId() == idJogador)
				.collect(Collectors.toList());
		if (salarioJogador.size() != 0) {
			return salarioJogador.get(0).getSalario();
		}
		throw new JogadorNaoEncontradoException();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> topJogadores = new ArrayList<>();
		List<Jogador> maisHabilidosos = jogadores;
		Collections.sort(maisHabilidosos, Collections.reverseOrder());
		if (top > maisHabilidosos.size()) {
			top = maisHabilidosos.size();
		}
		for (int i = 0; i < top; i += 1) {
			topJogadores.add(maisHabilidosos.get(i).getId());
		}

		return topJogadores;
	}
}
