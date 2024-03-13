package GreenDragon.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import GreenDragon.Model.Cadastro;

import GreenDragon.Repository.CadastroRepository;

public class CadastroController implements CadastroRepository {

	private ArrayList<Cadastro> listaCadastros = new ArrayList<Cadastro>();

	int numero = 0;

	@Override
	public Optional<Cadastro> procurarPorNumero(int numero) {
		Optional<Cadastro> cadastro = buscarNaCollection(numero);

		if (cadastro.isPresent()) {
			cadastro.get().visualizar();
		} else {
			System.out.println("O cadastro número: " + numero + " não foi encontrado!");
		}

		return cadastro;
	}

	@Override
	public void procurarPorTutor(String nomeTutor) {
		List<Cadastro> listaNomes = listaCadastros.stream().filter(n -> n.getNomeTutor().contains(nomeTutor))
				.collect(Collectors.toList());

		for (var cadastro : listaNomes)
			cadastro.visualizar();
	}

	@Override
	public void listarTodas() {
		for (var cadastro : listaCadastros) {
			cadastro.visualizar();
		}

	}

	@Override
	public void cadastrar(Cadastro cadastro) {
		listaCadastros.add(cadastro);
		System.out.println("O cadastro do Pet: " + cadastro.getNomePet() + " foi criado com Sucesso!");
	}

	@Override
	public void atualizar(Cadastro cadastro) {
		Optional<Cadastro> buscaCadastro = buscarNaCollection(cadastro.getNumero());

		if (buscaCadastro.isPresent()) {
			listaCadastros.set(listaCadastros.indexOf(buscaCadastro.get()), cadastro);
			System.out.println("O cadastro do Pet: " + cadastro.getNomePet() + " foi atualizado com sucesso!");
		} else {
			System.out.println("O cadastro do Pet: " + cadastro.getNomePet() + " não foi encontrado!");

		}
	}

	public void deletar(int numero) {

		Optional<Cadastro> cadastro = buscarNaCollection(numero);

		if (cadastro.isPresent())
			if (listaCadastros.remove(cadastro.get())) {
				System.out.println("O cadastro do Pet: " + numero + " foi excluído com sucesso!");
			} else {
				System.out.println("O cadastro do Pet: " + numero + " não foi encontrado!");
			}

	}

	public int gerarNumero() {
		return ++numero;
	}

	public Optional<Cadastro> buscarNaCollection(int numero) {
		for (var cadastro : listaCadastros) {
			if (cadastro.getNumero() == numero) {
				return Optional.of(cadastro);
			}
		}
		return Optional.empty();
	}

	public Cadastro get() {
		return null;
	}

}
