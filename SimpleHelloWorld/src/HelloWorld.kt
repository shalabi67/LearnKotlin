import com.learn.Person
import com.learn.Student

/**
 * Created by mohammad on 10/30/2017.
 */
fun main(args : Array<String>) {
    println("Hello world");

    var mohammad = Person();
    mohammad.name = "mohammad";

    println("Persone name is ${mohammad.name}");

    var sami = Student("sami");
    println("The student name is ${sami.name}");

    sami.display();

}