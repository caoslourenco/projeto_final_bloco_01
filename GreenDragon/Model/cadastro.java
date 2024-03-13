package GreenDragon.Model;

import GreenDragon.util.Cores;

public class Cadastro {

	private String nomeTutor;
	private String telefone;
	private String nomePet;
	private int tipo;
	private int numero;

	public Cadastro(int numero, String nomeTutor, String telefone, String nomePet, int tipo) {
		this.nomeTutor = nomeTutor;
		this.telefone = telefone;
		this.nomePet = nomePet;
		this.tipo = tipo;
		this.numero = numero;
	}

	public String getNomeTutor() {
		return nomeTutor;
	}

	public void setNomeTutor(String nomeTutor) {
		this.nomeTutor = nomeTutor;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNomePet() {
		return nomePet;
	}

	public void setNomePet(String nomePet) {
		this.nomePet = nomePet;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void visualizar() {

		String tipo = "";
		switch (this.tipo) {
		case 1 -> tipo = "Doméstico";
		case 2 -> tipo = "Silvestre";
		}

		System.out.println(Cores.TEXT_WHITE + Cores.ANSI_PURPLE_BACKGROUND_BRIGHT + 
				       "\n\n******************************************");
		System.out.println("         Cadastro do Pet:                 ");
		System.out.println("******************************************" + Cores.TEXT_RESET);
		System.out.println("Número do cadastro: " + this.numero);
		System.out.println("Nome do Tutor: " + this.nomeTutor);
		System.out.println("Telefone do Tutor: " + this.telefone);
		System.out.println("Nome do Pet: " + this.nomePet);
		System.out.println("Tipo de Pet: " + tipo);

	}

	public int getNumero() {
		return this.numero;
	}