package service;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import pt.esgts.brunojesus.attendancereport.model.Attendance;
import model.Student;

public class ConsoleService {
/**
 * Cria o atendimento para a lista de alunos 
 */
    public List<Attendance> createAttendanceList(List<Student> studentList) {

      return studentList.stream()
              .map(student -> new Attendance()
                      .setNumber(student.getId())
                      .setName(student.getName())
                      .setPresent(askPresence(student.getName()))
              ).collect(Collectors.toList());
  }

  private static boolean askPresence(String name) {
      final Scanner scanner = new Scanner(System.in);

      System.out.print(name + ": ");
      String value = scanner.nextLine();

      return value.equals("y");
  }
}
