package mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    MessageSender messageSender;

    @InjectMocks
    EmployeeService employeeService;

    @Test
    void testCreateEmployee() {
        employeeService.createEmployee("John Doe");

        verify(messageSender).sendMessage(any());
    }

}
