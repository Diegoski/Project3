/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "STUDENT_COURSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentCourse.findAll", query = "SELECT s FROM StudentCourse s"),
    @NamedQuery(name = "StudentCourse.findByIdStudent", query = "SELECT s FROM StudentCourse s WHERE s.studentCoursePK.idStudent = :idStudent"),
    @NamedQuery(name = "StudentCourse.findByIdCourse", query = "SELECT s FROM StudentCourse s WHERE s.studentCoursePK.idCourse = :idCourse"),
    @NamedQuery(name = "StudentCourse.findByQualification", query = "SELECT s FROM StudentCourse s WHERE s.qualification = :qualification")})
public class StudentCourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentCoursePK studentCoursePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUALIFICATION")
    private Double qualification;
    @JoinColumn(name = "ID_COURSE", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "ID_STUDENT", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public StudentCourse() {
    }

    public StudentCourse(StudentCoursePK studentCoursePK) {
        this.studentCoursePK = studentCoursePK;
    }

    public StudentCourse(int idStudent, String idCourse) {
        this.studentCoursePK = new StudentCoursePK(idStudent, idCourse);
    }
    public StudentCourse(int idStudent, String idCourse, int qualification){
    this.studentCoursePK = new StudentCoursePK(idStudent, idCourse, qualification);
    }
    public StudentCoursePK getStudentCoursePK() {
        return studentCoursePK;
    }

    public void setStudentCoursePK(StudentCoursePK studentCoursePK) {
        this.studentCoursePK = studentCoursePK;
    }

    public Double getQualification() {
        return qualification;
    }

    public void setQualification(Double qualification) {
        this.qualification = qualification;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentCoursePK != null ? studentCoursePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentCourse)) {
            return false;
        }
        StudentCourse other = (StudentCourse) object;
        if ((this.studentCoursePK == null && other.studentCoursePK != null) || (this.studentCoursePK != null && !this.studentCoursePK.equals(other.studentCoursePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.entity.StudentCourse[ studentCoursePK=" + studentCoursePK + " ]";
    }
    
}
