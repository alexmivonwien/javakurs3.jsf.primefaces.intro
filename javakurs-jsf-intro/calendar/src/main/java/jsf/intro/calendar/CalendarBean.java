package jsf.intro.calendar;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;

/**
 * A calendar bean that is used for both ajax and "normal" HTTP-Requests.
 * To programmatically check wheter a call is an ajax call, 
 * @see https://stackoverflow.com/questions/7428058/distinguish-ajax-requests-from-full-requests-in-jsf-custom-validator
 *  
 * @RequestScoped means that one instance of the class is used for each request
 * 
 * @author Alex-Mi
 *
 */
@ManagedBean
@RequestScoped // if no scope provided - defaults to @RequestScope 
public class CalendarBean {

	public enum MONTH {
		JAN, FEB, MAR, APR, MAY, JUNE, JULY, AUG, SEP, OCT, NOV, DEC
	};

	private List<String> monthValues = new ArrayList<>();

	private String selectedMonth;
	private int selectedMonthDays;

	public CalendarBean() {
		monthValues.add(MONTH.JAN.toString());
		monthValues.add(MONTH.FEB.toString());
		monthValues.add(MONTH.MAR.toString());
		monthValues.add(MONTH.APR.toString());
		monthValues.add(MONTH.MAY.toString());
		monthValues.add(MONTH.JUNE.toString());
		monthValues.add(MONTH.JULY.toString());
		monthValues.add(MONTH.AUG.toString());
		monthValues.add(MONTH.SEP.toString());
		monthValues.add(MONTH.OCT.toString());
		monthValues.add(MONTH.NOV.toString());
		monthValues.add(MONTH.DEC.toString());
	}

	public String getSelectedMonth() {
		return selectedMonth;
	}

	public void setSelectedMonth(String selectedMonth) {
		this.selectedMonth = selectedMonth;
		
		PartialViewContext pvc = FacesContext.getCurrentInstance().getPartialViewContext();
		if(pvc.isAjaxRequest()) { // this is an ajax Call, @see https://stackoverflow.com/questions/7428058/distinguish-ajax-requests-from-full-requests-in-jsf-custom-validator
			calculateMonthDays();
		} else {
			// ... do nothing
		}
		
	}

	public int getSelectedMonthDays() {
		return selectedMonthDays;
	}

	public void setSelectedMonthDays(int selectedMonthDays) {
		this.selectedMonthDays = selectedMonthDays;
	}

	public List<String> getMonthValues() {
		return monthValues;
	}

	public void setMonthValues(List<String> monthValues) {
		this.monthValues = monthValues;
	}

	private void calculateMonthDays() {

		MONTH monthSelected = MONTH.valueOf(selectedMonth);

		switch (monthSelected) {
		case JAN:
			selectedMonthDays = 31;
			break;
		case FEB:
			selectedMonthDays = 28;
			break;
		case MAR:
			selectedMonthDays = 31;
			break;
		case APR:
			selectedMonthDays = 30;
			break;
		case MAY:
			selectedMonthDays = 31;
			break;
		case JUNE:
			selectedMonthDays = 30;
			break;
		case JULY:
			selectedMonthDays = 31;
			break;
		case AUG:
			selectedMonthDays = 31;
			break;
		case SEP:
			selectedMonthDays = 30;
			break;
		case OCT:
			selectedMonthDays = 31;
			break;
		case NOV:
			selectedMonthDays = 30;
			break;
		case DEC:
			selectedMonthDays = 31;
			break;
		}

	}

	public String determineNextView() {
		calculateMonthDays();
		return null;
	}

}
