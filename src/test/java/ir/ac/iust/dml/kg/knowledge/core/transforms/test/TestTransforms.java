package ir.ac.iust.dml.kg.knowledge.core.transforms.test;

import ir.ac.iust.dml.kg.knowledge.core.TypedValue;
import ir.ac.iust.dml.kg.knowledge.core.ValueType;
import ir.ac.iust.dml.kg.knowledge.core.transforms.TransformException;
import ir.ac.iust.dml.kg.knowledge.core.transforms.TransformScanner;
import org.junit.Test;

/**
 * Created by HosseiN on 01/07/2017.
 */
public class TestTransforms {
    @Test
    public void priceTest() throws TransformException {
        final TransformScanner scanner = new TransformScanner();
        scanner.scan("ir.ac.iust.dml.kg.knowledge.core.transforms.test");
        assert scanner.getTransformer("pricetest") instanceof PriceTransformer;
        PriceTransformer priceTransformer = (PriceTransformer) scanner.getTransformer("pricetest");
        TypedValue result = priceTransformer.transform("۱۳ ریال", "fa", ValueType.String, null);
        assert result.getValue().equals("13");
        result = priceTransformer.transform("۱۳ تومان", "fa", ValueType.String, null);
        assert result.getValue().equals("130");
        result = priceTransformer.transform("13 تومان", "fa", ValueType.String, null);
        assert result.getValue().equals("130");
    }

}
