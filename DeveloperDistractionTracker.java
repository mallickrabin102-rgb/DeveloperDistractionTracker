import java.util.Scanner;

class Session {
    private String name;
    private String time;
    private String date;

    Session(String name, String time, String date) {
        this.name = name;
        this.time = time;
        this.date = date;
    }

    void displaySession() {
        System.out.println("Session Name:- " + name);
        System.out.println("Session Time:- " + time);
        System.out.println("Session Date:- " + date);
    }
}

class CodingSession extends Session {
    CodingSession(String name, String time, String date) {
        super(name, time, date);
    }

    @Override
    void displaySession() {
        System.out.println("Coding Session!");
        super.displaySession();
    }
}

class DistractionSession extends Session {
    DistractionSession(String name, String time, String date) {
        super(name, time, date);
    }

    @Override
    void displaySession() {
        System.out.println("Distractions!");
        super.displaySession();
    }
}

public class DeveloperDistractionTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Session[] sessions = new Session[10];
        int count = 0;

        int choice;
        do {
            System.out.println("1.Add Coding Session!");
            System.out.println("2.Add Distractions!");
            System.out.println("3.View Daily Report!");
            System.out.println("4.Show Focus Score!");
            System.out.println("5.Exit");
            System.out.println("Enter A Choice:");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Coding Language:");
                    String name = sc.nextLine();
                    System.out.println("Enter Time:");
                    String time = sc.nextLine();
                    System.out.println("Enter Date:");
                    String date = sc.nextLine();
                    Session s = new CodingSession(name, time, date);

                    if (count < sessions.length) {
                        sessions[count] = s;
                        count++;
                        System.out.println("Session Added");
                    } else {
                        System.out.println("Session Full");

                    }
                    break;
                case 2:
                    System.out.println("Distraction name:");
                    String decName = sc.nextLine();
                    System.out.println("How much time in " + decName + " platform:");
                    String decTime = sc.nextLine();
                    System.out.println("Date");
                    String decDate = sc.nextLine();

                    if (count < sessions.length) {
                        Session d = new DistractionSession(decName, decTime, decDate);

                        sessions[count] = d;
                        count++;
                        System.out.println("Distraction Added");
                    } else {
                        System.out.println("Distraction Session Full!");
                    }
                    break;
                case 3:
                    if (count == 0) {
                        System.out.println("No Session Yet!");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println("===== Sessions " + (i + 1) + " =====");
                            sessions[i].displaySession();
                        }

                    }
                    break;
                case 4:
                    int codingCount = 0;
                    int distCount = 0;
                    for (int i = 0; i < count; i++) {
                        if (sessions[i] instanceof CodingSession) {
                            codingCount++;
                        } else if (sessions[i] instanceof DistractionSession) {
                            distCount++;
                        }

                    }
                    int total = codingCount + distCount;
                    if (total == 0) {
                        System.out.println("No Session Yet!");

                    } else {
                        double score = (double) codingCount / total * 100;
                        System.out.println("Focus Score: " + score + "%");

                        if (score >= 80) {
                            System.out.println("Excellent Focus Developer!");
                        } else if (score >= 50) {
                            System.out.println("Good but can improve focus.");
                        } else {
                            System.out.println(" Too many distractions! Reduce social media.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Stay Focus!");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        } while (choice != 5);
        sc.close();
    }
}
