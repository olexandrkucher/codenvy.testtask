package com.codenvy.testtask.qname;

/**
 * Class describes the Qualified Names are allowed in the XML-document
 * 
 * @author kol
 */
public class QName {

	private String prefix;
	private String localName;
	
	public QName(String prefix, String localName){
		this.prefix = prefix;
		this.localName = localName;
	}
	
	/**
	 * @return Qualified Name represented as string
	 */
	public String getAsString(){
		String qualifiedName = "";
		if(prefix != null){
			qualifiedName = prefix + ":";
		}
		qualifiedName += localName;
		return qualifiedName;
	}

	/**
	 * Set prefix of Qualified Name
	 * @param prefix
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * Set localName Qualified Name
	 * @param localName
	 */
	public void setLocalName(String localName) {
		this.localName = localName;
	}

	/**
	 * Overridden method is used to compare two Qualified Names.
	 * It used for normal work of tests
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QName other = (QName) obj;
		if (localName == null) {
			if (other.localName != null)
				return false;
		} else if (!localName.equals(other.localName))
			return false;
		if (prefix == null) {
			if (other.prefix != null)
				return false;
		} else if (!prefix.equals(other.prefix))
			return false;
		return true;
	}
	
	/**
	 * @return the prefix of Qualified Name
	 */
	public String getPrefix() {
		return prefix;
	}
	
	/**
	 * @return the localName of Qualified Name
	 */
	public String getLocalName() {
		return localName;
	}
}