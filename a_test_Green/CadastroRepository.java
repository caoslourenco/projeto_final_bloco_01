package GreenDragon.Repository;

import GreenDragon.Model.Cadastro;
import java.util.Optional;

public interface CadastroRepository {

	Optional<Cadastro> procurarPorNumero(int numero);

	void listarTodas();

	void cadastrar(Cadastro cadastro);

	void atualizar(Cadastro cadastro);

	void procurarPorTutor(String nomeTutor);

	void deletar(int numero);
}