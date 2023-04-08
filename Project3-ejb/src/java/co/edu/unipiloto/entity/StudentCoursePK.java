/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Diego
 */
@Embeddable
public class StudentCoursePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_STUDENT")
    private int idStudent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ID_COURSE")
    private String idCourse;
    @Basic(optional = true)
    @Column(name = "QUALIFICATION")
    private float qualification;
    public StudentCoursePK() {
    }

    public StudentCoursePK(int idStudent, String idCourse) {
        this.idStudent = idStudent;
        this.idCourse = idCourse;
    }

    public StudentCoursePK(int idStudent, String idCourse, int qualification) {
        this.idStudent = idStudent;
        this.idCourse = idCourse;
        this.qualification = qualification;
    }
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idStudent;
        hash += (idCourse != null ? idCourse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentCoursePK)) {
            return false;
        }
        StudentCoursePK other = (StudentCoursePK) object;
        if (this.idStudent != other.idStudent) {
            return false;
        }
        if ((this.idCourse == null && other.idCourse != null) || (this.idCourse != null && !this.idCourse.equals(other.idCourse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.entity.StudentCoursePK[ idStudent=" + idStudent + ", idCourse=" + idCourse + " ]";
    }
    
}
