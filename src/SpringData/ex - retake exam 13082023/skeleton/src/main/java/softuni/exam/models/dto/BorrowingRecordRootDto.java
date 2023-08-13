package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "borrowing_records")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordRootDto {

    @XmlElement(name = "borrowing_record")
    List<BorrowingRecordDto> records;

    public List<BorrowingRecordDto> getRecords() {
        return records;
    }

    public void setRecords(List<BorrowingRecordDto> records) {
        this.records = records;
    }


}
