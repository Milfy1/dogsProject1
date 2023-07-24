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
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dogs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dogs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="breed" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fk_owner_id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="airTag" type="{http://soapclasses/gen}airTags"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dogs", propOrder = {
    "id",
    "name",
    "breed",
    "origin",
    "fkOwnerId",
    "airTag"
})
public class Dogs {

    protected long id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String breed;
    @XmlElement(required = true)
    protected String origin;
    @XmlElement(name = "fk_owner_id")
    protected long fkOwnerId;
    @XmlElement(required = true)
    protected AirTags airTag;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the breed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Sets the value of the breed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBreed(String value) {
        this.breed = value;
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    /**
     * Gets the value of the fkOwnerId property.
     * 
     */
    public long getFkOwnerId() {
        return fkOwnerId;
    }

    /**
     * Sets the value of the fkOwnerId property.
     * 
     */
    public void setFkOwnerId(long value) {
        this.fkOwnerId = value;
    }

    /**
     * Gets the value of the airTag property.
     * 
     * @return
     *     possible object is
     *     {@link AirTags }
     *     
     */
    public AirTags getAirTag() {
        return airTag;
    }

    /**
     * Sets the value of the airTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link AirTags }
     *     
     */
    public void setAirTag(AirTags value) {
        this.airTag = value;
    }

}
