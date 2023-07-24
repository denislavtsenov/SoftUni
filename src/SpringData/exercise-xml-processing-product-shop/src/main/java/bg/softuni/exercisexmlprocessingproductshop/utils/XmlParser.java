package bg.softuni.exercisexmlprocessingproductshop.utils;

import jakarta.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <T> T fromFile(String path, Class<T> tClass) throws JAXBException, FileNotFoundException;

    <T> void writeToFile(String path, T entity) throws JAXBException;

}
