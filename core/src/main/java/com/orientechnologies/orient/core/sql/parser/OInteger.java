/* Generated By:JJTree: Do not edit this line. OInteger.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import java.util.Map;

public class OInteger extends ONumber {

  protected Number value;

  public OInteger(int id) {
    super(id);
  }

  public OInteger(OrientSql p, int id) {
    super(p, id);
  }

  public Number getValue() {
    return value;
  }

  public void setValue(int sign, String stringValue) {
    int radix = radix(stringValue);
    stringValue = convertToJavaByRadix(stringValue, radix);

    if (stringValue.endsWith("L") || stringValue.endsWith("l")) {
      value = Long.parseLong(stringValue.substring(0, stringValue.length() - 1), radix) * sign;
    } else {
      long longValue = Long.parseLong(stringValue, radix) * sign;
      if (longValue > Integer.MAX_VALUE || longValue < Integer.MIN_VALUE) {
        value = longValue;
      } else {
        value = (int) longValue;
      }
    }
  }

  private String convertToJavaByRadix(String stringValue, int radix) {
    if (radix == 16) {
      if (stringValue.charAt(0) == '-') {
        return "-" + stringValue.substring(3);
      } else {
        return stringValue.substring(2);
      }
    }
    return stringValue;
  }

  private int radix(String stringValue) {
    if (stringValue.startsWith("-")) {
      stringValue = stringValue.substring(1);
    }
    if (stringValue.length() > 2 && stringValue.substring(0, 2).equalsIgnoreCase("0x")) {
      return 16;
    }
    if (stringValue.length() > 1 && stringValue.charAt(0) == '0') {
      return 8;
    }
    return 10;
  }

  public void setValue(Number value) {
    this.value = value;
  }

  public void toString(Map<Object, Object> params, StringBuilder builder) {
    builder.append("" + value);
  }

  public OInteger copy() {
    OInteger result = new OInteger(-1);
    result.value = value;
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    OInteger oInteger = (OInteger) o;

    if (value != null ? !value.equals(oInteger.value) : oInteger.value != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }
}
/* JavaCC - OriginalChecksum=2e6eee6366ff4e864dd6c8184d2766f5 (do not edit this line) */
