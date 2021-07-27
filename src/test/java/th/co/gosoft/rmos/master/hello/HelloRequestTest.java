package th.co.gosoft.rmos.master.hello;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HelloRequestTest {
    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    public static void close() {
        validatorFactory.close();
    }

    @Test
    public void nameNotNullAge19ShouldBeViolationsIsEmpty() {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setName("tanabut");
        helloRequest.setAge(19);

        Set<ConstraintViolation<HelloRequest>> violations = validator.validate(helloRequest);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void nameNullAge19ShouldBeViolationsSize1() {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setAge(19);

        Set<ConstraintViolation<HelloRequest>> violations = validator.validate(helloRequest);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        for (ConstraintViolation<HelloRequest> constraintViolation:violations) {
            assertTrue(constraintViolation.getMessage().contains("null"));
        }
    }

    @Test
    public void nameNotNullAge18ShouldBeViolationsIsEmpty() {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setName("tanabut");
        helloRequest.setAge(18);

        Set<ConstraintViolation<HelloRequest>> violations = validator.validate(helloRequest);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void nameNotNullAge99ShouldBeViolationsIsEmpty() {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setName("tanabut");
        helloRequest.setAge(99);

        Set<ConstraintViolation<HelloRequest>> violations = validator.validate(helloRequest);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void nameNotNullAge100ShouldBeViolationsIsEmpty() {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setName("tanabut");
        helloRequest.setAge(100);

        Set<ConstraintViolation<HelloRequest>> violations = validator.validate(helloRequest);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void nameNotNullAge17ShouldBeViolationsSize1() {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setName("tanabut");
        helloRequest.setAge(17);

        Set<ConstraintViolation<HelloRequest>> violations = validator.validate(helloRequest);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        for (ConstraintViolation<HelloRequest> constraintViolation:violations) {
            assertTrue(constraintViolation.getMessage().contains("greater than or equal to 18"));
        }
    }

    @Test
    public void nameNotNullAge101ShouldBeViolationsSize1() {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setName("tanabut");
        helloRequest.setAge(101);

        Set<ConstraintViolation<HelloRequest>> violations = validator.validate(helloRequest);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        for (ConstraintViolation<HelloRequest> constraintViolation:violations) {
            assertTrue(constraintViolation.getMessage().contains("less than or equal to 100"));
        }
    }

    @Test
    public void nameNullAge101ShouldBeViolationsSize2() {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setAge(101);

        Set<ConstraintViolation<HelloRequest>> violations = validator.validate(helloRequest);
        assertFalse(violations.isEmpty());
        assertEquals(2, violations.size());
    }
}