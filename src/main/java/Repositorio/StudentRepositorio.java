package Repositorio;

import model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentRepositorio {
	/**
	 * Permite acesso a data dos alunos, que e localizada no student cvs 
	 */
    private final List<Student> studentList;

    public StudentRepositorio() {
        studentList = loadStudentsFile()
                .stream()
                .map(s -> s.split(","))
                .map(s -> new Student(Long.parseLong(s[0]), s[1]))
                .toList();
    }
    
    /**
     * Devolve a listados alunos
     */

    public List<Student> findAll() {
        return new ArrayList<>(studentList);
        //return Collections.unmodifiableList(studentList);
    }

    /**
     * 
     */
    private List<String> loadStudentsFile() {
        List<String> result = null;

        try (InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("students.csv")) {

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream)
            );

            result = reader
                    .lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Failed to close file");
        }

        return result;
    }
}
