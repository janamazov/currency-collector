package az.digitalumbrella.currencycollector.client.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ValuteDTO {

    @XmlAttribute(name = "Code")
     String code;

    @XmlElement(name = "Nominal")
     String nominal;

    @XmlElement(name = "Name")
     String name;

    @XmlElement(name = "Value")
     BigDecimal value;

}
