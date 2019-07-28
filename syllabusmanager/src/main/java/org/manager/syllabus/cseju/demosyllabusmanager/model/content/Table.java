package org.manager.syllabus.cseju.demosyllabusmanager.model.content;

import lombok.*;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.component.TableRow;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "table")
public class Table extends Content {

    private List<String> fields;

    private List<TableRow> rows;

    public Table(String title, List<String> fields) {
        super(title);
        this.fields = fields;
        this.rows = new ArrayList<>();
    }

    /**
     * Getters for xml mapping
     */
    @XmlElementWrapper(name = "fields")
    @XmlElement(name = "field")
    public List<String> getFields() {
        return fields;
    }

    @XmlElementWrapper(name = "rows")
    @XmlElement(name = "row")
    public List<TableRow> getRows() {
        return rows;
    }

    public void addNewField() {
        if (this.fields == null) {
            this.fields = new ArrayList<>();
        }
        this.fields.add("Field" + this.fields.size());
    }

    public void deleteFieldName(int fieldNo) {
        if (this.fields == null) {
            this.fields = new ArrayList<>();
        }
        if (fieldNo >= this.fields.size()) {
            return;
        }
        this.fields.remove(fieldNo);

    }

    public String toXML() {
        String fieldsXML = "";
        for(String field : this.fields) {
            fieldsXML += ("<field>" + field + "</field>");
        }

        String rowsXML = "";
        for(TableRow tableRow : this.rows) {
            rowsXML += tableRow.toXML();
        }

        return "<table>" +
                    "<title>" + this.title + "</title>" +
                    "<fields>" + fieldsXML + "</fields>" +
                    "<rows>" + rowsXML + "</rows>" +
                "</table>";
    }
}
