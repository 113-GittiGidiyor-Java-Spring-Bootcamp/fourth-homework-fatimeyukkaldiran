package patika.dev.schoolmanagementsystem.service;

import javassist.tools.web.BadHttpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import patika.dev.schoolmanagementsystem.dto.PermanentInstructorDto;
import patika.dev.schoolmanagementsystem.entity.PermanentInstructor;
import patika.dev.schoolmanagementsystem.exceptions.BadRequestException;
import patika.dev.schoolmanagementsystem.mappers.PermanentInstructorMapper;
import patika.dev.schoolmanagementsystem.repository.PermanentInstructorRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermanentInstructorService {

    private final PermanentInstructorRepository instructorRepository;
    private final PermanentInstructorMapper instructorMapper;

    public Optional<PermanentInstructor> saveInstructor(PermanentInstructorDto instructorDto){

       boolean isExists = instructorRepository.selectExistPhoneNumber(instructorDto.getPhoneNumber());
        if (isExists) {
            throw new BadRequestException("Permanent Instructor with phone umber:" + instructorDto.getPhoneNumber() + "is already exists!");
        }


        PermanentInstructor instructor = instructorMapper.mapFromPermanentDtoToPermanentInstructor(instructorDto);
        return Optional.of(instructorRepository.save(instructor));
    }

}
