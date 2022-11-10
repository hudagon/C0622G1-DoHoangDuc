package com.demo123.demo.controller;

import com.demo123.demo.dto.StudentDto;
import com.demo123.demo.model.Classroom;
import com.demo123.demo.model.Student;
import com.demo123.demo.service.IClassroomService;
import com.demo123.demo.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IClassroomService classroomService;

    @Autowired
    private IStudentService studentService;

    @GetMapping("/list")
    public String showStudent (Model model) {

        List<Student> studentList = (List<Student>) studentService.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();

        for (Student x : studentList) {
            StudentDto studentDto = new StudentDto();

            BeanUtils.copyProperties(x, studentDto);

            studentDto.setStudentName(x.getName());
            studentDto.setClassName(x.getClassroom().getName());

            studentDtoList.add(studentDto);
        }


        model.addAttribute("studentList", studentDtoList);

        return "/list";
    }

    @GetMapping("/create")
    public String showForm(Model model) {

        model.addAttribute("newStudent", new StudentDto());

        return "/create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute StudentDto newStudent,
                                RedirectAttributes redirectAttributes) {

        Optional<Classroom> classroomATBC = classroomService.findById(Integer.valueOf(newStudent.getClassName()));

        Classroom classroomOk = new Classroom();

        if (classroomATBC.isPresent()) {
            classroomOk = classroomATBC.get();
        }

        Student studentATBC = new Student();

        BeanUtils.copyProperties(newStudent, studentATBC);

        studentATBC.setName(newStudent.getStudentName());
        studentATBC.setClassroom(classroomOk);

        studentService.save(studentATBC);

        redirectAttributes.addFlashAttribute("mess", "New student added successfully!");

        return "redirect:/student/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {

        Optional<Student> studentATBE = studentService.findById(Integer.valueOf(id));
        StudentDto studentDtoATBE = new StudentDto();

        BeanUtils.copyProperties(studentATBE, studentDtoATBE);

        studentDtoATBE.setStudentName(studentATBE.get().getName());
        studentDtoATBE.setClassName(studentATBE.get().getClassroom().getName());
        studentDtoATBE.setId(studentATBE.get().getId());

        model.addAttribute("studentEdited", studentDtoATBE);

        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute StudentDto studentEdited,
                       RedirectAttributes redirectAttributes) {

        Optional<Classroom> classroomATBE = classroomService.findById(Integer.valueOf(studentEdited.getClassName()));

        Student studentATBE = new Student();

        BeanUtils.copyProperties(studentEdited, studentATBE);

        studentATBE.setClassroom(classroomATBE.get());
        studentATBE.setName(studentEdited.getStudentName());

        studentService.save(studentATBE);

        redirectAttributes.addFlashAttribute("mess", "Student edited successfully!");

        return "redirect:/student/list";
    }
 }
