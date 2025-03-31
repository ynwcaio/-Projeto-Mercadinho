/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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

/**
 *
 * @author bruna
 */
@Entity
@Table(name = "produto", catalog = "MERCADO", schema = "")
@NamedQueries({
    @NamedQuery(name = "Produto_1.findAll", query = "SELECT p FROM Produto_1 p"),
    @NamedQuery(name = "Produto_1.findByCodProduto", query = "SELECT p FROM Produto_1 p WHERE p.codProduto = :codProduto"),
    @NamedQuery(name = "Produto_1.findByNomeProduto", query = "SELECT p FROM Produto_1 p WHERE p.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "Produto_1.findByPrecoProduto", query = "SELECT p FROM Produto_1 p WHERE p.precoProduto = :precoProduto"),
    @NamedQuery(name = "Produto_1.findByCategProduto", query = "SELECT p FROM Produto_1 p WHERE p.categProduto = :categProduto")})
public class Produto_1 implements Serializable {
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

    public Produto_1() {
    }

    public Produto_1(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public Produto_1(Integer codProduto, String nomeProduto, BigDecimal precoProduto, String categProduto) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.categProduto = categProduto;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(BigDecimal precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getCategProduto() {
        return categProduto;
    }

    public void setCategProduto(String categProduto) {
        this.categProduto = categProduto;
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
        if (!(object instanceof Produto_1)) {
            return false;
        }
        Produto_1 other = (Produto_1) object;
        if ((this.codProduto == null && other.codProduto != null) || (this.codProduto != null && !this.codProduto.equals(other.codProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Produto_1[ codProduto=" + codProduto + " ]";
    }
    
}
