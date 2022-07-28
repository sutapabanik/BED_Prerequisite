package su20402117.corejava.ratingstudent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import su20402117.corejava.ratingstudent.Assignment;

public class AssignmentService {
    
    private List<Assignment> sAssignments = new ArrayList<>();
    
    public void addAssignment(Assignment assignment){
        sAssignments.add(assignment);
    }

    public void removeAssignment(Assignment assignment){
        
    }

    public void updateAssignment(Assignment assignment){

    }

    public String[] getScores(List<Assignment> aList){

        float[] scores = new float[5];
        int testCount=0;
        int quizCount=0;
        int labCount=0;
        int projectCount=0;

        for(Assignment assignment : aList){
            if(assignment.getAssignmentCategory().startsWith("test")){
                scores[0]+=assignment.getPoints();
                testCount+=1;
            }
            if(assignment.getAssignmentCategory().startsWith("quiz")){
                scores[1]+=assignment.getPoints();
                quizCount+=1;
            }
            if(assignment.getAssignmentCategory().startsWith("lab")){
                scores[2]+=assignment.getPoints();
                labCount+=1;
            }
            if(assignment.getAssignmentCategory().startsWith("project")){
                scores[3]+=assignment.getPoints();
                projectCount+=1;
            }
        }

        scores[0] = (testCount!=0) ? (0.4f*(scores[0]/testCount)) : 0;
        scores[1] = (quizCount!=0) ? (0.2f*(scores[1]/quizCount)) : 0;
        scores[2] = (labCount!=0) ? (0.1f*(scores[2]/labCount)) : 0;
        scores[3] = (projectCount!=0) ? (0.3f*(scores[3]/projectCount)) : 0;
        scores[4]=scores[0]+scores[1]+scores[2]+scores[3];

        String[] sc = new String[5];
        for(int i=0; i<5; i++){
            sc[i] = (scores[i]==0) ? "NA" : Float.toString(scores[i]);
        }

        return sc;
    }

    public void displayRatingByStudentName(String studentName){

        List<Assignment> filteredList = sAssignments.stream().filter(a ->
        ((Assignment) a).getStudentName().equalsIgnoreCase(studentName)).collect(Collectors.toList());

        List<Assignment> elecScores = filteredList.stream().filter(a -> ((Assignment) a).getSubject().equalsIgnoreCase("Electro Fields")).collect(Collectors.toList());

        List<Assignment> compScores = filteredList.stream().filter(a -> ((Assignment) a).getSubject().equalsIgnoreCase("Computing Techniques")).collect(Collectors.toList());

        System.out.println("Student : "+ studentName);

        System.out.printf("%15s %15s %15s %15s %15s %15s\n", "Subject", "Test Score", "Quiz Score", "Lab Score", "Project Score", "Overall Rating (%)");
        System.out.println("----------------------------------------------------------------------------------------------------------");

        if(elecScores.size()!=0){
            String[] elecFieldsSubj = getScores(elecScores);
            System.out.printf("%15s %15s %15s %15s %15s %15s\n", "Electro Fields", elecFieldsSubj[0], elecFieldsSubj[1], elecFieldsSubj[2], elecFieldsSubj[3], elecFieldsSubj[4]);
        }
        
        if(compScores.size()!=0){
            String[] compTechSubj = getScores(compScores);
            System.out.printf("%15s %10s %15s %15s %15s %15s\n", "Computing Techniques", compTechSubj[0], compTechSubj[1], compTechSubj[2], compTechSubj[3], compTechSubj[4]);
        }
    }

    public void displayRatingBySubjectName(String subjectName){

        List<Assignment> filteredList = sAssignments.stream().filter(a ->
        ((Assignment) a).getSubject().equalsIgnoreCase(subjectName)).collect(Collectors.toList());

        Map<String, List<Assignment>> map = filteredList.stream().collect(Collectors.groupingBy(Assignment::getStudentName));
        Map<String, List<Assignment>> treeMap = new TreeMap<String, List<Assignment>>(map);

        System.out.println("Subject : "+ subjectName);

        System.out.printf("%15s %15s %15s %15s %15s %15s\n", "Student Name", "Test Score", "Quiz Score", "Lab Score", "Project Score", "Overall Rating (%)");
        System.out.println("----------------------------------------------------------------------------------------------------------");

        for(Map.Entry<String, List<Assignment>> entry : treeMap.entrySet()){
            String[] scores = getScores((List<Assignment>) entry.getValue());
            System.out.printf("%15s %15s %15s %15s %15s %15s\n", entry.getKey(), scores[0], scores[1], scores[2], scores[3], scores[4]);
        }
    }
}
