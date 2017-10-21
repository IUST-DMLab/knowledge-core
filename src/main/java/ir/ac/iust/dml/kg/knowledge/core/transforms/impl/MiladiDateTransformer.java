package ir.ac.iust.dml.kg.knowledge.core.transforms.impl;

import ir.ac.iust.dml.kg.knowledge.core.TypedValue;
import ir.ac.iust.dml.kg.knowledge.core.ValueType;
import ir.ac.iust.dml.kg.knowledge.core.transforms.GenericTransformer;
import ir.ac.iust.dml.kg.knowledge.core.transforms.ITransformer;
import ir.ac.iust.dml.kg.knowledge.core.transforms.TransformException;
import ir.ac.iust.dml.kg.knowledge.core.transforms.Transformer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mohammad on 10/21/2017.
 */
@Transformer(value = "string", description = "تبدیل تاریخ میلادی حرفی به عددی")
public class MiladiDateTransformer implements ITransformer {

    @Override
    public TypedValue transform(String value, String lang, ValueType type, String unit) throws TransformException {
        try {
            String result = GenericTransformer.miladiTransformer(value);
            return new TypedValue(ValueType.String, result + "", null);
        } catch (Throwable th) {
            throw new TransformException(th);
        }
    }
}
