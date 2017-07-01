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
}
