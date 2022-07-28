package su20402117.corejava.ratingstudent;

import su20402117.corejava.ratingstudent.service.AssignmentService;

public class App 
{

    public static void main( String[] args )
    {
        AssignmentService aService = new AssignmentService();

        Assignment[] assignments = new Assignment[20];
        assignments[0] = new Assignment("Ananth","Electro Fields", "test_1","21-Jul-16",100);
        assignments[1] = new Assignment("Bhagath","Electro Fields","test_1","21-Jul-16",78);
        assignments[2] = new Assignment("Chaya","Electro Fields","test_1","21-Jul-16",68);
        assignments[3] = new Assignment("Esharath","Electro Fields","test_1","21-Jul-16",87);
        assignments[4] = new Assignment("Bhagath","Electro Fields","quiz_1","22-Jul-16",20);
        assignments[5] = new Assignment("Chaya","Electro Fields","lab_1","23-Jul-16",10);
        assignments[6] = new Assignment("Ananth","Electro Fields","project_1","24-Jul-16",100);
        assignments[7] = new Assignment("Davanth","Electro Fields","project_1","24-Jul-16",100);
        assignments[8] = new Assignment("Bhagath","Electro Fields","quiz_2","25-Jul-16",50);
        assignments[9] = new Assignment("Ananth","Electro Fields","quiz_1","26-Jul-16",100);
        assignments[10] = new Assignment("Bhagath","Electro Fields","lab_1","27-Jul-16",10);
        assignments[11] = new Assignment("Chaya","Electro Fields","project_1","28-Jul-16",100);
        assignments[12] = new Assignment("Bhagath","Electro Fields","project_1","28-Jul-16",100);
        assignments[13] = new Assignment("Ananth","Computing Techniques","test_1","29-Jul-16",86);
        assignments[14] = new Assignment("Ananth","Electro Fields","quiz_2","29-Jul-16",100);
        assignments[15] = new Assignment("Bhagath","Computing Techniques","project_1","30-Jul-16",100);
        assignments[16] = new Assignment("Ananth","Electro Fields","lab_1","30-Jul-16",100);
        assignments[17] = new Assignment("Chaya","Computing Techniques","quiz_1","31-Jul-16",20);
        assignments[18] = new Assignment("Ananth","Electro Fields","test_2","1-Aug-16",100);
        assignments[19] = new Assignment("Chaya","Electro Fields","test_2","1-Aug-16",92);

        for(int i=0; i<20; i++){
            aService.addAssignment(assignments[i]);
        }


        aService.displayRatingByStudentName("Ananth");
        System.out.println();
        aService.displayRatingBySubjectName("Electro Fields");
    }
}
