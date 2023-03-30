package swag.rest.nis_risk_app.helper;

import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.stereotype.Component;
import swag.rest.nis_risk_app.entity.Phase;

import java.io.IOException;

public interface FormGenerator<X extends Phase> {
    void generatePdf(WordprocessingMLPackage wordMLPackage, X phase) throws IOException;

}
