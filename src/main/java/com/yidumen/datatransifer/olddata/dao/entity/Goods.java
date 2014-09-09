/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yidumen.datatransifer.olddata.dao.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pholance
 */
@Entity
@Table(name = "goods")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Goods.findAll", query = "SELECT g FROM Goods g"),
    @NamedQuery(name = "Goods.findById", query = "SELECT g FROM Goods g WHERE g.id = :id"),
    @NamedQuery(name = "Goods.findByName", query = "SELECT g FROM Goods g WHERE g.name = :name"),
    @NamedQuery(name = "Goods.findByTelphone", query = "SELECT g FROM Goods g WHERE g.telphone = :telphone"),
    @NamedQuery(name = "Goods.findByAddress", query = "SELECT g FROM Goods g WHERE g.address = :address"),
    @NamedQuery(name = "Goods.findByFromurl", query = "SELECT g FROM Goods g WHERE g.fromurl = :fromurl"),
    @NamedQuery(name = "Goods.findByCreatedate", query = "SELECT g FROM Goods g WHERE g.createdate = :createdate"),
    @NamedQuery(name = "Goods.findByStatus", query = "SELECT g FROM Goods g WHERE g.status = :status")})
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "TELPHONE")
    private String telphone;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @Column(name = "FROMURL")
    private String fromurl;
    @Basic(optional = false)
    @Column(name = "CREATEDATE")
    private long createdate;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private int status;

    public Goods() {
    }

    public Goods(Integer id) {
        this.id = id;
    }

    public Goods(Integer id, String name, String telphone, String address, String fromurl, long createdate, int status) {
        this.id = id;
        this.name = name;
        this.telphone = telphone;
        this.address = address;
        this.fromurl = fromurl;
        this.createdate = createdate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFromurl() {
        return fromurl;
    }

    public void setFromurl(String fromurl) {
        this.fromurl = fromurl;
    }

    public long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(long createdate) {
        this.createdate = createdate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Goods)) {
            return false;
        }
        Goods other = (Goods) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yidumen.datatransifer.olddata.dao.entity.Goods[ id=" + id + " ]";
    }
    
}
