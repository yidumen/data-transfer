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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByRegemailcode", query = "SELECT u FROM User u WHERE u.regemailcode = :regemailcode"),
    @NamedQuery(name = "User.findByResetpwcode", query = "SELECT u FROM User u WHERE u.resetpwcode = :resetpwcode"),
    @NamedQuery(name = "User.findByRegmobilecode", query = "SELECT u FROM User u WHERE u.regmobilecode = :regmobilecode"),
    @NamedQuery(name = "User.findByStatus", query = "SELECT u FROM User u WHERE u.status = :status"),
    @NamedQuery(name = "User.findByNickname", query = "SELECT u FROM User u WHERE u.nickname = :nickname"),
    @NamedQuery(name = "User.findByBuddhismname", query = "SELECT u FROM User u WHERE u.buddhismname = :buddhismname"),
    @NamedQuery(name = "User.findByRealname", query = "SELECT u FROM User u WHERE u.realname = :realname"),
    @NamedQuery(name = "User.findByLastlogintime", query = "SELECT u FROM User u WHERE u.lastlogintime = :lastlogintime"),
    @NamedQuery(name = "User.findByBday", query = "SELECT u FROM User u WHERE u.bday = :bday"),
    @NamedQuery(name = "User.findByHomecity", query = "SELECT u FROM User u WHERE u.homecity = :homecity"),
    @NamedQuery(name = "User.findBySinaweibo", query = "SELECT u FROM User u WHERE u.sinaweibo = :sinaweibo"),
    @NamedQuery(name = "User.findByTencentweibo", query = "SELECT u FROM User u WHERE u.tencentweibo = :tencentweibo"),
    @NamedQuery(name = "User.findByQzone", query = "SELECT u FROM User u WHERE u.qzone = :qzone"),
    @NamedQuery(name = "User.findByHeadpic", query = "SELECT u FROM User u WHERE u.headpic = :headpic"),
    @NamedQuery(name = "User.findBySex", query = "SELECT u FROM User u WHERE u.sex = :sex"),
    @NamedQuery(name = "User.findByTempemail", query = "SELECT u FROM User u WHERE u.tempemail = :tempemail"),
    @NamedQuery(name = "User.findByTempphone", query = "SELECT u FROM User u WHERE u.tempphone = :tempphone"),
    @NamedQuery(name = "User.findByMobilestatus", query = "SELECT u FROM User u WHERE u.mobilestatus = :mobilestatus"),
    @NamedQuery(name = "User.findByEmailstatus", query = "SELECT u FROM User u WHERE u.emailstatus = :emailstatus"),
    @NamedQuery(name = "User.findBySinaweibotoken", query = "SELECT u FROM User u WHERE u.sinaweibotoken = :sinaweibotoken"),
    @NamedQuery(name = "User.findByTencentweibotoken", query = "SELECT u FROM User u WHERE u.tencentweibotoken = :tencentweibotoken"),
    @NamedQuery(name = "User.findByQqzonetoken", query = "SELECT u FROM User u WHERE u.qqzonetoken = :qqzonetoken"),
    @NamedQuery(name = "User.findByCreatedate", query = "SELECT u FROM User u WHERE u.createdate = :createdate")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "PHONE")
    private String phone;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "regemailcode")
    private String regemailcode;
    @Basic(optional = false)
    @Column(name = "resetpwcode")
    private String resetpwcode;
    @Basic(optional = false)
    @Column(name = "regmobilecode")
    private String regmobilecode;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private int status;
    @Basic(optional = false)
    @Column(name = "nickname")
    private String nickname;
    @Basic(optional = false)
    @Column(name = "buddhismname")
    private String buddhismname;
    @Basic(optional = false)
    @Column(name = "realname")
    private String realname;
    @Basic(optional = false)
    @Column(name = "lastlogintime")
    private long lastlogintime;
    @Basic(optional = false)
    @Column(name = "bday")
    private long bday;
    @Basic(optional = false)
    @Column(name = "homecity")
    private String homecity;
    @Basic(optional = false)
    @Column(name = "sinaweibo")
    private String sinaweibo;
    @Basic(optional = false)
    @Column(name = "tencentweibo")
    private String tencentweibo;
    @Basic(optional = false)
    @Column(name = "qzone")
    private String qzone;
    @Basic(optional = false)
    @Column(name = "headpic")
    private String headpic;
    @Basic(optional = false)
    @Column(name = "sex")
    private int sex;
    @Basic(optional = false)
    @Column(name = "tempemail")
    private String tempemail;
    @Basic(optional = false)
    @Column(name = "tempphone")
    private String tempphone;
    @Basic(optional = false)
    @Column(name = "mobilestatus")
    private int mobilestatus;
    @Basic(optional = false)
    @Column(name = "emailstatus")
    private int emailstatus;
    @Basic(optional = false)
    @Column(name = "sinaweibotoken")
    private String sinaweibotoken;
    @Basic(optional = false)
    @Column(name = "tencentweibotoken")
    private String tencentweibotoken;
    @Basic(optional = false)
    @Column(name = "qqzonetoken")
    private String qqzonetoken;
    @Basic(optional = false)
    @Column(name = "CREATEDATE")
    private long createdate;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String email, String phone, String password, String regemailcode, String resetpwcode, String regmobilecode, int status, String nickname, String buddhismname, String realname, long lastlogintime, long bday, String homecity, String sinaweibo, String tencentweibo, String qzone, String headpic, int sex, String tempemail, String tempphone, int mobilestatus, int emailstatus, String sinaweibotoken, String tencentweibotoken, String qqzonetoken, long createdate) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.regemailcode = regemailcode;
        this.resetpwcode = resetpwcode;
        this.regmobilecode = regmobilecode;
        this.status = status;
        this.nickname = nickname;
        this.buddhismname = buddhismname;
        this.realname = realname;
        this.lastlogintime = lastlogintime;
        this.bday = bday;
        this.homecity = homecity;
        this.sinaweibo = sinaweibo;
        this.tencentweibo = tencentweibo;
        this.qzone = qzone;
        this.headpic = headpic;
        this.sex = sex;
        this.tempemail = tempemail;
        this.tempphone = tempphone;
        this.mobilestatus = mobilestatus;
        this.emailstatus = emailstatus;
        this.sinaweibotoken = sinaweibotoken;
        this.tencentweibotoken = tencentweibotoken;
        this.qqzonetoken = qqzonetoken;
        this.createdate = createdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegemailcode() {
        return regemailcode;
    }

    public void setRegemailcode(String regemailcode) {
        this.regemailcode = regemailcode;
    }

    public String getResetpwcode() {
        return resetpwcode;
    }

    public void setResetpwcode(String resetpwcode) {
        this.resetpwcode = resetpwcode;
    }

    public String getRegmobilecode() {
        return regmobilecode;
    }

    public void setRegmobilecode(String regmobilecode) {
        this.regmobilecode = regmobilecode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBuddhismname() {
        return buddhismname;
    }

    public void setBuddhismname(String buddhismname) {
        this.buddhismname = buddhismname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public long getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(long lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public long getBday() {
        return bday;
    }

    public void setBday(long bday) {
        this.bday = bday;
    }

    public String getHomecity() {
        return homecity;
    }

    public void setHomecity(String homecity) {
        this.homecity = homecity;
    }

    public String getSinaweibo() {
        return sinaweibo;
    }

    public void setSinaweibo(String sinaweibo) {
        this.sinaweibo = sinaweibo;
    }

    public String getTencentweibo() {
        return tencentweibo;
    }

    public void setTencentweibo(String tencentweibo) {
        this.tencentweibo = tencentweibo;
    }

    public String getQzone() {
        return qzone;
    }

    public void setQzone(String qzone) {
        this.qzone = qzone;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getTempemail() {
        return tempemail;
    }

    public void setTempemail(String tempemail) {
        this.tempemail = tempemail;
    }

    public String getTempphone() {
        return tempphone;
    }

    public void setTempphone(String tempphone) {
        this.tempphone = tempphone;
    }

    public int getMobilestatus() {
        return mobilestatus;
    }

    public void setMobilestatus(int mobilestatus) {
        this.mobilestatus = mobilestatus;
    }

    public int getEmailstatus() {
        return emailstatus;
    }

    public void setEmailstatus(int emailstatus) {
        this.emailstatus = emailstatus;
    }

    public String getSinaweibotoken() {
        return sinaweibotoken;
    }

    public void setSinaweibotoken(String sinaweibotoken) {
        this.sinaweibotoken = sinaweibotoken;
    }

    public String getTencentweibotoken() {
        return tencentweibotoken;
    }

    public void setTencentweibotoken(String tencentweibotoken) {
        this.tencentweibotoken = tencentweibotoken;
    }

    public String getQqzonetoken() {
        return qqzonetoken;
    }

    public void setQqzonetoken(String qqzonetoken) {
        this.qqzonetoken = qqzonetoken;
    }

    public long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(long createdate) {
        this.createdate = createdate;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yidumen.datatransifer.olddata.dao.entity.User[ id=" + id + " ]";
    }
    
}
