/*
 * Farsi Knowledge Graph Project
 * Iran University of Science and Technology (Year 2017)
 * Developed by Majid Asgari.
 */

package ir.ac.iust.dml.kg.knowledge.core.transforms.impl;

import ir.ac.iust.dml.kg.knowledge.core.TypedValue;
import ir.ac.iust.dml.kg.knowledge.core.ValueType;
import ir.ac.iust.dml.kg.knowledge.core.transforms.ITransformer;
import ir.ac.iust.dml.kg.knowledge.core.transforms.TransformException;
import ir.ac.iust.dml.kg.knowledge.core.transforms.Transformer;

import java.util.Date;
import java.util.regex.Pattern;

@Transformer(value = "gregorianDate", description = "تبدیل هر رشته تاریخی به تاریخ")
public class CommandoDateTransformer implements ITransformer {

  private final static String gregorianRegex = "(\\d+)\\s+" +
      "(january|jan|febraury|feb|march|mar" +
      "|april|apr|may|june|jun|july|jul|augest|aug|september|sep|october|oct|november|nov|december|dec)" +
      "\\s+(\\d+).*";
  private final static String gregorianRegex2 = "(?U)(\\d+)\\s+" +
      "(ژانویه|فوریه|مارس|مارچ|آوریل|آپریل" +
      "|اپریل|می|مه|جون|ژوئن|ژون|جولای|ژولای|اوت|آگوست|آگست|سپتامبر|اکتبر|نوامبر|دسامبر)" +
      "\\s+(\\d+).*";
  private final static String jalaliRegex = "(?U)(\\d+)\\s+" +
      "(امرداد|مرداد|تیر|خرداد|اردیبهشت|فروردین" +
      "|شهریور|مهر|آبان|آذر|دی|بهمن|اسفند)" +
      "\\s+(ماه\\s+)*(\\d+).*";
  private final static String moonRegex = "(?U)(\\d+)(ماه\\s+)*\\s+" +
      "(ربیع‌الثانی|ربیع الاول|ربیع‌الاول|محرم الحرام|محرم‌الحرام|محرم" +
      "|ربیع الثانی|جمادی الاول|جمادی‌الاول|جمادی‌الثانی|جمادی الثانی|رجب|شعبان|رمضان|شوال|ذی‌قعده|ذیقعده|ذی قعده" +
      "|ذی‌حجه|ذی حجه|ذیحجه)" +
      "\\s+(\\d+).*";
  private final static String gMonthRegex = "(?U)" +
      "(ژانویه|فوریه|مارس|مارچ|آوریل|آپریل" +
      "|اپریل|می|مه|جون|ژوئن|ژون|جولای|ژولای|اوت|آگوست|آگست|سپتامبر|اکتبر|نوامبر|دسامبر)" +
      "\\s+(\\d+).*";
  private final static String jMonthRegex = "(?U)" +
      "(امرداد|مرداد|تیر|خرداد|اردیبهشت|فروردین" +
      "|شهریور|مهر|آبان|آذر|دی|بهمن|اسفند)" +
      "\\s+(\\d+).*";
  private final static String mMonthRegex = "(?U)" +
      "(ربیع‌الثانی|ربیع الاول|ربیع‌الاول|محرم الحرام|محرم‌الحرام|محرم" +
      "|ربیع الثانی|جمادی الاول|جمادی‌الاول|جمادی‌الثانی|جمادی الثانی|رجب|شعبان|رمضان|شوال|ذی‌قعده|ذیقعده|ذی قعده" +
      "|ذی‌حجه|ذی حجه|ذیحجه)" +
      "\\s+(\\d+).*";
  private final static String yearRegex = "(?U)(\\d+)\\s*(هجری قمری|هجری شمسی|هجری خورشیدی|قمری|شمسی|خورشیدی|میلادی).*";
  final static Pattern GRE_PATTERN = Pattern.compile(gregorianRegex);
  final static Pattern GRE_PATTERN2 = Pattern.compile(gregorianRegex2);
  final static Pattern JAL_PATTERN = Pattern.compile(jalaliRegex);
  final static Pattern MON_PATTERN = Pattern.compile(moonRegex);
  final static Pattern GMONTH_PATTERN = Pattern.compile(gMonthRegex);
  final static Pattern JMONTH_PATTERN = Pattern.compile(jMonthRegex);
  final static Pattern MMONTH_PATTERN = Pattern.compile(mMonthRegex);
  final static Pattern YEAR_PATTERN = Pattern.compile(yearRegex);

  @Override
  public TypedValue transform(String value, String lang, ValueType type, String unit) throws TransformException {
    try {
      Date result = TransformUtils.miladiTransformer(value);
      return new TypedValue(ValueType.Date, String.valueOf(result.getTime()), null);
    } catch (Throwable th) {
      throw new TransformException(th);
    }
  }
}
