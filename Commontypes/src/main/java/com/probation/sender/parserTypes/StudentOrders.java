package com.probation.sender.parserTypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by sbt-saburov-ag1 on 21.03.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "student-orders")
public class StudentOrders
{
    @XmlElement(name = "student-order", required = true)
    private List<StudentOrder> studentOrders;

    public List<StudentOrder> getStudentOrders() {
        return studentOrders;
    }

    public void setStudentOrders(List<StudentOrder> studentOrders) {
        this.studentOrders = studentOrders;
    }
}
