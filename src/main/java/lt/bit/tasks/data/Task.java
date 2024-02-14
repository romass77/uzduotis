/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lt.bit.tasks.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo-L480
 */
@Entity
@Table(name = "tasks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
    @NamedQuery(name = "Task.findByIdtasks", query = "SELECT t FROM Task t WHERE t.idtasks = :idtasks"),
    @NamedQuery(name = "Task.findByTask", query = "SELECT t FROM Task t WHERE t.task = :task"),
    @NamedQuery(name = "Task.findByDescription", query = "SELECT t FROM Task t WHERE t.description = :description"),
    @NamedQuery(name = "Task.findByStartdate", query = "SELECT t FROM Task t WHERE t.startdate = :startdate"),
    @NamedQuery(name = "Task.findByEnddate", query = "SELECT t FROM Task t WHERE t.enddate = :enddate")})
public class Task implements Serializable {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtasks")
    private Integer idtasks;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "task")
    private String task;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @JoinColumn(name = "userid", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User userid;

    public Task() {
    }

    
    public Task(Integer idtasks) {
        this.idtasks = idtasks;
    }

    public Task(Integer idtasks, String task) {
        this.idtasks = idtasks;
        this.task = task;
    }

    public Integer getIdtasks() {
        return idtasks;
    }

    public void setIdtasks(Integer idtasks) {
        this.idtasks = idtasks;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtasks != null ? idtasks.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.idtasks == null && other.idtasks != null) || (this.idtasks != null && !this.idtasks.equals(other.idtasks))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.bit.tasks.data.Task[ idtasks=" + idtasks + " ]";
    }
    
}
