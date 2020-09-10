package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entities.Contratos;
import entities.Departamento;
import entities.Funcionario;
import entities.enums.Esperiencia;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Funcionario> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		int n = requestIntInput("Quantos funcionarios deseja cadastrar ?");

		for (int i = 0; i < n; i++) {
			Funcionario fun;
			int id = requestIntInput("Registre um Id");
			while (temId(list, id)) {
				id = requestIntInput("Este Id ja existe. Tente novamente");
			}
			String nomeDep = requestStrinInput("Digite o nome do departamento");
			String nome = requestStrinInput("Digite seu nome");
			String level = requestStrinInput("Digite a sua experiencia");
			double salario = requestIntInput("Forneca o seu salario");

			fun = new Funcionario(nome, id, salario, Esperiencia.valueOf(level), new Departamento(nomeDep));
			list.add(fun);
		}

		int id = requestIntInput("Digite o id especifico para adicionar os contratos");
		Funcionario fun = list.stream().filter(x -> x.getId() == id).findFirst().get();

		if (fun.getId() != id) {
			System.out.println("Este id nao existe ");
		}

		int contratos = requestIntInput(
				"Quantos contratos deseja adicionar a este id ? #" + fun.getId() + " Nome " + fun.getNome());
		for (int i = 0; i < contratos; i++) {
			System.out.print("Entre com a data do contrato numero #" + (i + 1) + " ");
			Date date = sdf.parse(sc.next());
			double valorHora = requestIntInput("Digite o valor da hora ");
			int horas = requestIntInput("Digite a duracao ");
			Contratos contrato = new Contratos(date, valorHora, horas);
			fun.addContratos(contrato);
		}

		String mesAno = requestStrinInput("Digite o MES e Ano");
		int ano = Integer.parseInt(mesAno.substring(0, 2));
		int mes = Integer.parseInt(mesAno.substring(3));
		int ids = requestIntInput("Digite o id");
		Funcionario funs = list.stream().filter(x -> x.getId() == ids).findFirst().get();
		if (funs.getId() != ids) {
			System.out.print("Funcionario nao cadastrado");
		} else {
			System.out.println("Nome " + funs.getNome());
			System.out.println("Departamento " + funs.getDepartamento().getNome());
			System.out.println("Ganhos do mes " + mesAno + " total" + funs.ganhos(ano, mes));
		}

		sc.close();
	}

	private static boolean temId(List<Funcionario> list, int id) {
		Funcionario fun = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return fun != null;
	}

	private static int requestIntInput(String mesagem) {
		return Integer.parseInt(JOptionPane.showInputDialog(mesagem));
	}

	private static String requestStrinInput(String mesagem) {
		return JOptionPane.showInputDialog(mesagem);
	}
}
