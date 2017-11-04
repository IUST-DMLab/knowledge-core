package ir.ac.iust.dml.kg.knowledge.core.transforms.impl;

import ir.ac.iust.dml.kg.knowledge.core.TypedValue;
import ir.ac.iust.dml.kg.knowledge.core.ValueType;
import ir.ac.iust.dml.kg.knowledge.core.transforms.ITransformer;
import ir.ac.iust.dml.kg.knowledge.core.transforms.TransformException;
import ir.ac.iust.dml.kg.knowledge.core.transforms.Transformer;

import java.util.Date;
import java.util.regex.Matcher;

/**
 * Created by mohammad on 10/21/2017.
 */
@Transformer(value = "endOfDateRange", description = "تبدیل بازه زمانی به حداکثر آن")
public class EndRangeDateTransformer implements ITransformer {

    @Override
    public TypedValue transform(String value, String lang, ValueType type, String unit) throws TransformException {
        try {
            final Matcher matcher = TransformUtils.RANGE_PATTERN.matcher(value);
            if (matcher.find()) {
                Date date = null;
                final String str = matcher.group(4);
                if (TransformUtils.detectDateType(str).equals("shamsi"))
                    date = TransformUtils.shamsiTransformer(str);
                else if (TransformUtils.detectDateType(str).equals("miladi"))
                    date = TransformUtils.miladiTransformer(str);
                if (date == null) throw new TransformException("i can't detect date type");
                return new TypedValue(ValueType.Date, String.valueOf(date.getTime()), null);
            }
            throw new TransformException("no range matched.");
        } catch (Throwable th) {
            throw new TransformException(th);
        }
    }
}
