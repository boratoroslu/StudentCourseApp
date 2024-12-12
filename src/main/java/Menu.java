import java.util.Scanner;

public class Menu {
    CourseService courseService = new CourseService();
    StudentService studentService = new StudentService();


    Scanner input = new Scanner(System.in);

    public void displayMenu(){
            boolean exit = true;

            while(exit){
                System.out.println("İşlem Seçiniz");
                System.out.println("1. Ders Ekle");
                System.out.println("2. Ders Sil");
                System.out.println("3. Dersleri Listele");
                System.out.println("4. Öğrenci Ekle");
                System.out.println("5. Örenci Sil");
                System.out.println("6. Örenci Listele");
                System.out.println("0. Çıkış");

        int choice = input.nextInt();

        switch(choice){
            case 1:
                addCourse();
                break;
            case 2:
                removeCourse();
                break;
            case 3:
                listCourse();
                break;
            case 4:
                addStudent();
                break;
            case 5:
                removeStudent();
                break;
            case 6:
                listStudent();
                break;
            case 0:
                exit = false;
                break;
            default:
                System.out.println("Geçersiz İşlem Seçildi");
                break;
        }
        }
    }

    private void listStudent() {
    }

    private void removeStudent() {
    }

    private void addStudent() {
    }

    private void listCourse() {
    }

    private void removeCourse() {
        System.out.println("Silmek istediğiniz kursun ID'sini giriniz..");
        String code = input.next();
        courseService.getCourseByCode(code);

    }

    private void addCourse() {
        input.nextLine();
        System.out.println("Ders Adı:");
        String name = input.nextLine();
        System.out.println("Ders kodu:");
        String code = input.nextLine();
        System.out.println("Ders kredisi:");
        int credit = input.nextInt();
        input.nextLine();
        System.out.println("Ders bölümü:");
        String department = input.next();

        courseService.addCourse(name,code,credit,department);

    }
}
