/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bruna
 */
@Entity
@Table(name = "pedido", catalog = "MERCADO", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pedido_1.findAll", query = "SELECT p FROM Pedido_1 p"),
    @NamedQuery(name = "Pedido_1.findByCodigoPedido", query = "SELECT p FROM Pedido_1 p WHERE p.codigoPedido = :codigoPedido"),
    @NamedQuery(name = "Pedido_1.findByDataPedido", query = "SELECT p FROM Pedido_1 p WHERE p.dataPedido = :dataPedido"),
    @NamedQuery(name = "Pedido_1.findByNomePedido", query = "SELECT p FROM Pedido_1 p WHERE p.nomePedido = :nomePedido"),
    @NamedQuery(name = "Pedido_1.findByContatoPedido", query = "SELECT p FROM Pedido_1 p WHERE p.contatoPedido = :contatoPedido"),
    @NamedQuery(name = "Pedido_1.findByCpfPedido", query = "SELECT p FROM Pedido_1 p WHERE p.cpfPedido = :cpfPedido"),
    @NamedQuery(name = "Pedido_1.findByCodProduto", query = "SELECT p FROM Pedido_1 p WHERE p.codProduto = :codProduto"),
    @NamedQuery(name = "Pedido_1.findByQuantidade", query = "SELECT p FROM Pedido_1 p WHERE p.quantidade = :quantidade")})
public class Pedido_1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_pedido")
    private Integer codigoPedido;
    @Basic(optional = false)
    @Column(name = "data_pedido")
    @Temporal(TemporalType.DATE)
    private Date dataPedido;
    @Basic(optional = false)
    @Column(name = "nome_pedido")
    private String nomePedido;
    @Column(name = "contato_pedido")
    private String contatoPedido;
    @Basic(optional = false)
    @Column(name = "cpf_pedido")
    private String cpfPedido;
    @Basic(optional = false)
    @Column(name = "cod_produto")
    private int codProduto;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;

    public Pedido_1() {
    }

    public Pedido_1(Integer codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Pedido_1(Integer codigoPedido, Date dataPedido, String nomePedido, String cpfPedido, int codProduto, int quantidade) {
        this.codigoPedido = codigoPedido;
        this.dataPedido = dataPedido;
        this.nomePedido = nomePedido;
        this.cpfPedido = cpfPedido;
        this.codProduto = codProduto;
        this.quantidade = quantidade;
    }

    public Integer getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Integer codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getNomePedido() {
        return nomePedido;
    }

    public void setNomePedido(String nomePedido) {
        this.nomePedido = nomePedido;
    }

    public String getContatoPedido() {
        return contatoPedido;
    }

    public void setContatoPedido(String contatoPedido) {
        this.contatoPedido = contatoPedido;
    }

    public String getCpfPedido() {
        return cpfPedido;
    }

    public void setCpfPedido(String cpfPedido) {
        this.cpfPedido = cpfPedido;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPedido != null ? codigoPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido_1)) {
            return false;
        }
        Pedido_1 other = (Pedido_1) object;
        if ((this.codigoPedido == null && other.codigoPedido != null) || (this.codigoPedido != null && !this.codigoPedido.equals(other.codigoPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Pedido_1[ codigoPedido=" + codigoPedido + " ]";
    }
    
}
