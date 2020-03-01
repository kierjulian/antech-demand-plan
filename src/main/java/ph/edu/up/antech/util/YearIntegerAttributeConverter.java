package ph.edu.up.antech.util;

import javax.persistence.AttributeConverter;
import java.time.Year;

public class YearIntegerAttributeConverter implements AttributeConverter<Year, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Year attribute) {
        return (Integer) attribute.getValue();
    }

    @Override
    public Year convertToEntityAttribute(Integer dbValue) {
        return Year.of(dbValue);
    }

}
