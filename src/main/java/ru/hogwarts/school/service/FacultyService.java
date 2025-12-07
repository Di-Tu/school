package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> faculties = new HashMap<>();
    private long lastId = 0L;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++lastId);
        return faculties.put(faculty.getId(), faculty);
    }

    public Faculty findFacultyById(Long id) {
        if (faculties.containsKey(id)) {
            return faculties.get(id);
        }
        return null;
    }

    public Collection<Faculty> findAllFaculties() {
        return faculties.values();
    }

    public Collection<Faculty> findFacultyByColor(String color) {
        return faculties.values().stream()
                .filter(student -> student.getColor().equals(color))
                .collect(Collectors.toList());
    }

    public Faculty updateFaculty(Faculty faculty) {
        if (faculties.containsKey(faculty.getId())) {
            return faculties.put(faculty.getId(), faculty);
        }
        return null;
    }

    public Faculty deleteFaculty(Long id) {
        if (faculties.containsKey(id)) {
            return faculties.remove(id);
        }
        return null;
    }

}
