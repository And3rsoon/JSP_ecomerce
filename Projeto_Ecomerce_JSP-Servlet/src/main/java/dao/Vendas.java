package dao;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;



@Entity
@Table(name="vendas")
public class Vendas {
	@Id
	public Integer cod_produto;
	public Integer quantidade;
	public Integer cod_cliente;
	public float valor_venda;
	public Date data_compra;
	public Date data_entrega;
	public String mod_compra;
	
	
	public Integer getCod_produto() {
		return cod_produto;
	}
	public void setCod_produto(Integer cod_produto) {
		this.cod_produto = cod_produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public float getValor_venda() {
		return valor_venda;
	}
	public void setValor_venda(float valor_venda) {
		this.valor_venda = valor_venda;
	}
	public Date getData_compra() {
		return data_compra;
	}
	public void setData_compra(Date data_compra) {
		this.data_compra = data_compra;
	}
	public Date getData_entrega() {
		return data_entrega;
	}
	public void setData_entrega(Date data_entrega) {
		this.data_entrega = data_entrega;
	}
	public String getMod_compra() {
		return mod_compra;
	}
	public void setMod_compra(String mod_compra) {
		this.mod_compra = mod_compra;
	}
	
}