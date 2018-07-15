package dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_participacao")
public class Participacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codPartipacao;
	private String personagem;
	private BigDecimal desconto;
	
	@ManyToOne
	@JoinColumn(name="filme")//nome da chave estrangeira 
	private Filme filme;
	
	@ManyToOne
	@JoinColumn(name="artista")
	private Artista artista;
	
	public Participacao() {
		
	}

	public Participacao(Integer codPartipacao, String personagem, BigDecimal desconto, Filme filme, Artista artista) {
		super();
		this.codPartipacao = codPartipacao;
		this.personagem = personagem;
		this.desconto = desconto;
		this.filme = filme;
		filme.addParticipacao(this);
		this.artista = artista;
		artista.addParticipacao(this);
	}

	public Integer getCodPartipacao() {
		return codPartipacao;
	}

	public void setCodPartipacao(Integer codPartipacao) {
		this.codPartipacao = codPartipacao;
	}

	public String getPersonagem() {
		return personagem;
	}

	public void setPersonagem(String personagem) {
		this.personagem = personagem;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	@Override
	public String toString() {
		return "Participacao [codPartipacao=" + codPartipacao + ", personagem=" + personagem + ", desconto=" + desconto
				+ "]";
	}
	
	public BigDecimal cachePago() {
		return artista.getCache().subtract(desconto);
	}
	

}
