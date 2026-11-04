package registration;


public class Registration {
    private int id;
    private String fullName;
    private String email;
    private String studentGroup;
    private String eventTitle;

    public Registration(int id, String fullName, String email, String studentGroup, String eventTitle){
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.studentGroup = studentGroup;
        this.eventTitle = eventTitle;


    }

    public int getId(){
        return id;
    }
    public String getFullName(){
        return fullName;
    }
    public String getEmail(){
        return email;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public String getEventTitle() {
        return eventTitle;
    }
    public static boolean isValidFullName(String name){
        return name != null && name.trim().length() >= 3;
    }
    public static boolean isValidEmail(String email){
        if (email == null ) return false;
        int atIndex = email.indexOf('@');
        return atIndex>0 && atIndex<email.length()-1;
    }
    public static boolean isValidGroup(String group){
        return group != null && !group.trim().isEmpty();
    }
    public static boolean isValidEvent(int choice){
        return choice >=1 && choice<=3;
    }
    public static String getEventTitleByChoice(int choice){
        switch (choice){
            case 1:return "Web Design Workshop";
            case 2:return "JavaScript Quiz";
            case 3:return "IT Career Talk";
            default:return "Unknown";
        }
    }
    @Override
    public String toString(){
        return id + " | " + fullName + " | " + email + " | " + studentGroup + " | " + eventTitle;
    }
}
