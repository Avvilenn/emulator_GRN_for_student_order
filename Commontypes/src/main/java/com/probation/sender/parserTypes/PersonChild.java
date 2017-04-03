package com.probation.sender.parserTypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;


@XmlAccessorType(XmlAccessType.FIELD)
public class PersonChild extends Person implements Serializable
{
    @XmlElement(name = "number", required = true)
    private String birthDocument;

    public String getBirthDocument() {
        return birthDocument;
    }

    public void setBirthDocument(String birthDocument) {
        this.birthDocument = birthDocument;
    }
}
