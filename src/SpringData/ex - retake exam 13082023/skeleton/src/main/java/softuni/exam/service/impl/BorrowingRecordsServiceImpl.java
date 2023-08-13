package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BorrowingRecordDto;
import softuni.exam.models.dto.BorrowingRecordRootDto;
import softuni.exam.models.entity.Book;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.BookRepository;
import softuni.exam.repository.BorrowingRecordRepository;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static softuni.exam.models.entity.Constants.*;

@Service
public class BorrowingRecordsServiceImpl implements BorrowingRecordsService {

    private static String BORROWING_RECORDS_PATH = "src/main/resources/files/xml/borrowing-records.xml";

    private BorrowingRecordRepository borrowingRecordRepository;
    private XmlParser xmlParser;
    private ValidationUtil validationUtil;
    private ModelMapper modelMapper;

    private BookRepository bookRepository;
    private LibraryMemberRepository libraryMemberRepository;

    public BorrowingRecordsServiceImpl(BorrowingRecordRepository borrowingRecordRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper, BookRepository bookRepository, LibraryMemberRepository libraryMemberRepository) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
        this.libraryMemberRepository = libraryMemberRepository;
    }

    @Override
    public boolean areImported() {
        return borrowingRecordRepository.count() > 0;
    }

    @Override
    public String readBorrowingRecordsFromFile() throws IOException {
        return Files.readString(Path.of(BORROWING_RECORDS_PATH));
    }

    @Override
    public String importBorrowingRecords() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        List<BorrowingRecordDto> records = this.xmlParser.fromFile(BORROWING_RECORDS_PATH, BorrowingRecordRootDto.class)
                .getRecords();

        for (BorrowingRecordDto record : records) {
            stringBuilder.append(System.lineSeparator());

            Optional<Book> book = this.bookRepository.findByTitle(record.getBook().getTitle());

            Optional<LibraryMember> member = this.libraryMemberRepository.findById(record.getMember().getId());


            if (book.isEmpty()
                    || member.isEmpty()
                    || !this.validationUtil.isValid(record)) {

                stringBuilder.append(String.format(INVALID_FORMAT, RECORD));
                continue;
            }

            BorrowingRecord recordToSave = this.modelMapper.map(record, BorrowingRecord.class);

            recordToSave.setBorrowDate(LocalDate.parse(record.getBorrowDate()));
            recordToSave.setReturnDate(LocalDate.parse(record.getReturnDate()));

            this.borrowingRecordRepository.save(recordToSave);

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT_RECORD,
                    record.getBook().getTitle(),
                    record.getBorrowDate()));

        }

        return stringBuilder.toString().trim();
    }

    @Override
    public String exportBorrowingRecords() {
        return null;
    }
}
