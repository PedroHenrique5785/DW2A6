package br.edu.ifspcjo.ads.dw2a6.TIF.Model;

public enum Status {

	EM_APROVAÇÃO ("Em aprovação"),
	APROVADA ("Aprovada"),
	EM_ANDAMENTO ("Em andamento"),
	FINALIZADA ("Finalizada");
	
	private String status;
	
	Status(String status) {
		this.status = status;
	}
	
	public String getStatus(){
		return this.status;
	}
}
