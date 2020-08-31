package Final_Project_mlarkin_CS122;

public class LabAccess extends BuildingAccess {

    String labDept;
    boolean labAccessgranted;

    LabAccess(String inRF_ID, String inName, String inDepartment, boolean inLabaccessGranted) {
        super(inRF_ID, inName, inDepartment);
        labDept = inDepartment;
        this.labAccessgranted = inLabaccessGranted;
    }

    public String getLabdept() {
        return this.labDept;
    }

    public void setLabdept(String inLabdept) {
        this.labDept = inLabdept;
    }

}
