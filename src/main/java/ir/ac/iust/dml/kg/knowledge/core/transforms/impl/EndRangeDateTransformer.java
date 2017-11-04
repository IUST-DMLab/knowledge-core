package ir.ac.iust.dml.kg.knowledge.core.transforms.impl;

import ir.ac.iust.dml.kg.knowledge.core.TypedValue;
import ir.ac.iust.dml.kg.knowledge.core.ValueType;
import ir.ac.iust.dml.kg.knowledge.core.transforms.ITransformer;
import ir.ac.iust.dml.kg.knowledge.core.transforms.TransformException;
import ir.ac.iust.dml.kg.knowledge.core.transforms.Transformer;

import java.util.Date;

/**
 * Created by mohammad on 10/21/2017.
 */
@Transformer(value = "String", description = "تبدیل بازه زمانی به حداکثر آن")
public class EndRangeDateTransformer implements ITransformer {

    @Override
    public TypedValue transform(String value, String lang, ValueType type, String unit) throws TransformException {
        try {
            value= value.replaceAll("\\(.*\\)","");
            String[] strs = value.split("تا|-|–");
            Date date = null;
            if (DateUtils.detectDateType(strs[1]).equals("shamsi"))
                date = DateUtils.shamsiTransformer(strs[1]);
            else if (DateUtils.detectDateType(strs[1]).equals("miladi"))
                date = DateUtils.miladiTransformer(strs[1]);
            if (date == null) throw new TransformException("i can't detect date type");
            return new TypedValue(ValueType.Date, String.valueOf(date.getTime()), null);
        } catch (Throwable th) {
            throw new TransformException(th);
        }
    }
}
