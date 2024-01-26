package one.digitalInnovation.dominio;

import java.time.LocalDateTime;

public class Mentoria extends Conteudo {

	private LocalDateTime data;

	@Override
	public double calcularXp() {
		// TODO Auto-generated method stub
		return XP_PADRAO;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

}
