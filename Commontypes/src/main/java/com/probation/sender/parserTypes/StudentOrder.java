package com.probation.sender.parserTypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
public class StudentOrder implements Serializable
{
    @XmlElement(name = "husband", required = true)
    private PersonAdult husband;
    @XmlElement(name = "wife", required = true)
    private PersonAdult wife;
    @XmlElementWrapper(name="children")
    @XmlElement(name = "child")
    private List<PersonChild> children;

    public boolean isGrnAnswer() {
        return grnAnswer;
    }

    public void setGrnAnswer(boolean grnAnswer) {
        this.grnAnswer = grnAnswer;
    }

    @XmlElement (name = "grnAnswer")
    private boolean grnAnswer;


    public StudentOrder() {
    }

    public StudentOrder(PersonAdult husband, PersonAdult wife, List<PersonChild> children) {
        this.husband = husband;
        this.wife = wife;
        this.children = children;
    }

    public PersonAdult getHusband() {
        return husband;
    }

    public PersonAdult getWife() {
        return wife;
    }

    public void setHusband(PersonAdult husband) {
        this.husband = husband;
    }

    public void setWife(PersonAdult wife) {
        this.wife = wife;
    }

    public List<PersonChild> getChildren() {
        return children;
    }

    public void setChildren(List<PersonChild> children) {
        this.children = children;
    }
}
