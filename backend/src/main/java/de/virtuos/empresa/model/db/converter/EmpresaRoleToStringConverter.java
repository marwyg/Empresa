package de.virtuos.empresa.model.db.converter;

import de.virtuos.empresa.model.db.EmpresaRole;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.AttributeConverter;


public class EmpresaRoleToStringConverter implements AttributeConverter<EmpresaRole, String> {

    private static Log log = LogFactory.getLog(EmpresaRoleToStringConverter.class);


    @Override
    public String convertToDatabaseColumn(EmpresaRole value) {
        return value == null ? "" : value.name();
    }

    @Override
    public EmpresaRole convertToEntityAttribute(String value) {
        try {
            return EmpresaRole.valueOf(value);
        } catch (IllegalArgumentException e) {
            log.error(String.format("Couldn't parse enum for value '%s'.", value), e);
            throw e;
        }
    }

}
