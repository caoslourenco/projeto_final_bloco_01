package GreenDragon;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import GreenDragon.Cadastro;
import GreenDragon.Domestico;
 

import java.util.Optional;

public interface CadastroRepository {

	Optional<Cadastro> procurarPorNumero(int numero);

	void listarTodas();

	void cadastrar(Cadastro cadastro);

	void atualizar(Cadastro cadastro);

	void procurarPorTutor(String nomeTutor);

	void deletar(int numero);
}