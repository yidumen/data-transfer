package com.yidumen.datatransifer.olddata.dao.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pholance
 */
@Entity
@Table(name = "buddhism")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buddhism.getByPartId", query = "SELECT b from Buddhism b WHERE b.partid LIKE :patten ORDER BY b.partid ASC"),
    @NamedQuery(name = "Buddhism.findByType", query = "SELECT b FROM Buddhism b WHERE b.type = :type")})
public class Buddhism implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "PARTID")
    private String partid;
    @Basic(optional = false)
    @Lob
    @Column(name = "CONTENT")
    private String content;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "TITLE_CSS")
    private String titleCss;
    @Basic(optional = false)
    @Column(name = "PREID")
    private int preid;
    @Basic(optional = false)
    @Column(name = "NEXTID")
    private int nextid;
    @Basic(optional = false)
    @Column(name = "TYPE")
    private int type;

    public Buddhism() {
    }

    public Buddhism(Integer id) {
        this.id = id;
    }

    public Buddhism(Integer id, String partid, String content, String title, String titleCss, int preid, int nextid, int type) {
        this.id = id;
        this.partid = partid;
        this.content = content;
        this.title = title;
        this.titleCss = titleCss;
        this.preid = preid;
        this.nextid = nextid;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartid() {
        return partid;
    }

    public void setPartid(String partid) {
        this.partid = partid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleCss() {
        return titleCss;
    }

    public void setTitleCss(String titleCss) {
        this.titleCss = titleCss;
    }

    public int getPreid() {
        return preid;
    }

    public void setPreid(int preid) {
        this.preid = preid;
    }

    public int getNextid() {
        return nextid;
    }

    public void setNextid(int nextid) {
        this.nextid = nextid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
        if (!(object instanceof Buddhism)) {
            return false;
        }
        Buddhism other = (Buddhism) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yidumen.datatransifer.olddata.dao.entity.Buddhism[ id=" + id + " ]";
    }
    
}
