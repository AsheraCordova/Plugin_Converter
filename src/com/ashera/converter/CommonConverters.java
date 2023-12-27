package com.ashera.converter;

import com.ashera.validations.AlphaNumeric;
import com.ashera.validations.Alphabet;
import com.ashera.validations.Date;
import com.ashera.validations.InRange;
import com.ashera.validations.IsEmail;
import com.ashera.validations.IsMobileNumber;
import com.ashera.validations.IsNumber;
import com.ashera.validations.IsPositiveInteger;
import com.ashera.validations.IsValidPIN;
import com.ashera.validations.Length;
import com.ashera.validations.MaxLength;
import com.ashera.validations.MaxValue;
import com.ashera.validations.MinLength;
import com.ashera.validations.MinValue;
import com.ashera.validations.NotEmpty;
import com.ashera.validations.Pattern;
import com.ashera.validations.StrongPassword;
import com.ashera.validations.Time;
import com.ashera.validations.Url;
import com.ashera.validations.ValidatorFactory;
import com.ashera.widget.EventCommandFactory;

public class CommonConverters {
	public final static String dimensionfloat = "dimensionfloat";
	public final static String dimensionsp = "dimensionsp";
	public final static String dimension = "dimension";
	public final static String font = "font";
	public final static String fontweight = "fontweight";
	public final static String fontstyle = "fontstyle";
	public final static String actionItem = "actionItem";
	public final static String intconverter = "int";
	public final static String floatconverter = "float";
	public final static String doubleconverter = "double";
	public final static String behaviorconverter = "behavior";
	public final static String validationconverter = "validator";
	public final static String timeconverter = "time";
	public final static String dimensionspint = "dimensionspint";
	public final static String dimensionsppxint = "dimensionsppxint";
	public final static String resourcestring = "resourcestring";
	public final static String gravity = "gravity";
	public final static String boolean_conv = "boolean";
	public final static String percent = "percent";
	public final static String id = "id";
	public final static String template = "template";
	public final static String dimensionpx = "dimensionpx";
	public final static String dimensionsppx = "dimensionsppx";
	public final static String dimensiondppx = "dimensiondppx";
	public final static String object = "object";
	public final static String array = "array";
	public final static String nil = "nil";
	public final static String listtointarray = "listtointarray";
	
	public final static String command_generic = "command_generic";
	public final static String command_password = "command_password";
	public final static String command_uppercase = "command_uppercase";
	public final static String command_maxlength = "command_maxlength";
	public final static String command_marquee = "command_marquee";
	public final static String command_escapehtml = "command_escapehtml";
	public final static String command_textformatter = "command_textformatter";
	public final static String command_imagestate = "command_imagestate";

	
	static {
		ConverterFactory.register(boolean_conv, new BooleanConverter());
		ConverterFactory.register(dimension, new DimensionConverter());
		ConverterFactory.register(dimensionsp, new DimensionSpConverter());
		ConverterFactory.register(dimensionspint, new DimensionSpIntConverter());
		ConverterFactory.register(dimensionsppxint, new DimensionSpPxIntConverter());
		ConverterFactory.register(floatconverter, new FloatConverter());
		ConverterFactory.register(doubleconverter, new DoubleConverter());
		ConverterFactory.register(resourcestring, new ResourceStringConverter());
		ConverterFactory.register(gravity, new GravityConverter());
		ConverterFactory.register(id, new IdConverter());
		ConverterFactory.register(intconverter, new IntConverter());
		ConverterFactory.register(percent, new PercentConverter());
		ConverterFactory.register(dimensionfloat, new DimensionFloatConverter());
		ConverterFactory.register(timeconverter, new TimeConverter());
		ConverterFactory.register(template, new TemplateConverter());
		ConverterFactory.register(dimensionsppx, new DimensionSpPxIntConverter());
		ConverterFactory.register(dimensionpx, new DimensionPxIntConverter());
		ConverterFactory.register(dimensiondppx, new DimensionDpPxIntConverter());
		
		ConverterFactory.register(object, new ObjectToMapConverter());
		ConverterFactory.register(array, new ArrayConverter());
		ConverterFactory.register(listtointarray, new ListToIntArrayConverter());
		ConverterFactory.register(nil, new NilConverter());

		ConverterFactory.registerCommandConverter(new PasswordCommandConveter(command_password));
		ConverterFactory.registerCommandConverter(new UpperCaseCommandConveter(command_uppercase));
		ConverterFactory.registerCommandConverter(new MaxLengthCommandConveter(command_maxlength));
		ConverterFactory.registerCommandConverter(new MarqueeCommandConverter(command_marquee));
		ConverterFactory.registerCommandConverter(new EscapeHtmlCommandConverter(command_escapehtml));
		ConverterFactory.registerCommandConverter(new TextFormatCommandConverter(command_textformatter));
		ConverterFactory.registerCommandConverter(new ImageStateCommandConverter(command_imagestate));
		
		ValidatorFactory.register("alphabet", new Alphabet());
		ValidatorFactory.register("alphanumeric", new AlphaNumeric());
		ValidatorFactory.register("date", new Date());
		ValidatorFactory.register("inrange", new InRange());
		ValidatorFactory.register("email", new IsEmail());
		ValidatorFactory.register("mobilenumber", new IsMobileNumber());
		ValidatorFactory.register("number", new IsNumber());
		ValidatorFactory.register("integer", new IsPositiveInteger());
		ValidatorFactory.register("pin", new IsValidPIN());
		ValidatorFactory.register("length", new Length());
		ValidatorFactory.register("required", new NotEmpty());
		ValidatorFactory.register("strongpassword", new StrongPassword());
		ValidatorFactory.register("time", new Time());
		ValidatorFactory.register("pattern", new Pattern());
		ValidatorFactory.register("minlength", new MinLength());
		ValidatorFactory.register("maxlength", new MaxLength());
		ValidatorFactory.register("maxvalue", new MaxValue());
		ValidatorFactory.register("minvalue", new MinValue());
		ValidatorFactory.register("url", new Url());

		EventCommandFactory.registerCommand("java", new JavaEventCommand());
	}
	
	public static void init() {
		
	}
}
