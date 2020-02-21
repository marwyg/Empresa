package de.virtuos.empresa.entity.converter;

import de.virtuos.empresa.entity.EmpresaUserRole;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Logger;

import javax.persistence.AttributeConverter;


public class EmpresaUserRoleToStringConverter implements AttributeConverter<EmpresaUserRole, String> {

    private static Log log = LogFactory.getLog(EmpresaUserRoleToStringConverter.class);


    @Override
    public String convertToDatabaseColumn(EmpresaUserRole value) {
        return value == null ? "" : value.name();
    }

    @Override
    public EmpresaUserRole convertToEntityAttribute(String value) {
        try {
            return EmpresaUserRole.valueOf(value);
        } catch (IllegalArgumentException e) {
            log.error(String.format("Couldn't parse enum for value '%s'.", value), e);
            throw e;
        }
    }

}
