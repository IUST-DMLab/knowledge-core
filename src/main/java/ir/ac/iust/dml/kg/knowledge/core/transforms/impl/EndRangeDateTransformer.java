package ir.ac.iust.dml.kg.knowledge.core.transforms.impl;

import ir.ac.iust.dml.kg.knowledge.core.TypedValue;
import ir.ac.iust.dml.kg.knowledge.core.ValueType;
import ir.ac.iust.dml.kg.knowledge.core.transforms.GenericTransformer;
import ir.ac.iust.dml.kg.knowledge.core.transforms.ITransformer;
import ir.ac.iust.dml.kg.knowledge.core.transforms.TransformException;
import ir.ac.iust.dml.kg.knowledge.core.transforms.Transformer;

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
            String stringDate="";
            if(GenericTransformer.detectDateType(strs[1]).equals("shamsi"))
                stringDate=GenericTransformer.shamsiTransformer(strs[1]);
            else if(GenericTransformer.detectDateType(strs[1]).equals("miladi"))
                stringDate=GenericTransformer.miladiTransformer(strs[1]);
            return new TypedValue(ValueType.String, stringDate + "", null);
        } catch (Throwable th) {
            throw new TransformException(th);
        }
    }
}
