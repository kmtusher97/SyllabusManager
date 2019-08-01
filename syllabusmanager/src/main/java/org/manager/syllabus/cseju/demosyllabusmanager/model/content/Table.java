package org.manager.syllabus.cseju.demosyllabusmanager.model.content;

import lombok.*;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.component.TableRow;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "table")
@XmlType(propOrder = {"title", "fields", "rows"})
public class Table implements Serializable {

    private Integer tableId;

    private String title;

    private List<String> fields;

    private List<TableRow> rows;

    public Table(String title, List<String> fields) {
        this.title = title;
        this.fields = fields;
        this.rows = new ArrayList<>();
    }


    /**
     * Getters for xml mapping
     */

    @XmlAttribute(name = "tableId")
    public Integer getTableId() {
        return tableId;
    }

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

    public void addRow(int rowId) {
        if(this.rows == null) {
            this.rows = new ArrayList<>();
        }
        TableRow tableRow = new TableRow();
        tableRow.setTableRowId(rowId);
        for(int i = 0; i < this.fields.size(); i++) {
            tableRow.addCell();
        }
        this.rows.add(tableRow);
    }
}
