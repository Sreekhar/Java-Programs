class Medication {
    String nurseName;
    String nurseSection;
    String nurseDepartment;
    String nurseType;
    List<String> medicinesList;
    Queue<TimeSheet> timeSheet;

    Medication(Nurse nurse, List<String> list, Queue<TimeSheet> sheet) {
      	this.nurseName = nurse.Name;
        this.nurseSection = nurse.Section;
        this.nurseDepartment = nurse.Department;
        this.nurseType = nurse.type;
        this.medicinesList = list;
        this.timeSheet = sheet;
    }

      void prepareMedication() {
          //For a particular time
      }

}

class TimeSheet {
    Date time;
    Patient id;
    TimeSheet(Date time, Patient obj) {
        this.time = time;
        this.id = obj;
    }
}

class Patient {
    String name;
    String otherDetails;
    Patient(String name, String otherDetails) {
        this.name = name;
        this.otherDetails = otherDetails;
    }
}
