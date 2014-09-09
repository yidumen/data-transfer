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
@Table(name = "video")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Video.findAll", query = "SELECT v FROM OldVideo v"),
    @NamedQuery(name = "Video.findById", query = "SELECT v FROM OldVideo v WHERE v.id = :id"),
    @NamedQuery(name = "Video.findByTitle", query = "SELECT v FROM OldVideo v WHERE v.title = :title"),
    @NamedQuery(name = "OldVideo.findByWidth", query = "SELECT v FROM OldVideo v WHERE v.width = :width"),
    @NamedQuery(name = "OldVideo.findByHeigth", query = "SELECT v FROM OldVideo v WHERE v.heigth = :heigth"),
    @NamedQuery(name = "OldVideo.findByFile", query = "SELECT v FROM OldVideo v WHERE v.file = :file"),
    @NamedQuery(name = "OldVideo.findByStatus", query = "SELECT v FROM OldVideo v WHERE v.status = :status"),
    @NamedQuery(name = "OldVideo.findByLength", query = "SELECT v FROM OldVideo v WHERE v.length = :length"),
    @NamedQuery(name = "OldVideo.findBySize", query = "SELECT v FROM OldVideo v WHERE v.size = :size"),
    @NamedQuery(name = "OldVideo.findByCreatetime", query = "SELECT v FROM OldVideo v WHERE v.createtime = :createtime"),
    @NamedQuery(name = "OldVideo.findByUpdatetime", query = "SELECT v FROM OldVideo v WHERE v.updatetime = :updatetime"),
    @NamedQuery(name = "OldVideo.findByShoottime", query = "SELECT v FROM OldVideo v WHERE v.shoottime = :shoottime"),
    @NamedQuery(name = "OldVideo.findByDescription", query = "SELECT v FROM OldVideo v WHERE v.description = :description"),
    @NamedQuery(name = "OldVideo.findByTag", query = "SELECT v FROM OldVideo v WHERE v.tag = :tag"),
    @NamedQuery(name = "OldVideo.findBySort", query = "SELECT v FROM OldVideo v WHERE v.sort = :sort"),
    @NamedQuery(name = "OldVideo.findByLevel", query = "SELECT v FROM OldVideo v WHERE v.level = :level"),
    @NamedQuery(name = "OldVideo.findByRefRes1", query = "SELECT v FROM OldVideo v WHERE v.refRes1 = :refRes1"),
    @NamedQuery(name = "OldVideo.findByRefRes2", query = "SELECT v FROM OldVideo v WHERE v.refRes2 = :refRes2"),
    @NamedQuery(name = "OldVideo.findByRefRes3", query = "SELECT v FROM OldVideo v WHERE v.refRes3 = :refRes3"),
    @NamedQuery(name = "OldVideo.findByRefRes4", query = "SELECT v FROM OldVideo v WHERE v.refRes4 = :refRes4"),
    @NamedQuery(name = "OldVideo.findByRefRes5", query = "SELECT v FROM OldVideo v WHERE v.refRes5 = :refRes5"),
    @NamedQuery(name = "OldVideo.findByDescs", query = "SELECT v FROM OldVideo v WHERE v.descs = :descs"),
    @NamedQuery(name = "OldVideo.findByRefRes1Desc", query = "SELECT v FROM OldVideo v WHERE v.refRes1Desc = :refRes1Desc"),
    @NamedQuery(name = "OldVideo.findByRefRes2Desc", query = "SELECT v FROM OldVideo v WHERE v.refRes2Desc = :refRes2Desc"),
    @NamedQuery(name = "OldVideo.findByRefRes3Desc", query = "SELECT v FROM OldVideo v WHERE v.refRes3Desc = :refRes3Desc"),
    @NamedQuery(name = "OldVideo.findByRefRes4Desc", query = "SELECT v FROM OldVideo v WHERE v.refRes4Desc = :refRes4Desc"),
    @NamedQuery(name = "OldVideo.findByRefRes5Desc", query = "SELECT v FROM OldVideo v WHERE v.refRes5Desc = :refRes5Desc"),
    @NamedQuery(name = "OldVideo.findByRefRes6", query = "SELECT v FROM OldVideo v WHERE v.refRes6 = :refRes6"),
    @NamedQuery(name = "OldVideo.findByRefRes7", query = "SELECT v FROM OldVideo v WHERE v.refRes7 = :refRes7"),
    @NamedQuery(name = "OldVideo.findByRefRes8", query = "SELECT v FROM OldVideo v WHERE v.refRes8 = :refRes8"),
    @NamedQuery(name = "OldVideo.findByRefRes9", query = "SELECT v FROM OldVideo v WHERE v.refRes9 = :refRes9"),
    @NamedQuery(name = "OldVideo.findByRefRes10", query = "SELECT v FROM OldVideo v WHERE v.refRes10 = :refRes10"),
    @NamedQuery(name = "OldVideo.findByRefRes6Desc", query = "SELECT v FROM OldVideo v WHERE v.refRes6Desc = :refRes6Desc"),
    @NamedQuery(name = "OldVideo.findByRefRes7Desc", query = "SELECT v FROM OldVideo v WHERE v.refRes7Desc = :refRes7Desc"),
    @NamedQuery(name = "OldVideo.findByRefRes8Desc", query = "SELECT v FROM OldVideo v WHERE v.refRes8Desc = :refRes8Desc"),
    @NamedQuery(name = "OldVideo.findByRefRes9Desc", query = "SELECT v FROM OldVideo v WHERE v.refRes9Desc = :refRes9Desc"),
    @NamedQuery(name = "OldVideo.findByRefRes10Desc", query = "SELECT v FROM OldVideo v WHERE v.refRes10Desc = :refRes10Desc"),
    @NamedQuery(name = "OldVideo.findByPubdate", query = "SELECT v FROM OldVideo v WHERE v.pubdate = :pubdate"),
    @NamedQuery(name = "OldVideo.findByAutopublishtime", query = "SELECT v FROM OldVideo v WHERE v.autopublishtime = :autopublishtime"),
    @NamedQuery(name = "OldVideo.findByPublishstatus", query = "SELECT v FROM OldVideo v WHERE v.publishstatus = :publishstatus"),
//    @NamedQuery(name = "OldVideo.findBySnum", query = "SELECT v FROM OldVideo v WHERE v.snum = :snum")
})
public class OldVideo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "WIDTH")
    private String width;
    @Basic(optional = false)
    @Column(name = "HEIGTH")
    private String heigth;
    @Basic(optional = false)
    @Column(name = "FILE")
    private String file;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private int status;
    @Basic(optional = false)
    @Column(name = "LENGTH")
    private String length;
    @Basic(optional = false)
    @Column(name = "SIZE")
    private String size;
    @Basic(optional = false)
    @Column(name = "CREATETIME")
    private long createtime;
    @Basic(optional = false)
    @Column(name = "UPDATETIME")
    private long updatetime;
    @Basic(optional = false)
    @Column(name = "SHOOTTIME")
    private String shoottime;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "TAG")
    private String tag;
    @Basic(optional = false)
    @Column(name = "sort")
    private int sort;
    @Basic(optional = false)
    @Column(name = "LEVEL")
    private String level;
    @Basic(optional = false)
    @Column(name = "REF_RES1")
    private String refRes1;
    @Basic(optional = false)
    @Column(name = "REF_RES2")
    private String refRes2;
    @Basic(optional = false)
    @Column(name = "REF_RES3")
    private String refRes3;
    @Basic(optional = false)
    @Column(name = "REF_RES4")
    private String refRes4;
    @Basic(optional = false)
    @Column(name = "REF_RES5")
    private String refRes5;
    @Basic(optional = false)
    @Column(name = "DESCS")
    private String descs;
    @Basic(optional = false)
    @Column(name = "REF_RES1_DESC")
    private String refRes1Desc;
    @Basic(optional = false)
    @Column(name = "REF_RES2_DESC")
    private String refRes2Desc;
    @Basic(optional = false)
    @Column(name = "REF_RES3_DESC")
    private String refRes3Desc;
    @Basic(optional = false)
    @Column(name = "REF_RES4_DESC")
    private String refRes4Desc;
    @Basic(optional = false)
    @Column(name = "REF_RES5_DESC")
    private String refRes5Desc;
    @Basic(optional = false)
    @Column(name = "REF_RES6")
    private String refRes6;
    @Basic(optional = false)
    @Column(name = "REF_RES7")
    private String refRes7;
    @Basic(optional = false)
    @Column(name = "REF_RES8")
    private String refRes8;
    @Basic(optional = false)
    @Column(name = "REF_RES9")
    private String refRes9;
    @Basic(optional = false)
    @Column(name = "REF_RES10")
    private String refRes10;
    @Basic(optional = false)
    @Column(name = "REF_RES6_DESC")
    private String refRes6Desc;
    @Basic(optional = false)
    @Column(name = "REF_RES7_DESC")
    private String refRes7Desc;
    @Basic(optional = false)
    @Column(name = "REF_RES8_DESC")
    private String refRes8Desc;
    @Basic(optional = false)
    @Column(name = "REF_RES9_DESC")
    private String refRes9Desc;
    @Basic(optional = false)
    @Column(name = "REF_RES10_DESC")
    private String refRes10Desc;
    @Basic(optional = false)
    @Column(name = "PUBDATE")
    private long pubdate;
    @Basic(optional = false)
    @Column(name = "autopublishtime")
    private long autopublishtime;
    @Basic(optional = false)
    @Column(name = "publishstatus")
    private int publishstatus;
//    @Basic(optional = false)
//    @Column(name = "snum")
//    private int snum;

    public OldVideo() {
    }

    public OldVideo(Integer id) {
        this.id = id;
    }

    public OldVideo(Integer id, String title, String width, String heigth, String file, int status, String length, String size, long createtime, long updatetime, String shoottime, String description, String tag, int sort, String level, String refRes1, String refRes2, String refRes3, String refRes4, String refRes5, String descs, String refRes1Desc, String refRes2Desc, String refRes3Desc, String refRes4Desc, String refRes5Desc, String refRes6, String refRes7, String refRes8, String refRes9, String refRes10, String refRes6Desc, String refRes7Desc, String refRes8Desc, String refRes9Desc, String refRes10Desc, long pubdate, long autopublishtime, int publishstatus, int snum) {
        this.id = id;
        this.title = title;
        this.width = width;
        this.heigth = heigth;
        this.file = file;
        this.status = status;
        this.length = length;
        this.size = size;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.shoottime = shoottime;
        this.description = description;
        this.tag = tag;
        this.sort = sort;
        this.level = level;
        this.refRes1 = refRes1;
        this.refRes2 = refRes2;
        this.refRes3 = refRes3;
        this.refRes4 = refRes4;
        this.refRes5 = refRes5;
        this.descs = descs;
        this.refRes1Desc = refRes1Desc;
        this.refRes2Desc = refRes2Desc;
        this.refRes3Desc = refRes3Desc;
        this.refRes4Desc = refRes4Desc;
        this.refRes5Desc = refRes5Desc;
        this.refRes6 = refRes6;
        this.refRes7 = refRes7;
        this.refRes8 = refRes8;
        this.refRes9 = refRes9;
        this.refRes10 = refRes10;
        this.refRes6Desc = refRes6Desc;
        this.refRes7Desc = refRes7Desc;
        this.refRes8Desc = refRes8Desc;
        this.refRes9Desc = refRes9Desc;
        this.refRes10Desc = refRes10Desc;
        this.pubdate = pubdate;
        this.autopublishtime = autopublishtime;
        this.publishstatus = publishstatus;
//        this.snum = snum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeigth() {
        return heigth;
    }

    public void setHeigth(String heigth) {
        this.heigth = heigth;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(long updatetime) {
        this.updatetime = updatetime;
    }

    public String getShoottime() {
        return shoottime;
    }

    public void setShoottime(String shoottime) {
        this.shoottime = shoottime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRefRes1() {
        return refRes1;
    }

    public void setRefRes1(String refRes1) {
        this.refRes1 = refRes1;
    }

    public String getRefRes2() {
        return refRes2;
    }

    public void setRefRes2(String refRes2) {
        this.refRes2 = refRes2;
    }

    public String getRefRes3() {
        return refRes3;
    }

    public void setRefRes3(String refRes3) {
        this.refRes3 = refRes3;
    }

    public String getRefRes4() {
        return refRes4;
    }

    public void setRefRes4(String refRes4) {
        this.refRes4 = refRes4;
    }

    public String getRefRes5() {
        return refRes5;
    }

    public void setRefRes5(String refRes5) {
        this.refRes5 = refRes5;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public String getRefRes1Desc() {
        return refRes1Desc;
    }

    public void setRefRes1Desc(String refRes1Desc) {
        this.refRes1Desc = refRes1Desc;
    }

    public String getRefRes2Desc() {
        return refRes2Desc;
    }

    public void setRefRes2Desc(String refRes2Desc) {
        this.refRes2Desc = refRes2Desc;
    }

    public String getRefRes3Desc() {
        return refRes3Desc;
    }

    public void setRefRes3Desc(String refRes3Desc) {
        this.refRes3Desc = refRes3Desc;
    }

    public String getRefRes4Desc() {
        return refRes4Desc;
    }

    public void setRefRes4Desc(String refRes4Desc) {
        this.refRes4Desc = refRes4Desc;
    }

    public String getRefRes5Desc() {
        return refRes5Desc;
    }

    public void setRefRes5Desc(String refRes5Desc) {
        this.refRes5Desc = refRes5Desc;
    }

    public String getRefRes6() {
        return refRes6;
    }

    public void setRefRes6(String refRes6) {
        this.refRes6 = refRes6;
    }

    public String getRefRes7() {
        return refRes7;
    }

    public void setRefRes7(String refRes7) {
        this.refRes7 = refRes7;
    }

    public String getRefRes8() {
        return refRes8;
    }

    public void setRefRes8(String refRes8) {
        this.refRes8 = refRes8;
    }

    public String getRefRes9() {
        return refRes9;
    }

    public void setRefRes9(String refRes9) {
        this.refRes9 = refRes9;
    }

    public String getRefRes10() {
        return refRes10;
    }

    public void setRefRes10(String refRes10) {
        this.refRes10 = refRes10;
    }

    public String getRefRes6Desc() {
        return refRes6Desc;
    }

    public void setRefRes6Desc(String refRes6Desc) {
        this.refRes6Desc = refRes6Desc;
    }

    public String getRefRes7Desc() {
        return refRes7Desc;
    }

    public void setRefRes7Desc(String refRes7Desc) {
        this.refRes7Desc = refRes7Desc;
    }

    public String getRefRes8Desc() {
        return refRes8Desc;
    }

    public void setRefRes8Desc(String refRes8Desc) {
        this.refRes8Desc = refRes8Desc;
    }

    public String getRefRes9Desc() {
        return refRes9Desc;
    }

    public void setRefRes9Desc(String refRes9Desc) {
        this.refRes9Desc = refRes9Desc;
    }

    public String getRefRes10Desc() {
        return refRes10Desc;
    }

    public void setRefRes10Desc(String refRes10Desc) {
        this.refRes10Desc = refRes10Desc;
    }

    public long getPubdate() {
        return pubdate;
    }

    public void setPubdate(long pubdate) {
        this.pubdate = pubdate;
    }

    public long getAutopublishtime() {
        return autopublishtime;
    }

    public void setAutopublishtime(long autopublishtime) {
        this.autopublishtime = autopublishtime;
    }

    public int getPublishstatus() {
        return publishstatus;
    }

    public void setPublishstatus(int publishstatus) {
        this.publishstatus = publishstatus;
    }

//    public int getSnum() {
//        return snum;
//    }
//
//    public void setSnum(int snum) {
//        this.snum = snum;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OldVideo)) {
            return false;
        }
        OldVideo other = (OldVideo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yidumen.datatransifer.olddata.dao.entity.Video[ id=" + id + " ]";
    }
    
}
