package az.digitalumbrella.currencycollector.client.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@Data
@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ValCursDTO {

    @XmlElement(name = "ValType")
     List<ValTypeDTO> valTypes;

    @XmlElement(name = "Date")
     LocalDate date;

    @XmlAttribute(name = "Name")
     String name;

    @XmlAttribute(name = "Description")
     String description;

}
