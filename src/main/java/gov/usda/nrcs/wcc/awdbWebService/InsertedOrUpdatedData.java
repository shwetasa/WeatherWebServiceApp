
package gov.usda.nrcs.wcc.awdbWebService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for insertedOrUpdatedData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="insertedOrUpdatedData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="beginDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataContentList" type="{http://www.wcc.nrcs.usda.gov/ns/awdbWebService}insertedOrUpdatedDataContent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="duration" type="{http://www.wcc.nrcs.usda.gov/ns/awdbWebService}duration" minOccurs="0"/>
 *         &lt;element name="elementCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stationTriplet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timezoneOffset" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="unitCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertedOrUpdatedData", propOrder = {
    "beginDate",
    "dataContentList",
    "duration",
    "elementCd",
    "endDate",
    "stationTriplet",
    "timezoneOffset",
    "unitCd"
})
public class InsertedOrUpdatedData {

    protected String beginDate;
    @XmlElement(nillable = true)
    protected List<InsertedOrUpdatedDataContent> dataContentList;
    @XmlSchemaType(name = "string")
    protected Duration duration;
    protected String elementCd;
    protected String endDate;
    protected String stationTriplet;
    protected int timezoneOffset;
    protected String unitCd;

    /**
     * Gets the value of the beginDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginDate() {
        return beginDate;
    }

    /**
     * Sets the value of the beginDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginDate(String value) {
        this.beginDate = value;
    }

    /**
     * Gets the value of the dataContentList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataContentList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataContentList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InsertedOrUpdatedDataContent }
     * 
     * 
     */
    public List<InsertedOrUpdatedDataContent> getDataContentList() {
        if (dataContentList == null) {
            dataContentList = new ArrayList<InsertedOrUpdatedDataContent>();
        }
        return this.dataContentList;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDuration(Duration value) {
        this.duration = value;
    }

    /**
     * Gets the value of the elementCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElementCd() {
        return elementCd;
    }

    /**
     * Sets the value of the elementCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElementCd(String value) {
        this.elementCd = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the stationTriplet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStationTriplet() {
        return stationTriplet;
    }

    /**
     * Sets the value of the stationTriplet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStationTriplet(String value) {
        this.stationTriplet = value;
    }

    /**
     * Gets the value of the timezoneOffset property.
     * 
     */
    public int getTimezoneOffset() {
        return timezoneOffset;
    }

    /**
     * Sets the value of the timezoneOffset property.
     * 
     */
    public void setTimezoneOffset(int value) {
        this.timezoneOffset = value;
    }

    /**
     * Gets the value of the unitCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitCd() {
        return unitCd;
    }

    /**
     * Sets the value of the unitCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitCd(String value) {
        this.unitCd = value;
    }

}
