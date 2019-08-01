package org.manager.syllabus.cseju.demosyllabusmanager.model.content.component;


import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "row")
public class TableRow implements Serializable {

    private Integer tableRowId;

    private List<String> cells;


    /**
     * Getters for xml mapping
     *
     */

    @XmlAttribute(name = "tableRowId")
    public Integer getTableRowId() {
        return tableRowId;
    }

    @XmlElementWrapper(name = "row")
    @XmlElement(name = "cell")
    public List<String> getCells() {
        return cells;
    }


}
