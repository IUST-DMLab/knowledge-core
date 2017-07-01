package ir.ac.iust.dml.kg.knowledge.core.transforms;

import ir.ac.iust.dml.kg.knowledge.core.TypedValue;
import ir.ac.iust.dml.kg.knowledge.core.ValueType;

/**
 * A transformer must implement this
 */
public interface ITransformer {
    /**
     * Main function of transformer
     *
     * @param value value of triple that must be transformed to standard form
     * @param lang  lang of value and can be null
     * @param type  type of value that come form mapping rule and maybe ignored by this function
     * @param unit  unit of value that expert choose it
     * @return TypedValue that has been transformed
     * @throws TransformException on bad format
     */
    TypedValue transform(String value, String lang, ValueType type, String unit) throws TransformException;
}
