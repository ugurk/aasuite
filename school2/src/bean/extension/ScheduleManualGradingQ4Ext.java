/*
 * Schedule.java
 *
 * Created on Dec 2, 2007, 6:15:07 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.extension;

import java.io.Serializable;

import template.ActionButton;
import template.ActionButtons;
import template.ChildRecord;
import template.ChildRecords;
import template.Display;
import template.Displays;
import template.Reports;
import template.UITemplate;
import template.screen.ChildTemplateListOnly;
import template.screen.TemplateTabSinglePageLeftRightNoCriteria;
import util.GlobalBean;
import bean.reference.Course;
import bean.reference.Section;
import bean.reference.Subject;

/**
 *
 * @author Charliemagne Mark
 * Faculty Tool
 */
@UITemplate(select="SELECT a FROM Schedule a WHERE a.facultyId=${personId} ",template=TemplateTabSinglePageLeftRightNoCriteria.class,columnSearch={"subject","course","section"}, gridCount=6, title="Faculty Grading",canDelete=false,canNew=false)
@Displays({
        @Display(name="course", enabled=false, label="Grade Level", type="PopSearch", linktoBean=Course.class),
        @Display(name="section", enabled=false,label="Section", gridFieldWidth=3,width=-1, type="PopSearch", linktoBean=Section.class),
        @Display(name="subject", enabled=false, gridFieldWidth=5, width=-1, type="PopSearch", linktoBean=Subject.class)
})
@Reports({
   // @template.Report(reportFile="Schedule", reportTitle="Schedule Report", reportSql="")
})
@ChildRecords({
    @ChildRecord(entity = StudentSubjectManualGradingQ4Ext.class, template=ChildTemplateListOnly.class, title="Q4", sql = "SELECT a FROM StudentSubject a WHERE a.scheduleId=${seq} AND a.schoolYear='${useYear}'", fieldMapping = {"seq", "scheduleId"}),
    @ChildRecord(entity = StudentSubjectManualGradingExt.class, template=ChildTemplateListOnly.class, title="All Quarters", sql = "SELECT a FROM StudentSubject a WHERE a.scheduleId=${seq} AND a.schoolYear='${useYear}'", fieldMapping = {"seq", "scheduleId"})
})
@ActionButtons({
    @ActionButton(name="btnSaveGrade4", label="Save Grade")
})
public class ScheduleManualGradingQ4Ext extends ScheduleManualGradingExt {
    public static void main(String[] args) {
    	GlobalBean.getInstance().setPersonId(10967);
        view(ScheduleManualGradingQ4Ext.class);
    }
}