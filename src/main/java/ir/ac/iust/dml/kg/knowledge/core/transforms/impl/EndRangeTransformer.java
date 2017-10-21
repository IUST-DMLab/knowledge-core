package ir.ac.iust.dml.kg.knowledge.core.transforms.impl;

import ir.ac.iust.dml.kg.knowledge.core.TypedValue;
import ir.ac.iust.dml.kg.knowledge.core.ValueType;
import ir.ac.iust.dml.kg.knowledge.core.transforms.ITransformer;
import ir.ac.iust.dml.kg.knowledge.core.transforms.TransformException;
import ir.ac.iust.dml.kg.knowledge.core.transforms.Transformer;

/**
 * Created by mohammad on 10/21/2017.
 */
@Transformer(value = "float", description = "تبدیل بازه به حداکثر آن")
public class EndRangeTransformer implements ITransformer {

    @Override
    public TypedValue transform(String value, String lang, ValueType type, String unit) throws TransformException {
        try {
            value= value.replaceAll("\\(.*\\)","");
            String[] strs = value.split("تا|-|–");
            return new TypedValue(ValueType.Float, Float.parseFloat(strs[1]) + "", null);
        } catch (Throwable th) {
            throw new TransformException(th);
        }
    }
}
