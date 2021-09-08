package patika.dev.schoolmanagementsystem.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import patika.dev.schoolmanagementsystem.dto.PermanentInstructorDto;
import patika.dev.schoolmanagementsystem.entity.PermanentInstructor;
import patika.dev.schoolmanagementsystem.service.PermanentInstructorService;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/permanent-instructor")
public class PermanentInstructorController {

    private final PermanentInstructorService instructorService;

    @PostMapping("/add")
    public ResponseEntity<PermanentInstructor> saveInstructor(@RequestBody PermanentInstructorDto instructorDto){
        Optional<PermanentInstructor> resultOptional = instructorService.saveInstructor(instructorDto);
        if (resultOptional.isPresent()){
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
