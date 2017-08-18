package ir.ac.iust.dml.kg.knowledge.core.transforms.test;

import ir.ac.iust.dml.kg.knowledge.core.transforms.TransformScanner;
import org.junit.Test;

/**
 * Created by HosseiN on 01/07/2017.
 */
public class TestTransforms {
    @Test
    public void test() {
        final TransformScanner scanner = new TransformScanner();
        scanner.scan("ir.ac.iust.dml.kg.knowledge.core.transforms.test");
        assert scanner.getTransformer("pricetest") instanceof PriceTransformer;
    }

}
