package bg.softuni.jsonprocessingcardealer.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "is_imported")
    private boolean isImporter;

    public Supplier() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }

}
