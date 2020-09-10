package entities;

import java.util.Calendar;
import java.util.List;

import entities.enums.Esperiencia;

public class Funcionario {

	private String nome;
	private Integer id;
	private double baseSalarial;
	private Esperiencia esperiencia;

	private Departamento departamento;
	private List<Contratos> contratos;

	
	
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public double getBaseSalarial() {
		return baseSalarial;
	}


	public void setBaseSalarial(double baseSalarial) {
		this.baseSalarial = baseSalarial;
	}


	public Esperiencia getEsperiencia() {
		return esperiencia;
	}


	public void setEsperiencia(Esperiencia esperiencia) {
		this.esperiencia = esperiencia;
	}


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public List<Contratos> getContratos() {
		return contratos;
	}


	public Funcionario() {}
	
	
	public Funcionario(String nome, Integer id, double baseSalarial, Esperiencia esperiencia,
			Departamento departamento) {
		this.nome = nome;
		this.id = id;
		this.baseSalarial = baseSalarial;
		this.esperiencia = esperiencia;
		this.departamento = departamento;
	}

	public void addContratos(Contratos contrato) {
		contratos.add(contrato);
	}
	public void removerContratos(Contratos contrato) {
		contratos.remove(contrato);
	}
	
	public double ganhos(int ano, int mes) {
		double soma = baseSalarial;
		Calendar cal = Calendar.getInstance();
		for (Contratos contrato : contratos) {
			cal.setTime(contrato.getDate());
			int contrato_ano = cal.get(Calendar.YEAR);
			int contrato_mes = cal.get(Calendar.MONTH);
			if(ano == contrato_ano && mes == contrato_mes) {
				soma+= contrato.total();
			}
		}
		return soma;
	}
}
