package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.LibraryMemberImportDto;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.lang.reflect.Member;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.models.entity.Constants.*;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService {

    private static String LIBRARY_MEMBERS_PATH = "src/main/resources/files/json/library-members.json";

    private LibraryMemberRepository libraryMemberRepository;
    private ModelMapper modelMapper;
    private Gson gson;
    private ValidationUtil validationUtil;

    public LibraryMemberServiceImpl(LibraryMemberRepository libraryMemberRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.libraryMemberRepository = libraryMemberRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return libraryMemberRepository.count() > 0;
    }

    @Override
    public String readLibraryMembersFileContent() throws IOException {
        return Files.readString(Path.of(LIBRARY_MEMBERS_PATH));
    }

    @Override
    public String importLibraryMembers() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        List<LibraryMemberImportDto> libraryMembers = Arrays.stream(this.gson.fromJson(readLibraryMembersFileContent(), LibraryMemberImportDto[].class))
                .collect(Collectors.toList());

        for (LibraryMemberImportDto member : libraryMembers) {
            stringBuilder.append(System.lineSeparator());

            if (this.libraryMemberRepository.findByPhoneNumber(member.getPhoneNumber()).isPresent()
                    || !this.validationUtil.isValid(member)) {

                stringBuilder.append(String.format(INVALID_FORMAT, MEMBER));
                continue;
            }

            this.libraryMemberRepository.save(this.modelMapper.map(member, LibraryMember.class));

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT_MEMBER,
                    member.getFirstName(),
                    member.getLastName()));
        }

        return stringBuilder.toString().trim();
    }
}
