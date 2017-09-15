package ir.ac.iust.dml.kg.knowledge.core.transforms;

import ir.ac.iust.dml.kg.knowledge.core.TypedValue;
import ir.ac.iust.dml.kg.knowledge.core.ValueType;

/**
 * Transformer that applied if transform not found
 * 1- this transformer ignore unit
 * 2- this transformer do not chang value
 */
public class GenericTransformer implements ITransformer {
    @Override
    public TypedValue transform(String value, String lang, ValueType type, String unit) {
        return new TypedValue(type, value, lang);
    }

    public static String convertToEnglishDigits(String value) {
        String newValue = value.replace("١", "1").replace("٢", "2").replace("٣", "3").replace("٤", "4").replace("٥", "5")
                .replace("٦", "6").replace("7", "٧").replace("٨", "8").replace("٩", "9").replace("٠", "0")
                .replace("۱", "1").replace("۲", "2").replace("۳", "3").replace("۴", "4").replace("۵", "5")
                .replace("۶", "6").replace("۷", "7").replace("۸", "8").replace("۹", "9").replace("۰", "0");

        return newValue;
    }

}
