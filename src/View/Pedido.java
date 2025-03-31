/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

/**
 *
 * @author bruna
 */
@Entity
@Table(name = "pedido", catalog = "MERCADO", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByCodigoPedido", query = "SELECT p FROM Pedido p WHERE p.codigoPedido = :codigoPedido"),
    @NamedQuery(name = "Pedido.findByDataPedido", query = "SELECT p FROM Pedido p WHERE p.dataPedido = :dataPedido"),
    @NamedQuery(name = "Pedido.findByNomePedido", query = "SELECT p FROM Pedido p WHERE p.nomePedido = :nomePedido"),
    @NamedQuery(name = "Pedido.findByContatoPedido", query = "SELECT p FROM Pedido p WHERE p.contatoPedido = :contatoPedido"),
    @NamedQuery(name = "Pedido.findByCpfPedido", query = "SELECT p FROM Pedido p WHERE p.cpfPedido = :cpfPedido"),
    @NamedQuery(name = "Pedido.findByCodProduto", query = "SELECT p FROM Pedido p WHERE p.codProduto = :codProduto"),
    @NamedQuery(name = "Pedido.findByQuantidade", query = "SELECT p FROM Pedido p WHERE p.quantidade = :quantidade")})
public class Pedido implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
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

    public Pedido() {
    }

    public Pedido(Integer codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Pedido(Integer codigoPedido, Date dataPedido, String nomePedido, String cpfPedido, int codProduto, int quantidade) {
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
        Integer oldCodigoPedido = this.codigoPedido;
        this.codigoPedido = codigoPedido;
        changeSupport.firePropertyChange("codigoPedido", oldCodigoPedido, codigoPedido);
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        Date oldDataPedido = this.dataPedido;
        this.dataPedido = dataPedido;
        changeSupport.firePropertyChange("dataPedido", oldDataPedido, dataPedido);
    }

    public String getNomePedido() {
        return nomePedido;
    }

    public void setNomePedido(String nomePedido) {
        String oldNomePedido = this.nomePedido;
        this.nomePedido = nomePedido;
        changeSupport.firePropertyChange("nomePedido", oldNomePedido, nomePedido);
    }

    public String getContatoPedido() {
        return contatoPedido;
    }

    public void setContatoPedido(String contatoPedido) {
        String oldContatoPedido = this.contatoPedido;
        this.contatoPedido = contatoPedido;
        changeSupport.firePropertyChange("contatoPedido", oldContatoPedido, contatoPedido);
    }

    public String getCpfPedido() {
        return cpfPedido;
    }

    public void setCpfPedido(String cpfPedido) {
        String oldCpfPedido = this.cpfPedido;
        this.cpfPedido = cpfPedido;
        changeSupport.firePropertyChange("cpfPedido", oldCpfPedido, cpfPedido);
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        int oldCodProduto = this.codProduto;
        this.codProduto = codProduto;
        changeSupport.firePropertyChange("codProduto", oldCodProduto, codProduto);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        int oldQuantidade = this.quantidade;
        this.quantidade = quantidade;
        changeSupport.firePropertyChange("quantidade", oldQuantidade, quantidade);
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
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.codigoPedido == null && other.codigoPedido != null) || (this.codigoPedido != null && !this.codigoPedido.equals(other.codigoPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Pedido[ codigoPedido=" + codigoPedido + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
