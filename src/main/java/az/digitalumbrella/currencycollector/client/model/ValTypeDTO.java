package az.digitalumbrella.currencycollector.client.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ValTypeDTO {

    @XmlElement(name = "Valute")
    List<ValuteDTO> valutes;

    @XmlAttribute(name = "Type")
    String type;

}
