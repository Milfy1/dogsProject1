//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.07.23 at 07:18:56 AM AST 
//


package com.udacity.bootstrap.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dog" type="{http://soapclasses/gen}dogs"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dog"
})
@XmlRootElement(name = "addDogResponse")
public class AddDogResponse {

    @XmlElement(required = true)
    protected Dogs dog;

    /**
     * Gets the value of the dog property.
     * 
     * @return
     *     possible object is
     *     {@link Dogs }
     *     
     */
    public Dogs getDog() {
        return dog;
    }

    /**
     * Sets the value of the dog property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dogs }
     *     
     */
    public void setDog(Dogs value) {
        this.dog = value;
    }

}