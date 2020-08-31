/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_Project_mlarkin_CS122;

import java.util.Scanner;
/*
The access class will have the main member variables RF ID, name and department.  With gettâ€™er & settâ€™ers.
The sub-classes Labaccess & Conferaccess will ensure that the RF ID badge only allows access to the right
department by matching the departments.  If the RF ID does not match the right department access will be denied.
Read from input file.
List all employees   1: 1234 Mark Eng  2. next entry
Access Lab
1. Enter your employee list numberâ€¦.1
2. What lab? press 1 for Eng or 2. for Accounting)...
3. If dept of employee matches dept of lab â€œaccess grantedâ€ otherwise not.
Access Conference room
1. Enter your RF ID number
2. What Conference ? press 1 for Eng or 2. for Accounting)...
3. If dept of employee matches dept of Conference access granted otherwise not
Exit
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BuildingAccess {

    protected String RF_ID;
    protected String name;
    protected String department;
    private boolean lab;
    private boolean conf;
    private ArrayList<BuildingAccess> employee;
    private ArrayList<LabAccess> labacc;
    private ArrayList<ConferenceRoomAccess> confacc;

    public BuildingAccess() {
        this.RF_ID = "";
        this.name = "";
        this.department = "";
        this.lab = false;
        this.conf = false;
        employee = new ArrayList<BuildingAccess>();
        labacc = new ArrayList<LabAccess>();
        confacc = new ArrayList<ConferenceRoomAccess>();
        ReadFileData();
    }

    public BuildingAccess(String inRF_ID, String inName, String inDepartment) {
        this.RF_ID = inRF_ID;
        this.name = inName;
        this.department = inDepartment;
        this.lab = false;
        this.conf = false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int lineNum = 0;
        int lineNump = 0;
        int lineNumpp = 0;
        BuildingAccess b = new BuildingAccess();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean printIt = false;
        while (true) {
            choice = 0;
            printIt = false;
            //Menu
            System.out.println("Main Menu");
            System.out.println("[1]: List all employees to the console.");
            System.out.println("[2]: Enter your employee information.");
            System.out.println("[3]: Press 3 to enter a lab. You must first complete menu item 2.");
            System.out.println("[4]: Press 4 to enter a conference room. You must first complete menu item 2.");
            System.out.println("[5]: Exit.");

            System.out.println("Please enter your integer choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Please enter an integer!");
                System.exit(0);
            }
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                if (s.length() == 0) {
                    break;
                }
            }

            switch (choice) {
                case 1:

                    break;

                case 2:
                    System.out.println(" Please Enter your RF ID number");
                    if (scanner.hasNextLine()) {
                        b.RF_ID = scanner.nextLine();
                    }
                    System.out.println(" Please Enter your username -- First letter of first name and last name: John Doe == JDoe.");
                    if (scanner.hasNextLine()) {
                        b.name = scanner.nextLine();
                    }
                    System.out.println("Please enter the name of your department -- accounting or engineering only.");
                    if (scanner.hasNextLine()) {
                        b.department = scanner.nextLine();
                    }
                    BuildingAccess temp = new BuildingAccess(b.RF_ID, b.name, b.department);
                    //employee[lineNum] = temp;
                    lineNum++;
                    break;

                case 3:
                    if (b.RF_ID.equals("")) {
                        System.out.println("Please enter 2 and your personal information first.");
                        System.exit(0);
                    }
                    System.out.println("What lab? press 1 for Eng or 2. for Accounting)...'");
                    if (scanner.hasNextInt()) {
                        //b.lab = scanner.nextInt();
                    } else {
                        System.out.println("Please enter an integer!");
                        System.exit(0);
                    }
                    while (scanner.hasNextLine()) {
                        String s = scanner.nextLine();
                        if (s.length() == 0) {
                            break;
                        }
                    }
                    //if (b.conf != 1) {
                    System.out.println(b.name + " is denied access.");
                    //} else {
                    System.out.println(b.name + " is allowed access.");
                    //}
                    break;

                case 4:
                    if (b.RF_ID.equals("")) {
                        System.out.println("Please enter 2 and your personal information first.");
                        System.exit(0);
                    }
                    System.out.println("What conference room? press 1 for Eng or 2. for Accounting)...'");
                    if (scanner.hasNextInt()) {
                        //b.conf = scanner.nextInt();
                    } else {
                        System.out.println("Please enter an integer!");
                        System.exit(0);
                    }
                    while (scanner.hasNextLine()) {
                        String s = scanner.nextLine();
                        if (s.length() == 0) {
                            break;
                        }
                    }
                    //if (b.conf != 2) {
                    System.out.println(b.name + " is denied access.");
                    //} else {
                    System.out.println(b.name + " is allowed access.");
                    // }
                    break;

                case 5:
                    System.out.println("Bye!");
                    break;

                default:
                    System.out.println("Please enter an integer between 1 and 5 inclusive!");
                    System.exit(0);
                    break;

            }
            if (choice == 5) {
                break;
            }
        }

    }//end main

    public String getRF_ID() {
        return this.RF_ID;
    }

    public void setRF_ID(String inRF_ID) {
        this.RF_ID = inRF_ID;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String inDepartment) {
        this.department = inDepartment;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String inName) {
        this.name = inName;
    }

    public void ReadFileData() {
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader("RF_ID.txt"));
            String wholeLine = "";

            while (true) {
                wholeLine = inputStream.readLine();
                if (wholeLine == null) {
                    break;
                }
                if (wholeLine.length() == 0) {
                    break;
                }
                String[] splitLine = wholeLine.split("\\s+");

                BuildingAccess temp = new BuildingAccess(splitLine[0], splitLine[1], splitLine[2]);
                if (splitLine[2].equals("engineering")) {
                    temp.setLab(true);
                } else {
                    temp.setConf(true);
                }
                employee.add(temp);
                if (splitLine[2].equals("engineering")) {
                    LabAccess tempp = new LabAccess(splitLine[0], splitLine[1], splitLine[2], true);
                    labacc.add(tempp);
                    ConferenceRoomAccess temppp = new ConferenceRoomAccess(splitLine[0], splitLine[1], splitLine[2], false);
                    confacc.add(temppp);
                } else {
                    LabAccess tempp = new LabAccess(splitLine[0], splitLine[1], splitLine[2], false);
                    labacc.add(tempp);
                    ConferenceRoomAccess temppp = new ConferenceRoomAccess(splitLine[0], splitLine[1], splitLine[2], true);
                    confacc.add(temppp);
                }

            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("RF_ID.txt was not found");
        } catch (IOException e) {
            System.out.println("Error reading from RF_ID.txt");
        }
    }

    public String PrintIt() {
        String s = "";

        int i = 0;
        s += "All employess listed currently:\n";
        while (i < employee.size()) {
            s += employee.get(i).RF_ID + " " + employee.get(i).name + " " + employee.get(i).department + "\n";
            i++;
        }
        s += "\n";

        s += "\n";
        i = 0;
        s += "Listed Employees allowed Eng lab access:\n";
        while (i < labacc.size()) {
            if (labacc.get(i).labDept.equals("engineering")) {
                s += labacc.get(i).RF_ID + " " + labacc.get(i).name + " " + labacc.get(i).department + "\n";
                i++;
            }
            i++;
        }
        s += "\n";
        i = 0;
        s += "Listed Employees allowed accnting lab access:\n";
        while (i < labacc.size()) {
            if (labacc.get(i).labDept.equals("accounting")) {
                s += labacc.get(i).RF_ID + " " + labacc.get(i).name + " " + labacc.get(i).department + "\n";
                i++;
            }
            i++;
        }
        s += "\n";
        i = 0;
        s += "Listed Employees allowed Eng conference room access:\n";
        while (i < confacc.size()) {
            if (confacc.get(i).conferDept.equals("engineering")) {
                s += confacc.get(i).RF_ID + " " + confacc.get(i).name + " " + confacc.get(i).department + "\n";
                i++;
            }
            i++;
        }
        s += "\n";
        i = 0;
        s += "Listed Employees allowed accounting conference room access:\n";
        while (i < confacc.size()) {
            if (confacc.get(i).conferDept.equals("accounting")) {
                s += confacc.get(i).RF_ID + " " + confacc.get(i).name + " " + confacc.get(i).department + "\n";
                i++;
            }
            i++;
        }
        s += "\n";
        return s;
    }

    public int checkAccess(String rf_id, String nameFirst, String dept) {
        System.out.println("id=" + rf_id + " name= " + nameFirst + " dept= " + dept);
        BuildingAccess tempBld = new BuildingAccess(rf_id, nameFirst, dept);
        int result = 0;
        if (tempBld.department.equals("engineering")) {
            tempBld.setLab(true);
            result = 1;
        } else {
            tempBld.setConf(true);
            result = 2;
        }
        employee.add(tempBld);

        if (tempBld.department.equals("engineering")) {
            LabAccess tempp = new LabAccess(rf_id, nameFirst, dept, true);
            labacc.add(tempp);
            ConferenceRoomAccess temppp = new ConferenceRoomAccess(rf_id, nameFirst, dept, false);
            confacc.add(temppp);
        } else {
            LabAccess tempp = new LabAccess(rf_id, nameFirst, dept, false);
            labacc.add(tempp);
            ConferenceRoomAccess temppp = new ConferenceRoomAccess(rf_id, nameFirst, dept, true);
            confacc.add(temppp);
        }
        return result;
    }

    /**
     * @return the employee
     */
    public ArrayList<BuildingAccess> getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(ArrayList<BuildingAccess> employee) {
        this.employee = employee;
    }

    /**
     * @return the labacc
     */
    public ArrayList<LabAccess> getLabacc() {
        return labacc;
    }

    /**
     * @param labacc the labacc to set
     */
    public void setLabacc(ArrayList<LabAccess> labacc) {
        this.labacc = labacc;
    }

    /**
     * @return the confacc
     */
    public ArrayList<ConferenceRoomAccess> getConfacc() {
        return confacc;
    }

    /**
     * @param confacc the confacc to set
     */
    public void setConfacc(ArrayList<ConferenceRoomAccess> confacc) {
        this.confacc = confacc;
    }

    /**
     * @return the lab
     */
    public boolean isLab() {
        return lab;
    }

    /**
     * @param lab the lab to set
     */
    public void setLab(boolean lab) {
        this.lab = lab;
    }

    /**
     * @return the conf
     */
    public boolean isConf() {
        return conf;
    }

    /**
     * @param conf the conf to set
     */
    public void setConf(boolean conf) {
        this.conf = conf;
    }
}//end class
