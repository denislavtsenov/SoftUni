package bg.softuni.exercisexmlprocessingproductshop.utils;

import jakarta.validation.ConstraintViolation;
import org.springframework.stereotype.Component;

import java.util.Set;

public interface ValidationUtil {

    <E> boolean isValid(E entity);

    <E> Set<ConstraintViolation<E>> getViolations(E entity);


}
