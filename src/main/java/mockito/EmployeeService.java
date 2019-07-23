package mockito;

public class EmployeeService {

    private MessageSender messageSender;

    public EmployeeService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void createEmployee(String name) {
        var employee = new Employee(name);
        messageSender.sendMessage(employee);
    }
}
