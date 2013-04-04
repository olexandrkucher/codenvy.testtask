package com.codenvy.testtask.qname;

import java.util.regex.*;

/**
 * Class-parser realize only one static method which parses string 
 * and returns object QName 
 * Also contains regular expressions for parsing
 * @author kol
 */
public class ParseQName {
	
	/**
	 * Regular expressions which using for parsing given string as Qualified Name
	 */
	private static final String prefix = "([^/:*'|\"\\[\\]\\s0-9])|([^/:*'|\"\\[\\]\\s0-9][^/:*'|\"\\[\\]\\s])"
			+ "|([^/:*'|\"\\[\\]\\s0-9])((([^/:*'|\"\\[\\]\\s]))|(((([^/:*'|\"\\[\\]\\s]))*)(([^/:*'|"
			+ "\"\\[\\]\\s]))))([^/:*'|\"\\[\\]\\s])";
	private static final String nonSpace = "[^/:*'|\"\\[\\]\\s]";
	private static final String oneCharLocalName = nonSpace;
	private static final String char1 = "(" + nonSpace + ")|(" + ' ' + ")";
	private static final String oneCharSimpleName = "[^./:*'|\"\\[\\]\\s]";
	private static final String twoCharLocalName = "(" + nonSpace + nonSpace + ")";
	private static final String string = "(" + char1 + ")|((" + char1 + ")*(" + char1 + "))";
	private static final String threeOrMoreCharName = "(" + nonSpace + ")(" + string + ")(" + nonSpace + ")";
	private static final String twoCharSimpleName = "(" + '.' + oneCharSimpleName + ")|("
			+ oneCharSimpleName + '.' + ")|(" + oneCharSimpleName
			+ oneCharSimpleName + ")";
	private static final String localName = "(" + oneCharLocalName + ")|(" + twoCharLocalName
			+ ")|(" + threeOrMoreCharName + ")";
	private static final String prefixedName = "(" + prefix + ")" + ':' + "(" + localName + ")";
	private static final String simpleName = "(" + oneCharSimpleName + ")|(" + twoCharSimpleName
			+ ")|(" + threeOrMoreCharName + ")";
	private static final String nameXML = "(" + simpleName + ")|(" + prefixedName + ")";
	
	/**
	 * Compilation of pattern 
	 */
	private static Pattern pattern = Pattern.compile(nameXML);

	/**
	 * Parse given string as Qualified Name if it possible, or throw IllegalNameException else
	 * @param name - string which you want parse as Qualified Name
	 * @return
	 * @throws IllegalNameException - throws when the format of string is not correct for parsing
	 */
	public static QName parse(String name) throws IllegalNameException {
		Matcher matcher = pattern.matcher(name);
		if(!matcher.matches()){
			throw new IllegalNameException(name);
		} else {
			if(name.indexOf(':') != -1){
				String prefix = name.substring(0, name.indexOf(':'));
				String localName = name.substring(name.indexOf(':')+1);
				return new QName(prefix, localName);
			} else {
				return new QName(null, name);
			}
		}
	}
}