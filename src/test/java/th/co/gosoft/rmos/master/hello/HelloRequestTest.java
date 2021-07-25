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
    public void notNameShouldBeNotNullName() {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setAge(25);

        Set<ConstraintViolation<HelloRequest>> violations = validator.validate(helloRequest);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    public void notNameMinScopeAgeShouldBeNullNameAndMinAge() {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setAge(17);

        Set<ConstraintViolation<HelloRequest>> violations = validator.validate(helloRequest);
        assertFalse(violations.isEmpty());
        assertEquals(2, violations.size());
    }

    @Test
    public void notNameMaxScopeAgeShouldBeNullNameAndMaxAge() {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setAge(101);

        Set<ConstraintViolation<HelloRequest>> violations = validator.validate(helloRequest);
        assertFalse(violations.isEmpty());
        assertEquals(2, violations.size());
    }

    @Test
    public void trueRequestShouldBeViolationsIsEmpty() {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setName("tanabut");
        helloRequest.setAge(18);

        Set<ConstraintViolation<HelloRequest>> violations = validator.validate(helloRequest);
        assertTrue(violations.isEmpty());
    }
}