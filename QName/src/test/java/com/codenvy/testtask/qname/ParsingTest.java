package com.codenvy.testtask.qname;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Class contains methods for checking correctness of the parser
 * 
 * @author kol
 */
public class ParsingTest { 

	/**
	 * Test for verify method getPrefix() when prefix and localName not equals null 
	 * @throws IllegalNameException
	 */
	@Test
	public void testForGetPrefixMethod() throws IllegalNameException {
		QName qname = ParseQName.parse("prefix:name");
		assertEquals(qname.getPrefix(), "prefix");
	}
	
	/**
	 * Test for verify method getPrefix() when prefix equals null and localName not equals null 
	 * @throws IllegalNameException
	 */
	@Test
	public void testForGetPrefixMethodWithNullPrefix() throws IllegalNameException {
		QName qname = ParseQName.parse("name");
		assertNull(qname.getPrefix());
	}
	
	/**
	 * Test for verify method getLocalName() when prefix equals null and localName not equals null 
	 * @throws IllegalNameException
	 */
	@Test
	public void testForGetLocalNameMethodWithNullPrefix() throws IllegalNameException {
		QName qname = ParseQName.parse("name");
		assertEquals(qname.getLocalName(), "name");
	}
	
	/**
	 * Test for verify method getLocalName() when prefix and localName not equals null 
	 * @throws IllegalNameException
	 */
	@Test
	public void testForGetLocalNameMethod() throws IllegalNameException {
		QName qname = ParseQName.parse("prefix:name");
		assertEquals(qname.getLocalName(), "name");
	}
	
	/**
	 * Test for verify method getAsString() when prefix and localName not equals null 
	 * @throws IllegalNameException
	 */
	@Test
	public void testForGetAsStringMethod() throws IllegalNameException {
		QName qname = ParseQName.parse("prefix:name");
		assertEquals(qname.getAsString(), "prefix:name");
	}
	
	/**
	 * Test for verify method getAsString() when prefix equals null and localName not equals null 
	 * @throws IllegalNameException
	 */
	@Test
	public void testForGetAsStringMethodWithNullPrefix() throws IllegalNameException {
		QName qname = ParseQName.parse("name");
		assertEquals(qname.getAsString(), "name");
	}
	
	/**
	 * Test for verify method parse() when prefix is string and localName is one number 
	 * @throws IllegalNameException
	 */
	@Test
	public void testPrefixAndLocalNameAsNumber() throws IllegalNameException{
		assertEquals(new QName("prefix", "1"), 		ParseQName.parse("prefix:1"));
	}
	
	/**
	 * Test for verify method parse() when prefix equals null and localName equals ".n" 
	 * @throws IllegalNameException
	 */
	@Test
	public void testOnePointAndCharacter() throws IllegalNameException{
		assertEquals(new QName(null, ".n"), 		ParseQName.parse(".n"));
	}
	
	/**
	 * Test for verify method parse() when prefix equals null and localName equals "n."
	 * @throws IllegalNameException
	 */
	@Test
	public void testCharacterAndOnePoint() throws IllegalNameException{
		assertEquals(new QName(null, "n."), 		ParseQName.parse("n."));
	}
	
	/**
	 * Test for verify method parse() when prefix equals null and localName equals simple string
	 * @throws IllegalNameException
	 */
	@Test
	public void testOnlyLocalName() throws IllegalNameException{
		assertEquals(new QName(null, "name"), 		ParseQName.parse("name"));
	}
	
	/**
	 * Test for verify method parse() when prefix and localName not equals null
	 * @throws IllegalNameException
	 */
	@Test
	public void testPrefixAndLocalName() throws IllegalNameException{
		assertEquals(new QName("prefix", "name"), 	ParseQName.parse("prefix:name"));
	}
	
	/**
	 * Test for verify method parse() when prefix equals simple string and 
	 * localName equals string with space inside
	 * @throws IllegalNameException
	 */
	@Test
	public void testPrefixAndLocalNameWithSpaceInside() throws IllegalNameException{
		assertEquals(new QName("prefix", "na me"), 	ParseQName.parse("prefix:na me"));
	}
	
	/**
	 * Test for verify method parse() when prefix equals null and 
	 * localName equals string with space inside
	 * @throws IllegalNameException
	 */
	@Test
	public void testOnlyLocalNameWithSpaceInside() throws IllegalNameException{
		assertEquals(new QName(null, "na me"), 		ParseQName.parse("na me"));
	}

	/**
	 * Next tests throws IllegalNameException
	 */
	
	/**
	 * Test for verify method parse() when prefix is not valid (prefix start with a digit)
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testNumberAsFirstCharacterInPrefix() throws IllegalNameException {
		ParseQName.parse("5:5");
	}
	
	/**
	 * Test for verify method parse() when string for parsing is empty
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testEmptyString() throws IllegalNameException {
		ParseQName.parse("");
	}
	
	/**
	 * Test for verify method parse() when string for parsing equals <space>
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testOnlySpace() throws IllegalNameException {
		ParseQName.parse(" ");
	}
	
	/**
	 * Test for verify method parse() when string equals ".."
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testTwoPoints() throws IllegalNameException {
		ParseQName.parse("..");
	}
	
	/**
	 * Test for verify method parse() when string for parsing equals "."
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testOnePoint() throws IllegalNameException {
		ParseQName.parse(".");
	}
	
	/**
	 * Test for verify method parse() when prefix not equals null and localName start with <space>
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testSpaceBetweenColonAndLocalName() throws IllegalNameException {
		ParseQName.parse("prefix: name");
	}
	
	/**
	 * Test for verify method parse() when prefix equals null
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testOnlyColonBeforeLocalName() throws IllegalNameException {
		ParseQName.parse(":name");
	}
	
	/**
	 * Test for verify method parse() when localName equals null
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testEmptyLocalName() throws IllegalNameException {
		ParseQName.parse("prefix:");
	}
	
	/**
	 * Test for verify method parse() when prefix equals null and localName start with <space>
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testSpaceBeforeLocalName() throws IllegalNameException {
		ParseQName.parse(" name");
	}
	
	/**
	 * Test for verify method parse() when prefix start with <space>
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testSpaceBeforePrefix() throws IllegalNameException {
		ParseQName.parse(" prefix:name");
	}
	
	/**
	 * Test for verify method parse() when prefix not equals null and localName end with <space>
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testSpaceAfterLocalName() throws IllegalNameException {
		ParseQName.parse("prefix:name ");
	}
	
	/**
	 * Test for verify method parse() when prefix has <space> inside
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testSpaceInPrefix() throws IllegalNameException {
		ParseQName.parse("pre fix:name");
	}
	
	/**
	 * Test for verify method parse() when localName has wrong symbol inside ('/')
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testUnacceptableCharacter() throws IllegalNameException {
		ParseQName.parse("name/name");
	}
	
	/**
	 * Test for verify method parse() when localName has wrong symbol inside ('[')
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testUnacceptableCharacter1() throws IllegalNameException {
		ParseQName.parse("name[name");
	}
	
	/**
	 * Test for verify method parse() when prefix start with colon (':')
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testColonInPrefixAndInLocalName() throws IllegalNameException {
		ParseQName.parse(":prefix:name:name");
	}
	
	/**
	 * Test for verify method parse() when localName has colon inside
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testColonInLocalName() throws IllegalNameException {
		ParseQName.parse("prefix:name:name");
	}
	
	/**
	 * Test for verify method parse() when localName start with colon
	 * @throws IllegalNameException
	 */
	@Test(expected = IllegalNameException.class)
	public void testTwoColonsBetweenPrefixAndLocalName() throws IllegalNameException {
		ParseQName.parse("prefix::name");
	}
}