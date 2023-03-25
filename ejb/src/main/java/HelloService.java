import jakarta.ejb.Stateless;

@Stateless
public class HelloService {
    public String sayHello() {
        return "Hello";
    }
}
