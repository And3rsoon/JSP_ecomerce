package dao;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.*;



@Entity
@Table(name="produtos")
public class Products {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer codigo;
	public String categoria;
	public Integer quantidade;
	public String url_img;
	public String nome;
	public String fabricante;
	public float valor_comp;
	public float valor_venda;
	@Lob
	public String descricao;
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getUrl_img() {
		return url_img;
	}
	public void setUrl_img(String url_img) {
		this.url_img = url_img;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public float getValor_comp() {
		return valor_comp;
	}
	public void setValor_comp(float valor_comp) {
		this.valor_comp = valor_comp;
	}
	public float getValor_venda() {
		return valor_venda;
	}
	public void setValor_venda(float valor_venda) {
		this.valor_venda = valor_venda;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String toString() {
		return this.nome;
	}
	
		
}
