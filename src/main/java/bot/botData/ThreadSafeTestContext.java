package bot.botData;

import org.openqa.selenium.WebElement;

import java.util.List;

public class ThreadSafeTestContext {

    private static final ThreadLocal<String> grade = new ThreadLocal<>();
    private static final ThreadLocal<String> section = new ThreadLocal<>();
    private static final ThreadLocal<String> schoolCode = new ThreadLocal<>();
    private static final ThreadLocal<String> botName = new ThreadLocal<>();
    private static final ThreadLocal<List<WebElement>> locator = new ThreadLocal<>();
    private static final ThreadLocal<Integer> numberOfStudentSubmittedForApproval = new ThreadLocal<>();
    private static final ThreadLocal<Integer> noOfStudentVerificationIsInProgress = new ThreadLocal<>();
    private static final ThreadLocal<Integer> noOfStudentApproved = new ThreadLocal<>();
    private static final ThreadLocal<Integer> noOfRejection = new ThreadLocal<>();
    private static final ThreadLocal<Integer> noOfStudentDisapproved = new ThreadLocal<>();
    private static final ThreadLocal<Integer> noOfStudentSubmitted = new ThreadLocal<>();
    private static final ThreadLocal<Integer> noOfSchools = new ThreadLocal<>();
    private static final ThreadLocal<Integer> noOfRequestRaised = new ThreadLocal<>();
    private static final ThreadLocal<Integer> noOfRequestNotRaised = new ThreadLocal<>();
    private static final ThreadLocal<Integer> pendingNoOfStudents = new ThreadLocal<>();
    private static final ThreadLocal<Integer> noOfClasses = new ThreadLocal<>();
    private static final ThreadLocal<Integer> requestApproved = new ThreadLocal<>();
    private static final ThreadLocal<Integer> numberOfStudentDetailsCheckedByApprover = new ThreadLocal<>();
    private static final ThreadLocal<Integer> totalNumberOfStudentInTheClass = new ThreadLocal<>();
    private static final ThreadLocal<Integer> noOfStudentNotSentForApprovalOrRejected = new ThreadLocal<>();
    private static final ThreadLocal<Integer> academicYear = new ThreadLocal<>();
    private static final ThreadLocal<Integer> noOfStudentInTheClass = new ThreadLocal<>();
    private static final ThreadLocal<String> singleStudentName = new ThreadLocal<>();
    private static final ThreadLocal<String> singleStudentId = new ThreadLocal<>();
    private static final ThreadLocal<List<String>> studentNameList = new ThreadLocal<>();
    private static final ThreadLocal<List<String>> studentIdList = new ThreadLocal<>();



    // ATTENDANCE

    private static final ThreadLocal<String> medium = new ThreadLocal<>();



    public static void setStringLocator(List<WebElement> value) {
        locator.set(value);
    }
    public static List<WebElement> getStringLocator() {
        return locator.get();
    }

    public static void setBotName(String value) {
        botName.set(value);
    }
    public static String getBotName() {
        return botName.get();
    }

    public static void setSchoolCode(String value) {
        schoolCode.set(value);
    }

    public static void setGrade(String value) {
        grade.set(value);
    }

    public static String getGrade() {
        return grade.get();
    }

    public static String getSchoolCode() {
        return schoolCode.get();
    }

    public static void setSection(String value) {
        section.set(value);
    }

    public static String getSection() {
        return section.get();
    }
    public static String getMedium() {
        return medium.get();
    }
    public static void setMedium(String value) {
        medium.set(value);
    }

    public static void setNumberOfStudentSubmittedForApproval() {

    }
    public static void clear() {
        grade.remove();
        section.remove();
        schoolCode.remove();
    }

    // Java
    public static void setNumberOfStudentSubmittedForApproval(Integer value) {
        numberOfStudentSubmittedForApproval.set(value);
    }
    public static Integer getNumberOfStudentSubmittedForApproval() {
        return numberOfStudentSubmittedForApproval.get();
    }

    public static void setNoOfStudentVerificationIsInProgress(Integer value) {
        noOfStudentVerificationIsInProgress.set(value);
    }
    public static Integer getNoOfStudentVerificationIsInProgress() {
        return noOfStudentVerificationIsInProgress.get();
    }

    public static void setNoOfStudentApproved(Integer value) {
        noOfStudentApproved.set(value);
    }
    public static Integer getNoOfStudentApproved() {
        return noOfStudentApproved.get();
    }

    public static void setNoOfRejection(Integer value) {
        noOfRejection.set(value);
    }
    public static Integer getNoOfRejection() {
        return noOfRejection.get();
    }

    public static void setNoOfStudentDisapproved(Integer value) {
        noOfStudentDisapproved.set(value);
    }
    public static Integer getNoOfStudentDisapproved() {
        return noOfStudentDisapproved.get();
    }

    public static void setNoOfStudentSubmitted(Integer value) {
        noOfStudentSubmitted.set(value);
    }
    public static Integer getNoOfStudentSubmitted() {
        return noOfStudentSubmitted.get();
    }

    public static void setNoOfSchools(Integer value) {
        noOfSchools.set(value);
    }
    public static Integer getNoOfSchools() {
        return noOfSchools.get();
    }

    public static void setNoOfRequestRaised(Integer value) {
        noOfRequestRaised.set(value);
    }
    public static Integer getNoOfRequestRaised() {
        return noOfRequestRaised.get();
    }

    public static void setNoOfRequestNotRaised(Integer value) {
        noOfRequestNotRaised.set(value);
    }
    public static Integer getNoOfRequestNotRaised() {
        return noOfRequestNotRaised.get();
    }

    public static void setPendingNoOfStudents(Integer value) {
        pendingNoOfStudents.set(value);
    }
    public static Integer getPendingNoOfStudents() {
        return pendingNoOfStudents.get();
    }

    public static void setNoOfClasses(Integer value) {
        noOfClasses.set(value);
    }
    public static Integer getNoOfClasses() {
        return noOfClasses.get();
    }

    public static void setRequestApproved(Integer value) {
        requestApproved.set(value);
    }
    public static Integer getRequestApproved() {
        return requestApproved.get();
    }

    public static void setNumberOfStudentDetailsCheckedByApprover(Integer value) {
        numberOfStudentDetailsCheckedByApprover.set(value);
    }
    public static Integer getNumberOfStudentDetailsCheckedByApprover() {
        return numberOfStudentDetailsCheckedByApprover.get();
    }

    public static void setTotalNumberOfStudentInTheClass(Integer value) {
        totalNumberOfStudentInTheClass.set(value);
    }
    public static Integer getTotalNumberOfStudentInTheClass() {
        return totalNumberOfStudentInTheClass.get();
    }

    public static void setNoOfStudentNotSentForApprovalOrRejected(Integer value) {
        noOfStudentNotSentForApprovalOrRejected.set(value);
    }
    public static Integer getNoOfStudentNotSentForApprovalOrRejected() {
        return noOfStudentNotSentForApprovalOrRejected.get();
    }

    public static void setAcademicYear(Integer value) {
        academicYear.set(value);
    }
    public static Integer getAcademicYear() {
        return academicYear.get();
    }

    public static void setNoOfStudentInTheClass(Integer value) {
        noOfStudentInTheClass.set(value);
    }
    public static Integer getNoOfStudentInTheClass() {
        return noOfStudentInTheClass.get();
    }

    public static void setSingleStudentName(String value) {
        singleStudentName.set(value);
    }
    public static String getSingleStudentName() {
        return singleStudentName.get();
    }

    public static void setSingleStudentId(String value) {
        singleStudentId.set(value);
    }
    public static String getSingleStudentId() {
        return singleStudentId.get();
    }

    public static void setStudentNameList(List<String> value) {
        studentNameList.set(value);
    }
    public static List<String> getStudentNameList() {
        return studentNameList.get();
    }

    public static void setStudentIdList(List<String> value) {
        studentIdList.set(value);
    }
    public static List<String> getStudentIdList() {
        return studentIdList.get();
    }


    public static void clearGrade() {
        grade.remove();
    }
    public static void clearSection() {
        section.remove();
    }
    public static void clearSchoolCode() {
        schoolCode.remove();
    }
    public static void clearLocator() {
        locator.remove();
    }
    public static void clearNumberOfStudentSubmittedForApproval() {
        numberOfStudentSubmittedForApproval.remove();
    }
    public static void clearNoOfStudentVerificationIsInProgress() {
        noOfStudentVerificationIsInProgress.remove();
    }
    public static void clearNoOfStudentApproved() {
        noOfStudentApproved.remove();
    }
    public static void clearNoOfRejection() {
        noOfRejection.remove();
    }
    public static void clearNoOfStudentDisapproved() {
        noOfStudentDisapproved.remove();
    }
    public static void clearNoOfStudentSubmitted() {
        noOfStudentSubmitted.remove();
    }
    public static void clearNoOfSchools() {
        noOfSchools.remove();
    }
    public static void clearNoOfRequestRaised() {
        noOfRequestRaised.remove();
    }
    public static void clearNoOfRequestNotRaised() {
        noOfRequestNotRaised.remove();
    }
    public static void clearPendingNoOfStudents() {
        pendingNoOfStudents.remove();
    }
    public static void clearNoOfClasses() {
        noOfClasses.remove();
    }
    public static void clearRequestApproved() {
        requestApproved.remove();
    }
    public static void clearNumberOfStudentDetailsCheckedByApprover() {
        numberOfStudentDetailsCheckedByApprover.remove();
    }
    public static void clearTotalNumberOfStudentInTheClass() {
        totalNumberOfStudentInTheClass.remove();
    }
    public static void clearNoOfStudentNotSentForApprovalOrRejected() {
        noOfStudentNotSentForApprovalOrRejected.remove();
    }
    public static void clearAcademicYear() {
        academicYear.remove();
    }
    public static void clearNoOfStudentInTheClass() {
        noOfStudentInTheClass.remove();
    }
    public static void clearSingleStudentName() {
        singleStudentName.remove();
    }
    public static void clearSingleStudentId() {
        singleStudentId.remove();
    }
    public static void clearStudentNameList() {
        studentNameList.remove();
    }
    public static void clearStudentIdList() {
        studentIdList.remove();
    }

}
