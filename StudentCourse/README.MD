# Student Course App
Bu uygulamada iki sınıf olacaktır. Student ve Course. Student sınıfı, bir öğrencinin adını, soyadını, numarasını ve bölümünü içerecektir. Course sınıfı, bir dersin adını, kodunu, kredisini ve bölümünü içerecektir. Bu iki sınıf arasında bir "many to many" ilişkisi olacaktır. Yani, her öğrenci birden fazla derse kayıt olabilir ve her ders birden fazla öğrenciye ait olabilir.

 ## Entity Sınıfları
Uygulamamızda, öğreci(Student) ve ders(course) verilerini temsil etmek için iki adet entity sınıf kullanılmaktadır.

## Student Sınıfı
Student sınıfı, aşağıdaki değişkenleri içerecektir:
* `id` : Öğrencinin benzersiz bir id'si **Long** türünde.
* `name` : Öğrencinin adı, **String** türünde.
* `surname` : Öğrencinin soyadı, **String** türünde.
* `studentNumber` : Öğrencinin öğrenci numarası, **int** türünde.
* `department` : Öğrencinin bölümü, **String** türünde.
* `courses` : Dersi alan öğrencilerin listesi, **List** türünde.

Ayrıca, bu sınıf **@Entity** ve **@Table** anatasyonları ile işaretlenmiştir.Bu, sınıfın bir Hibernate entity sınıfı olduğunu ve "students" adlı bir veritabanı tablosuyla ilişkilendirildiğini belirtir.

* **@Entity** : Sınıfımızın bir Hibernate entity sınıfı olduğunu belirtir.
* **@Table** : Veri tabanındaki tablo adını belirtir.
* **@Id** : Birincil anahtar alanını belirtir.
* **@GeneratedValue** : Birincil anahtarın otomatik olarak artan bir değere sahip olduğunu belirtir.
* **@Column** : Alanın adını ve diğer özelliklerini belirtir.
* **@ManyToMany** ve **@JoinTable**: Öğrenci sınıfının, ders sınıfı ile "many to many" ilişkisini belirtir. Bu, ilişkiyi yöneten tablonun adını ve ilişki alanlarını belirtir.

## Course Sınıfı
 Course sınıfı, aşağıdaki değişkenleri içerecektir:
* `id` : Dersin benzersiz id'si **Long** türünde.
* `name` : Dersin adı, **String** türünde.
* `code` : Dersin kodu, **String** türünde.
* `credit` : Dersin kredisi, **int** türünde.
* `department` : Dersin bölümü, **String** türünde.
* `students` : Dersi alan öğrencilerin listesi, **List** türünde.

Bu sınıf **@Entity** ve **@Table** anotasyonları ile işaretlenmiştir. Bu, sınıfın bir Hibernate entity sınıfı olduğunu ve "courses" adlı bir veritabanı tablosuyla ilişkilendirildiğini belirtir.
* **@Entity**  ve **@Table** : Aynı şekilde sonofon ve tablonun adını belirtir.
* **@Id** , **@GeneratedValue** ve **@Column** : Birincil anahtar ve diğer alanlar için aynı işlevi görür
* **@ManyToMany** ve **@JoinTable** : Ders sınıfının, öğrenci sınıfı ile "many to many " ilişkisini belirtir. **@JoinTable** ile bağlantı tablosunun adı ve bağlantılar belirtilir.

# İlişki
Student ve Course sınıfları arasındaki "many to many " ilişkisi , bir öğrencinin birden fazla derse kayıt olabileceği ve bir dersin birden fazla öğrenciye ait olabileceği anlamına gelmektedir.Bu ilişkiyi modellemek için, her iki sınıfta da bir "courses" listesi oluşturacağız.

## StudentService Sınıfı
StudentService sınıfında,""courses" listesi bir ArrayList türünde olacaktır.Bu liste, öğrencinin kayıt olduğu tüm dersleri içerecektir.
* **addStudent(Student student)** : Öğrenciye yeni bir ders eklemek için.
* **removeStudent(Student student)** :Öğrencinin bir dersini kaldırmak için.
* **getAllStudents()** :Öğrencinin kayıtlı olduğu tüm dersleri döndürür.
* **getStudentByNumber(int studentNumber)** : Verilen öğrenci numarasına sahip bir öğrenciyi bulmak için kullanılır.Bu metod, öğrenci numarasını parametre olarak alır ve ilgili öğrenciyi döndürür. Eğer belirtilen öğrenci numarasına ait bir öğrenci bulunmazsa **null** değeri döndürür.

## CourseService Sınıfı
CourseService sınıfında, "students" listesi bir HashSet türünde olacaktır. Bu liste, dersin kayıtlı olduğu tüm öğrenciler içerecektir.

* **addCourse(String name, String code, int credit,String department)** : Derse yeni bir öğrenci eklemek için kullanılacak.
* **removeCourse(String code)** : Dersten bir öğreniciyi kaldırmak için kullanılacak.
* **getAllCourses()** : Dersin kayıtlı olduğu tüm öğrencileri döndürür.
* **getCourseByCode(String code)** : Verilen ders koduna sahip bir dersi bulmak için kullanılır. Bu metod , ders kodunu parametre olarak alır ve ilgili dersi döndürür. Eğer belirtlilen ders koduna sahip bir ders bulunamazsa, null değeri döndürülür.

## Menü Sınıfı
1. Ders ekle
2. Ders sil
3. Dersleri listele
4. Öğrenci ekle
5. Öğrenci sil
6. Öğrencileri listele
7. Çıkış