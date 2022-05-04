package pt.esgts.presencas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import Repositorio.StudentRepositorio;
import model.Student;
import pt.esgts.brunojesus.attendancereport.PresenceReportFacade;
import pt.esgts.brunojesus.attendancereport.actions.Report;
import pt.esgts.brunojesus.attendancereport.model.Attendance;
import pt.esgts.brunojesus.attendancereport.model.ReportData;
import service.ConsoleService;
/**
 * Cria um report com uma lista de atendimento
 * 
 *
 *Pede o atendimento de cada aluno 
 */
public class Main {

	  public static void main(String[] args) {
	        final StudentRepositorio studentRepository = new StudentRepositorio();
	        final PresenceReportFacade presenceReportFacade = new PresenceReportFacade();
	        final ConsoleService consoleService = new ConsoleService();

	        final List<Student> studentList = studentRepository.findAll();

	        final ReportData reportData = new ReportData()
	                .setAcademicYear(2021)
	                .setClassName("Eng. de Software")
	                .setCourseName("TPSI")
	                .setDate(LocalDate.now())
	                .setAttendances(consoleService.createAttendanceList(studentList));

	        final Report report = presenceReportFacade.compileReport(reportData);
	        presenceReportFacade.viewReport(report);
	    }


	}
