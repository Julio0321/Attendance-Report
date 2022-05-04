package pt.esgts.presencas;

import java.time.LocalDate;
import java.util.ArrayList;

import pt.esgts.brunojesus.attendancereport.PresenceReportFacade;
import pt.esgts.brunojesus.attendancereport.actions.Report;
import pt.esgts.brunojesus.attendancereport.model.Attendance;
import pt.esgts.brunojesus.attendancereport.model.ReportData;

public class Mail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final ReportData reportData = new ReportData();
		reportData.setDate(LocalDate.now())
		
		.setAcademicYear(2021)
		.setClassName("Engenharia de Software")
		.setCourseName("TPSI")
		.setAttendances(new ArrayList<Attendance>());
		
		final PresenceReportFacade prensenceFacade = new PresenceReportFacade();
				
				final Report report = prensenceFacade.compileReport(reportData);
	}

}
