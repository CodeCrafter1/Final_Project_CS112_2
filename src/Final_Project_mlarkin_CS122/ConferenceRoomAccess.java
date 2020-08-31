package Final_Project_mlarkin_CS122;

public class ConferenceRoomAccess extends BuildingAccess {

    String conferDept;
    boolean conferAccessgranted;

    ConferenceRoomAccess(String inRF_ID, String inName, String inDepartment, boolean inConferaccessGranted) {
        super(inRF_ID, inName, inDepartment);
        conferDept = inDepartment;
        this.conferAccessgranted = inConferaccessGranted;
    }

    public String getConferdept() {
        return this.conferDept;
    }

    public void setConferdept(String inConferdept) {
        this.conferDept = inConferdept;
    }

}
