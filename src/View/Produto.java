/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author bruna
 */
@Entity
@Table(name = "produto", catalog = "MERCADO", schema = "")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByCodProduto", query = "SELECT p FROM Produto p WHERE p.codProduto = :codProduto"),
    @NamedQuery(name = "Produto.findByNomeProduto", query = "SELECT p FROM Produto p WHERE p.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "Produto.findByPrecoProduto", query = "SELECT p FROM Produto p WHERE p.precoProduto = :precoProduto"),
    @NamedQuery(name = "Produto.findByCategProduto", query = "SELECT p FROM Produto p WHERE p.categProduto = :categProduto")})
public class Produto implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_produto")
    private Integer codProduto;
    @Basic(optional = false)
    @Column(name = "nome_produto")
    private String nomeProduto;
    @Lob
    @Column(name = "desc_produto")
    private String descProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "preco_produto")
    private BigDecimal precoProduto;
    @Basic(optional = false)
    @Column(name = "categ_produto")
    private String categProduto;

    public Produto() {
    }

    public Produto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public Produto(Integer codProduto, String nomeProduto, BigDecimal precoProduto, String categProduto) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.categProduto = categProduto;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        Integer oldCodProduto = this.codProduto;
        this.codProduto = codProduto;
        changeSupport.firePropertyChange("codProduto", oldCodProduto, codProduto);
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        String oldNomeProduto = this.nomeProduto;
        this.nomeProduto = nomeProduto;
        changeSupport.firePropertyChange("nomeProduto", oldNomeProduto, nomeProduto);
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        String oldDescProduto = this.descProduto;
        this.descProduto = descProduto;
        changeSupport.firePropertyChange("descProduto", oldDescProduto, descProduto);
    }

    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(BigDecimal precoProduto) {
        BigDecimal oldPrecoProduto = this.precoProduto;
        this.precoProduto = precoProduto;
        changeSupport.firePropertyChange("precoProduto", oldPrecoProduto, precoProduto);
    }

    public String getCategProduto() {
        return categProduto;
    }

    public void setCategProduto(String categProduto) {
        String oldCategProduto = this.categProduto;
        this.categProduto = categProduto;
        changeSupport.firePropertyChange("categProduto", oldCategProduto, categProduto);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProduto != null ? codProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.codProduto == null && other.codProduto != null) || (this.codProduto != null && !this.codProduto.equals(other.codProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Produto[ codProduto=" + codProduto + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
