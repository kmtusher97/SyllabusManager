package org.manager.syllabus.cseju.demosyllabusmanager.model.content.component;


import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "row")
public class TableRow {

    private List<String> cells;

    /**
     * Getters for xml mapping
     *
     */
    @XmlElementWrapper(name = "row")
    @XmlElement(name = "cell")
    public List<String> getCells() {
        return cells;
    }

    public String toXML() {
        String cellsXML = "";
        for(String cell : this.cells) {
            cellsXML += ("<cell>" + cell + "</cell>");
        }

        return "<row>" + cellsXML + "</row>";
    }
}
