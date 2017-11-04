package ir.ac.iust.dml.kg.knowledge.core.transforms.test;

import ir.ac.iust.dml.kg.knowledge.core.TypedValue;
import ir.ac.iust.dml.kg.knowledge.core.ValueType;
import ir.ac.iust.dml.kg.knowledge.core.transforms.TransformException;
import ir.ac.iust.dml.kg.knowledge.core.transforms.TransformScanner;
import ir.ac.iust.dml.kg.knowledge.core.transforms.impl.*;
import org.junit.Test;

import java.util.Objects;

/**
 * Farsi Knowledge Graph Project
 * Iran University of Science and Technology (Year 2017)
 * Developed by HosseiN Khademi khaledi
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


    @Test
    public void mileToKMTest() throws TransformException {

        MileToKmTransformer mileToKm = new MileToKmTransformer();
        TypedValue result = mileToKm.transform("2", "fa", ValueType.String, null);
        assert result.getValue().equals("3.21868");

    }

    @Test
    public void startTemp() throws TransformException {
        StartTempratureTransformer startTemp = new StartTempratureTransformer();
        TypedValue result = startTemp.transform("-20 تا +30", "fa", ValueType.String, null);
        assert result.getValue().equals("-20.0");
    }

    @Test
    public void endTemp() throws TransformException {
        EndTempratureTransformer endTemp = new EndTempratureTransformer();
        TypedValue result = endTemp.transform("-20 تا +30", "fa", ValueType.String, null);
        assert result.getValue().equals("30.0");
    }


    @Test
    public void populationTest() throws TransformException {

        PopulationTransformer endTemp = new PopulationTransformer();
        TypedValue result = endTemp.transform("30000 نفر", "fa", ValueType.String, null);
        assert result.getValue().equals("30000");
        result = endTemp.transform("۱۰۰۷ نفر (سرشماری ۱۳۹۰)", "fa", ValueType.String, null);
        assert result.getValue().equals("1007");

    }

    @Test
    public void altitudeTest() throws TransformException {

        AltitudeTransformer endTemp = new AltitudeTransformer();
        TypedValue result = endTemp.transform("30000 متر", "fa", ValueType.String, null);
        assert result.getValue().equals("30000");

    }

    @Test
    public void startRangeTransformer() throws  TransformException
    {
        StartRangeTransformer startRangeTransformer=new StartRangeTransformer();
        TypedValue result=startRangeTransformer.transform("2.5 تا 3.5","fa",ValueType.Float,null);
        assert result.getValue().equals("2.5");
    }

    @Test
    public void endRangeTransformer() throws  TransformException
    {
        EndRangeTransformer endRangeTransformer=new EndRangeTransformer();
        TypedValue result=endRangeTransformer.transform("2.5 تا 3.5(بر حسب متر)","fa",ValueType.Float,null);
        assert result.getValue().equals("3.5");
    }
    @Test
    public void miladiDateTransformer() throws  TransformException
    {
        MiladiDateTransformer miladiDateTransformer=new MiladiDateTransformer();
        TypedValue result=miladiDateTransformer.transform("23 ژوئیه ۱۹۵۲","fa",ValueType.String,null);
        assert Long.parseLong(result.getValue()) == -547788600000L;
        result=miladiDateTransformer.transform("23 July ۱۹۵۲","fa",ValueType.String,null);
        assert Objects.equals(result.getValue(), "-547788600000");
    }

    @Test
    public void shamsiDateTransformer() throws  TransformException
    {
        ShamsiDateTransformer shamsiDateTransformer=new ShamsiDateTransformer();
        TypedValue result=shamsiDateTransformer.transform("23 فروردین ۱3۵۲","fa",ValueType.String,null);
        assert Objects.equals(result.getValue(), "-19496950200000");

    }

    @Test
    public void startRangeDateTransformer() throws  TransformException
    {
        StartRangeDateTransformer startRangeDateTransformer=new StartRangeDateTransformer();
        TypedValue result=startRangeDateTransformer.transform(" 12 مرداد ۱۳۹۲ – ۲۷ شهریور ۱۳۹۵","fa",ValueType.String,null);
        assert Objects.equals(result.getValue(), "-18225142200000");
    }

    @Test
    public void endShamsiRangeDateTransformer() throws  TransformException
    {
        EndRangeDateTransformer endRangeDateTransformer=new EndRangeDateTransformer();
        TypedValue result=endRangeDateTransformer.transform(" 12 مرداد ۱۳۹۲ – ۲۷ شهریور ۱۳۹۵","fa",ValueType.String,null);
        assert Objects.equals(result.getValue(), "-18126646200000");
    }
}
