package mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    MessageSender messageSender;

    @InjectMocks
    EmployeeService employeeService;

    @Test
    void testCreateEmployee() {
        var messageSender = mock(MessageSender.class);
        var employeeService = new EmployeeService(messageSender);

        employeeService.createEmployee("John Doe");

        verify(messageSender).sendMessage(any());
    }

    @Test
    void testCreateEmployeeWithExtension() {
        employeeService.createEmployee("John Doe");

        verify(messageSender).sendMessage(any());
    }

    @Test
    void testSendMessageParameter() {
        ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);
        employeeService.createEmployee("John Doe");

        verify(messageSender).sendMessage(employeeArgumentCaptor.capture());
        assertEquals("John Doe", employeeArgumentCaptor.getValue().getName());
    }

}
